package com.skt.ssp.gw.parse;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.vo.customer.IfCu001ComBodyAuthResVO;
import com.skt.ssp.gw.vo.customer.IfCu001DbpDataResVO;
import com.skt.ssp.gw.vo.customer.IfCu001MobDataResVO;
import com.skt.ssp.gw.vo.customer.IfCu001MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu002DbpDataResVO;
import com.skt.ssp.gw.vo.customer.IfCu002MobDataResVO;
import com.skt.ssp.gw.vo.customer.IfCu002MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu003DbpDataResVO;
import com.skt.ssp.gw.vo.customer.IfCu003MobDataResVO;
import com.skt.ssp.gw.vo.customer.IfCu003MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu004ComBodyMarketResVO;
import com.skt.ssp.gw.vo.customer.IfCu004DbpDataResVO;
import com.skt.ssp.gw.vo.customer.IfCu004MobDataResVO;
import com.skt.ssp.gw.vo.customer.IfCu004MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu005DbpDataResVO;
import com.skt.ssp.gw.vo.customer.IfCu005MobDataResVO;
import com.skt.ssp.gw.vo.customer.IfCu005MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu006DbpDataResVO;
import com.skt.ssp.gw.vo.customer.IfCu006MobDataResVO;
import com.skt.ssp.gw.vo.customer.IfCu006MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu007ComBodyMarketResVO;
import com.skt.ssp.gw.vo.customer.IfCu007ComBodyTagcomResVO;
import com.skt.ssp.gw.vo.customer.IfCu007DbpDataResVO;
import com.skt.ssp.gw.vo.customer.IfCu007MobDataResVO;
import com.skt.ssp.gw.vo.customer.IfCu007MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu008DbpDataResVO;
import com.skt.ssp.gw.vo.customer.IfCu008MobDataResVO;
import com.skt.ssp.gw.vo.customer.IfCu008MobResVO;
import com.thoughtworks.xstream.XStream;

/**
 * CustomerDbpMsgReader (CustomerDbpMsgReader)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: CustomerDbpMsgReader.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
@Component
public class CustomerDbpMsgReader {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public CustomerDbpMsgReader() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public IfCu001MobResVO getCu001DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCu001DbpDataResVO.class);
		xstream.alias("auths", IfCu001ComBodyAuthResVO.class);
		IfCu001DbpDataResVO ifCu001DbpDataResVO = (IfCu001DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCu001MobResVO ifCu001MobResVO = new IfCu001MobResVO();
		ifCu001MobResVO.setResponse(new IfCu001MobDataResVO());
		ifCu001MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCu001DbpDataResVO.getHeader()));
		ifCu001MobResVO.getResponse().setBody(ifCu001DbpDataResVO.getBody());
		logger.debug("ifCu001DbpDataResVO="+ifCu001DbpDataResVO+"\n");
		return ifCu001MobResVO;
	}

	public IfCu002MobResVO getCu002DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCu002DbpDataResVO.class);
		IfCu002DbpDataResVO ifCu002DbpDataResVO = (IfCu002DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCu002MobResVO ifCu002MobResVO = new IfCu002MobResVO();
		ifCu002MobResVO.setResponse(new IfCu002MobDataResVO());
		ifCu002MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCu002DbpDataResVO.getHeader()));
		ifCu002MobResVO.getResponse().setBody(ifCu002DbpDataResVO.getBody());
		logger.debug("ifCu002DbpDataResVO="+ifCu002DbpDataResVO+"\n");
		return ifCu002MobResVO;
	}

	public IfCu003MobResVO getCu003DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCu003DbpDataResVO.class);
		IfCu003DbpDataResVO ifCu003DbpDataResVO = (IfCu003DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCu003MobResVO ifCu003MobResVO = new IfCu003MobResVO();
		ifCu003MobResVO.setResponse(new IfCu003MobDataResVO());
		ifCu003MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCu003DbpDataResVO.getHeader()));
		ifCu003MobResVO.getResponse().setBody(ifCu003DbpDataResVO.getBody());
		logger.debug("ifCu003DbpDataResVO="+ifCu003DbpDataResVO+"\n");
		return ifCu003MobResVO;
	}

	public IfCu004MobResVO getCu004DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCu004DbpDataResVO.class);
		xstream.alias("markets", IfCu004ComBodyMarketResVO.class);
		IfCu004DbpDataResVO ifCu004DbpDataResVO = (IfCu004DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCu004MobResVO ifCu004MobResVO = new IfCu004MobResVO();
		ifCu004MobResVO.setResponse(new IfCu004MobDataResVO());
		ifCu004MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCu004DbpDataResVO.getHeader()));
		ifCu004MobResVO.getResponse().setBody(ifCu004DbpDataResVO.getBody());
		logger.debug("ifCu004DbpDataResVO="+ifCu004DbpDataResVO+"\n");
		return ifCu004MobResVO;
	}

	public IfCu005MobResVO getCu005DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCu005DbpDataResVO.class);
		IfCu005DbpDataResVO ifCu005DbpDataResVO = (IfCu005DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCu005MobResVO ifCu005MobResVO = new IfCu005MobResVO();
		ifCu005MobResVO.setResponse(new IfCu005MobDataResVO());
		ifCu005MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCu005DbpDataResVO.getHeader()));
		ifCu005MobResVO.getResponse().setBody(ifCu005DbpDataResVO.getBody());
		logger.debug("ifCu005DbpDataResVO="+ifCu005DbpDataResVO+"\n");
		return ifCu005MobResVO;
	}

	public IfCu006MobResVO getCu006DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCu006DbpDataResVO.class);
		IfCu006DbpDataResVO ifCu006DbpDataResVO = (IfCu006DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCu006MobResVO ifCu006MobResVO = new IfCu006MobResVO();
		ifCu006MobResVO.setResponse(new IfCu006MobDataResVO());
		ifCu006MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCu006DbpDataResVO.getHeader()));
		ifCu006MobResVO.getResponse().setBody(ifCu006DbpDataResVO.getBody());
		logger.debug("ifCu006DbpDataResVO="+ifCu006DbpDataResVO+"\n");
		return ifCu006MobResVO;
	}

	public IfCu007MobResVO getCu007DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCu007DbpDataResVO.class);
		xstream.alias("markets", IfCu007ComBodyMarketResVO.class);
		xstream.alias("tagcoms", IfCu007ComBodyTagcomResVO.class);
		IfCu007DbpDataResVO ifCu007DbpDataResVO = (IfCu007DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCu007MobResVO ifCu007MobResVO = new IfCu007MobResVO();
		ifCu007MobResVO.setResponse(new IfCu007MobDataResVO());
		ifCu007MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCu007DbpDataResVO.getHeader()));
		ifCu007MobResVO.getResponse().setBody(ifCu007DbpDataResVO.getBody());
		logger.debug("ifCu007DbpDataResVO="+ifCu007DbpDataResVO+"\n");
		return ifCu007MobResVO;
	}
	
	public IfCu008MobResVO getCu008DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("Response", IfCu008DbpDataResVO.class);
		IfCu008DbpDataResVO ifCu008DbpDataResVO = (IfCu008DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfCu008MobResVO ifCu008MobResVO = new IfCu008MobResVO();
		ifCu008MobResVO.setResponse(new IfCu008MobDataResVO());
		ifCu008MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifCu008DbpDataResVO.getHeader()));
//		ifCu008MobResVO.getResponse().setBody(ifCu008DbpDataResVO.getBody());
		logger.debug("ifCu008DbpDataResVO="+ifCu008DbpDataResVO+"\n");
		return ifCu008MobResVO;
	}
}