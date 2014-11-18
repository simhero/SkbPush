package com.skt.ssp.gw.parse;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;

/**
 * MarketDbpMsgReader (MarketDbpMsgReader)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: MarketDbpMsgReader.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
@Component
public class MarketDbpMsgReader {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public MarketDbpMsgReader() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}
	
	public CommonService getCommonService() {
		return commonService;
	}


}