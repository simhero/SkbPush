package com.skt.ssp.gw.parse;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.vo.goods.IfGo001ComBodyGoodsResVO;
import com.skt.ssp.gw.vo.goods.IfGo001DbpDataResVO;
import com.skt.ssp.gw.vo.goods.IfGo001MobDataResVO;
import com.skt.ssp.gw.vo.goods.IfGo001MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo002ComBodyGoodsResVO;
import com.skt.ssp.gw.vo.goods.IfGo002DbpDataResVO;
import com.skt.ssp.gw.vo.goods.IfGo002MobDataResVO;
import com.skt.ssp.gw.vo.goods.IfGo002MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo003ComBodyGoodsResVO;
import com.skt.ssp.gw.vo.goods.IfGo003DbpDataResVO;
import com.skt.ssp.gw.vo.goods.IfGo003MobDataResVO;
import com.skt.ssp.gw.vo.goods.IfGo003MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo004ComBodyGoodsResVO;
import com.skt.ssp.gw.vo.goods.IfGo004DbpDataResVO;
import com.skt.ssp.gw.vo.goods.IfGo004MobDataResVO;
import com.skt.ssp.gw.vo.goods.IfGo004MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo0051DbpDataResVO;
import com.skt.ssp.gw.vo.goods.IfGo0051MobDataResVO;
import com.skt.ssp.gw.vo.goods.IfGo0051MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo005DbpDataResVO;
import com.skt.ssp.gw.vo.goods.IfGo005MobDataResVO;
import com.skt.ssp.gw.vo.goods.IfGo005MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo006ComBodyGroupResVO;
import com.skt.ssp.gw.vo.goods.IfGo006DbpDataResVO;
import com.skt.ssp.gw.vo.goods.IfGo006MobDataResVO;
import com.skt.ssp.gw.vo.goods.IfGo006MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo007ComBodyPriceResVO;
import com.skt.ssp.gw.vo.goods.IfGo007DbpDataResVO;
import com.skt.ssp.gw.vo.goods.IfGo007MobDataResVO;
import com.skt.ssp.gw.vo.goods.IfGo007MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo008DbpDataResVO;
import com.skt.ssp.gw.vo.goods.IfGo008MobDataResVO;
import com.skt.ssp.gw.vo.goods.IfGo008MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo009ComBodyPriceResVO;
import com.skt.ssp.gw.vo.goods.IfGo009DbpDataResVO;
import com.skt.ssp.gw.vo.goods.IfGo009MobDataResVO;
import com.skt.ssp.gw.vo.goods.IfGo009MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo010ComBodyIdxResVO;
import com.skt.ssp.gw.vo.goods.IfGo010DbpDataResVO;
import com.skt.ssp.gw.vo.goods.IfGo010MobDataResVO;
import com.skt.ssp.gw.vo.goods.IfGo010MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo011ComBodyPriceResVO;
import com.skt.ssp.gw.vo.goods.IfGo011DbpDataResVO;
import com.skt.ssp.gw.vo.goods.IfGo011MobDataResVO;
import com.skt.ssp.gw.vo.goods.IfGo011MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo012ComBodyMyPriceResVO;
import com.skt.ssp.gw.vo.goods.IfGo012DbpDataResVO;
import com.skt.ssp.gw.vo.goods.IfGo012MobDataResVO;
import com.skt.ssp.gw.vo.goods.IfGo012MobResVO;
import com.thoughtworks.xstream.XStream;

