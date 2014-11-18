package com.skt.ssp.ih.service.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.jms.JMSException;
import javax.jms.MessageListener;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skt.ssp.ih.common.QueueReceive;
import com.skt.ssp.ih.common.QueueSend;
import com.skt.ssp.ih.service.CommonService;
import com.skt.ssp.ih.vo.imageConvert.IfIh001BodyFileResVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh001BodyResVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh001BodyUrlResVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh001DataResVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002BodyResVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002DataResVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh003BodyFileReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh003BodyReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh003BodyUrlReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh003DataReqVO;
import com.thoughtworks.xstream.XStream;

/**
 * CommonServiceImpl (CommonServiceImpl)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: CommonServiceImpl.java,v1.0 2011/10/11 00:00:00 ChoKyuJin Express $
 */
@Service("commonService")
public class CommonServiceImpl implements CommonService {
	protected final Log logger = LogFactory.getLog(getClass());
	protected final Log logger2 = LogFactory.getLog("XXX_XXX_XXX");
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Autowired
	private CompositeConfiguration config;
	
	public static String[] msgJinsu = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	public static int msgSeqNumber = 0;
	
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
			logger.error(e);
			return config.getString(config.getString("DEFAULT_HOST_NAME")+".SERVER_ID");
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
			logger.error(e);
			return config.getString(config.getString("DEFAULT_HOST_NAME")+".SERVER_SOURCE_IP");
		}
	}

	@Override
	public String getHostName() {
		try {
			return InetAddress.getLocalHost().getHostName().toUpperCase();
		} catch (UnknownHostException e) {
			logger.error(e);
			return config.getString("DEFAULT_HOST_NAME");
		}
	}

	@Override
	public String getHostAddress() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public String getServerMode() {
		try {
			return config.getString(InetAddress.getLocalHost().getHostName().toUpperCase()+".MODE");
		} catch (UnknownHostException e) {
			logger.error(e);
			return config.getString(config.getString("DEFAULT_HOST_NAME")+".MODE");
		}
	}
	
	@Override
	public String getDbpIp() {
		try {
			return config.getString(InetAddress.getLocalHost().getHostName().toUpperCase()+".DBP_IP");
		} catch (UnknownHostException e) {
			logger.error(e);
			return config.getString(config.getString("DEFAULT_HOST_NAME")+".DBP_IP");
		}
	}
	
	@Override
	public int getDbpPort() {
		try {
			return config.getInt(InetAddress.getLocalHost().getHostName().toUpperCase()+".DBP_PORT");
		} catch (UnknownHostException e) {
			logger.error(e);
			return 0;
		}
	}
	
	@Override
	public String getDbpReqEndPoint(String interfaceId) {
		return config.getString(getHostName()+".DBP_REQ_ENDPOINT."+interfaceId);
	}
	
	@Override
	public String getGwDateType() {
		Date today= new java.util.Date( );
		return sdf.format(today);
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
	public String getConversionCode() {
		return config.getString("DAEMON.IH_CONV.CONVERSION_CODE");
	}
	
	@Override
	public String getProcThreadCnt() {
		return config.getString("DAEMON.IH_CONV.PROC_THREAD_CNT");
	}
	
	@Override
	public String getProcThreadRow() {
		return config.getString("DAEMON.IH_CONV.PROC_THREAD_ROW");
	}
	
	@Override
	public String getConvertTool() {
		return config.getString(getHostName()+".IMG_CONVERT.TOOL");
	}
	
	@Override
	public String getSrcDir() {
		return config.getString(getHostName()+".IMG_CONVERT.SRC_DIR");
	}
	
	@Override
	public String getTempDir() {
		return config.getString(getHostName()+".IMG_CONVERT.TEMP_DIR");
	}
	
	@Override
	public String getDescDir() {
		return config.getString(getHostName()+".IMG_CONVERT.DESC_DIR");
	}
	
	@Override
	public String getImgUrl() {
		return config.getString(getHostName() + ".IMG_CONVERT.SERVICE_DOMAIN") + config.getString(getHostName() + ".IMG_CONVERT.HTTP_URL");
//		return config.getString(getHostName() + ".IMG_CONVERT.HTTP_URL");
	}
	
	@Override
	public String getFileSeqId(int cnt) {
		DecimalFormat df = new DecimalFormat("00000");
		return df.format(cnt);
	}
	
	@Override
	public String getFileId() {
		return new StringBuilder()
				.append(getServerId())
				.append(config.getString(getHostName() + ".MSG_REQ_SERVER_ID"))
				.append(getMessageSeq(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()))).toString();
	}
	
	@Override
	public String getConvId() {
		return new StringBuilder()
				.append(getServerId())
				.append(config.getString(getHostName() + ".MSG_REQ_SERVER_ID"))
				.append(getMessageSeq(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()))).toString();
	}
	
	public String getMessageSeq(String acceptTime) {
		return new StringBuilder()
				.append(oper10to36(Integer.parseInt(acceptTime.substring(2, 4))))
				.append(oper10to36(Integer.parseInt(acceptTime.substring(4, 6))))
				.append(oper10to36(Integer.parseInt(acceptTime.substring(6, 8))))
				.append(oper10to36(Integer.parseInt(acceptTime.substring(8, 10))))
				.append(acceptTime.substring(10, 12))
				.append(acceptTime.substring(12, 14))
				.append(StringUtils.leftPad(oper10to36(getMsgSeqNumber()), 3, '0')).toString();
	}

	private String oper10to36(int data) {
		String ret = "";
		int imsi = data;
		if (data < 36 && data > -1) {
			ret = msgJinsu[data];
		} else {
			while (true) {
				int quotient = imsi / 36;
				int remainder = imsi % 36;
				ret = msgJinsu[remainder] + ret;
				if (quotient < 36) {
					ret = msgJinsu[quotient] + ret;
					break;
				}
				imsi = quotient;
			}
		}
		return ret;
	}

	private synchronized int getMsgSeqNumber() {
		if (msgSeqNumber >= 30000) {
			msgSeqNumber = 0;
		} else {
			++msgSeqNumber;
		}
		return msgSeqNumber;
	}
	
	@Override
	public String getDeviceStr(String type) {
		String rsltStr = "";
		if("IOS".equals(type))		rsltStr = "IOS";
		else if("AND".equals(type))	rsltStr = "AND";
		else if("TEMP".equals(type))rsltStr = "TEMP";
		else						rsltStr = "DEFAULT";
		return rsltStr;
	}
	
	@Override
	public String getDeviceImgSize(String type) {
		String rsltStr = "";
		String temp = StringUtils.stripToEmpty(type);
		if("".equals(temp))			rsltStr = "144x144";
		else if("IOS".equals(temp))	rsltStr = "144x144";
		else if("AND".equals(temp))	rsltStr = "108x108";
		else						rsltStr = temp;
		return rsltStr;
	}

	@Override
	public boolean isAllowAccess(String remoteIp) {
		logger.debug("remoteIp="+remoteIp);
		if("Y".equals(config.getString("ACCESS_IP_CHECK"))) {
			String accessIp = config.getString("ALLOW_ACCESS_IP");
			if(accessIp.indexOf(remoteIp) > -1) return true;
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public void setErrorResUrlCode(IfIh001BodyUrlResVO resUrlVO, String errorCode) {
		resUrlVO.setResultCode(errorCode);
		resUrlVO.setResultMsg(config.getString(errorCode));
	}
	
	@Override
	public void setErrorResUrlCode(IfIh003BodyUrlReqVO resUrlVO, String errorCode) {
		resUrlVO.setResultCode(errorCode);
		resUrlVO.setResultMsg(config.getString(errorCode));
	}
	
	@Override
	public IfIh001DataResVO setIfIh001ResponseVO(String errcode) {
		IfIh001BodyResVO bodyVO = new IfIh001BodyResVO();
		bodyVO.setResultCode(errcode);
		bodyVO.setResultMsg(config.getString(errcode));
		bodyVO.setResponseDate(sdf.format(new Date()));
		IfIh001DataResVO resVO = new IfIh001DataResVO();
		resVO.setBody(bodyVO);
		return resVO;
	}
	
	@Override
	public IfIh002DataResVO setIfIh002ResponseVO(String errcode) {
		IfIh002BodyResVO bodyVO = new IfIh002BodyResVO();
		bodyVO.setResultCode(errcode);
		bodyVO.setResultMsg(config.getString(errcode));
		bodyVO.setResponseDate(sdf.format(new Date()));
		IfIh002DataResVO resVO = new IfIh002DataResVO();
		resVO.setBody(bodyVO);
		return resVO;
	}
	
	@Override
	public IfIh003DataReqVO setIfIh003RequestVO(String errcode) {
		IfIh003BodyReqVO bodyVO = new IfIh003BodyReqVO();
		IfIh003DataReqVO reqVO = new IfIh003DataReqVO();
		reqVO.setBody(bodyVO);
		reqVO.getBody().setFileList(new ArrayList<IfIh003BodyFileReqVO>());
		return reqVO;
	}
	
	@Override
	public IfIh001DataResVO setIfIh001ResponseErrorVO(String errcode, String msg) {
		IfIh001BodyResVO bodyVO = new IfIh001BodyResVO();
		bodyVO.setResultCode(errcode);
		bodyVO.setResultMsg(config.getString(errcode) + " : " + StringUtils.substring(msg, 0, 128));
		bodyVO.setResponseDate(sdf.format(new Date()));
		IfIh001DataResVO resVO = new IfIh001DataResVO();
		resVO.setBody(bodyVO);
		return resVO;
	}
	
	@Override
	public IfIh002DataResVO setIfIh002ResponseErrorVO(String errcode, String msg) {
		IfIh002BodyResVO bodyVO = new IfIh002BodyResVO();
		bodyVO.setResultCode(errcode);
		bodyVO.setResultMsg(config.getString(errcode) + " : " + StringUtils.substring(msg, 0, 128));
		bodyVO.setResponseDate(sdf.format(new Date()));
		IfIh002DataResVO resVO = new IfIh002DataResVO();
		resVO.setBody(bodyVO);
		return resVO;
	}
	
	@Override
	public String returnStringIfIh001(IfIh001DataResVO imageConvertResVO) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfIh001DataResVO.class);
		xstream.alias("files", IfIh001BodyFileResVO.class);
		xstream.alias("urls", IfIh001BodyUrlResVO.class);
		String xml = xstream.toXML(imageConvertResVO);
		logger.debug("returnString="+xml);
		return xml;
	}
	
	@Override
	public String returnStringIfIh002(IfIh002DataResVO imageConvertResVO) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfIh002DataResVO.class);
		String xml = xstream.toXML(imageConvertResVO);
		logger.debug("returnString="+xml);
		return xml;
	}
	
	@Override
	public String requestStringIfIh003(IfIh003DataReqVO imageConvertResVO) {
		XStream xstream = new XStream();
		xstream.alias("Request", IfIh003DataReqVO.class);
		xstream.alias("files", IfIh003BodyFileReqVO.class);
		xstream.alias("urls", IfIh003BodyUrlReqVO.class);
		String xml = xstream.toXML(imageConvertResVO);
		logger.debug("returnString="+xml);
		return xml;
	}

}