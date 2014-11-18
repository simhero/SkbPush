package com.skt.ssp.gw.parse;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.vo.goods.IfGo001ComBodyUidConverter;
import com.skt.ssp.gw.vo.goods.IfGo001ComBodyUidReqVO;
import com.skt.ssp.gw.vo.goods.IfGo001DbpDataReqVO;
import com.skt.ssp.gw.vo.goods.IfGo001MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo002DbpDataReqVO;
import com.skt.ssp.gw.vo.goods.IfGo002MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo003ComBodyGoodsReqVO;
import com.skt.ssp.gw.vo.goods.IfGo003DbpDataReqVO;
import com.skt.ssp.gw.vo.goods.IfGo003MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo004ComBodyGoodsReqVO;
import com.skt.ssp.gw.vo.goods.IfGo004DbpDataReqVO;
import com.skt.ssp.gw.vo.goods.IfGo004MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo0051ComBodyDataReqVO;
import com.skt.ssp.gw.vo.goods.IfGo0051DbpDataReqVO;
import com.skt.ssp.gw.vo.goods.IfGo0051MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo005DbpDataReqVO;
import com.skt.ssp.gw.vo.goods.IfGo005MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo006DbpDataReqVO;
import com.skt.ssp.gw.vo.goods.IfGo006MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo007DbpDataReqVO;
import com.skt.ssp.gw.vo.goods.IfGo007MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo008DbpDataReqVO;
import com.skt.ssp.gw.vo.goods.IfGo008MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo009DbpDataReqVO;
import com.skt.ssp.gw.vo.goods.IfGo009MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo010ComBodyIdxConverter;
import com.skt.ssp.gw.vo.goods.IfGo010ComBodyIdxReqVO;
import com.skt.ssp.gw.vo.goods.IfGo010DbpDataReqVO;
import com.skt.ssp.gw.vo.goods.IfGo010MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo011DbpDataReqVO;
import com.skt.ssp.gw.vo.goods.IfGo011MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo012DbpDataReqVO;
import com.skt.ssp.gw.vo.goods.IfGo012MobReqVO;
import com.thoughtworks.xstream.XStream;

