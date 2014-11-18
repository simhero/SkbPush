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

import com.skt.ssp.gw.adapter.DbpMsgSender;
import com.skt.ssp.gw.common.QueueSend;
import com.skt.ssp.gw.parse.IntroDbpMsgMaker;
import com.skt.ssp.gw.parse.IntroDbpMsgReader;
import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.service.IntroService;
import com.skt.ssp.gw.vo.intro.IfIn001MobReqVO;
import com.skt.ssp.gw.vo.intro.IfIn001MobResVO;
import com.skt.ssp.gw.vo.intro.IfIn002MobReqVO;
import com.skt.ssp.gw.vo.intro.IfIn002MobResVO;

/**
 * Intro Service Impl(IntroServiceImpl)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IntroServiceImpl.java,v 1.0 2011/09/03 00:00:00 SimByungChul  Express $
 */
@Service("introService")
public class IntroServiceImpl implements IntroService {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CompositeConfiguration config;
	@Autowired
	private CommonService commonService;
	@Autowired
	private IntroDbpMsgMaker introDbpMsgMaker;
	@Autowired
	private IntroDbpMsgReader introDbpMsgReader;
	@Autowired
	private DbpMsgSender dbpMsgSender;
	private QueueSend qs = null;

	public IntroServiceImpl() {
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
	public void jmsTest() {
		try {
			sendQueue("QUEUE TEST");
		} catch (JMSException jmsEx) {
			qs = null;
			if (logger.isErrorEnabled()) {
				logger.error("jmsIntro()\r\n" + jmsEx);
			}
		} catch (Exception e) {
			if (qs == null)
				qs = commonService.getQueueInstance(config.getString("SAMPLE_QUEUE"));
			if (logger.isErrorEnabled()) {
				logger.error("jmsIntro()\r\n" + e);
			}
		}
	}

	private void sendQueue(String msg) throws Exception {
		HashMap<String,Object> queueData = new HashMap<String,Object>();
		logger.info("sendQueue(String msg) msg="+msg);
		queueData.put("MSG", msg);
		qs.send(queueData);
	}

	public String send(String interfaceId, String dbpReqMessage) {
		return dbpMsgSender.send(interfaceId, StringUtils.stripToEmpty(dbpReqMessage));
	}

	@Override
	public IfIn001MobResVO requestIntro001(IfIn001MobReqVO ifIn001MobReqVO) {
		return getIn001DbpResMessage(send(ifIn001MobReqVO.getRequest().getHeader().getComInterfaceId(), getIn001DbpReqMessage(ifIn001MobReqVO)));
	}

	private String getIn001DbpReqMessage(IfIn001MobReqVO ifIn001MobReqVO) {
		return introDbpMsgMaker.getIn001DbpReqMessage(ifIn001MobReqVO);
	}

	private IfIn001MobResVO getIn001DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return introDbpMsgReader.getIn001DbpResMessage(dbpResMessage);
	}

	@Override
	public IfIn002MobResVO requestIntro002(IfIn002MobReqVO ifIn002MobReqVO) {
		return getIn002DbpResMessage(send(ifIn002MobReqVO.getRequest().getHeader().getComInterfaceId(), getIn002DbpReqMessage(ifIn002MobReqVO)));
	}

	private String getIn002DbpReqMessage(IfIn002MobReqVO ifIn002MobReqVO) {
		return introDbpMsgMaker.getIn002DbpReqMessage(ifIn002MobReqVO);
	}

	private IfIn002MobResVO getIn002DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return introDbpMsgReader.getIn002DbpResMessage(dbpResMessage);
	}
}