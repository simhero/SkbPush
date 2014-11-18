package com.skt.ssp.gw.service.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.jms.JMSException;
import javax.jms.MessageListener;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skt.ssp.gw.common.QueueReceive;
import com.skt.ssp.gw.common.QueueSend;
import com.skt.ssp.gw.service.AuthService;
import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.vo.AuthVO;
import com.skt.ssp.gw.vo.IfErrMobDataResVO;
import com.skt.ssp.gw.vo.IfErrMobResVO;
import com.skt.ssp.gw.vo.IfHeaderDbpReqVO;
import com.skt.ssp.gw.vo.IfHeaderDbpResVO;
import com.skt.ssp.gw.vo.IfHeaderMobReqVO;
import com.skt.ssp.gw.vo.IfHeaderMobResVO;

/**
 * CommonServiceImpl (CommonServiceImpl)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: CommonServiceImpl.java,v1.0 2011/08/25 00:00:00 SimByungChul Express $
 */
@Service("commonService")
public class CommonServiceImpl implements CommonService {
	protected final Log logger = LogFactory.getLog(getClass());
	protected final Log logger2 = LogFactory.getLog("XXX_XXX_XXX");
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Autowired
	private CompositeConfiguration config;
	@Autowired
	private AuthService authService;

	public CommonServiceImpl() {
	}

	@Override
	public CompositeConfiguration getConfiguration() {
		return config;
	}

	@Override
	public String getServerId(String hostName) {
		return config.getString(hostName+".SERVER_ID");
	}

	@Override
	public String getServerId() {
		try {
			return config.getString(InetAddress.getLocalHost().getHostName().toUpperCase()+".SERVER_ID");
		} catch (UnknownHostException e) {
			return null;
		}
	}

	@Override
	public String getServerSourceIp(String hostName) {
		return config.getString(hostName+".SERVER_SOURCE_IP");
	}

	@Override
	public String getServerSourceIp() {
		try {
			return config.getString(InetAddress.getLocalHost().getHostName().toUpperCase()+".SERVER_SOURCE_IP");
		} catch (UnknownHostException e) {
			return null;
		}
	}

	@Override
	public String getHostName() {
		try {
			return InetAddress.getLocalHost().getHostName().toUpperCase();
		} catch (UnknownHostException e) {
			return null;
		}
	}

