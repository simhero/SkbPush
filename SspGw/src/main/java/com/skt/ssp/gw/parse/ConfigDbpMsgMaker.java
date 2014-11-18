package com.skt.ssp.gw.parse;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.vo.config.IfCf001DbpDataReqVO;
import com.skt.ssp.gw.vo.config.IfCf001MobReqVO;
import com.skt.ssp.gw.vo.config.IfCf002DbpDataReqVO;
import com.skt.ssp.gw.vo.config.IfCf002MobReqVO;
import com.skt.ssp.gw.vo.config.IfCf003DbpDataReqVO;
import com.skt.ssp.gw.vo.config.IfCf003MobReqVO;
import com.skt.ssp.gw.vo.config.IfCf004DbpDataReqVO;
import com.skt.ssp.gw.vo.config.IfCf004MobReqVO;
import com.thoughtworks.xstream.XStream;

/**
 * ConfigDbpMsgMaker (ConfigDbpMsgMaker)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: ConfigDbpMsgMaker.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Component
public class ConfigDbpMsgMaker {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public ConfigDbpMsgMaker() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public String getCf001DbpReqMessage(IfCf001MobReqVO ifCf001MobReqVO) {
		IfCf001DbpDataReqVO ifCf001DbpDataReqVO = new IfCf001DbpDataReqVO();
		ifCf001DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCf001MobReqVO.getRequest().getHeader()));
		ifCf001DbpDataReqVO.setBody(ifCf001MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfCf001DbpDataReqVO.class);
		logger.debug("ifCf001DbpDataReqVO="+ifCf001DbpDataReqVO);
		return xstream.toXML(ifCf001DbpDataReqVO);
	}
	
	public String getCf002DbpReqMessage(IfCf002MobReqVO ifCf002MobReqVO) {
		IfCf002DbpDataReqVO ifCf002DbpDataReqVO = new IfCf002DbpDataReqVO();
		ifCf002DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCf002MobReqVO.getRequest().getHeader()));
		ifCf002DbpDataReqVO.setBody(ifCf002MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfCf002DbpDataReqVO.class);
		logger.debug("ifCf002DbpDataReqVO="+ifCf002DbpDataReqVO);
		return xstream.toXML(ifCf002DbpDataReqVO);
	}
	
	public String getCf003DbpReqMessage(IfCf003MobReqVO ifCf003MobReqVO) {
		IfCf003DbpDataReqVO ifCf003DbpDataReqVO = new IfCf003DbpDataReqVO();
		ifCf003DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCf003MobReqVO.getRequest().getHeader()));
		ifCf003DbpDataReqVO.setBody(ifCf003MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfCf003DbpDataReqVO.class);
		logger.debug("ifCf003DbpDataReqVO="+ifCf003DbpDataReqVO);
		return xstream.toXML(ifCf003DbpDataReqVO);
	}
	
	public String getCf004DbpReqMessage(IfCf004MobReqVO ifCf004MobReqVO) {
		IfCf004DbpDataReqVO ifCf004DbpDataReqVO = new IfCf004DbpDataReqVO();
		ifCf004DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCf004MobReqVO.getRequest().getHeader()));
		ifCf004DbpDataReqVO.setBody(ifCf004MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfCf004DbpDataReqVO.class);
		logger.debug("ifCf004DbpDataReqVO="+ifCf004DbpDataReqVO);
		return xstream.toXML(ifCf004DbpDataReqVO);
	}
}