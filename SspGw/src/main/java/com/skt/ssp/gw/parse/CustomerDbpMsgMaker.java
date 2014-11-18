package com.skt.ssp.gw.parse;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.vo.customer.IfCu001DbpDataReqVO;
import com.skt.ssp.gw.vo.customer.IfCu001MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu002DbpDataReqVO;
import com.skt.ssp.gw.vo.customer.IfCu002MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu003DbpDataReqVO;
import com.skt.ssp.gw.vo.customer.IfCu003MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu004DbpDataReqVO;
import com.skt.ssp.gw.vo.customer.IfCu004MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu005DbpDataReqVO;
import com.skt.ssp.gw.vo.customer.IfCu005MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu006DbpDataReqVO;
import com.skt.ssp.gw.vo.customer.IfCu006MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu007DbpDataReqVO;
import com.skt.ssp.gw.vo.customer.IfCu007MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu008DbpDataReqVO;
import com.skt.ssp.gw.vo.customer.IfCu008MobReqVO;
import com.thoughtworks.xstream.XStream;

/**
 * CustomerDbpMsgMaker (CustomerDbpMsgMaker)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: CustomerDbpMsgMaker.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
@Component
public class CustomerDbpMsgMaker {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public CustomerDbpMsgMaker() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public String getCu001DbpReqMessage(IfCu001MobReqVO ifCu001MobReqVO) {
		IfCu001DbpDataReqVO ifCu001DbpDataReqVO = new IfCu001DbpDataReqVO();
		ifCu001DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCu001MobReqVO.getRequest().getHeader()));
		ifCu001DbpDataReqVO.setBody(ifCu001MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfCu001DbpDataReqVO.class);
		logger.debug("ifCu001DbpDataReqVO="+ifCu001DbpDataReqVO+"\n");
		return xstream.toXML(ifCu001DbpDataReqVO);
	}

	public String getCu002DbpReqMessage(IfCu002MobReqVO ifCu002MobReqVO) {
		IfCu002DbpDataReqVO ifCu002DbpDataReqVO = new IfCu002DbpDataReqVO();
		ifCu002DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCu002MobReqVO.getRequest().getHeader()));
		ifCu002DbpDataReqVO.setBody(ifCu002MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfCu002DbpDataReqVO.class);
		logger.debug("ifCu002DbpDataReqVO="+ifCu002DbpDataReqVO+"\n");
		return xstream.toXML(ifCu002DbpDataReqVO);
	}

	public String getCu003DbpReqMessage(IfCu003MobReqVO ifCu003MobReqVO) {
		IfCu003DbpDataReqVO ifCu003DbpDataReqVO = new IfCu003DbpDataReqVO();
		ifCu003DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCu003MobReqVO.getRequest().getHeader()));
		ifCu003DbpDataReqVO.setBody(ifCu003MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfCu003DbpDataReqVO.class);
		logger.debug("ifCu003DbpDataReqVO="+ifCu003DbpDataReqVO+"\n");
		return xstream.toXML(ifCu003DbpDataReqVO);
	}
	

	public String getCu004DbpReqMessage(IfCu004MobReqVO ifCu004MobReqVO) {
		IfCu004DbpDataReqVO ifCu004DbpDataReqVO = new IfCu004DbpDataReqVO();
		ifCu004DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCu004MobReqVO.getRequest().getHeader()));
		ifCu004DbpDataReqVO.setBody(ifCu004MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfCu004DbpDataReqVO.class);
		logger.debug("ifCu004DbpDataReqVO="+ifCu004DbpDataReqVO+"\n");
		return xstream.toXML(ifCu004DbpDataReqVO);
	}

	public String getCu005DbpReqMessage(IfCu005MobReqVO ifCu005MobReqVO) {
		IfCu005DbpDataReqVO ifCu005DbpDataReqVO = new IfCu005DbpDataReqVO();
		ifCu005DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCu005MobReqVO.getRequest().getHeader()));
		ifCu005DbpDataReqVO.setBody(ifCu005MobReqVO.getRequest().getBody());
		String time = commonService.getGwDateType();
		if(StringUtils.stripToEmpty(ifCu005DbpDataReqVO.getBody().getDateFrom()).length() == 0) {
			ifCu005DbpDataReqVO.getBody().setDateFrom(time);
		}
		if(StringUtils.stripToEmpty(ifCu005DbpDataReqVO.getBody().getDateTo()).length() == 0) {
			ifCu005DbpDataReqVO.getBody().setDateTo(time);
		}
		XStream xstream = new XStream();
		xstream.alias("Request", IfCu005DbpDataReqVO.class);
		logger.debug("ifCu005DbpDataReqVO="+ifCu005DbpDataReqVO+"\n");
		return xstream.toXML(ifCu005DbpDataReqVO);
	}

	public String getCu006DbpReqMessage(IfCu006MobReqVO ifCu006MobReqVO) {
		IfCu006DbpDataReqVO ifCu006DbpDataReqVO = new IfCu006DbpDataReqVO();
		ifCu006DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCu006MobReqVO.getRequest().getHeader()));
		ifCu006DbpDataReqVO.setBody(ifCu006MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfCu006DbpDataReqVO.class);
		logger.debug("ifCu006DbpDataReqVO="+ifCu006DbpDataReqVO+"\n");
		return xstream.toXML(ifCu006DbpDataReqVO);
	}

	public String getCu007DbpReqMessage(IfCu007MobReqVO ifCu007MobReqVO) {
		IfCu007DbpDataReqVO ifCu007DbpDataReqVO = new IfCu007DbpDataReqVO();
		ifCu007DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCu007MobReqVO.getRequest().getHeader()));
		ifCu007DbpDataReqVO.setBody(ifCu007MobReqVO.getRequest().getBody());
		String time = commonService.getGwDateType();
		if(StringUtils.stripToEmpty(ifCu007DbpDataReqVO.getBody().getDateFrom()).length() == 0) {
			ifCu007DbpDataReqVO.getBody().setDateFrom(time);
		}
		if(StringUtils.stripToEmpty(ifCu007DbpDataReqVO.getBody().getDateTo()).length() == 0) {
			ifCu007DbpDataReqVO.getBody().setDateTo(time);
		}
		XStream xstream = new XStream();
		xstream.alias("Request", IfCu007DbpDataReqVO.class);
		logger.debug("ifCu007DbpDataReqVO="+ifCu007DbpDataReqVO+"\n");
		return xstream.toXML(ifCu007DbpDataReqVO);
	}
	
	public String getCu008DbpReqMessage(IfCu008MobReqVO ifCu008MobReqVO) {
		IfCu008DbpDataReqVO ifCu008DbpDataReqVO = new IfCu008DbpDataReqVO();
		ifCu008DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCu008MobReqVO.getRequest().getHeader()));
		ifCu008DbpDataReqVO.setBody(ifCu008MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfCu008DbpDataReqVO.class);
		logger.debug("ifCu008DbpDataReqVO="+ifCu008DbpDataReqVO+"\n");
		return xstream.toXML(ifCu008DbpDataReqVO);
	}
}