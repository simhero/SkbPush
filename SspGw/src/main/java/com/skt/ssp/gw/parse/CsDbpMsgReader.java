package com.skt.ssp.gw.parse;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.vo.cs.IfCs001ComBodyCsResVO;
import com.skt.ssp.gw.vo.cs.IfCs001DbpDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs001MobDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs001MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs002DbpDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs002MobDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs002MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs003DbpDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs003MobDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs003MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs004ComBodyCsResVO;
import com.skt.ssp.gw.vo.cs.IfCs004DbpDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs004MobDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs004MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs005DbpDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs005MobDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs005MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs006ComBodyCsResVO;
import com.skt.ssp.gw.vo.cs.IfCs006DbpDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs006MobDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs006MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs007DbpDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs007MobDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs007MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs008ComBodyCsResVO;
import com.skt.ssp.gw.vo.cs.IfCs008DbpDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs008MobDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs008MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs009ComBodyCsResVO;
import com.skt.ssp.gw.vo.cs.IfCs009DbpDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs009MobDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs009MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs010DbpDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs010MobDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs010MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs011ComBodyCsResVO;
import com.skt.ssp.gw.vo.cs.IfCs011DbpDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs011MobDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs011MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs012ComBodyFaqResVO;
import com.skt.ssp.gw.vo.cs.IfCs012DbpDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs012MobDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs012MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs013DbpDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs013MobDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs013MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs014DbpDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs014MobDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs014MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs015DbpDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs015MobDataResVO;
import com.skt.ssp.gw.vo.cs.IfCs015MobResVO;
import com.thoughtworks.xstream.XStream;

