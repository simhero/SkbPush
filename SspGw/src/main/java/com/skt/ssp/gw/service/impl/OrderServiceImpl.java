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
import com.skt.ssp.gw.parse.OrderDbpMsgMaker;
import com.skt.ssp.gw.parse.OrderDbpMsgReader;
import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.service.OrderService;
import com.skt.ssp.gw.vo.order.IfOr001MobReqVO;
import com.skt.ssp.gw.vo.order.IfOr001MobResVO;
import com.skt.ssp.gw.vo.order.IfOr002MobReqVO;
import com.skt.ssp.gw.vo.order.IfOr002MobResVO;
import com.skt.ssp.gw.vo.order.IfOr003MobReqVO;
import com.skt.ssp.gw.vo.order.IfOr003MobResVO;

/**
 * Order Service Impl(OrderServiceImpl)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: OrderServiceImpl.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin  Express $
 */
@Service("oederService")
public class OrderServiceImpl implements OrderService {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CompositeConfiguration config;
	@Autowired
	private CommonService commonService;
	@Autowired
	private DbpMsgSender dbpMsgSender;
	@Autowired
	private OrderDbpMsgMaker orderDbpMsgMaker;
	@Autowired
	private OrderDbpMsgReader orderDbpMsgReader;
	private QueueSend qs = null;

	public OrderServiceImpl() {
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
	public void jmsOrder() {
		try {
			sendQueue("QUEUE TEST");
		} catch (JMSException jmsEx) {
			qs = null;
			if (logger.isErrorEnabled()) {
				logger.error("jmsOrder()\r\n" + jmsEx);
			}
		} catch (Exception e) {
			if (qs == null)
				qs = commonService.getQueueInstance(config.getString("SAMPLE_QUEUE"));
			if (logger.isErrorEnabled()) {
				logger.error("jmsOrder()\r\n" + e);
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
	public IfOr001MobResVO requestOrder001(IfOr001MobReqVO ifOr001MobReqVO) {
		return getOr001DbpResMessage(send(ifOr001MobReqVO.getRequest().getHeader().getComInterfaceId(), getOr001DbpReqMessage(ifOr001MobReqVO)));
	}

	private String getOr001DbpReqMessage(IfOr001MobReqVO ifOr001MobReqVO) {
		return orderDbpMsgMaker.getOr001DbpReqMessage(ifOr001MobReqVO);
	}

	private IfOr001MobResVO getOr001DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return orderDbpMsgReader.getOr001DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfOr002MobResVO requestOrder002(IfOr002MobReqVO ifOr002MobReqVO) {
		return getOr002DbpResMessage(send(ifOr002MobReqVO.getRequest().getHeader().getComInterfaceId(), getOr002DbpReqMessage(ifOr002MobReqVO)));
	}

	private String getOr002DbpReqMessage(IfOr002MobReqVO ifOr002MobReqVO) {
		return orderDbpMsgMaker.getOr002DbpReqMessage(ifOr002MobReqVO);
	}

	private IfOr002MobResVO getOr002DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return orderDbpMsgReader.getOr002DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfOr003MobResVO requestOrder003(IfOr003MobReqVO ifOr003MobReqVO) {
		return getOr003DbpResMessage(send(ifOr003MobReqVO.getRequest().getHeader().getComInterfaceId(), getOr003DbpReqMessage(ifOr003MobReqVO)));
	}

	private String getOr003DbpReqMessage(IfOr003MobReqVO ifOr003MobReqVO) {
		return orderDbpMsgMaker.getOr003DbpReqMessage(ifOr003MobReqVO);
	}

	private IfOr003MobResVO getOr003DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return orderDbpMsgReader.getOr003DbpResMessage(dbpResMessage);
	}
	
}