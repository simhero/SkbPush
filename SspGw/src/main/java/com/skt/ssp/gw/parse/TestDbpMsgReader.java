package com.skt.ssp.gw.parse;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.vo.test.IfTe001ComBodyOrderResVO;
import com.skt.ssp.gw.vo.test.IfTe001DbpDataResVO;
import com.skt.ssp.gw.vo.test.IfTe001MobDataResVO;
import com.skt.ssp.gw.vo.test.IfTe001MobResVO;
import com.thoughtworks.xstream.XStream;

/**
 * TestDbpMsgReader (TestDbpMsgReader)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: TestDbpMsgReader.java,v1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
@Component
public class TestDbpMsgReader {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public TestDbpMsgReader() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public IfTe001MobResVO getTe001DbpResMessage(String dbpResMessage) {
		XStream xstream = new XStream();
		xstream.alias("response", IfTe001DbpDataResVO.class);
		xstream.alias("order", IfTe001ComBodyOrderResVO.class);
		IfTe001DbpDataResVO ifTe001DbpDataResVO = (IfTe001DbpDataResVO)xstream.fromXML(dbpResMessage);
		IfTe001MobResVO ifTe001MobResVO = new IfTe001MobResVO();
		ifTe001MobResVO.setResponse(new IfTe001MobDataResVO());
		ifTe001MobResVO.getResponse().setHeader(commonService.setMobResHeader(ifTe001DbpDataResVO.getHeader()));
		ifTe001MobResVO.getResponse().setBody(ifTe001DbpDataResVO.getBody());
		logger.debug("ifTe001DbpDataResVO="+ifTe001DbpDataResVO);
		return ifTe001MobResVO;
	}


}