/**
 * CsDbpMsgReader (CsDbpMsgReader)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: CsDbpMsgReader.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Component
public class CsDbpMsgReader {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public CsDbpMsgReader() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public IfCs001MobResVO getCs001DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCs001DbpDataResVO.class);
		xstream.alias("css", IfCs001ComBodyCsResVO.class);
		IfCs001DbpDataResVO ifCs001DbpDataResVO = (IfCs001DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCs001MobResVO ifCs001MobResVO = new IfCs001MobResVO();
		ifCs001MobResVO.setResponse(new IfCs001MobDataResVO());
		ifCs001MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCs001DbpDataResVO.getHeader()));
		ifCs001MobResVO.getResponse().setBody(ifCs001DbpDataResVO.getBody());
		logger.debug("ifCs001DbpDataResVO"+ifCs001DbpDataResVO+"\n");
		return ifCs001MobResVO;
	}
	
	public IfCs002MobResVO getCs002DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCs002DbpDataResVO.class);
		IfCs002DbpDataResVO ifCs002DbpDataResVO = (IfCs002DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCs002MobResVO ifCs002MobResVO = new IfCs002MobResVO();
		ifCs002MobResVO.setResponse(new IfCs002MobDataResVO());
		ifCs002MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCs002DbpDataResVO.getHeader()));
		ifCs002MobResVO.getResponse().setBody(ifCs002DbpDataResVO.getBody());
		logger.debug("ifCs002DbpDataResVO"+ifCs002DbpDataResVO+"\n");
		return ifCs002MobResVO;
	}
	
	public IfCs003MobResVO getCs003DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCs003DbpDataResVO.class);
		IfCs003DbpDataResVO ifCs003DbpDataResVO = (IfCs003DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCs003MobResVO ifCs003MobResVO = new IfCs003MobResVO();
		ifCs003MobResVO.setResponse(new IfCs003MobDataResVO());
		ifCs003MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCs003DbpDataResVO.getHeader()));
//		ifCs003MobResVO.getResponse().setBody(ifCs003DbpDataResVO.getBody());
		logger.debug("ifCs003DbpDataResVO"+ifCs003DbpDataResVO+"\n");
		return ifCs003MobResVO;
	}
	
	public IfCs004MobResVO getCs004DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCs004DbpDataResVO.class);
		xstream.alias("css", IfCs004ComBodyCsResVO.class);
		IfCs004DbpDataResVO ifCs004DbpDataResVO = (IfCs004DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCs004MobResVO ifCs004MobResVO = new IfCs004MobResVO();
		ifCs004MobResVO.setResponse(new IfCs004MobDataResVO());
		ifCs004MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCs004DbpDataResVO.getHeader()));
		ifCs004MobResVO.getResponse().setBody(ifCs004DbpDataResVO.getBody());
		logger.debug("ifCs004DbpDataResVO"+ifCs004DbpDataResVO+"\n");
		return ifCs004MobResVO;
	}
	
	public IfCs005MobResVO getCs005DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCs005DbpDataResVO.class);
		IfCs005DbpDataResVO ifCs005DbpDataResVO = (IfCs005DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCs005MobResVO ifCs005MobResVO = new IfCs005MobResVO();
		ifCs005MobResVO.setResponse(new IfCs005MobDataResVO());
		ifCs005MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCs005DbpDataResVO.getHeader()));
		ifCs005MobResVO.getResponse().setBody(ifCs005DbpDataResVO.getBody());
		logger.debug("ifCs005DbpDataResVO"+ifCs005DbpDataResVO+"\n");
		return ifCs005MobResVO;
	}
	
	public IfCs006MobResVO getCs006DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCs006DbpDataResVO.class);
		xstream.alias("css", IfCs006ComBodyCsResVO.class);
		IfCs006DbpDataResVO ifCs006DbpDataResVO = (IfCs006DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCs006MobResVO ifCs006MobResVO = new IfCs006MobResVO();
		ifCs006MobResVO.setResponse(new IfCs006MobDataResVO());
		ifCs006MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCs006DbpDataResVO.getHeader()));
		ifCs006MobResVO.getResponse().setBody(ifCs006DbpDataResVO.getBody());
		logger.debug("ifCs006DbpDataResVO"+ifCs006DbpDataResVO+"\n");
		return ifCs006MobResVO;
	}
	
	public IfCs007MobResVO getCs007DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCs007DbpDataResVO.class);
		IfCs007DbpDataResVO ifCs007DbpDataResVO = (IfCs007DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCs007MobResVO ifCs007MobResVO = new IfCs007MobResVO();
		ifCs007MobResVO.setResponse(new IfCs007MobDataResVO());
		ifCs007MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCs007DbpDataResVO.getHeader()));
//		ifCs007MobResVO.getResponse().setBody(ifCs007DbpDataResVO.getBody());
		logger.debug("ifCs007DbpDataResVO"+ifCs007DbpDataResVO+"\n");
		return ifCs007MobResVO;
	}
	
	public IfCs008MobResVO getCs008DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCs008DbpDataResVO.class);
		xstream.alias("css", IfCs008ComBodyCsResVO.class);
		IfCs008DbpDataResVO ifCs008DbpDataResVO = (IfCs008DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCs008MobResVO ifCs008MobResVO = new IfCs008MobResVO();
		ifCs008MobResVO.setResponse(new IfCs008MobDataResVO());
		ifCs008MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCs008DbpDataResVO.getHeader()));
		ifCs008MobResVO.getResponse().setBody(ifCs008DbpDataResVO.getBody());
		logger.debug("ifCs008DbpDataResVO"+ifCs008DbpDataResVO+"\n");
		return ifCs008MobResVO;
	}
	
	public IfCs009MobResVO getCs009DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCs009DbpDataResVO.class);
		xstream.alias("css", IfCs009ComBodyCsResVO.class);
		IfCs009DbpDataResVO ifCs009DbpDataResVO = (IfCs009DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCs009MobResVO ifCs009MobResVO = new IfCs009MobResVO();
		ifCs009MobResVO.setResponse(new IfCs009MobDataResVO());
		ifCs009MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCs009DbpDataResVO.getHeader()));
		ifCs009MobResVO.getResponse().setBody(ifCs009DbpDataResVO.getBody());
		logger.debug("ifCs009DbpDataResVO"+ifCs009DbpDataResVO+"\n");
		return ifCs009MobResVO;
	}
	
	public IfCs010MobResVO getCs010DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCs010DbpDataResVO.class);
		IfCs010DbpDataResVO ifCs010DbpDataResVO = (IfCs010DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCs010MobResVO ifCs010MobResVO = new IfCs010MobResVO();
		ifCs010MobResVO.setResponse(new IfCs010MobDataResVO());
		ifCs010MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCs010DbpDataResVO.getHeader()));
		ifCs010MobResVO.getResponse().setBody(ifCs010DbpDataResVO.getBody());
		logger.debug("ifCs010DbpDataResVO"+ifCs010DbpDataResVO+"\n");
		return ifCs010MobResVO;
	}
	
	public IfCs011MobResVO getCs011DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCs011DbpDataResVO.class);
		xstream.alias("css", IfCs011ComBodyCsResVO.class);
		IfCs011DbpDataResVO ifCs011DbpDataResVO = (IfCs011DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCs011MobResVO ifCs011MobResVO = new IfCs011MobResVO();
		ifCs011MobResVO.setResponse(new IfCs011MobDataResVO());
		ifCs011MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCs011DbpDataResVO.getHeader()));
		ifCs011MobResVO.getResponse().setBody(ifCs011DbpDataResVO.getBody());
		logger.debug("ifCs011DbpDataResVO"+ifCs011DbpDataResVO+"\n");
		return ifCs011MobResVO;
	}
	
	public IfCs012MobResVO getCs012DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCs012DbpDataResVO.class);
		xstream.alias("faqs", IfCs012ComBodyFaqResVO.class);
		IfCs012DbpDataResVO ifCs012DbpDataResVO = (IfCs012DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCs012MobResVO ifCs012MobResVO = new IfCs012MobResVO();
		ifCs012MobResVO.setResponse(new IfCs012MobDataResVO());
		ifCs012MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCs012DbpDataResVO.getHeader()));
		ifCs012MobResVO.getResponse().setBody(ifCs012DbpDataResVO.getBody());
		logger.debug("ifCs012DbpDataResVO"+ifCs012DbpDataResVO+"\n");
		return ifCs012MobResVO;
	}
	
	public IfCs013MobResVO getCs013DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCs013DbpDataResVO.class);
		IfCs013DbpDataResVO ifCs013DbpDataResVO = (IfCs013DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCs013MobResVO ifCs013MobResVO = new IfCs013MobResVO();
		ifCs013MobResVO.setResponse(new IfCs013MobDataResVO());
		ifCs013MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCs013DbpDataResVO.getHeader()));
//		ifCs013MobResVO.getResponse().setBody(ifCs013DbpDataResVO.getBody());
		logger.debug("ifCs013DbpDataResVO"+ifCs013DbpDataResVO+"\n");
		return ifCs013MobResVO;
	}
	
	public IfCs014MobResVO getCs014DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCs014DbpDataResVO.class);
		IfCs014DbpDataResVO ifCs014DbpDataResVO = (IfCs014DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCs014MobResVO ifCs014MobResVO = new IfCs014MobResVO();
		ifCs014MobResVO.setResponse(new IfCs014MobDataResVO());
		ifCs014MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCs014DbpDataResVO.getHeader()));
//		ifCs014MobResVO.getResponse().setBody(ifCs014DbpDataResVO.getBody());
		logger.debug("ifCs014DbpDataResVO"+ifCs014DbpDataResVO+"\n");
		return ifCs014MobResVO;
	}
	
	public IfCs015MobResVO getCs015DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCs015DbpDataResVO.class);
		IfCs015DbpDataResVO ifCs015DbpDataResVO = (IfCs015DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCs015MobResVO ifCs015MobResVO = new IfCs015MobResVO();
		ifCs015MobResVO.setResponse(new IfCs015MobDataResVO());
		ifCs015MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCs015DbpDataResVO.getHeader()));
//		ifCs015MobResVO.getResponse().setBody(ifCs015DbpDataResVO.getBody());
		logger.debug("ifCs015DbpDataResVO"+ifCs015DbpDataResVO+"\n");
		return ifCs015MobResVO;
	}

}