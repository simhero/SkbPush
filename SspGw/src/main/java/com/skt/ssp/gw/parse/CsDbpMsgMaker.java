package com.skt.ssp.gw.parse;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.vo.cs.IfCs001ComBodyUidConverter;
import com.skt.ssp.gw.vo.cs.IfCs001ComBodyUidReqVO;
import com.skt.ssp.gw.vo.cs.IfCs001DbpDataReqVO;
import com.skt.ssp.gw.vo.cs.IfCs001MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs002DbpDataReqVO;
import com.skt.ssp.gw.vo.cs.IfCs002MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs003DbpDataReqVO;
import com.skt.ssp.gw.vo.cs.IfCs003MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs004ComBodyUidConverter;
import com.skt.ssp.gw.vo.cs.IfCs004ComBodyUidReqVO;
import com.skt.ssp.gw.vo.cs.IfCs004DbpDataReqVO;
import com.skt.ssp.gw.vo.cs.IfCs004MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs005DbpDataReqVO;
import com.skt.ssp.gw.vo.cs.IfCs005MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs006DbpDataReqVO;
import com.skt.ssp.gw.vo.cs.IfCs006MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs007DbpDataReqVO;
import com.skt.ssp.gw.vo.cs.IfCs007MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs008DbpDataReqVO;
import com.skt.ssp.gw.vo.cs.IfCs008MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs009DbpDataReqVO;
import com.skt.ssp.gw.vo.cs.IfCs009MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs010DbpDataReqVO;
import com.skt.ssp.gw.vo.cs.IfCs010MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs011ComBodyCsReqVO;
import com.skt.ssp.gw.vo.cs.IfCs011DbpDataReqVO;
import com.skt.ssp.gw.vo.cs.IfCs011MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs012DbpDataReqVO;
import com.skt.ssp.gw.vo.cs.IfCs012MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs013DbpDataReqVO;
import com.skt.ssp.gw.vo.cs.IfCs013MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs014DbpDataReqVO;
import com.skt.ssp.gw.vo.cs.IfCs014MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs015DbpDataReqVO;
import com.skt.ssp.gw.vo.cs.IfCs015MobReqVO;
import com.thoughtworks.xstream.XStream;

