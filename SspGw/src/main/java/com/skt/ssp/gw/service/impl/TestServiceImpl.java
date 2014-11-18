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
import com.skt.ssp.gw.parse.TestDbpMsgMaker;
import com.skt.ssp.gw.parse.TestDbpMsgReader;
import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.service.TestService;
import com.skt.ssp.gw.vo.test.IfTe001MobReqVO;
import com.skt.ssp.gw.vo.test.IfTe001MobResVO;

/**
 * Test Service Impl(TestServiceImpl)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: TestServiceImpl.java,v 1.0 2011/09/03 00:00:00 SimByungChul  Express $
 */
@Service("testService")
public class TestServiceImpl implements TestService {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CompositeConfiguration config;
	@Autowired
	private CommonService commonService;
	@Autowired
	private TestDbpMsgMaker testDbpMsgMaker;
	@Autowired
	private TestDbpMsgReader testDbpMsgReader;
	@Autowired
	private DbpMsgSender dbpMsgSender;
	private QueueSend qs = null;

	public TestServiceImpl() {
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
				logger.error("jmsTest()\r\n" + jmsEx);
			}
		} catch (Exception e) {
			if (qs == null)
				qs = commonService.getQueueInstance(config.getString("SAMPLE_QUEUE"));
			if (logger.isErrorEnabled()) {
				logger.error("jmsTest()\r\n" + e);
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
	public IfTe001MobResVO requestTest001(IfTe001MobReqVO ifTe001MobReqVO) {
		return getTe001DbpResMessage(send(ifTe001MobReqVO.getRequest().getHeader().getComInterfaceId(), getTe001DbpReqMessage(ifTe001MobReqVO)));
	}

	private String getTe001DbpReqMessage(IfTe001MobReqVO ifTe001MobReqVO) {
		return testDbpMsgMaker.getTe001DbpReqMessage(ifTe001MobReqVO);
	}

	private IfTe001MobResVO getTe001DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return testDbpMsgReader.getTe001DbpResMessage(dbpResMessage);
	}

}