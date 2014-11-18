package com.skt.ssp.gw.parse;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.vo.intro.IfIn001DbpDataReqVO;
import com.skt.ssp.gw.vo.intro.IfIn001MobReqVO;
import com.skt.ssp.gw.vo.intro.IfIn002DbpDataReqVO;
import com.skt.ssp.gw.vo.intro.IfIn002MobReqVO;
import com.thoughtworks.xstream.XStream;

/**
 * IntroDbpMsgMaker (IntroDbpMsgMaker)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IntroDbpMsgMaker.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
@Component
public class IntroDbpMsgMaker {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public IntroDbpMsgMaker() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public String getIn001DbpReqMessage(IfIn001MobReqVO ifIn001MobReqVO) {
		IfIn001DbpDataReqVO ifIn001DbpDataReqVO = new IfIn001DbpDataReqVO();
		ifIn001DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifIn001MobReqVO.getRequest().getHeader()));
		ifIn001DbpDataReqVO.setBody(ifIn001MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfIn001DbpDataReqVO.class);
		logger.debug("ifIn001DbpDataReqVO="+ifIn001DbpDataReqVO+"\n");
		return xstream.toXML(ifIn001DbpDataReqVO);
	}

	public String getIn002DbpReqMessage(IfIn002MobReqVO ifIn002MobReqVO) {
		IfIn002DbpDataReqVO ifIn002DbpDataReqVO = new IfIn002DbpDataReqVO();
		ifIn002DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifIn002MobReqVO.getRequest().getHeader()));
		ifIn002DbpDataReqVO.setBody(ifIn002MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfIn002DbpDataReqVO.class);
		logger.debug("ifIn002DbpDataReqVO="+ifIn002DbpDataReqVO+"\n");
		return xstream.toXML(ifIn002DbpDataReqVO);
	}


}