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
import com.skt.ssp.gw.parse.GoodsDbpMsgMaker;
import com.skt.ssp.gw.parse.GoodsDbpMsgReader;
import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.service.GoodsService;
import com.skt.ssp.gw.vo.goods.IfGo001MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo001MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo002MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo002MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo003MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo003MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo004MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo004MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo0051MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo0051MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo005MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo005MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo006MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo006MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo007MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo007MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo008MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo008MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo009MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo009MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo010MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo010MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo011MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo011MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo012MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo012MobResVO;

/**
 * Goods Service Impl(GoodsServiceImpl)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: GoodsServiceImpl.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin  Express $
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CompositeConfiguration config;
	@Autowired
	private CommonService commonService;
	@Autowired
	private DbpMsgSender dbpMsgSender;
	@Autowired
	private GoodsDbpMsgMaker goodsDbpMsgMaker;
	@Autowired
	private GoodsDbpMsgReader goodsDbpMsgReader;
	
	private QueueSend qs = null;

	public GoodsServiceImpl() {
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
	public void jmsGoods() {
		try {
			sendQueue("QUEUE TEST");
		} catch (JMSException jmsEx) {
			qs = null;
			if (logger.isErrorEnabled()) {
				logger.error("jmsGoods()\r\n" + jmsEx);
			}
		} catch (Exception e) {
			if (qs == null)
				qs = commonService.getQueueInstance(config.getString("SAMPLE_QUEUE"));
			if (logger.isErrorEnabled()) {
				logger.error("jmsGoods()\r\n" + e);
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
	public IfGo001MobResVO requestGoods001(IfGo001MobReqVO ifGo001MobReqVO) {
		return getGo001DbpResMessage(send(ifGo001MobReqVO.getRequest().getHeader().getComInterfaceId(), getGo001DbpReqMessage(ifGo001MobReqVO)));
	}

	private String getGo001DbpReqMessage(IfGo001MobReqVO ifGo001MobReqVO) {
		return goodsDbpMsgMaker.getGo001DbpReqMessage(ifGo001MobReqVO);
	}

	private IfGo001MobResVO getGo001DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return goodsDbpMsgReader.getGo001DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfGo002MobResVO requestGoods002(IfGo002MobReqVO ifGo002MobReqVO) {
		return getGo002DbpResMessage(send(ifGo002MobReqVO.getRequest().getHeader().getComInterfaceId(), getGo002DbpReqMessage(ifGo002MobReqVO)));
	}

	private String getGo002DbpReqMessage(IfGo002MobReqVO ifGo002MobReqVO) {
		return goodsDbpMsgMaker.getGo002DbpReqMessage(ifGo002MobReqVO);
	}

	private IfGo002MobResVO getGo002DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return goodsDbpMsgReader.getGo002DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfGo003MobResVO requestGoods003(IfGo003MobReqVO ifGo003MobReqVO) {
		return getGo003DbpResMessage(send(ifGo003MobReqVO.getRequest().getHeader().getComInterfaceId(), getGo003DbpReqMessage(ifGo003MobReqVO)));
	}

	private String getGo003DbpReqMessage(IfGo003MobReqVO ifGo003MobReqVO) {
		return goodsDbpMsgMaker.getGo003DbpReqMessage(ifGo003MobReqVO);
	}

	private IfGo003MobResVO getGo003DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return goodsDbpMsgReader.getGo003DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfGo004MobResVO requestGoods004(IfGo004MobReqVO ifGo004MobReqVO) {
		return getGo004DbpResMessage(send(ifGo004MobReqVO.getRequest().getHeader().getComInterfaceId(), getGo004DbpReqMessage(ifGo004MobReqVO)));
	}

	private String getGo004DbpReqMessage(IfGo004MobReqVO ifGo004MobReqVO) {
		return goodsDbpMsgMaker.getGo004DbpReqMessage(ifGo004MobReqVO);
	}

	private IfGo004MobResVO getGo004DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return goodsDbpMsgReader.getGo004DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfGo005MobResVO requestGoods005(IfGo005MobReqVO ifGo005MobReqVO) {
		return getGo005DbpResMessage(send(ifGo005MobReqVO.getRequest().getHeader().getComInterfaceId(), getGo005DbpReqMessage(ifGo005MobReqVO)));
	}

	private String getGo005DbpReqMessage(IfGo005MobReqVO ifGo005MobReqVO) {
		return goodsDbpMsgMaker.getGo005DbpReqMessage(ifGo005MobReqVO);
	}

	private IfGo005MobResVO getGo005DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return goodsDbpMsgReader.getGo005DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfGo0051MobResVO requestGoods0051(IfGo0051MobReqVO ifGo0051MobReqVO) {
		return getGo0051DbpResMessage(send(ifGo0051MobReqVO.getRequest().getHeader().getComInterfaceId(), getGo0051DbpReqMessage(ifGo0051MobReqVO)));
	}

	private String getGo0051DbpReqMessage(IfGo0051MobReqVO ifGo0051MobReqVO) {
		return goodsDbpMsgMaker.getGo0051DbpReqMessage(ifGo0051MobReqVO);
	}

	private IfGo0051MobResVO getGo0051DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return goodsDbpMsgReader.getGo0051DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfGo006MobResVO requestGoods006(IfGo006MobReqVO ifGo006MobReqVO) {
		return getGo006DbpResMessage(send(ifGo006MobReqVO.getRequest().getHeader().getComInterfaceId(), getGo006DbpReqMessage(ifGo006MobReqVO)));
	}

	private String getGo006DbpReqMessage(IfGo006MobReqVO ifGo006MobReqVO) {
		return goodsDbpMsgMaker.getGo006DbpReqMessage(ifGo006MobReqVO);
	}

	private IfGo006MobResVO getGo006DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return goodsDbpMsgReader.getGo006DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfGo007MobResVO requestGoods007(IfGo007MobReqVO ifGo007MobReqVO) {
		return getGo007DbpResMessage(send(ifGo007MobReqVO.getRequest().getHeader().getComInterfaceId(), getGo007DbpReqMessage(ifGo007MobReqVO)));
	}

	private String getGo007DbpReqMessage(IfGo007MobReqVO ifGo007MobReqVO) {
		return goodsDbpMsgMaker.getGo007DbpReqMessage(ifGo007MobReqVO);
	}

	private IfGo007MobResVO getGo007DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return goodsDbpMsgReader.getGo007DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfGo008MobResVO requestGoods008(IfGo008MobReqVO ifGo008MobReqVO) {
		return getGo008DbpResMessage(send(ifGo008MobReqVO.getRequest().getHeader().getComInterfaceId(), getGo008DbpReqMessage(ifGo008MobReqVO)));
	}

	private String getGo008DbpReqMessage(IfGo008MobReqVO ifGo008MobReqVO) {
		return goodsDbpMsgMaker.getGo008DbpReqMessage(ifGo008MobReqVO);
	}

	private IfGo008MobResVO getGo008DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return goodsDbpMsgReader.getGo008DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfGo009MobResVO requestGoods009(IfGo009MobReqVO ifGo009MobReqVO) {
		return getGo009DbpResMessage(send(ifGo009MobReqVO.getRequest().getHeader().getComInterfaceId(), getGo009DbpReqMessage(ifGo009MobReqVO)));
	}

	private String getGo009DbpReqMessage(IfGo009MobReqVO ifGo009MobReqVO) {
		return goodsDbpMsgMaker.getGo009DbpReqMessage(ifGo009MobReqVO);
	}

	private IfGo009MobResVO getGo009DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return goodsDbpMsgReader.getGo009DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfGo010MobResVO requestGoods010(IfGo010MobReqVO ifGo010MobReqVO) {
		return getGo010DbpResMessage(send(ifGo010MobReqVO.getRequest().getHeader().getComInterfaceId(), getGo010DbpReqMessage(ifGo010MobReqVO)));
	}

	private String getGo010DbpReqMessage(IfGo010MobReqVO ifGo010MobReqVO) {
		return goodsDbpMsgMaker.getGo010DbpReqMessage(ifGo010MobReqVO);
	}

	private IfGo010MobResVO getGo010DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return goodsDbpMsgReader.getGo010DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfGo011MobResVO requestGoods011(IfGo011MobReqVO ifGo011MobReqVO) {
		return getGo011DbpResMessage(send(ifGo011MobReqVO.getRequest().getHeader().getComInterfaceId(), getGo011DbpReqMessage(ifGo011MobReqVO)));
	}

	private String getGo011DbpReqMessage(IfGo011MobReqVO ifGo011MobReqVO) {
		return goodsDbpMsgMaker.getGo011DbpReqMessage(ifGo011MobReqVO);
	}

	private IfGo011MobResVO getGo011DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return goodsDbpMsgReader.getGo011DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfGo012MobResVO requestGoods012(IfGo012MobReqVO ifGo012MobReqVO) {
		return getGo012DbpResMessage(send(ifGo012MobReqVO.getRequest().getHeader().getComInterfaceId(), getGo012DbpReqMessage(ifGo012MobReqVO)));
	}

	private String getGo012DbpReqMessage(IfGo012MobReqVO ifGo012MobReqVO) {
		return goodsDbpMsgMaker.getGo012DbpReqMessage(ifGo012MobReqVO);
	}

	private IfGo012MobResVO getGo012DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return goodsDbpMsgReader.getGo012DbpResMessage(dbpResMessage);
	}
	
}