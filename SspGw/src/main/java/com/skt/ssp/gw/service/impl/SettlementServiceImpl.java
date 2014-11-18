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
import com.skt.ssp.gw.parse.SettlementDbpMsgMaker;
import com.skt.ssp.gw.parse.SettlementDbpMsgReader;
import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.service.SettlementService;
import com.skt.ssp.gw.vo.settlement.IfSe001MobReqVO;
import com.skt.ssp.gw.vo.settlement.IfSe001MobResVO;
import com.skt.ssp.gw.vo.settlement.IfSe002MobReqVO;
import com.skt.ssp.gw.vo.settlement.IfSe002MobResVO;

/**
 * Settlement Service Impl(SettlementServiceImpl)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: SettlementServiceImpl.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin  Express $
 */
@Service("settlementService")
public class SettlementServiceImpl implements SettlementService {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CompositeConfiguration config;
	@Autowired
	private CommonService commonService;
	@Autowired
	private DbpMsgSender dbpMsgSender;
	@Autowired
	private SettlementDbpMsgMaker settlementDbpMsgMaker;
	@Autowired
	private SettlementDbpMsgReader settlementDbpMsgReader;
	private QueueSend qs = null;

	public SettlementServiceImpl() {
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
	public void jmsSettlement() {
		try {
			sendQueue("QUEUE TEST");
		} catch (JMSException jmsEx) {
			qs = null;
			if (logger.isErrorEnabled()) {
				logger.error("jmsSettlement()\r\n" + jmsEx);
			}
		} catch (Exception e) {
			if (qs == null)
				qs = commonService.getQueueInstance(config.getString("SAMPLE_QUEUE"));
			if (logger.isErrorEnabled()) {
				logger.error("jmsSettlement()\r\n" + e);
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
	public IfSe001MobResVO requestSettlement001(IfSe001MobReqVO ifSe001MobReqVO) {
		return getSe001DbpResMessage(send(ifSe001MobReqVO.getRequest().getHeader().getComInterfaceId(), getSe001DbpReqMessage(ifSe001MobReqVO)));
	}

	private String getSe001DbpReqMessage(IfSe001MobReqVO ifSe001MobReqVO) {
		return settlementDbpMsgMaker.getSe001DbpReqMessage(ifSe001MobReqVO);
	}

	private IfSe001MobResVO getSe001DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return settlementDbpMsgReader.getSe001DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfSe002MobResVO requestSettlement002(IfSe002MobReqVO ifSe002MobReqVO) {
		return getSe002DbpResMessage(send(ifSe002MobReqVO.getRequest().getHeader().getComInterfaceId(), getSe002DbpReqMessage(ifSe002MobReqVO)));
	}

	private String getSe002DbpReqMessage(IfSe002MobReqVO ifSe002MobReqVO) {
		return settlementDbpMsgMaker.getSe002DbpReqMessage(ifSe002MobReqVO);
	}

	private IfSe002MobResVO getSe002DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return settlementDbpMsgReader.getSe002DbpResMessage(dbpResMessage);
	}
	
}