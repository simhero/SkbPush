package com.skt.ssp.gw.parse;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.vo.intro.IfIn001ComBodyKeyWordResVO;
import com.skt.ssp.gw.vo.intro.IfIn001ComBodyMarketResVO;
import com.skt.ssp.gw.vo.intro.IfIn001DbpDataResVO;
import com.skt.ssp.gw.vo.intro.IfIn001MobDataResVO;
import com.skt.ssp.gw.vo.intro.IfIn001MobResVO;
import com.skt.ssp.gw.vo.intro.IfIn002DbpDataResVO;
import com.skt.ssp.gw.vo.intro.IfIn002MobDataResVO;
import com.skt.ssp.gw.vo.intro.IfIn002MobResVO;
import com.thoughtworks.xstream.XStream;

/**
 * IntroDbpMsgReader (IntroDbpMsgReader)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IntroDbpMsgReader.java,v1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
@Component
public class IntroDbpMsgReader {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public IntroDbpMsgReader() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public IfIn001MobResVO getIn001DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfIn001DbpDataResVO.class);
		xstream.alias("markets", IfIn001ComBodyMarketResVO.class);
		xstream.alias("keyWords", IfIn001ComBodyKeyWordResVO.class);
		IfIn001DbpDataResVO ifIn001DbpDataResVO = (IfIn001DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfIn001MobResVO ifIn001MobResVO = new IfIn001MobResVO();
		ifIn001MobResVO.setResponse(new IfIn001MobDataResVO());
		ifIn001MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifIn001DbpDataResVO.getHeader()));
		ifIn001MobResVO.getResponse().setBody(ifIn001DbpDataResVO.getBody());
		if(ifIn001MobResVO.getResponse().getBody() != null) {
			ifIn001MobResVO.getResponse().getBody().setComAppVersion(config.getString("APP_VERSION"));
			ifIn001MobResVO.getResponse().getBody().setComAppUpdate(config.getString("APP_UPDATE"));
		}
		logger.debug("ifIn001DbpDataResVO="+ifIn001DbpDataResVO+"\n");
		return ifIn001MobResVO;
	}

	public IfIn002MobResVO getIn002DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfIn002DbpDataResVO.class);
		IfIn002DbpDataResVO ifIn002DbpDataResVO = (IfIn002DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfIn002MobResVO ifIn002MobResVO = new IfIn002MobResVO();
		ifIn002MobResVO.setResponse(new IfIn002MobDataResVO());
		ifIn002MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifIn002DbpDataResVO.getHeader()));
		logger.debug("ifIn002DbpDataResVO="+ifIn002DbpDataResVO+"\n");
		return ifIn002MobResVO;
	}


}