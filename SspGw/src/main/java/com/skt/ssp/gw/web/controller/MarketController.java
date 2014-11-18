package com.skt.ssp.gw.web.controller;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.vo.test.IfTe001MobReqVO;
import com.skt.ssp.gw.vo.test.IfTe001MobResVO;
import com.skt.ssp.gw.web.validator.MarketValidator;

/**
 * MarketController (MarketController)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: MarketController.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
@Controller
@RequestMapping("/mobileInterface")
public class MarketController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;
	@Autowired
	private MarketValidator marketValidator;

	@RequestMapping(value = "/IFMA001", method=RequestMethod.POST)
	public @ResponseBody IfTe001MobResVO requestMarket001(@RequestHeader("User-Agent") String userAgent, @RequestBody IfTe001MobReqVO ifTe001MobReqVO) {
		IfTe001MobResVO ifTe001MobResVO = marketValidator.validateMarket001(ifTe001MobReqVO);
		if (ifTe001MobResVO != null) return ifTe001MobResVO;
//		logger.debug("ifTe001ResVO="+ifTe001ResVO);
		commonService.getServerId();
		config.getString("SUCCESS");
		return ifTe001MobResVO;
	}

}