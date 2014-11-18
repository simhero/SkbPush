package com.skt.ssp.gw.parse;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.vo.statistics.IfSt001ComBodyUidConverter;
import com.skt.ssp.gw.vo.statistics.IfSt001ComBodyUidReqVO;
import com.skt.ssp.gw.vo.statistics.IfSt001DbpDataReqVO;
import com.skt.ssp.gw.vo.statistics.IfSt001MobReqVO;
import com.skt.ssp.gw.vo.statistics.IfSt002ComBodyUidConverter;
import com.skt.ssp.gw.vo.statistics.IfSt002ComBodyUidReqVO;
import com.skt.ssp.gw.vo.statistics.IfSt002DbpDataReqVO;
import com.skt.ssp.gw.vo.statistics.IfSt002MobReqVO;
import com.thoughtworks.xstream.XStream;

/**
 * StatisticsDbpMsgMaker (StatisticsDbpMsgMaker)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: StatisticsDbpMsgMaker.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Component
public class StatisticsDbpMsgMaker {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public StatisticsDbpMsgMaker() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public String getSt001DbpReqMessage(IfSt001MobReqVO ifSt001MobReqVO) {
		IfSt001DbpDataReqVO ifSt001DbpDataReqVO = new IfSt001DbpDataReqVO();
		ifSt001DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifSt001MobReqVO.getRequest().getHeader()));
		ifSt001DbpDataReqVO.setBody(ifSt001MobReqVO.getRequest().getBody());
		String time = commonService.getGwDateType();
		if(StringUtils.stripToEmpty(ifSt001DbpDataReqVO.getBody().getDateFrom()).length() == 0) {
			ifSt001DbpDataReqVO.getBody().setDateFrom(time);
		}
		if(StringUtils.stripToEmpty(ifSt001DbpDataReqVO.getBody().getDateTo()).length() == 0) {
			ifSt001DbpDataReqVO.getBody().setDateTo(time);
		}
		XStream xstream = new XStream();
		xstream.registerConverter(new IfSt001ComBodyUidConverter());
		xstream.alias("Request", IfSt001DbpDataReqVO.class);
		xstream.alias("uid", IfSt001ComBodyUidReqVO.class);
		logger.debug("ifSt001DbpDataReqVO="+ifSt001DbpDataReqVO+"\n");
		return xstream.toXML(ifSt001DbpDataReqVO);
	}
	
	public String getSt002DbpReqMessage(IfSt002MobReqVO ifSt002MobReqVO) {
		IfSt002DbpDataReqVO ifSt002DbpDataReqVO = new IfSt002DbpDataReqVO();
		ifSt002DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifSt002MobReqVO.getRequest().getHeader()));
		ifSt002DbpDataReqVO.setBody(ifSt002MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.registerConverter(new IfSt002ComBodyUidConverter());
		xstream.alias("Request", IfSt002DbpDataReqVO.class);
		xstream.alias("uid", IfSt002ComBodyUidReqVO.class);
		logger.debug("ifSt002DbpDataReqVO="+ifSt002DbpDataReqVO+"\n");
		return xstream.toXML(ifSt002DbpDataReqVO);
	}

}