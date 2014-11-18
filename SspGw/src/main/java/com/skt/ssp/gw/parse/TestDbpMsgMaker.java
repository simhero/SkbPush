package com.skt.ssp.gw.parse;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.vo.test.IfTe001ComBodyOrderReqVO;
import com.skt.ssp.gw.vo.test.IfTe001DbpDataReqVO;
import com.skt.ssp.gw.vo.test.IfTe001MobReqVO;
import com.thoughtworks.xstream.XStream;

/**
 * TestDbpMsgMaker (TestDbpMsgMaker)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: TestDbpMsgMaker.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
@Component
public class TestDbpMsgMaker {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public TestDbpMsgMaker() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public String getTe001DbpReqMessage(IfTe001MobReqVO ifTe001MobReqVO) {
		IfTe001DbpDataReqVO ifTe001DbpDataReqVO = new IfTe001DbpDataReqVO();
		ifTe001DbpDataReqVO.setHeader(commonService.setDbpReqHeader(ifTe001MobReqVO.getRequest().getHeader()));
		ifTe001DbpDataReqVO.setBody(ifTe001MobReqVO.getRequest().getBody());
		XStream xstream = new XStream();
		xstream.alias("request", IfTe001DbpDataReqVO.class);
		xstream.alias("order", IfTe001ComBodyOrderReqVO.class);
		logger.debug("ifTe001DbpDataReqVO="+ifTe001DbpDataReqVO);
		return xstream.toXML(ifTe001DbpDataReqVO);
	}


}