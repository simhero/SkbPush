package com.skt.ssp.gw.parse;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.vo.order.IfOr001ComBodyOrderResVO;
import com.skt.ssp.gw.vo.order.IfOr001DbpDataResVO;
import com.skt.ssp.gw.vo.order.IfOr001MobDataResVO;
import com.skt.ssp.gw.vo.order.IfOr001MobResVO;
import com.skt.ssp.gw.vo.order.IfOr002ComBodyBeaResVO;
import com.skt.ssp.gw.vo.order.IfOr002ComBodyClaimInfoResVO;
import com.skt.ssp.gw.vo.order.IfOr002ComBodyGoodsResVO;
import com.skt.ssp.gw.vo.order.IfOr002DbpDataResVO;
import com.skt.ssp.gw.vo.order.IfOr002MobDataResVO;
import com.skt.ssp.gw.vo.order.IfOr002MobResVO;
import com.skt.ssp.gw.vo.order.IfOr003ComBodyOrderResVO;
import com.skt.ssp.gw.vo.order.IfOr003DbpDataResVO;
import com.skt.ssp.gw.vo.order.IfOr003MobDataResVO;
import com.skt.ssp.gw.vo.order.IfOr003MobResVO;
import com.thoughtworks.xstream.XStream;

/**
 * OrderDbpMsgReader (OrderDbpMsgReader)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: OrderDbpMsgReader.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Component
public class OrderDbpMsgReader {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public OrderDbpMsgReader() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}
	
	public IfOr001MobResVO getOr001DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfOr001DbpDataResVO.class);
		xstream.alias("orders", IfOr001ComBodyOrderResVO.class);
		IfOr001DbpDataResVO ifOr001DbpDataResVO = (IfOr001DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfOr001MobResVO ifOr001MobResVO = new IfOr001MobResVO();
		ifOr001MobResVO.setResponse(new IfOr001MobDataResVO());
		ifOr001MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifOr001DbpDataResVO.getHeader()));
		ifOr001MobResVO.getResponse().setBody(ifOr001DbpDataResVO.getBody());
		logger.debug("ifOr001MobResVO"+ifOr001MobResVO+"\n");
		return ifOr001MobResVO;
	}

	public IfOr002MobResVO getOr002DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfOr002DbpDataResVO.class);
		xstream.alias("goods", IfOr002ComBodyGoodsResVO.class);
		xstream.alias("beas", IfOr002ComBodyBeaResVO.class);
		xstream.alias("claimInfo", IfOr002ComBodyClaimInfoResVO.class);
		IfOr002DbpDataResVO ifOr002DbpDataResVO = (IfOr002DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfOr002MobResVO ifOr002MobResVO = new IfOr002MobResVO();
		ifOr002MobResVO.setResponse(new IfOr002MobDataResVO());
		ifOr002MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifOr002DbpDataResVO.getHeader()));
		ifOr002MobResVO.getResponse().setBody(ifOr002DbpDataResVO.getBody());
		logger.debug("ifOr002MobResVO"+ifOr002MobResVO+"\n");
		return ifOr002MobResVO;
	}
	
	public IfOr003MobResVO getOr003DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfOr003DbpDataResVO.class);
		xstream.alias("orders", IfOr003ComBodyOrderResVO.class);
		IfOr003DbpDataResVO ifOr003DbpDataResVO = (IfOr003DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfOr003MobResVO ifOr003MobResVO = new IfOr003MobResVO();
		ifOr003MobResVO.setResponse(new IfOr003MobDataResVO());
		ifOr003MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifOr003DbpDataResVO.getHeader()));
		ifOr003MobResVO.getResponse().setBody(ifOr003DbpDataResVO.getBody());
		logger.debug("ifOr003MobResVO"+ifOr003MobResVO+"\n");
		return ifOr003MobResVO;
	}
	
}