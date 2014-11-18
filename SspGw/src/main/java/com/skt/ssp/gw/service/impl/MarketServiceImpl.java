package com.skt.ssp.gw.service.impl;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.jms.JMSException;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skt.ssp.gw.common.QueueSend;
import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.service.MarketService;
import com.skt.ssp.gw.vo.test.IfTe001MobReqVO;
import com.skt.ssp.gw.vo.test.IfTe001MobResVO;

/**
 * Market Service Impl(MarketServiceImpl)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: MarketServiceImpl.java,v 1.0 2011/09/03 00:00:00 SimByungChul  Express $
 */
@Service("marketService")
public class MarketServiceImpl implements MarketService {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CompositeConfiguration config;
	@Autowired
	private CommonService commonService;
	private QueueSend qs = null;

	public MarketServiceImpl() {
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
	public void jmsMarket() {
		try {
			sendQueue("QUEUE TEST");
		} catch (JMSException jmsEx) {
			qs = null;
			if (logger.isErrorEnabled()) {
				logger.error("jmsMarket()\r\n" + jmsEx);
			}
		} catch (Exception e) {
			if (qs == null)
				qs = commonService.getQueueInstance(config.getString("SAMPLE_QUEUE"));
			if (logger.isErrorEnabled()) {
				logger.error("jmsMarket()\r\n" + e);
			}
		}
	}

	private void sendQueue(String msg) throws Exception {
		HashMap<String,Object> queueData = new HashMap<String,Object>();
		logger.info("sendQueue(String msg) msg="+msg);
		queueData.put("MSG", msg);
		qs.send(queueData);
	}

	@Override
	public IfTe001MobResVO requestMarket001(IfTe001MobReqVO ifTe001MobReqVO) {
		// TODO Auto-generated method stub
		return null;
	}
}