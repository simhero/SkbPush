package com.skt.ssp.gw.parse;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.vo.settlement.IfSe001ComBodyUidConverter;
import com.skt.ssp.gw.vo.settlement.IfSe001ComBodyUidReqVO;
import com.skt.ssp.gw.vo.settlement.IfSe001DbpDataReqVO;
import com.skt.ssp.gw.vo.settlement.IfSe001MobReqVO;
import com.skt.ssp.gw.vo.settlement.IfSe002DbpDataReqVO;
import com.skt.ssp.gw.vo.settlement.IfSe002MobReqVO;
import com.thoughtworks.xstream.XStream;

/**
 * SettlementDbpMsgMaker (SettlementDbpMsgMaker)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: SettlementDbpMsgMaker.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Component
public class SettlementDbpMsgMaker {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public SettlementDbpMsgMaker() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public String getSe001DbpReqMessage(IfSe001MobReqVO ifSe001MobReqVO) {
		IfSe001DbpDataReqVO ifSe001DbpDataReqVO = new IfSe001DbpDataReqVO();
		ifSe001DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifSe001MobReqVO.getRequest().getHeader()));
		ifSe001DbpDataReqVO.setBody(ifSe001MobReqVO.getRequest().getBody());
		String time = commonService.getGwDateType();
		if(StringUtils.stripToEmpty(ifSe001DbpDataReqVO.getBody().getDateFrom()).length() == 0) {
			ifSe001DbpDataReqVO.getBody().setDateFrom(time);
		}
		if(StringUtils.stripToEmpty(ifSe001DbpDataReqVO.getBody().getDateTo()).length() == 0) {
			ifSe001DbpDataReqVO.getBody().setDateTo(time);
		}
		XStream xstream = new XStream();
		xstream.registerConverter(new IfSe001ComBodyUidConverter());
		xstream.alias("Request", IfSe001DbpDataReqVO.class);
		xstream.alias("uid", IfSe001ComBodyUidReqVO.class);
		logger.debug("ifSe001DbpDataReqVO="+ifSe001DbpDataReqVO+"\n");
		return xstream.toXML(ifSe001DbpDataReqVO);
	}
	
	public String getSe002DbpReqMessage(IfSe002MobReqVO ifSe002MobReqVO) {
		IfSe002DbpDataReqVO ifSe002DbpDataReqVO = new IfSe002DbpDataReqVO();
		ifSe002DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifSe002MobReqVO.getRequest().getHeader()));
		ifSe002DbpDataReqVO.setBody(ifSe002MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfSe002DbpDataReqVO.class);
		logger.debug("ifSe002DbpDataReqVO="+ifSe002DbpDataReqVO+"\n");
		return xstream.toXML(ifSe002DbpDataReqVO);
	}
	
}