	@Override
	public String getHostAddress() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			return null;
		}
	}

	@Override
	public String getServerMode() {
		try {
			return config.getString(InetAddress.getLocalHost().getHostName().toUpperCase()+".MODE");
		} catch (UnknownHostException e) {
			return null;
		}
	}

	@Override
	public QueueSend getQueueInstance(String queueName) {
		QueueSend queueSend = new QueueSend();
		try {
			queueSend.init(config.getString("INITIAL_CONTEXT_FACTORY"), config.getString("JMS_URL"), config.getString("CONNECTION_FACTORY"), queueName);
			return queueSend;
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {
				logger.info("queueName=" + queueName);
				logger.info("getQueueInstance(String queueName) Exception \r\n" + e);
			}
			return null;
		}
	}

	@Override
	public void initQueueReceiveInstance(String queueName, MessageListener messageListener) {
		QueueReceive queueReceive = new QueueReceive();
		try {
			queueReceive.init(config.getString("INITIAL_CONTEXT_FACTORY"), config.getString("JMS_URL"), config.getString("CONNECTION_FACTORY"), queueName, messageListener);
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {
				logger.info("queueName=" + queueName);
				logger.info("getQueueReceiveInstance(String queueName) Exception \r\n" + e);
			}
			try {
				queueReceive.close();
			} catch (JMSException e1) {
				logger.info("queueReceive.close() Exception \r\n" + e1);
			}
		}
	}

	@Override
	public QueueReceive initAndGetQueueReceiveInstance(String queueName, MessageListener messageListener) {
		QueueReceive queueReceive = new QueueReceive();
		try {
			queueReceive.init(config.getString("INITIAL_CONTEXT_FACTORY"), config.getString("JMS_URL"), config.getString("CONNECTION_FACTORY"), queueName, messageListener);
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {
				logger.info("queueName=" + queueName);
				logger.info("getQueueReceiveInstance(String queueName) Exception \r\n" + e);
			}
			try {
				queueReceive.close();
			} catch (JMSException e1) {
				logger.info("queueReceive.close() Exception \r\n" + e1);
			}
		}
		return queueReceive;
	}

	@Override
	public boolean isMdn(String mdn){
		mdn = mdn.replaceAll("-", "").replaceAll(" ", "").trim();
		if ( mdn != null  &&
			!mdn.equals("") &&
			(mdn.length()== 10 || mdn.length()== 11) &&
			(
				mdn.substring(0,3).equals("010")
				|| mdn.substring(0,3).equals("011")
				|| mdn.substring(0,3).equals("016")
				|| mdn.substring(0,3).equals("018")
				|| mdn.substring(0,3).equals("019")
				|| mdn.substring(0,3).equals("017")
			)
		) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getDbpReqEndPoint(String interfaceId) {
		return config.getString(getHostName()+".DBP_REQ_ENDPOINT."+interfaceId);
	}

	@Override
	public String getDbpReqEndPoint(String interfaceId, String hostName) {
		return config.getString(hostName+".DBP_REQ_ENDPOINT."+interfaceId);
	}

	@Override
	public String getMobErrorResponseMsg(String errorCode, String errorMsg) {
		StringBuilder sb = new StringBuilder();
		sb.append("{\"response\":{\"header\":{\"comInterfaceId\":\"\",\"comAuthKey\":\"\"," +
				"\"comTrId\":\"\",\"comResultCode\":\"" +errorCode +"\",\"comResultMsg\":\"" +errorMsg +"\"," +
				"\"comResponseDate\":\"" +getGwDateType() +"\"}}}");
		return sb.toString();
	}

	@Override
	public IfErrMobResVO getMobErrorResponseMsg(IfHeaderMobReqVO ifHeaderMobReqVO, String errorCode) {
		IfErrMobResVO ifErrMobResVO = new IfErrMobResVO();
		IfErrMobDataResVO ifErrMobDataResVO = new IfErrMobDataResVO();
		ifErrMobResVO.setResponse(ifErrMobDataResVO);
		ifErrMobDataResVO.setHeader(new IfHeaderMobResVO());
		IfHeaderMobResVO ifHeaderMobResVO = ifErrMobResVO.getResponse().getHeader();
		ifHeaderMobResVO.setComAuthKey(ifHeaderMobReqVO.getComAuthKey());
		ifHeaderMobResVO.setComInterfaceId(ifHeaderMobReqVO.getComInterfaceId());
		ifHeaderMobResVO.setComTrId(ifHeaderMobReqVO.getComTrId());
		ifHeaderMobResVO.setComResultCode(errorCode);
		ifHeaderMobResVO.setComResultMsg(getResultMsgOfMobileRes(errorCode));
		ifHeaderMobResVO.setComResponseDate(getGwDateType());
		return ifErrMobResVO;
	}
	
	@Override
	public IfErrMobResVO getMobErrorResponseMsg(IfHeaderMobReqVO ifHeaderMobReqVO, String errorCode, String errorMsg) {
		IfErrMobResVO ifErrMobResVO = new IfErrMobResVO();
		IfErrMobDataResVO ifErrMobDataResVO = new IfErrMobDataResVO();
		ifErrMobResVO.setResponse(ifErrMobDataResVO);
		ifErrMobDataResVO.setHeader(new IfHeaderMobResVO());
		IfHeaderMobResVO ifHeaderMobResVO = ifErrMobResVO.getResponse().getHeader();
		ifHeaderMobResVO.setComAuthKey(ifHeaderMobReqVO.getComAuthKey());
		ifHeaderMobResVO.setComInterfaceId(ifHeaderMobReqVO.getComInterfaceId());
		ifHeaderMobResVO.setComTrId(ifHeaderMobReqVO.getComTrId());
		ifHeaderMobResVO.setComResultCode(errorCode);
		ifHeaderMobResVO.setComResultMsg(errorMsg);
		ifHeaderMobResVO.setComResponseDate(getGwDateType());
		return ifErrMobResVO;
	}

	@Override
	public IfErrMobResVO validateMobHeaderReq(IfHeaderMobReqVO ifHeaderMobReqVO) {
		if (isEmptyOrMaxLengthOver(ifHeaderMobReqVO.getComAuthKey(), 255, "O"))		return getMobErrorResponseMsg(ifHeaderMobReqVO, "CO00002");
		if (isEmptyOrMaxLengthOver(ifHeaderMobReqVO.getComInterfaceId(), 10, "M"))	return getMobErrorResponseMsg(ifHeaderMobReqVO, "CO00003");
		if (isEmptyOrMaxLengthOver(ifHeaderMobReqVO.getComAppVersion(), 6, "M"))		return getMobErrorResponseMsg(ifHeaderMobReqVO, "CO00004");
		if (isEmptyOrMaxLengthOver(ifHeaderMobReqVO.getComTrId(), 36, "M"))			return getMobErrorResponseMsg(ifHeaderMobReqVO, "CO00005");
		if (isEmptyOrMaxLengthOver(ifHeaderMobReqVO.getComReqDevCd(), 3, "M"))		return getMobErrorResponseMsg(ifHeaderMobReqVO, "CO00006");
		if (isEmptyOrMaxLengthOver(ifHeaderMobReqVO.getComResolution(), 10, "M"))	return getMobErrorResponseMsg(ifHeaderMobReqVO, "CO00007");
		if (isEmptyOrMaxLengthOver(ifHeaderMobReqVO.getComCc(), 5, "O"))			return getMobErrorResponseMsg(ifHeaderMobReqVO, "CO00008");
		if (isEmptyOrMaxLengthOver(ifHeaderMobReqVO.getComPhoneNum(), 13, "O"))		return getMobErrorResponseMsg(ifHeaderMobReqVO, "CO00009");
		if (isEmptyOrMaxLengthOver(ifHeaderMobReqVO.getComModel(), 50, "M"))		return getMobErrorResponseMsg(ifHeaderMobReqVO, "CO00010");
		if (isEmptyOrMaxLengthOver(ifHeaderMobReqVO.getComManufacturer(), 10, "O"))	return getMobErrorResponseMsg(ifHeaderMobReqVO, "CO00011");
		if (isEmptyOrMaxLengthOver(ifHeaderMobReqVO.getComDataType(), 20, "M"))		return getMobErrorResponseMsg(ifHeaderMobReqVO, "CO00012");
		if (isEmptyOrMaxLengthOver(ifHeaderMobReqVO.getComRequestDate(), 20, "M"))	return getMobErrorResponseMsg(ifHeaderMobReqVO, "CO00013");
		return null;
	}

	@Override
	public IfErrMobResVO validateMobHeaderRes(IfHeaderMobReqVO ifHeaderMobReqVO, IfHeaderMobResVO ifHeaderMobResVO) {
		if (StringUtils.stripToEmpty(ifHeaderMobResVO.getComTrId()).equals("")) ifHeaderMobResVO.setComTrId(ifHeaderMobReqVO.getComTrId());
		if (isEmptyOrMaxLengthOver(ifHeaderMobResVO.getComAuthKey(), 255, "O"))		return getMobErrorResponseMsg(ifHeaderMobReqVO, "CO00502");
		if (isEmptyOrMaxLengthOver(ifHeaderMobResVO.getComInterfaceId(), 10, "M"))	return getMobErrorResponseMsg(ifHeaderMobReqVO, "CO00503");
		if (isEmptyOrMaxLengthOver(ifHeaderMobResVO.getComTrId(), 36, "M"))			return getMobErrorResponseMsg(ifHeaderMobReqVO, "CO00504");
		if (isEmptyOrMaxLengthOver(ifHeaderMobResVO.getComResultCode(), 20, "M"))	return getMobErrorResponseMsg(ifHeaderMobReqVO, "CO00505");
		if (isEmptyOrMaxLengthOver(ifHeaderMobResVO.getComResultMsg(), 255, "O"))	return getMobErrorResponseMsg(ifHeaderMobReqVO, "CO00506");
		if (isEmptyOrMaxLengthOver(ifHeaderMobResVO.getComResponseDate(), 20, "M"))	return getMobErrorResponseMsg(ifHeaderMobReqVO, "CO00507");
		return null;
	}

	@Override
	public boolean isEmptyOrMaxLengthOver(String val, int maxLeng, String opt) {

		String tripStr = StringUtils.stripToEmpty(val);

		if("M".equals(opt)) {

			return ((tripStr.length() == 0 || tripStr.length() > maxLeng));

		} else if("O".equals(opt)) {

			return (tripStr.length() > maxLeng);

		} else {

			return true;

		}

	}

	@Override
	public String getResultMsgOfMobileRes(String errorCode) {
		return config.getString(errorCode);
	}

	@Override
	public String getDbpIp(String hostName) {
		return config.getString(hostName+".DBP_IP");
	}

	@Override
	public String getDbpIp() {
		try {
			return config.getString(InetAddress.getLocalHost().getHostName().toUpperCase()+".DBP_IP");
		} catch (UnknownHostException e) {
			return null;
		}
	}

	@Override
	public int getDbpPort(String hostName) {
		return config.getInt(hostName+".DBP_PORT");
	}

	@Override
	public int getDbpPort() {
		try {
			return config.getInt(InetAddress.getLocalHost().getHostName().toUpperCase()+".DBP_PORT");
		} catch (UnknownHostException e) {
			return 0;
		}
	}

	@Override
	public IfHeaderDbpReqVO setDbpReqHeader(IfHeaderMobReqVO ifHeaderMobReqVO) {
		IfHeaderDbpReqVO ifHeaderDbpReqVO = new IfHeaderDbpReqVO();
		ifHeaderDbpReqVO.setAuthKey( getReqAuthKey( ifHeaderMobReqVO.getComAuthKey() ) );
		ifHeaderDbpReqVO.setInterfaceId(ifHeaderMobReqVO.getComInterfaceId());
		ifHeaderDbpReqVO.setReqDevCd(ifHeaderMobReqVO.getComReqDevCd());
		ifHeaderDbpReqVO.setCc(ifHeaderMobReqVO.getComCc());
		ifHeaderDbpReqVO.setPhoneNum(ifHeaderMobReqVO.getComPhoneNum());
		ifHeaderDbpReqVO.setModel(ifHeaderMobReqVO.getComModel());
		ifHeaderDbpReqVO.setManufacturer(ifHeaderMobReqVO.getComManufacturer());
		ifHeaderDbpReqVO.setDataType(ifHeaderMobReqVO.getComDataType());
		ifHeaderDbpReqVO.setRequestDate(ifHeaderMobReqVO.getComRequestDate());
		return ifHeaderDbpReqVO;
	}

	@Override
	public IfHeaderMobResVO setMobResHeader(IfHeaderDbpResVO ifHeaderDbpResVO) {
		IfHeaderMobResVO ifHeaderMobResVO = new IfHeaderMobResVO();
		ifHeaderMobResVO.setComAuthKey(ifHeaderDbpResVO.getAuthKey());
		setResultCode(ifHeaderDbpResVO, ifHeaderMobResVO);
		ifHeaderMobResVO.setComInterfaceId(ifHeaderDbpResVO.getInterfaceId());
		ifHeaderMobResVO.setComResponseDate(ifHeaderDbpResVO.getResponseDate());
		return ifHeaderMobResVO;
	}
	
	public void setResultCode(IfHeaderDbpResVO ifHeaderDbpResVO, IfHeaderMobResVO ifHeaderMobResVO) {
		if("SUCCESS_EXIST_GROUP_NAME".equals(ifHeaderDbpResVO.getResultMsg())){
			ifHeaderMobResVO.setComResultCode("GO05502");
			ifHeaderMobResVO.setComResultMsg(ifHeaderDbpResVO.getResultMsg());
		} else {
			ifHeaderMobResVO.setComResultCode(getResultMsgOfMobileRes(ifHeaderDbpResVO.getResultCode()));
			ifHeaderMobResVO.setComResultMsg(ifHeaderDbpResVO.getResultMsg());
		}
	}

	@Override
	public IfErrMobResVO chkDemoInterface(IfHeaderMobReqVO ifHeaderMobReqVO, String adminCode, String userId) {
		try {
			
			if(adminCode.equals(config.getString("DEMO.ADMIN_CODE")) 
					&& userId.equals(config.getString("DEMO.USER_ID"))) {
				
				// demo id 인 경우 인증키 체크 통과 && 접근 안되는 전문 체크
				String ifidStr = config.getString("DEMO.NOT_ACCESS_INTERFACE");
				String[] ifids = ifidStr.split(";");
				for(String ifid : ifids) {
					if(ifHeaderMobReqVO.getComInterfaceId().equals(ifid)) {
						return getMobErrorResponseMsg(ifHeaderMobReqVO, "CO00901");
					}
				}
				
			}
			
		} catch (Exception e) {

			logger.error(e);
			return getMobErrorResponseMsg(ifHeaderMobReqVO, "CO00900");

		}
		return null;
	}
	
	/**
	 * 유효한 인증키인지 체크, 세션 타임아웃 체크
	 */
	@Override
	public IfErrMobResVO chkAuthInfo(IfHeaderMobReqVO ifHeaderMobReqVO, String adminCode, String userId) {
		try {
			
			if(isEmptyOrMaxLengthOver(ifHeaderMobReqVO.getComAuthKey(), 255, "M"))	return getMobErrorResponseMsg(ifHeaderMobReqVO, "CO00002");
			
			if(adminCode.equals(config.getString("DEMO.ADMIN_CODE")) 
					&& userId.equals(config.getString("DEMO.USER_ID"))) {
				
				// demo id 인 경우 인증키 체크 통과 && 접근 안되는 전문 체크
				String ifidStr = config.getString("DEMO.NOT_ACCESS_INTERFACE");
				String[] ifids = ifidStr.split(";");
				for(String ifid : ifids) {
					if(ifHeaderMobReqVO.getComInterfaceId().equals(ifid)) {
						return getMobErrorResponseMsg(ifHeaderMobReqVO, "CO00901");
					}
				}
				
			} else {

				AuthVO reqAuthVO = new AuthVO( userId, getReqAuthKey(ifHeaderMobReqVO.getComAuthKey()), getAuthReqTime(ifHeaderMobReqVO.getComAuthKey()) );
				AuthVO resAuthVO = authService.selectAuthInfo(reqAuthVO);
				if( resAuthVO == null ) return getMobErrorResponseMsg(ifHeaderMobReqVO, "CO00401");

				Long registerDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(getLastConnectTime(ifHeaderMobReqVO.getComAuthKey()), new ParsePosition(0)).getTime();
				Long currentDate = Calendar.getInstance().getTime().getTime();
				if(currentDate - registerDate > (1000 * 60 * config.getInt("SESSION_TIME"))) {
					authService.deleteAuthInfo(reqAuthVO);
					return getMobErrorResponseMsg(ifHeaderMobReqVO, "CO00402");
				}

			}
			
		} catch (Exception e) {

			logger.error(e);
			return getMobErrorResponseMsg(ifHeaderMobReqVO, "CO00002");

		}
		return null;
	}
	
	/**
	 * 인증키에 마지막 리스판스 시간 추가
	 */
	@Override
	public void addResAuthTime(IfHeaderMobReqVO ifHeaderMobReqVO, IfHeaderMobResVO IfHeaderMobResVO) {
		if(StringUtils.stripToEmpty(ifHeaderMobReqVO.getComAuthKey()).length() == 0) return;
		String authKey = DSDecode(ifHeaderMobReqVO.getComAuthKey());
		authKey = authKey.substring(0, authKey.lastIndexOf("|") );
		authKey = authKey + "|" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		IfHeaderMobResVO.setComAuthKey(DSEncode(authKey));
	}
	
	/**
	 * GW 에서 추가한 데이터를 삭제하고 인증키를 리턴
	 */
	@Override
	public String getReqAuthKey(String reqAuthKey) {
		if(StringUtils.stripToEmpty(reqAuthKey).length() == 0) return reqAuthKey;
		reqAuthKey = DSDecode(reqAuthKey);
		reqAuthKey = reqAuthKey.substring(0, reqAuthKey.lastIndexOf("|") );
		String authValue = reqAuthKey.substring(0, reqAuthKey.lastIndexOf("|") );
		return DSEncode(authValue);
	}

	/**
	 * DB 비교를 위해 인증키에서 AUTH_REQ_DATE 추출
	 */
	@Override
	public String getAuthReqTime(String reqAuthKey) {
		if(StringUtils.stripToEmpty(reqAuthKey).length() == 0) return reqAuthKey;
		reqAuthKey = DSDecode(reqAuthKey);
		reqAuthKey = reqAuthKey.substring(0, reqAuthKey.lastIndexOf("|") );
		String authReqTime = reqAuthKey.substring(reqAuthKey.lastIndexOf("|"), reqAuthKey.length() ).replace("|", "");
		return authReqTime;
	}
	
	/**
	 * 인증키에 마지막 리스판스 시간 추출
	 */
	@Override
	public String getLastConnectTime(String reqAuthKey) {
		if(StringUtils.stripToEmpty(reqAuthKey).length() == 0) return reqAuthKey;
		reqAuthKey = DSDecode(reqAuthKey);
		String lastConnectTime = reqAuthKey.substring(reqAuthKey.lastIndexOf("|"), reqAuthKey.length()).replace("|", "");
		return lastConnectTime;
	}

	@Override
	public String getMobilePageCount(String reqDevCd, String resolution) {
		return config.getString(reqDevCd+"_"+resolution);
	}

	/**
	 *  암호화 라이브러리 - 암호화할 입력값을 입력받아 자체의 특정한 규칙에 따라 Encoding
	 *
	 *  @param   strIn		암호화할 문자열
	 *  @return  String		암호화된 문자열
	*/
	@Override
	public String DSEncode(String strIn)
	{

		strIn = strIn + config.getString("CYPER_KEY");
		String retStr="";

		for(int i=0; i < strIn.length(); i++) {
			retStr += (char)((int)strIn.charAt(i)+(i % 5)+ 1 );
		}

		return retStr;
//		return strIn;
	}

	/**
	 * 암호화 라이브러리 - 암호된 입력값을 입력받아 자체의 특정한 규칙에 따라 Decoding
	 *
	 * @param   strIn		암호화된 문자열
	 * @return  String		일반 문자열
	 */
	@Override
	public String DSDecode(String strIn)
	{
		String retStr = "";
		String cyperKey = config.getString("CYPER_KEY");

		for(int i=0; i < (strIn.length()); i++) {
             retStr += (char)((int)(strIn.charAt(i))-(i % 5) - 1 );
		}

		if(retStr.length() < 2 || !retStr.substring(retStr.length()-cyperKey.length()).equals(cyperKey)) {
			retStr = "";
		} else {
			retStr = retStr.substring(0, retStr.length() - cyperKey.length());
		}
		logger.debug("DSDecode Key="+retStr);
		return retStr;
//		return strIn;
	}

	@Override
	public String getGwDateType() {
		Date today= new java.util.Date( );
		return sdf.format(today);
	}
}