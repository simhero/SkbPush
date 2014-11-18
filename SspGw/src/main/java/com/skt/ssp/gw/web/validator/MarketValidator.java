package com.skt.ssp.gw.web.validator;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.vo.test.IfTe001MobReqVO;
import com.skt.ssp.gw.vo.test.IfTe001MobResVO;

/**
 * MarketValidator (MarketValidator)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: MarketValidator.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
@Component
public class MarketValidator {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public MarketValidator() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public IfTe001MobResVO validateMarket001(IfTe001MobReqVO ifTe001MobReqVO) {
		// TODO Auto-generated method stub
		commonService.getServerId();
		return null;
	}


}