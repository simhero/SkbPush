package com.skt.ssp.gw.parse;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.vo.order.IfOr001ComBodyUidConverter;
import com.skt.ssp.gw.vo.order.IfOr001ComBodyUidReqVO;
import com.skt.ssp.gw.vo.order.IfOr001DbpDataReqVO;
import com.skt.ssp.gw.vo.order.IfOr001MobReqVO;
import com.skt.ssp.gw.vo.order.IfOr002DbpDataReqVO;
import com.skt.ssp.gw.vo.order.IfOr002MobReqVO;
import com.skt.ssp.gw.vo.order.IfOr003ComBodyOrderReqVO;
import com.skt.ssp.gw.vo.order.IfOr003DbpDataReqVO;
import com.skt.ssp.gw.vo.order.IfOr003MobReqVO;
import com.thoughtworks.xstream.XStream;

/**
 * OrderDbpMsgMaker (OrderDbpMsgMaker)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: OrderDbpMsgMaker.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Component
public class OrderDbpMsgMaker {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public OrderDbpMsgMaker() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public String getOr001DbpReqMessage(IfOr001MobReqVO ifOr001MobReqVO) {
		IfOr001DbpDataReqVO ifOr001DbpDataReqVO = new IfOr001DbpDataReqVO();
		ifOr001DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifOr001MobReqVO.getRequest().getHeader()));
		ifOr001DbpDataReqVO.setBody(ifOr001MobReqVO.getRequest().getBody());
		String time = commonService.getGwDateType();
		if(StringUtils.stripToEmpty(ifOr001DbpDataReqVO.getBody().getDateFrom()).length() == 0) {
			ifOr001DbpDataReqVO.getBody().setDateFrom(time);
		}
		if(StringUtils.stripToEmpty(ifOr001DbpDataReqVO.getBody().getDateTo()).length() == 0) {
			ifOr001DbpDataReqVO.getBody().setDateTo(time);
		}
		XStream xstream = new XStream();
		xstream.registerConverter(new IfOr001ComBodyUidConverter());
		xstream.alias("Request", IfOr001DbpDataReqVO.class);
		xstream.alias("uid", IfOr001ComBodyUidReqVO.class);
		logger.debug("ifOr001DbpDataReqVO="+ifOr001DbpDataReqVO+"\n");
		return xstream.toXML(ifOr001DbpDataReqVO);
	}
	
	public String getOr002DbpReqMessage(IfOr002MobReqVO ifOr002MobReqVO) {
		IfOr002DbpDataReqVO ifOr002DbpDataReqVO = new IfOr002DbpDataReqVO();
		ifOr002DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifOr002MobReqVO.getRequest().getHeader()));
		ifOr002DbpDataReqVO.setBody(ifOr002MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfOr002DbpDataReqVO.class);
		logger.debug("ifOr002DbpDataReqVO="+ifOr002DbpDataReqVO+"\n");
		return xstream.toXML(ifOr002DbpDataReqVO);
	}
	
	public String getOr003DbpReqMessage(IfOr003MobReqVO ifOr003MobReqVO) {
		IfOr003DbpDataReqVO ifOr003DbpDataReqVO = new IfOr003DbpDataReqVO();
		ifOr003DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifOr003MobReqVO.getRequest().getHeader()));
		ifOr003DbpDataReqVO.setBody(ifOr003MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfOr003DbpDataReqVO.class);
		xstream.alias("orders", IfOr003ComBodyOrderReqVO.class);
		logger.debug("ifOr003DbpDataReqVO="+ifOr003DbpDataReqVO+"\n");
		return xstream.toXML(ifOr003DbpDataReqVO);
	}
	
}