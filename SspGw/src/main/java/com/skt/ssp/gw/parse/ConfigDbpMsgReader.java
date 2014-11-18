package com.skt.ssp.gw.parse;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.vo.config.IfCf001DbpDataResVO;
import com.skt.ssp.gw.vo.config.IfCf001MobDataResVO;
import com.skt.ssp.gw.vo.config.IfCf001MobResVO;
import com.skt.ssp.gw.vo.config.IfCf002DbpDataResVO;
import com.skt.ssp.gw.vo.config.IfCf002MobDataResVO;
import com.skt.ssp.gw.vo.config.IfCf002MobResVO;
import com.skt.ssp.gw.vo.config.IfCf003DbpDataResVO;
import com.skt.ssp.gw.vo.config.IfCf003MobDataResVO;
import com.skt.ssp.gw.vo.config.IfCf003MobResVO;
import com.skt.ssp.gw.vo.config.IfCf004DbpDataResVO;
import com.skt.ssp.gw.vo.config.IfCf004MobDataResVO;
import com.skt.ssp.gw.vo.config.IfCf004MobResVO;
import com.thoughtworks.xstream.XStream;

/**
 * ConfigDbpMsgReader (ConfigDbpMsgReader)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: ConfigDbpMsgReader.java,v1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Component
public class ConfigDbpMsgReader {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public ConfigDbpMsgReader() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public IfCf001MobResVO getCf001DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCf001DbpDataResVO.class);
		IfCf001DbpDataResVO ifCf001DbpDataResVO = (IfCf001DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCf001MobResVO ifCf001MobResVO = new IfCf001MobResVO();
		ifCf001MobResVO.setResponse(new IfCf001MobDataResVO());
		ifCf001MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCf001DbpDataResVO.getHeader()));
		ifCf001MobResVO.getResponse().setBody(ifCf001DbpDataResVO.getBody());
		if(ifCf001MobResVO.getResponse().getBody() != null) {
			ifCf001MobResVO.getResponse().getBody().setLastAppVersion(config.getString("APP_VERSION"));
		}
		logger.debug("ifCf001DbpDataResVO="+ifCf001DbpDataResVO);
		return ifCf001MobResVO;
	}
	
	public IfCf002MobResVO getCf002DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCf002DbpDataResVO.class);
		IfCf002DbpDataResVO ifCf002DbpDataResVO = (IfCf002DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCf002MobResVO ifCf002MobResVO = new IfCf002MobResVO();
		ifCf002MobResVO.setResponse(new IfCf002MobDataResVO());
		ifCf002MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCf002DbpDataResVO.getHeader()));
//		ifCf002MobResVO.getResponse().setBody(ifCf002DbpDataResVO.getBody());
		logger.debug("ifCf002DbpDataResVO="+ifCf002DbpDataResVO);
		return ifCf002MobResVO;
	}
	
	public IfCf003MobResVO getCf003DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCf003DbpDataResVO.class);
		IfCf003DbpDataResVO ifCf003DbpDataResVO = (IfCf003DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCf003MobResVO ifCf003MobResVO = new IfCf003MobResVO();
		ifCf003MobResVO.setResponse(new IfCf003MobDataResVO());
		ifCf003MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCf003DbpDataResVO.getHeader()));
		ifCf003MobResVO.getResponse().setBody(ifCf003DbpDataResVO.getBody());
		logger.debug("ifCf003DbpDataResVO="+ifCf003DbpDataResVO);
		return ifCf003MobResVO;
	}
	
	public IfCf004MobResVO getCf004DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCf004DbpDataResVO.class);
		IfCf004DbpDataResVO ifCf004DbpDataResVO = (IfCf004DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCf004MobResVO ifCf004MobResVO = new IfCf004MobResVO();
		ifCf004MobResVO.setResponse(new IfCf004MobDataResVO());
		ifCf004MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCf004DbpDataResVO.getHeader()));
//		ifCf004MobResVO.getResponse().setBody(ifCf004DbpDataResVO.getBody());
		logger.debug("ifCf004DbpDataResVO="+ifCf004DbpDataResVO);
		return ifCf004MobResVO;
	}

}