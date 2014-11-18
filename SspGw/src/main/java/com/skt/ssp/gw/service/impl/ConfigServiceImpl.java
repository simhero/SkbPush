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
import com.skt.ssp.gw.parse.ConfigDbpMsgMaker;
import com.skt.ssp.gw.parse.ConfigDbpMsgReader;
import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.service.ConfigService;
import com.skt.ssp.gw.vo.config.IfCf001MobReqVO;
import com.skt.ssp.gw.vo.config.IfCf001MobResVO;
import com.skt.ssp.gw.vo.config.IfCf002MobReqVO;
import com.skt.ssp.gw.vo.config.IfCf002MobResVO;
import com.skt.ssp.gw.vo.config.IfCf003MobReqVO;
import com.skt.ssp.gw.vo.config.IfCf003MobResVO;
import com.skt.ssp.gw.vo.config.IfCf004MobReqVO;
import com.skt.ssp.gw.vo.config.IfCf004MobResVO;

/**
 * Config Service Impl(ConfigServiceImpl)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: ConfigServiceImpl.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin  Express $
 */
@Service("configService")
public class ConfigServiceImpl implements ConfigService {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CompositeConfiguration config;
	@Autowired
	private CommonService commonService;
	@Autowired
	private DbpMsgSender dbpMsgSender;
	@Autowired
	private ConfigDbpMsgMaker configDbpMsgMaker;
	@Autowired
	private ConfigDbpMsgReader configDbpMsgReader;
	private QueueSend qs = null;
	
	public ConfigServiceImpl() { }

	@PostConstruct
	public void init() throws Exception {
		qs = commonService.getQueueInstance(config.getString("SAMPLE_QUEUE"));
	}

	@PreDestroy
	public void destroy() throws Exception {
		if(qs != null) qs.close();
	}
	
	@Override
	public void jmsPush() {
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
	public IfCf001MobResVO requestConfig001(IfCf001MobReqVO ifCf001MobReqVO) {
		return getCf001DbpResMessage(send(ifCf001MobReqVO.getRequest().getHeader().getComInterfaceId(), getCf001DbpReqMessage(ifCf001MobReqVO)));
	}

	private String getCf001DbpReqMessage(IfCf001MobReqVO ifCf001MobReqVO) {
		return configDbpMsgMaker.getCf001DbpReqMessage(ifCf001MobReqVO);
	}

	private IfCf001MobResVO getCf001DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return configDbpMsgReader.getCf001DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfCf002MobResVO requestConfig002(IfCf002MobReqVO ifCf002MobReqVO) {
		return getCf002DbpResMessage(send(ifCf002MobReqVO.getRequest().getHeader().getComInterfaceId(), getCf002DbpReqMessage(ifCf002MobReqVO)));
	}

	private String getCf002DbpReqMessage(IfCf002MobReqVO ifCf002MobReqVO) {
		return configDbpMsgMaker.getCf002DbpReqMessage(ifCf002MobReqVO);
	}

	private IfCf002MobResVO getCf002DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return configDbpMsgReader.getCf002DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfCf003MobResVO requestConfig003(IfCf003MobReqVO ifCf003MobReqVO) {
		return getCf003DbpResMessage(send(ifCf003MobReqVO.getRequest().getHeader().getComInterfaceId(), getCf003DbpReqMessage(ifCf003MobReqVO)));
	}

	private String getCf003DbpReqMessage(IfCf003MobReqVO ifCf003MobReqVO) {
		return configDbpMsgMaker.getCf003DbpReqMessage(ifCf003MobReqVO);
	}

	private IfCf003MobResVO getCf003DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return configDbpMsgReader.getCf003DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfCf004MobResVO requestConfig004(IfCf004MobReqVO ifCf004MobReqVO) {
		return getCf004DbpResMessage(send(ifCf004MobReqVO.getRequest().getHeader().getComInterfaceId(), getCf004DbpReqMessage(ifCf004MobReqVO)));
	}

	private String getCf004DbpReqMessage(IfCf004MobReqVO ifCf004MobReqVO) {
		return configDbpMsgMaker.getCf004DbpReqMessage(ifCf004MobReqVO);
	}

	private IfCf004MobResVO getCf004DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return configDbpMsgReader.getCf004DbpResMessage(dbpResMessage);
	}
	
	
}