/**
 * GoodsDbpMsgReader (GoodsDbpMsgReader)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: GoodsDbpMsgReader.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Component
public class GoodsDbpMsgReader {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public GoodsDbpMsgReader() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public IfGo001MobResVO getGo001DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfGo001DbpDataResVO.class);
		xstream.alias("goods", IfGo001ComBodyGoodsResVO.class);
		IfGo001DbpDataResVO ifGo001DbpDataResVO = (IfGo001DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfGo001MobResVO ifGo001MobResVO = new IfGo001MobResVO();
		ifGo001MobResVO.setResponse(new IfGo001MobDataResVO());
		ifGo001MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifGo001DbpDataResVO.getHeader()));
		ifGo001MobResVO.getResponse().setBody(ifGo001DbpDataResVO.getBody());
		logger.debug("ifGo001DbpDataResVO"+ifGo001DbpDataResVO+"\n");
		return ifGo001MobResVO;
	}

	public IfGo002MobResVO getGo002DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfGo002DbpDataResVO.class);
		xstream.alias("goods", IfGo002ComBodyGoodsResVO.class);
		IfGo002DbpDataResVO ifGo002DbpDataResVO = (IfGo002DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfGo002MobResVO ifGo002MobResVO = new IfGo002MobResVO();
		ifGo002MobResVO.setResponse(new IfGo002MobDataResVO());
		ifGo002MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifGo002DbpDataResVO.getHeader()));
		ifGo002MobResVO.getResponse().setBody(ifGo002DbpDataResVO.getBody());
		logger.debug("ifGo002DbpDataResVO"+ifGo002DbpDataResVO+"\n");
		return ifGo002MobResVO;
	}

	public IfGo003MobResVO getGo003DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfGo003DbpDataResVO.class);
		xstream.alias("goods", IfGo003ComBodyGoodsResVO.class);
		IfGo003DbpDataResVO ifGo003DbpDataResVO = (IfGo003DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfGo003MobResVO ifGo003MobResVO = new IfGo003MobResVO();
		ifGo003MobResVO.setResponse(new IfGo003MobDataResVO());
		ifGo003MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifGo003DbpDataResVO.getHeader()));
		ifGo003MobResVO.getResponse().setBody(ifGo003DbpDataResVO.getBody());
		logger.debug("ifGo003DbpDataResVO"+ifGo003DbpDataResVO+"\n");
		return ifGo003MobResVO;
	}

	public IfGo004MobResVO getGo004DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfGo004DbpDataResVO.class);
		xstream.alias("goodsLogs", IfGo004ComBodyGoodsResVO.class);
		IfGo004DbpDataResVO ifGo004DbpDataResVO = (IfGo004DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfGo004MobResVO ifGo004MobResVO = new IfGo004MobResVO();
		ifGo004MobResVO.setResponse(new IfGo004MobDataResVO());
		ifGo004MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifGo004DbpDataResVO.getHeader()));
		ifGo004MobResVO.getResponse().setBody(ifGo004DbpDataResVO.getBody());
		logger.debug("ifGo004DbpDataResVO"+ifGo004DbpDataResVO+"\n");
		return ifGo004MobResVO;
	}
	
	public IfGo005MobResVO getGo005DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfGo005DbpDataResVO.class);
		IfGo005DbpDataResVO ifGo005DbpDataResVO = (IfGo005DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfGo005MobResVO ifGo005MobResVO = new IfGo005MobResVO();
		ifGo005MobResVO.setResponse(new IfGo005MobDataResVO());
		ifGo005MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifGo005DbpDataResVO.getHeader()));
		ifGo005MobResVO.getResponse().setBody(ifGo005DbpDataResVO.getBody());
		logger.debug("ifGo005DbpDataResVO"+ifGo005DbpDataResVO+"\n");
		return ifGo005MobResVO;
	}
	
	public IfGo0051MobResVO getGo0051DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfGo0051DbpDataResVO.class);
		IfGo0051DbpDataResVO ifGo0051DbpDataResVO = (IfGo0051DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfGo0051MobResVO ifGo0051MobResVO = new IfGo0051MobResVO();
		ifGo0051MobResVO.setResponse(new IfGo0051MobDataResVO());
		ifGo0051MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifGo0051DbpDataResVO.getHeader()));
		ifGo0051MobResVO.getResponse().setBody(ifGo0051DbpDataResVO.getBody());
		logger.debug("ifGo0051DbpDataResVO"+ifGo0051DbpDataResVO+"\n");
		return ifGo0051MobResVO;
	}

	public IfGo006MobResVO getGo006DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfGo006DbpDataResVO.class);
		xstream.alias("groups", IfGo006ComBodyGroupResVO.class);
		IfGo006DbpDataResVO ifGo006DbpDataResVO = (IfGo006DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfGo006MobResVO ifGo006MobResVO = new IfGo006MobResVO();
		ifGo006MobResVO.setResponse(new IfGo006MobDataResVO());
		ifGo006MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifGo006DbpDataResVO.getHeader()));
		ifGo006MobResVO.getResponse().setBody(ifGo006DbpDataResVO.getBody());
		logger.debug("ifGo006DbpDataResVO"+ifGo006DbpDataResVO+"\n");
		return ifGo006MobResVO;
	}
	
	public IfGo007MobResVO getGo007DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfGo007DbpDataResVO.class);
		xstream.alias("prices", IfGo007ComBodyPriceResVO.class);
		IfGo007DbpDataResVO ifGo007DbpDataResVO = (IfGo007DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfGo007MobResVO ifGo007MobResVO = new IfGo007MobResVO();
		ifGo007MobResVO.setResponse(new IfGo007MobDataResVO());
		ifGo007MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifGo007DbpDataResVO.getHeader()));
		ifGo007MobResVO.getResponse().setBody(ifGo007DbpDataResVO.getBody());
		logger.debug("ifGo007DbpDataResVO"+ifGo007DbpDataResVO+"\n");
		return ifGo007MobResVO;
	}
	
	public IfGo008MobResVO getGo008DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfGo008DbpDataResVO.class);
		IfGo008DbpDataResVO ifGo008DbpDataResVO = (IfGo008DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfGo008MobResVO ifGo008MobResVO = new IfGo008MobResVO();
		ifGo008MobResVO.setResponse(new IfGo008MobDataResVO());
		ifGo008MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifGo008DbpDataResVO.getHeader()));
//		ifGo008MobResVO.getResponse().setBody(ifGo008DbpDataResVO.getBody());
		logger.debug("ifGo008DbpDataResVO"+ifGo008DbpDataResVO+"\n");
		return ifGo008MobResVO;
	}
	
	public IfGo009MobResVO getGo009DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfGo009DbpDataResVO.class);
		xstream.alias("prices", IfGo009ComBodyPriceResVO.class);
		IfGo009DbpDataResVO ifGo009DbpDataResVO = (IfGo009DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfGo009MobResVO ifGo009MobResVO = new IfGo009MobResVO();
		ifGo009MobResVO.setResponse(new IfGo009MobDataResVO());
		ifGo009MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifGo009DbpDataResVO.getHeader()));
		ifGo009MobResVO.getResponse().setBody(ifGo009DbpDataResVO.getBody());
		logger.debug("ifGo009DbpDataResVO"+ifGo009DbpDataResVO+"\n");
		return ifGo009MobResVO;
	}
	
	public IfGo010MobResVO getGo010DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfGo010DbpDataResVO.class);
		xstream.alias("idxs", IfGo010ComBodyIdxResVO.class);
		IfGo010DbpDataResVO ifGo010DbpDataResVO = (IfGo010DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfGo010MobResVO ifGo010MobResVO = new IfGo010MobResVO();
		ifGo010MobResVO.setResponse(new IfGo010MobDataResVO());
		ifGo010MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifGo010DbpDataResVO.getHeader()));
		ifGo010MobResVO.getResponse().setBody(ifGo010DbpDataResVO.getBody());
		logger.debug("ifGo010DbpDataResVO"+ifGo010DbpDataResVO+"\n");
		return ifGo010MobResVO;
	}
	
	public IfGo011MobResVO getGo011DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfGo011DbpDataResVO.class);
		xstream.alias("prices", IfGo011ComBodyPriceResVO.class);
		IfGo011DbpDataResVO ifGo011DbpDataResVO = (IfGo011DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfGo011MobResVO ifGo011MobResVO = new IfGo011MobResVO();
		ifGo011MobResVO.setResponse(new IfGo011MobDataResVO());
		ifGo011MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifGo011DbpDataResVO.getHeader()));
		ifGo011MobResVO.getResponse().setBody(ifGo011DbpDataResVO.getBody());
		logger.debug("ifGo011DbpDataResVO"+ifGo011DbpDataResVO+"\n");
		return ifGo011MobResVO;
	}
	
	public IfGo012MobResVO getGo012DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfGo012DbpDataResVO.class);
		xstream.alias("myPrices", IfGo012ComBodyMyPriceResVO.class);
		IfGo012DbpDataResVO ifGo012DbpDataResVO = (IfGo012DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfGo012MobResVO ifGo012MobResVO = new IfGo012MobResVO();
		ifGo012MobResVO.setResponse(new IfGo012MobDataResVO());
		ifGo012MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifGo012DbpDataResVO.getHeader()));
		ifGo012MobResVO.getResponse().setBody(ifGo012DbpDataResVO.getBody());
		logger.debug("ifGo012DbpDataResVO"+ifGo012DbpDataResVO+"\n");
		return ifGo012MobResVO;
	}
	
}