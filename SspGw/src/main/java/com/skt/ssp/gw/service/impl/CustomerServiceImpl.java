package com.skt.ssp.gw.service.impl;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.jms.JMSException;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skt.ssp.gw.adapter.DbpMsgSender;
import com.skt.ssp.gw.common.QueueSend;
import com.skt.ssp.gw.parse.CustomerDbpMsgMaker;
import com.skt.ssp.gw.parse.CustomerDbpMsgReader;
import com.skt.ssp.gw.service.AuthService;
import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.service.CustomerService;
import com.skt.ssp.gw.vo.AuthVO;
import com.skt.ssp.gw.vo.IfHeaderMobResVO;
import com.skt.ssp.gw.vo.customer.IfCu001ComBodyAuthResVO;
import com.skt.ssp.gw.vo.customer.IfCu001ComBodyResVO;
import com.skt.ssp.gw.vo.customer.IfCu001MobDataResVO;
import com.skt.ssp.gw.vo.customer.IfCu001MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu001MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu002MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu002MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu003MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu003MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu004MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu004MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu005MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu005MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu006MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu006MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu007MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu007MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu008MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu008MobResVO;

/**
 * Customer Service Impl(CustomerServiceImpl)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: CustomerServiceImpl.java,v 1.0 2011/09/03 00:00:00 SimByungChul  Express $
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CompositeConfiguration config;
	@Autowired
	private CommonService commonService;
	@Autowired
	private CustomerDbpMsgMaker customerDbpMsgMaker;
	@Autowired
	private CustomerDbpMsgReader customerDbpMsgReader;
	@Autowired
	private DbpMsgSender dbpMsgSender;
	@Autowired
	private AuthService authService;
	private QueueSend qs = null;

	public CustomerServiceImpl() {
	}

	@PostConstruct
	public void init() throws Exception {
		qs = commonService.getQueueInstance(config.getString("SAMPLE_QUEUE"));
	}

	@PreDestroy
	public void destroy() throws Exception {
		if(qs != null) qs.close();
	}

	@Override
	public void jmsCustomer() {
		try {
			sendQueue("QUEUE TEST");
		} catch (JMSException jmsEx) {
			qs = null;
			if (logger.isErrorEnabled()) {
				logger.error("jmsCustomer()\r\n" + jmsEx);
			}
		} catch (Exception e) {
			if (qs == null)
				qs = commonService.getQueueInstance(config.getString("SAMPLE_QUEUE"));
			if (logger.isErrorEnabled()) {
				logger.error("jmsCustomer()\r\n" + e);
			}
		}
	}

	private void sendQueue(String msg) throws Exception {
		HashMap<String,Object> queueData = new HashMap<String,Object>();
		logger.info("sendQueue(String msg) msg="+msg);
		queueData.put("MSG", msg);
		qs.send(queueData);
	}

	private String send(String interfaceId, String dbpReqMessage) {
		return dbpMsgSender.send(interfaceId, dbpReqMessage);
	}

	@Override
	public IfCu001MobResVO requestCustomer001(IfCu001MobReqVO ifCu001MobReqVO) throws Exception {
		IfCu001MobResVO ifCu001MobResVO = null;
		
		if(StringUtils.stripToEmpty(ifCu001MobReqVO.getRequest().getBody().getAdminCode()).equals(config.getString("DEMO.ADMIN_CODE")) 
				&& StringUtils.stripToEmpty(ifCu001MobReqVO.getRequest().getBody().getUserId()).equals(config.getString("DEMO.USER_ID"))) {
			// demo id 인 경우 임의 로그인키 생성 ( 더비 저장 없음 )
			ifCu001MobResVO = getDemoIdLogin(ifCu001MobReqVO);
		
		} else {
			
			String resMsg = send(ifCu001MobReqVO.getRequest().getHeader().getComInterfaceId(), getCu001DbpReqMessage(ifCu001MobReqVO));
			ifCu001MobResVO = getCu001DbpResMessage(resMsg);
			
			/*
			 * Auth key DB process
			 */
			if(ifCu001MobResVO != null && config.getString("SUCCESS").equals(ifCu001MobResVO.getResponse().getHeader().getComResultCode())) {
						
				//	1. Auth VO Create (adminCode, userId, authKey, authHeader, authBody, pushNotiId)
				AuthVO authVO = new AuthVO(ifCu001MobReqVO.getRequest().getBody().getAdminCode(), 
						ifCu001MobReqVO.getRequest().getBody().getUserId(), "", "", "", ifCu001MobReqVO.getRequest().getBody().getPushID());
				
				//	2. Auth Info DB Delete
				authService.deleteAuthInfo(authVO);
				
				//	3. Auth VO add value
				authVO.setAuthKey(ifCu001MobResVO.getResponse().getHeader().getComAuthKey());
				authVO.setAuthHeader(resMsg.substring(resMsg.indexOf("<header>"), resMsg.indexOf("</header>")) + "</header>");
				authVO.setAuthBody(resMsg.substring(resMsg.indexOf("<body>"), resMsg.indexOf("</body>")) + "</body>");
				authVO.setRegisterId(ifCu001MobReqVO.getRequest().getBody().getUserId());
				authVO.setUpdateId(ifCu001MobReqVO.getRequest().getBody().getUserId());
				String time = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime());
				authVO.setAuthReqDate(time);
				authVO.setAuthUpdDate(time);
				
				//	4. Auth Info DB Insert
				authService.insertAuthInfo(authVO);
				
				//  5. Auth key
				String authKey = commonService.DSDecode(ifCu001MobResVO.getResponse().getHeader().getComAuthKey()) + 
								"|" + time + 
								"|" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
				ifCu001MobResVO.getResponse().getHeader().setComAuthKey(commonService.DSEncode(authKey));
			}
			
		}
		
		return ifCu001MobResVO;
	}

	public String getCu001DbpReqMessage(IfCu001MobReqVO ifCu001MobReqVO) {
		return customerDbpMsgMaker.getCu001DbpReqMessage(ifCu001MobReqVO);
	}

	public IfCu001MobResVO getCu001DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return customerDbpMsgReader.getCu001DbpResMessage(dbpResMessage);
	}
	
	public IfCu001MobResVO getDemoIdLogin(IfCu001MobReqVO ifCu001MobReqVO) {
		IfCu001MobResVO ifCu001MobResVO = new IfCu001MobResVO();
		ifCu001MobResVO.setResponse(new IfCu001MobDataResVO());
		ifCu001MobResVO.getResponse().setHeader(new IfHeaderMobResVO());
		ifCu001MobResVO.getResponse().setBody(new IfCu001ComBodyResVO());
		ifCu001MobResVO.getResponse().getHeader().setComInterfaceId(ifCu001MobReqVO.getRequest().getHeader().getComInterfaceId());
		ifCu001MobResVO.getResponse().getHeader().setComTrId(ifCu001MobReqVO.getRequest().getHeader().getComTrId());
		ifCu001MobResVO.getResponse().getHeader().setComResponseDate(commonService.getGwDateType());
		ifCu001MobResVO.getResponse().getBody().setAdminCode(ifCu001MobReqVO.getRequest().getBody().getAdminCode());
		ifCu001MobResVO.getResponse().getBody().setUserId(ifCu001MobReqVO.getRequest().getBody().getUserId());
		
		if(StringUtils.stripToEmpty(ifCu001MobReqVO.getRequest().getBody().getUserPW()).equals(config.getString("DEMO.USER_PW"))) {

			String authKey = ifCu001MobReqVO.getRequest().getBody().getAdminCode() + 
							"|" + ifCu001MobReqVO.getRequest().getBody().getUserId() + 
							"|" + new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()) +
							"|" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()) + 
							"|" + commonService.getGwDateType();
			ifCu001MobResVO.getResponse().getHeader().setComAuthKey(commonService.DSEncode(authKey));
			ifCu001MobResVO.getResponse().getHeader().setComResultCode(config.getString("SUCCESS"));
			ifCu001MobResVO.getResponse().getHeader().setComResultMsg("SUCCESS");
			ifCu001MobResVO.getResponse().getBody().setAuthList(new ArrayList<IfCu001ComBodyAuthResVO>());
			for(int i = 1; i <= 10; i++) {
				DecimalFormat df = new DecimalFormat("00");
				IfCu001ComBodyAuthResVO ifCu001ComBodyAuthResVO = new IfCu001ComBodyAuthResVO();
				ifCu001ComBodyAuthResVO.setAuthority("111");
				ifCu001ComBodyAuthResVO.setMenuItem(df.format((i)));
				ifCu001MobResVO.getResponse().getBody().getAuthList().add(ifCu001ComBodyAuthResVO);
			}
			
		} else {

			ifCu001MobResVO.getResponse().getHeader().setComAuthKey("");
			ifCu001MobResVO.getResponse().getHeader().setComResultCode(config.getString("IF_E_1003"));
			ifCu001MobResVO.getResponse().getHeader().setComResultMsg(config.getString(ifCu001MobResVO.getResponse().getHeader().getComResultCode()));
			
		}
		return ifCu001MobResVO;
	}

	@Override
	public IfCu002MobResVO requestCustomer002(IfCu002MobReqVO ifCu002MobReqVO) {
		return getCu002DbpResMessage(send(ifCu002MobReqVO.getRequest().getHeader().getComInterfaceId(), getCu002DbpReqMessage(ifCu002MobReqVO)));
	}

	public String getCu002DbpReqMessage(IfCu002MobReqVO ifCu002MobReqVO) {
		return customerDbpMsgMaker.getCu002DbpReqMessage(ifCu002MobReqVO);
	}

	public IfCu002MobResVO getCu002DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return customerDbpMsgReader.getCu002DbpResMessage(dbpResMessage);
	}

	@Override
	public IfCu003MobResVO requestCustomer003(IfCu003MobReqVO ifCu003MobReqVO) {
		return getCu003DbpResMessage(send(ifCu003MobReqVO.getRequest().getHeader().getComInterfaceId(), getCu003DbpReqMessage(ifCu003MobReqVO)));
	}

	public String getCu003DbpReqMessage(IfCu003MobReqVO ifCu003MobReqVO) {
		return customerDbpMsgMaker.getCu003DbpReqMessage(ifCu003MobReqVO);
	}

	public IfCu003MobResVO getCu003DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return customerDbpMsgReader.getCu003DbpResMessage(dbpResMessage);
	}
	

	@Override
	public IfCu004MobResVO requestCustomer004(IfCu004MobReqVO ifCu004MobReqVO) {
		return getCu004DbpResMessage(send(ifCu004MobReqVO.getRequest().getHeader().getComInterfaceId(), getCu004DbpReqMessage(ifCu004MobReqVO)));
	}

	private String getCu004DbpReqMessage(IfCu004MobReqVO ifCu004MobReqVO) {
		return customerDbpMsgMaker.getCu004DbpReqMessage(ifCu004MobReqVO);
	}

	private IfCu004MobResVO getCu004DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return customerDbpMsgReader.getCu004DbpResMessage(dbpResMessage);
	}
	

	@Override
	public IfCu005MobResVO requestCustomer005(IfCu005MobReqVO ifCu005MobReqVO) {
		return getCu005DbpResMessage(send(ifCu005MobReqVO.getRequest().getHeader().getComInterfaceId(), getCu005DbpReqMessage(ifCu005MobReqVO)));
	}

	public String getCu005DbpReqMessage(IfCu005MobReqVO ifCu005MobReqVO) {
		return customerDbpMsgMaker.getCu005DbpReqMessage(ifCu005MobReqVO);
	}

	public IfCu005MobResVO getCu005DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return customerDbpMsgReader.getCu005DbpResMessage(dbpResMessage);
	}

	@Override
	public IfCu006MobResVO requestCustomer006(IfCu006MobReqVO ifCu006MobReqVO) {
		return getCu006DbpResMessage(send(ifCu006MobReqVO.getRequest().getHeader().getComInterfaceId(), getCu006DbpReqMessage(ifCu006MobReqVO)));
	}

	public String getCu006DbpReqMessage(IfCu006MobReqVO ifCu006MobReqVO) {
		return customerDbpMsgMaker.getCu006DbpReqMessage(ifCu006MobReqVO);
	}

	public IfCu006MobResVO getCu006DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return customerDbpMsgReader.getCu006DbpResMessage(dbpResMessage);
	}

	@Override
	public IfCu007MobResVO requestCustomer007(IfCu007MobReqVO ifCu007MobReqVO) {
		return getCu007DbpResMessage(send(ifCu007MobReqVO.getRequest().getHeader().getComInterfaceId(), getCu007DbpReqMessage(ifCu007MobReqVO)));
	}

	public String getCu007DbpReqMessage(IfCu007MobReqVO ifCu007MobReqVO) {
		return customerDbpMsgMaker.getCu007DbpReqMessage(ifCu007MobReqVO);
	}

	public IfCu007MobResVO getCu007DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return customerDbpMsgReader.getCu007DbpResMessage(dbpResMessage);
	}

	@Override
	public IfCu008MobResVO requestCustomer008(IfCu008MobReqVO ifCu008MobReqVO) throws Exception {
		return getCu008DbpResMessage(send(ifCu008MobReqVO.getRequest().getHeader().getComInterfaceId(), getCu008DbpReqMessage(ifCu008MobReqVO)));
	}
	
	public String getCu008DbpReqMessage(IfCu008MobReqVO ifCu008MobReqVO) {
		return customerDbpMsgMaker.getCu008DbpReqMessage(ifCu008MobReqVO);
	}

	public IfCu008MobResVO getCu008DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return customerDbpMsgReader.getCu008DbpResMessage(dbpResMessage);
	}

}