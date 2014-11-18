package com.skt.ssp.gw.parse;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.vo.settlement.IfSe001ComBodySettleResVO;
import com.skt.ssp.gw.vo.settlement.IfSe001DbpDataResVO;
import com.skt.ssp.gw.vo.settlement.IfSe001MobDataResVO;
import com.skt.ssp.gw.vo.settlement.IfSe001MobResVO;
import com.skt.ssp.gw.vo.settlement.IfSe002ComBodySettleResVO;
import com.skt.ssp.gw.vo.settlement.IfSe002DbpDataResVO;
import com.skt.ssp.gw.vo.settlement.IfSe002MobDataResVO;
import com.skt.ssp.gw.vo.settlement.IfSe002MobResVO;
import com.thoughtworks.xstream.XStream;

/**
 * SettlementDbpMsgReader (SettlementDbpMsgReader)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: SettlementDbpMsgReader.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Component
public class SettlementDbpMsgReader {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public SettlementDbpMsgReader() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public IfSe001MobResVO getSe001DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfSe001DbpDataResVO.class);
		xstream.alias("settles", IfSe001ComBodySettleResVO.class);
		IfSe001DbpDataResVO ifSe001DbpDataResVO = (IfSe001DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfSe001MobResVO ifSe001MobResVO = new IfSe001MobResVO();
		ifSe001MobResVO.setResponse(new IfSe001MobDataResVO());
		ifSe001MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifSe001DbpDataResVO.getHeader()));
		ifSe001MobResVO.getResponse().setBody(ifSe001DbpDataResVO.getBody());
		logger.debug("ifSe001MobResVO"+ifSe001MobResVO+"\n");
		return ifSe001MobResVO;
	}
	
	public IfSe002MobResVO getSe002DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfSe002DbpDataResVO.class);
		xstream.alias("settles", IfSe002ComBodySettleResVO.class);
		IfSe002DbpDataResVO ifSe002DbpDataResVO = (IfSe002DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfSe002MobResVO ifSe002MobResVO = new IfSe002MobResVO();
		ifSe002MobResVO.setResponse(new IfSe002MobDataResVO());
		ifSe002MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifSe002DbpDataResVO.getHeader()));
		ifSe002MobResVO.getResponse().setBody(ifSe002DbpDataResVO.getBody());
		logger.debug("ifSe002MobResVO"+ifSe002MobResVO+"\n");
		return ifSe002MobResVO;
	}
	
}