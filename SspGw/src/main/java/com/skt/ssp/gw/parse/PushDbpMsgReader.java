package com.skt.ssp.gw.parse;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.vo.push.IfPu001ComBodyPushMsgResVO;
import com.skt.ssp.gw.vo.push.IfPu001DbpDataResVO;
import com.skt.ssp.gw.vo.push.IfPu001MobDataResVO;
import com.skt.ssp.gw.vo.push.IfPu001MobResVO;
import com.skt.ssp.gw.vo.push.IfPu002ComBodyPushMsgResVO;
import com.skt.ssp.gw.vo.push.IfPu002DbpDataResVO;
import com.skt.ssp.gw.vo.push.IfPu002MobDataResVO;
import com.skt.ssp.gw.vo.push.IfPu002MobResVO;
import com.skt.ssp.gw.vo.push.IfPu003ComBodyPushIDReqVO;
import com.skt.ssp.gw.vo.push.IfPu003ComBodyTransferGroupReqVO;
import com.skt.ssp.gw.vo.push.IfPu003DbpDataReqVO;
import com.skt.ssp.gw.vo.push.IfPu004ComBodyPushInfoResVO;
import com.skt.ssp.gw.vo.push.IfPu004DbpDataResVO;
import com.skt.ssp.gw.vo.push.IfPu004MobDataResVO;
import com.skt.ssp.gw.vo.push.IfPu004MobResVO;
import com.thoughtworks.xstream.XStream;

/**
 * PushDbpMsgReader (PushDbpMsgReader)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: PushDbpMsgReader.java,v1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Component
public class PushDbpMsgReader {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public PushDbpMsgReader() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public IfPu001MobResVO getPu001DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfPu001DbpDataResVO.class);
		xstream.alias("pushMsgs", IfPu001ComBodyPushMsgResVO.class);
		IfPu001DbpDataResVO ifPu001DbpDataResVO = (IfPu001DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfPu001MobResVO ifPu001MobResVO = new IfPu001MobResVO();
		ifPu001MobResVO.setResponse(new IfPu001MobDataResVO());
		ifPu001MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifPu001DbpDataResVO.getHeader()));
		ifPu001MobResVO.getResponse().setBody(ifPu001DbpDataResVO.getBody());
		logger.debug("ifPu001DbpDataResVO="+ifPu001DbpDataResVO);
		return ifPu001MobResVO;
	}
	
	public IfPu002MobResVO getPu002DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfPu002DbpDataResVO.class);
		xstream.alias("pushMsgs", IfPu002ComBodyPushMsgResVO.class);
		IfPu002DbpDataResVO ifPu002DbpDataResVO = (IfPu002DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfPu002MobResVO ifPu002MobResVO = new IfPu002MobResVO();
		ifPu002MobResVO.setResponse(new IfPu002MobDataResVO());
		ifPu002MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifPu002DbpDataResVO.getHeader()));
		ifPu002MobResVO.getResponse().setBody(ifPu002DbpDataResVO.getBody());
		logger.debug("ifPu002DbpDataResVO="+ifPu002DbpDataResVO);
		return ifPu002MobResVO;
	}
	
	public IfPu003DbpDataReqVO getPu003DbpReqMessage(String dbpReqMessage) {
		XStream xstream = new XStream();
		xstream.alias("Request", IfPu003DbpDataReqVO.class);
		xstream.alias("pushIds", IfPu003ComBodyPushIDReqVO.class);
		xstream.alias("transferGroups", IfPu003ComBodyTransferGroupReqVO.class);
		IfPu003DbpDataReqVO ifPu003DbpDataReqVO = (IfPu003DbpDataReqVO)xstream.fromXML(dbpReqMessage);
		logger.debug("ifPu003DbpDataReqVO="+ifPu003DbpDataReqVO);
		return ifPu003DbpDataReqVO;
	}
	
	public IfPu004MobResVO getPu004DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfPu004DbpDataResVO.class);
		xstream.alias("pushInfos", IfPu004ComBodyPushInfoResVO.class);
		IfPu004DbpDataResVO ifPu004DbpDataResVO = (IfPu004DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfPu004MobResVO ifPu004MobResVO = new IfPu004MobResVO();
		ifPu004MobResVO.setResponse(new IfPu004MobDataResVO());
		ifPu004MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifPu004DbpDataResVO.getHeader()));
		ifPu004MobResVO.getResponse().setBody(ifPu004DbpDataResVO.getBody());
		logger.debug("ifPu004DbpDataResVO="+ifPu004DbpDataResVO);
		return ifPu004MobResVO;
	}


}