/**
 * CsDbpMsgMaker (CsDbpMsgMaker)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: CsDbpMsgMaker.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Component
public class CsDbpMsgMaker {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public CsDbpMsgMaker() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}
	
	public String getCs001DbpReqMessage(IfCs001MobReqVO ifCs001MobReqVO) {
		IfCs001DbpDataReqVO ifCs001DbpDataReqVO = new IfCs001DbpDataReqVO();
		ifCs001DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCs001MobReqVO.getRequest().getHeader()));
		ifCs001DbpDataReqVO.setBody(ifCs001MobReqVO.getRequest().getBody());
		String time = commonService.getGwDateType();
		if(StringUtils.stripToEmpty(ifCs001DbpDataReqVO.getBody().getDateFrom()).length() == 0) {
			ifCs001DbpDataReqVO.getBody().setDateFrom(time);
		}
		if(StringUtils.stripToEmpty(ifCs001DbpDataReqVO.getBody().getDateTo()).length() == 0) {
			ifCs001DbpDataReqVO.getBody().setDateTo(time);
		}
		XStream xstream = new XStream();
		xstream.registerConverter(new IfCs001ComBodyUidConverter());
		xstream.alias("Request", IfCs001DbpDataReqVO.class);
		xstream.alias("uid", IfCs001ComBodyUidReqVO.class);
		logger.debug("ifCs001DbpDataReqVO="+ifCs001DbpDataReqVO+"\n");
		return xstream.toXML(ifCs001DbpDataReqVO);
	}
	
	public String getCs002DbpReqMessage(IfCs002MobReqVO ifCs002MobReqVO) {
		IfCs002DbpDataReqVO ifCs002DbpDataReqVO = new IfCs002DbpDataReqVO();
		ifCs002DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCs002MobReqVO.getRequest().getHeader()));
		ifCs002DbpDataReqVO.setBody(ifCs002MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfCs002DbpDataReqVO.class);
		logger.debug("ifCs002DbpDataReqVO="+ifCs002DbpDataReqVO+"\n");
		return xstream.toXML(ifCs002DbpDataReqVO);
	}

	public String getCs003DbpReqMessage(IfCs003MobReqVO ifCs003MobReqVO) {
		IfCs003DbpDataReqVO ifCs003DbpDataReqVO = new IfCs003DbpDataReqVO();
		ifCs003DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCs003MobReqVO.getRequest().getHeader()));
		ifCs003DbpDataReqVO.setBody(ifCs003MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfCs003DbpDataReqVO.class);
		logger.debug("ifCs003DbpDataReqVO="+ifCs003DbpDataReqVO+"\n");
		return xstream.toXML(ifCs003DbpDataReqVO);
	}
	
	public String getCs004DbpReqMessage(IfCs004MobReqVO ifCs004MobReqVO) {
		IfCs004DbpDataReqVO ifCs004DbpDataReqVO = new IfCs004DbpDataReqVO();
		ifCs004DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCs004MobReqVO.getRequest().getHeader()));
		ifCs004DbpDataReqVO.setBody(ifCs004MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.registerConverter(new IfCs004ComBodyUidConverter());
		xstream.alias("Request", IfCs004DbpDataReqVO.class);
		xstream.alias("uid", IfCs004ComBodyUidReqVO.class);
		logger.debug("ifCs004DbpDataReqVO="+ifCs004DbpDataReqVO+"\n");
		return xstream.toXML(ifCs004DbpDataReqVO);
	}
	
	public String getCs005DbpReqMessage(IfCs005MobReqVO ifCs005MobReqVO) {
		IfCs005DbpDataReqVO ifCs005DbpDataReqVO = new IfCs005DbpDataReqVO();
		ifCs005DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCs005MobReqVO.getRequest().getHeader()));
		ifCs005DbpDataReqVO.setBody(ifCs005MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfCs005DbpDataReqVO.class);
		logger.debug("ifCs005DbpDataReqVO="+ifCs005DbpDataReqVO+"\n");
		return xstream.toXML(ifCs005DbpDataReqVO);
	}
	
	public String getCs006DbpReqMessage(IfCs006MobReqVO ifCs006MobReqVO) {
		IfCs006DbpDataReqVO ifCs006DbpDataReqVO = new IfCs006DbpDataReqVO();
		ifCs006DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCs006MobReqVO.getRequest().getHeader()));
		ifCs006DbpDataReqVO.setBody(ifCs006MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfCs006DbpDataReqVO.class);
		logger.debug("ifCs006DbpDataReqVO="+ifCs006DbpDataReqVO+"\n");
		return xstream.toXML(ifCs006DbpDataReqVO);
	}
	
	public String getCs007DbpReqMessage(IfCs007MobReqVO ifCs007MobReqVO) {
		IfCs007DbpDataReqVO ifCs007DbpDataReqVO = new IfCs007DbpDataReqVO();
		ifCs007DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCs007MobReqVO.getRequest().getHeader()));
		ifCs007DbpDataReqVO.setBody(ifCs007MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfCs007DbpDataReqVO.class);
		logger.debug("ifCs007DbpDataReqVO="+ifCs007DbpDataReqVO+"\n");
		return xstream.toXML(ifCs007DbpDataReqVO);
	}
	
	public String getCs008DbpReqMessage(IfCs008MobReqVO ifCs008MobReqVO) {
		IfCs008DbpDataReqVO ifCs008DbpDataReqVO = new IfCs008DbpDataReqVO();
		ifCs008DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCs008MobReqVO.getRequest().getHeader()));
		ifCs008DbpDataReqVO.setBody(ifCs008MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfCs008DbpDataReqVO.class);
		logger.debug("ifCs008DbpDataReqVO="+ifCs008DbpDataReqVO+"\n");
		return xstream.toXML(ifCs008DbpDataReqVO);
	}
	
	public String getCs009DbpReqMessage(IfCs009MobReqVO ifCs009MobReqVO) {
		IfCs009DbpDataReqVO ifCs009DbpDataReqVO = new IfCs009DbpDataReqVO();
		ifCs009DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCs009MobReqVO.getRequest().getHeader()));
		ifCs009DbpDataReqVO.setBody(ifCs009MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfCs009DbpDataReqVO.class);
		logger.debug("ifCs009DbpDataReqVO="+ifCs009DbpDataReqVO+"\n");
		return xstream.toXML(ifCs009DbpDataReqVO);
	}
	
	public String getCs010DbpReqMessage(IfCs010MobReqVO ifCs010MobReqVO) {
		IfCs010DbpDataReqVO ifCs010DbpDataReqVO = new IfCs010DbpDataReqVO();
		ifCs010DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCs010MobReqVO.getRequest().getHeader()));
		ifCs010DbpDataReqVO.setBody(ifCs010MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfCs010DbpDataReqVO.class);
		logger.debug("ifCs010DbpDataReqVO="+ifCs010DbpDataReqVO+"\n");
		return xstream.toXML(ifCs010DbpDataReqVO);
	}
	
	public String getCs011DbpReqMessage(IfCs011MobReqVO ifCs011MobReqVO) {
		IfCs011DbpDataReqVO ifCs011DbpDataReqVO = new IfCs011DbpDataReqVO();
		ifCs011DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCs011MobReqVO.getRequest().getHeader()));
		ifCs011DbpDataReqVO.setBody(ifCs011MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfCs011DbpDataReqVO.class);
		xstream.alias("css", IfCs011ComBodyCsReqVO.class);
		logger.debug("ifCs011DbpDataReqVO="+ifCs011DbpDataReqVO+"\n");
		return xstream.toXML(ifCs011DbpDataReqVO);
	}
	
	public String getCs012DbpReqMessage(IfCs012MobReqVO ifCs012MobReqVO) {
		IfCs012DbpDataReqVO ifCs012DbpDataReqVO = new IfCs012DbpDataReqVO();
		ifCs012DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCs012MobReqVO.getRequest().getHeader()));
		ifCs012DbpDataReqVO.setBody(ifCs012MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfCs012DbpDataReqVO.class);
		logger.debug("ifCs012DbpDataReqVO="+ifCs012DbpDataReqVO+"\n");
		return xstream.toXML(ifCs012DbpDataReqVO);
	}
	
	public String getCs013DbpReqMessage(IfCs013MobReqVO ifCs013MobReqVO) {
		IfCs013DbpDataReqVO ifCs013DbpDataReqVO = new IfCs013DbpDataReqVO();
		ifCs013DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCs013MobReqVO.getRequest().getHeader()));
		ifCs013DbpDataReqVO.setBody(ifCs013MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfCs013DbpDataReqVO.class);
		logger.debug("ifCs013DbpDataReqVO="+ifCs013DbpDataReqVO+"\n");
		return xstream.toXML(ifCs013DbpDataReqVO);
	}
	
	public String getCs014DbpReqMessage(IfCs014MobReqVO ifCs014MobReqVO) {
		IfCs014DbpDataReqVO ifCs014DbpDataReqVO = new IfCs014DbpDataReqVO();
		ifCs014DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCs014MobReqVO.getRequest().getHeader()));
		ifCs014DbpDataReqVO.setBody(ifCs014MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfCs014DbpDataReqVO.class);
		logger.debug("ifCs014DbpDataReqVO="+ifCs014DbpDataReqVO+"\n");
		return xstream.toXML(ifCs014DbpDataReqVO);
	}
	
	public String getCs015DbpReqMessage(IfCs015MobReqVO ifCs015MobReqVO) {
		IfCs015DbpDataReqVO ifCs015DbpDataReqVO = new IfCs015DbpDataReqVO();
		ifCs015DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifCs015MobReqVO.getRequest().getHeader()));
		ifCs015DbpDataReqVO.setBody(ifCs015MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("Request", IfCs015DbpDataReqVO.class);
		logger.debug("ifCs015DbpDataReqVO="+ifCs015DbpDataReqVO+"\n");
		return xstream.toXML(ifCs015DbpDataReqVO);
	}
	
}