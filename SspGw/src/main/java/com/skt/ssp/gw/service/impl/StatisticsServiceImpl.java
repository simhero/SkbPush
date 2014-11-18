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
import com.skt.ssp.gw.parse.StatisticsDbpMsgMaker;
import com.skt.ssp.gw.parse.StatisticsDbpMsgReader;
import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.service.StatisticsService;
import com.skt.ssp.gw.vo.statistics.IfSt001MobReqVO;
import com.skt.ssp.gw.vo.statistics.IfSt001MobResVO;
import com.skt.ssp.gw.vo.statistics.IfSt002MobReqVO;
import com.skt.ssp.gw.vo.statistics.IfSt002MobResVO;

/**
 * Statistics Service Impl(StatisticsServiceImpl)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: StatisticsServiceImpl.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin  Express $
 */
@Service("statisticsService")
public class StatisticsServiceImpl implements StatisticsService {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CompositeConfiguration config;
	@Autowired
	private CommonService commonService;
	@Autowired
	private DbpMsgSender dbpMsgSender;
	@Autowired
	private StatisticsDbpMsgMaker statisticsDbpMsgMaker;
	@Autowired
	private StatisticsDbpMsgReader statisticsDbpMsgReader;
	private QueueSend qs = null;

	public StatisticsServiceImpl() {
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
	public void jmsStatistics() {
		try {
			sendQueue("QUEUE TEST");
		} catch (JMSException jmsEx) {
			qs = null;
			if (logger.isErrorEnabled()) {
				logger.error("jmsStatistics()\r\n" + jmsEx);
			}
		} catch (Exception e) {
			if (qs == null)
				qs = commonService.getQueueInstance(config.getString("SAMPLE_QUEUE"));
			if (logger.isErrorEnabled()) {
				logger.error("jmsStatistics()\r\n" + e);
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
	public IfSt001MobResVO requestStatistics001(IfSt001MobReqVO ifSt001MobReqVO) {
		return getSt001DbpResMessage(send(ifSt001MobReqVO.getRequest().getHeader().getComInterfaceId(), getSt001DbpReqMessage(ifSt001MobReqVO)));
	}

	private String getSt001DbpReqMessage(IfSt001MobReqVO ifSt001MobReqVO) {
		return statisticsDbpMsgMaker.getSt001DbpReqMessage(ifSt001MobReqVO);
	}

	private IfSt001MobResVO getSt001DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return statisticsDbpMsgReader.getSt001DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfSt002MobResVO requestStatistics002(IfSt002MobReqVO ifSt002MobReqVO) {
		return getSt002DbpResMessage(send(ifSt002MobReqVO.getRequest().getHeader().getComInterfaceId(), getSt002DbpReqMessage(ifSt002MobReqVO)));
	}

	private String getSt002DbpReqMessage(IfSt002MobReqVO ifSt002MobReqVO) {
		return statisticsDbpMsgMaker.getSt002DbpReqMessage(ifSt002MobReqVO);
	}

	private IfSt002MobResVO getSt002DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return statisticsDbpMsgReader.getSt002DbpResMessage(dbpResMessage);
	}
	
}