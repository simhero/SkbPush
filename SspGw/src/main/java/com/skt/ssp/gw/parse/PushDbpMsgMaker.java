package com.skt.ssp.gw.parse;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.vo.push.IfPu001ComBodyUidConverter;
import com.skt.ssp.gw.vo.push.IfPu001ComBodyUidReqVO;
import com.skt.ssp.gw.vo.push.IfPu001DbpDataReqVO;
import com.skt.ssp.gw.vo.push.IfPu001MobReqVO;
import com.skt.ssp.gw.vo.push.IfPu002ComBodyUidConverter;
import com.skt.ssp.gw.vo.push.IfPu002ComBodyUidReqVO;
import com.skt.ssp.gw.vo.push.IfPu002DbpDataReqVO;
import com.skt.ssp.gw.vo.push.IfPu002MobReqVO;
import com.skt.ssp.gw.vo.push.IfPu004ComBodyPushInfoReqVO;
import com.skt.ssp.gw.vo.push.IfPu004DbpDataReqVO;
import com.skt.ssp.gw.vo.push.IfPu004MobReqVO;
import com.thoughtworks.xstream.XStream;

/**
 * PushDbpMsgMaker (PushDbpMsgMaker)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: PushDbpMsgMaker.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Component
public class PushDbpMsgMaker {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public PushDbpMsgMaker() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public String getPu001DbpReqMessage(IfPu001MobReqVO ifPu001MobReqVO) {
		IfPu001DbpDataReqVO ifPu001DbpDataReqVO = new IfPu001DbpDataReqVO();
		ifPu001DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifPu001MobReqVO.getRequest().getHeader()));
		ifPu001DbpDataReqVO.setBody(ifPu001MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.registerConverter(new IfPu001ComBodyUidConverter());
		xstream.alias("Request", IfPu001DbpDataReqVO.class);
		xstream.alias("uid", IfPu001ComBodyUidReqVO.class);
		logger.debug("ifPu001DbpDataReqVO="+ifPu001DbpDataReqVO);
		return xstream.toXML(ifPu001DbpDataReqVO);
	}
	
	public String getPu002DbpReqMessage(IfPu002MobReqVO ifPu002MobReqVO) {
		IfPu002DbpDataReqVO ifPu002DbpDataReqVO = new IfPu002DbpDataReqVO();
		ifPu002DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifPu002MobReqVO.getRequest().getHeader()));
		ifPu002DbpDataReqVO.setBody(ifPu002MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.registerConverter(new IfPu002ComBodyUidConverter());
		xstream.alias("Request", IfPu002DbpDataReqVO.class);
		xstream.alias("uid", IfPu002ComBodyUidReqVO.class);
		logger.debug("ifPu002DbpDataReqVO="+ifPu002DbpDataReqVO);
		return xstream.toXML(ifPu002DbpDataReqVO);
	}
	
	public String getPu004DbpReqMessage(IfPu004MobReqVO ifPu004MobReqVO) {
		IfPu004DbpDataReqVO ifPu004DbpDataReqVO = new IfPu004DbpDataReqVO();
		ifPu004DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifPu004MobReqVO.getRequest().getHeader()));
		ifPu004DbpDataReqVO.setBody(ifPu004MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfPu004DbpDataReqVO.class);
		xstream.alias("pushInfos", IfPu004ComBodyPushInfoReqVO.class);
		logger.debug("ifPu003DbpDataReqVO="+ifPu004DbpDataReqVO);
		return xstream.toXML(ifPu004DbpDataReqVO);
	}

}