/**
 * GoodsDbpMsgMaker (GoodsDbpMsgMaker)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: GoodsDbpMsgMaker.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Component
public class GoodsDbpMsgMaker {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public GoodsDbpMsgMaker() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public String getGo001DbpReqMessage(IfGo001MobReqVO ifGo001MobReqVO) {
		IfGo001DbpDataReqVO ifGo001DbpDataReqVO = new IfGo001DbpDataReqVO();
		ifGo001DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifGo001MobReqVO.getRequest().getHeader()));
		ifGo001DbpDataReqVO.setBody(ifGo001MobReqVO.getRequest().getBody());
		String time = commonService.getGwDateType();
		if(StringUtils.stripToEmpty(ifGo001DbpDataReqVO.getBody().getDateFrom()).length() == 0) {
			ifGo001DbpDataReqVO.getBody().setDateFrom(time);
		}
		if(StringUtils.stripToEmpty(ifGo001DbpDataReqVO.getBody().getDateTo()).length() == 0) {
			ifGo001DbpDataReqVO.getBody().setDateTo(time);
		}
		if(StringUtils.stripToEmpty(ifGo001DbpDataReqVO.getBody().getReSearchWord()).length() == 0) {
			ifGo001DbpDataReqVO.getBody().setReSearchGubun("all");
		}
		XStream xstream = new XStream();
		xstream.registerConverter(new IfGo001ComBodyUidConverter());
		xstream.alias("Request", IfGo001DbpDataReqVO.class);
		xstream.alias("uid", IfGo001ComBodyUidReqVO.class);
		logger.debug("ifGo001DbpDataReqVO="+ifGo001DbpDataReqVO+"\n");
		return xstream.toXML(ifGo001DbpDataReqVO);
	}

	public String getGo002DbpReqMessage(IfGo002MobReqVO ifGo002MobReqVO) {
		IfGo002DbpDataReqVO ifGo002DbpDataReqVO = new IfGo002DbpDataReqVO();
		ifGo002DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifGo002MobReqVO.getRequest().getHeader()));
		ifGo002DbpDataReqVO.setBody(ifGo002MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfGo002DbpDataReqVO.class);
		logger.debug("ifGo002DbpDataReqVO="+ifGo002DbpDataReqVO+"\n");
		return xstream.toXML(ifGo002DbpDataReqVO);
	}
	
	public String getGo003DbpReqMessage(IfGo003MobReqVO ifGo003MobReqVO) {
		IfGo003DbpDataReqVO ifGo003DbpDataReqVO = new IfGo003DbpDataReqVO();
		ifGo003DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifGo003MobReqVO.getRequest().getHeader()));
		ifGo003DbpDataReqVO.setBody(ifGo003MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfGo003DbpDataReqVO.class);
		xstream.alias("goods", IfGo003ComBodyGoodsReqVO.class);
		logger.debug("ifGo003DbpDataReqVO="+ifGo003DbpDataReqVO+"\n");
		return xstream.toXML(ifGo003DbpDataReqVO);
	}
	
	public String getGo004DbpReqMessage(IfGo004MobReqVO ifGo004MobReqVO) {
		IfGo004DbpDataReqVO ifGo004DbpDataReqVO = new IfGo004DbpDataReqVO();
		ifGo004DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifGo004MobReqVO.getRequest().getHeader()));
		ifGo004DbpDataReqVO.setBody(ifGo004MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfGo004DbpDataReqVO.class);
		xstream.alias("goods", IfGo004ComBodyGoodsReqVO.class);
		logger.debug("ifGo004DbpDataReqVO="+ifGo004DbpDataReqVO+"\n");
		return xstream.toXML(ifGo004DbpDataReqVO);
	}
	
	public String getGo005DbpReqMessage(IfGo005MobReqVO ifGo005MobReqVO) {
		IfGo005DbpDataReqVO ifGo005DbpDataReqVO = new IfGo005DbpDataReqVO();
		ifGo005DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifGo005MobReqVO.getRequest().getHeader()));
		ifGo005DbpDataReqVO.setBody(ifGo005MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfGo005DbpDataReqVO.class);
		logger.debug("ifGo005DbpDataReqVO="+ifGo005DbpDataReqVO+"\n");
		return xstream.toXML(ifGo005DbpDataReqVO);
	}
	
	public String getGo0051DbpReqMessage(IfGo0051MobReqVO ifGo0051MobReqVO) {
		IfGo0051DbpDataReqVO ifGo0051DbpDataReqVO = new IfGo0051DbpDataReqVO();
		ifGo0051DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifGo0051MobReqVO.getRequest().getHeader()));
		ifGo0051DbpDataReqVO.setBody(ifGo0051MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfGo0051DbpDataReqVO.class);
		xstream.alias("datas", IfGo0051ComBodyDataReqVO.class);
		logger.debug("ifGo0051DbpDataReqVO="+ifGo0051DbpDataReqVO+"\n");
		return xstream.toXML(ifGo0051DbpDataReqVO);
	}
	
	public String getGo006DbpReqMessage(IfGo006MobReqVO ifGo006MobReqVO) {
		IfGo006DbpDataReqVO ifGo006DbpDataReqVO = new IfGo006DbpDataReqVO();
		ifGo006DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifGo006MobReqVO.getRequest().getHeader()));
		ifGo006DbpDataReqVO.setBody(ifGo006MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfGo006DbpDataReqVO.class);
		logger.debug("ifGo006DbpDataReqVO="+ifGo006DbpDataReqVO+"\n");
		return xstream.toXML(ifGo006DbpDataReqVO);
	}
	
	public String getGo007DbpReqMessage(IfGo007MobReqVO ifGo007MobReqVO) {
		IfGo007DbpDataReqVO ifGo007DbpDataReqVO = new IfGo007DbpDataReqVO();
		ifGo007DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifGo007MobReqVO.getRequest().getHeader()));
		ifGo007DbpDataReqVO.setBody(ifGo007MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfGo007DbpDataReqVO.class);
		logger.debug("ifGo007DbpDataReqVO="+ifGo007DbpDataReqVO+"\n");
		return xstream.toXML(ifGo007DbpDataReqVO);
	}
	
	public String getGo008DbpReqMessage(IfGo008MobReqVO ifGo008MobReqVO) {
		IfGo008DbpDataReqVO ifGo008DbpDataReqVO = new IfGo008DbpDataReqVO();
		ifGo008DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifGo008MobReqVO.getRequest().getHeader()));
		ifGo008DbpDataReqVO.setBody(ifGo008MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfGo008DbpDataReqVO.class);
		logger.debug("ifGo008DbpDataReqVO="+ifGo008DbpDataReqVO+"\n");
		return xstream.toXML(ifGo008DbpDataReqVO);
	}
	
	public String getGo009DbpReqMessage(IfGo009MobReqVO ifGo009MobReqVO) {
		IfGo009DbpDataReqVO ifGo009DbpDataReqVO = new IfGo009DbpDataReqVO();
		ifGo009DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifGo009MobReqVO.getRequest().getHeader()));
		ifGo009DbpDataReqVO.setBody(ifGo009MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfGo009DbpDataReqVO.class);
		logger.debug("ifGo009DbpDataReqVO="+ifGo009DbpDataReqVO+"\n");
		return xstream.toXML(ifGo009DbpDataReqVO);
	}
	
	public String getGo010DbpReqMessage(IfGo010MobReqVO ifGo010MobReqVO) {
		IfGo010DbpDataReqVO ifGo010DbpDataReqVO = new IfGo010DbpDataReqVO();
		ifGo010DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifGo010MobReqVO.getRequest().getHeader()));
		ifGo010DbpDataReqVO.setBody(ifGo010MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.registerConverter(new IfGo010ComBodyIdxConverter());
		xstream.alias("Request", IfGo010DbpDataReqVO.class);
		xstream.alias("idx", IfGo010ComBodyIdxReqVO.class);
		logger.debug("ifGo010DbpDataReqVO="+ifGo010DbpDataReqVO+"\n");
		return xstream.toXML(ifGo010DbpDataReqVO);
	}
	
	public String getGo011DbpReqMessage(IfGo011MobReqVO ifGo011MobReqVO) {
		IfGo011DbpDataReqVO ifGo011DbpDataReqVO = new IfGo011DbpDataReqVO();
		ifGo011DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifGo011MobReqVO.getRequest().getHeader()));
		ifGo011DbpDataReqVO.setBody(ifGo011MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfGo011DbpDataReqVO.class);
		logger.debug("ifGo011DbpDataReqVO="+ifGo011DbpDataReqVO+"\n");
		return xstream.toXML(ifGo011DbpDataReqVO);
	}
	
	public String getGo012DbpReqMessage(IfGo012MobReqVO ifGo012MobReqVO) {
		IfGo012DbpDataReqVO ifGo012DbpDataReqVO = new IfGo012DbpDataReqVO();
		ifGo012DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifGo012MobReqVO.getRequest().getHeader()));
		ifGo012DbpDataReqVO.setBody(ifGo012MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfGo012DbpDataReqVO.class);
		logger.debug("ifGo012DbpDataReqVO="+ifGo012DbpDataReqVO+"\n");
		return xstream.toXML(ifGo012DbpDataReqVO);
	}
	
}