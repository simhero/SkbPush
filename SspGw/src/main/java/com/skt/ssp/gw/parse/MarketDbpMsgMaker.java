package com.skt.ssp.gw.parse;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;

/**
 * MarketDbpMsgMaker (MarketDbpMsgMaker)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: MarketDbpMsgMaker.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
@Component
public class MarketDbpMsgMaker {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public MarketDbpMsgMaker() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}
	
	public CommonService getCommonService() {
		return commonService;
	}


}