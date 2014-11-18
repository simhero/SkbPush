package com.skt.ssp.gw.service.impl;

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

import com.skt.ssp.gw.adapter.ApnsMsgSender;
import com.skt.ssp.gw.adapter.C2dmMsgSender;
import com.skt.ssp.gw.adapter.DbpMsgSender;
import com.skt.ssp.gw.common.QueueSend;
import com.skt.ssp.gw.parse.PushDbpMsgMaker;
import com.skt.ssp.gw.parse.PushDbpMsgReader;
import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.service.PushService;
import com.skt.ssp.gw.vo.push.IfPu001MobReqVO;
import com.skt.ssp.gw.vo.push.IfPu001MobResVO;
import com.skt.ssp.gw.vo.push.IfPu002MobReqVO;
import com.skt.ssp.gw.vo.push.IfPu002MobResVO;
import com.skt.ssp.gw.vo.push.IfPu003ComBodyResVO;
import com.skt.ssp.gw.vo.push.IfPu003DbpDataResVO;
import com.skt.ssp.gw.vo.push.IfPu004MobReqVO;
import com.skt.ssp.gw.vo.push.IfPu004MobResVO;
import com.thoughtworks.xstream.XStream;

/**
 * Push Service Impl(PushServiceImpl)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: PushServiceImpl.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin  Express $
 */
@Service("pushService")
public class PushServiceImpl implements PushService {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CompositeConfiguration config;
	@Autowired
	private CommonService commonService;
	@Autowired
	private DbpMsgSender dbpMsgSender;
	@Autowired
	private PushDbpMsgMaker pushDbpMsgMaker;
	@Autowired
	private PushDbpMsgReader pushDbpMsgReader;
	@Autowired
	private ApnsMsgSender apnsMsgSender;
	@Autowired
	private C2dmMsgSender c2dmMsgSender;
	private QueueSend qs = null;

	public PushServiceImpl() {
	}

	@PostConstruct
	public void init() throws Exception {
		qs = commonService.getQueueInstance(config.getString("PUSH_QUEUE"));
	}

	@PreDestroy
	public void destroy() throws Exception {
		if(qs != null) qs.close();
	}

	@Override
	public CompositeConfiguration getConfiguration() {
		return config;
	}

	@Override
	public CommonService getCommonService() {
		return commonService;
	}

	@Override
	public void jmsPush() {
		try {
			sendQueue("QUEUE TEST");
		} catch (JMSException jmsEx) {
			qs = null;
			if (logger.isErrorEnabled()) {
				logger.error("jmsPush()\r\n" + jmsEx);
			}
		} catch (Exception e) {
			if (qs == null)
				qs = commonService.getQueueInstance(config.getString("PUSH_QUEUE"));
			if (logger.isErrorEnabled()) {
				logger.error("jmsPush()\r\n" + e);
			}
		}
	}

	public String send(String interfaceId, String dbpReqMessage) {
		return dbpMsgSender.send(interfaceId, StringUtils.stripToEmpty(dbpReqMessage));
	}

	private void sendQueue(String msg) throws Exception {
		HashMap<String,Object> queueData = new HashMap<String,Object>();
		logger.info("sendQueue(String msg) msg="+msg);
		queueData.put("MSG", msg);
		qs.send(queueData);
	}

	@Override
	public IfPu001MobResVO requestPush001(IfPu001MobReqVO ifPu001MobReqVO) {
		return getPu001DbpResMessage(send(ifPu001MobReqVO.getRequest().getHeader().getComInterfaceId(), getPu001DbpReqMessage(ifPu001MobReqVO)));
	}

	private String getPu001DbpReqMessage(IfPu001MobReqVO ifPu001MobReqVO) {
		return pushDbpMsgMaker.getPu001DbpReqMessage(ifPu001MobReqVO);
	}

	private IfPu001MobResVO getPu001DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return pushDbpMsgReader.getPu001DbpResMessage(dbpResMessage);
	}

	@Override
	public IfPu002MobResVO requestPush002(IfPu002MobReqVO ifPu002MobReqVO) {
		return getPu002DbpResMessage(send(ifPu002MobReqVO.getRequest().getHeader().getComInterfaceId(), getPu002DbpReqMessage(ifPu002MobReqVO)));
	}

	private String getPu002DbpReqMessage(IfPu002MobReqVO ifPu002MobReqVO) {
		return pushDbpMsgMaker.getPu002DbpReqMessage(ifPu002MobReqVO);
	}

	private IfPu002MobResVO getPu002DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return pushDbpMsgReader.getPu002DbpResMessage(dbpResMessage);
	}

	@Override
	public String requestPush003(String bodyStr) throws Exception {
		sendQueue(bodyStr);

		IfPu003ComBodyResVO ifPu003ComBodyResVO = new IfPu003ComBodyResVO();
		ifPu003ComBodyResVO.setResultCode("00");
		ifPu003ComBodyResVO.setResultMsg("SUCCESS");
		ifPu003ComBodyResVO.setResponseDate(commonService.getGwDateType());

		IfPu003DbpDataResVO ifPu003DbpDataResVO = new IfPu003DbpDataResVO();
		ifPu003DbpDataResVO.setBody(ifPu003ComBodyResVO);

		logger.debug("ifPu003DbpDataResVO="+ifPu003DbpDataResVO);
		XStream xstream = new XStream();
		xstream.alias("Response", IfPu003DbpDataResVO.class);
		return xstream.toXML(ifPu003DbpDataResVO);
	}

	@Override
	public String getPush003ErrorResponseMsg(String errCode) {
		IfPu003ComBodyResVO ifPu003ComBodyResVO = new IfPu003ComBodyResVO();
		ifPu003ComBodyResVO.setResultCode("99");
		ifPu003ComBodyResVO.setResultMsg(config.getString(errCode));
		ifPu003ComBodyResVO.setResponseDate(commonService.getGwDateType());

		IfPu003DbpDataResVO ifPu003DbpDataResVO = new IfPu003DbpDataResVO();
		ifPu003DbpDataResVO.setBody(ifPu003ComBodyResVO);

		logger.debug("ifPu003DbpDataResVO="+ifPu003DbpDataResVO);
		XStream xstream = new XStream();
		xstream.alias("Response", IfPu003DbpDataResVO.class);
		return xstream.toXML(ifPu003DbpDataResVO);
	}

	@Override
	public IfPu004MobResVO requestPush004(IfPu004MobReqVO ifPu004MobReqVO) {
		return getPu004DbpResMessage(send(ifPu004MobReqVO.getRequest().getHeader().getComInterfaceId(), getPu004DbpReqMessage(ifPu004MobReqVO)));
	}

	private String getPu004DbpReqMessage(IfPu004MobReqVO ifPu004MobReqVO) {
		return pushDbpMsgMaker.getPu004DbpReqMessage(ifPu004MobReqVO);
	}

	private IfPu004MobResVO getPu004DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return pushDbpMsgReader.getPu004DbpResMessage(dbpResMessage);
	}

	public ApnsMsgSender getApnsMsgSender() {
		return apnsMsgSender;
	}

	public C2dmMsgSender getC2dmMsgSender() {
		return c2dmMsgSender;
	}

	public PushDbpMsgReader getPushDbpMsgReader() {
		return pushDbpMsgReader;
	}


}