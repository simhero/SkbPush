package com.skt.ssp.gw.parse;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.vo.statistics.IfSt001ComBodyDataResVO;
import com.skt.ssp.gw.vo.statistics.IfSt001ComBodyStatisticsResVO;
import com.skt.ssp.gw.vo.statistics.IfSt001DbpDataResVO;
import com.skt.ssp.gw.vo.statistics.IfSt001MobDataResVO;
import com.skt.ssp.gw.vo.statistics.IfSt001MobResVO;
import com.skt.ssp.gw.vo.statistics.IfSt002ComBodyDataResVO;
import com.skt.ssp.gw.vo.statistics.IfSt002ComBodyStatisticsResVO;
import com.skt.ssp.gw.vo.statistics.IfSt002DbpDataResVO;
import com.skt.ssp.gw.vo.statistics.IfSt002MobDataResVO;
import com.skt.ssp.gw.vo.statistics.IfSt002MobResVO;
import com.thoughtworks.xstream.XStream;

/**
 * StatisticsDbpMsgReader (StatisticsDbpMsgReader)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: StatisticsDbpMsgReader.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Component
public class StatisticsDbpMsgReader {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public StatisticsDbpMsgReader() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public IfSt001MobResVO getSt001DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfSt001DbpDataResVO.class);
		xstream.alias("statistics", IfSt001ComBodyStatisticsResVO.class);
		xstream.alias("datas", IfSt001ComBodyDataResVO.class);
		IfSt001DbpDataResVO ifSt001DbpDataResVO = (IfSt001DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfSt001MobResVO ifSt001MobResVO = new IfSt001MobResVO();
		ifSt001MobResVO.setResponse(new IfSt001MobDataResVO());
		ifSt001MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifSt001DbpDataResVO.getHeader()));
		ifSt001MobResVO.getResponse().setBody(ifSt001DbpDataResVO.getBody());
		logger.debug("ifSt001DbpDataResVO"+ifSt001DbpDataResVO+"\n");
		return ifSt001MobResVO;
	}
	
	public IfSt002MobResVO getSt002DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfSt002DbpDataResVO.class);
		xstream.alias("statistics", IfSt002ComBodyStatisticsResVO.class);
		xstream.alias("datas", IfSt002ComBodyDataResVO.class);
		IfSt002DbpDataResVO ifSt002DbpDataResVO = (IfSt002DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfSt002MobResVO ifSt002MobResVO = new IfSt002MobResVO();
		ifSt002MobResVO.setResponse(new IfSt002MobDataResVO());
		ifSt002MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifSt002DbpDataResVO.getHeader()));
		ifSt002MobResVO.getResponse().setBody(ifSt002DbpDataResVO.getBody());
		logger.debug("ifSt002DbpDataResVO"+ifSt002DbpDataResVO+"\n");
		return ifSt002MobResVO;
	}

}