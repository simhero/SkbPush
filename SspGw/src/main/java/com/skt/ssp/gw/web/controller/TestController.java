package com.skt.ssp.gw.web.controller;


import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skt.ssp.gw.vo.IfErrMobResVO;
import com.skt.ssp.gw.vo.test.IfTe001MobReqVO;
import com.skt.ssp.gw.vo.test.IfTe001MobResVO;
import com.skt.ssp.gw.web.validator.TestValidator;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.service.TestService;

/**
 * TestController (TestController)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: TestController.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
@Controller
@RequestMapping("/mobileInterface")
public class TestController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;
	@Autowired
	private TestValidator testValidator;
	@Autowired
	private TestService testService;

	@RequestMapping(value = "/IF-TE-001", method=RequestMethod.POST)
	public @ResponseBody Object requestTest001(@RequestHeader("User-Agent") String userAgent, @RequestBody IfTe001MobReqVO ifTe001MobReqVO) {
		try {
			String test = "";
			Integer.parseInt(test);
			IfErrMobResVO ifErrMobResVO = testValidator.validateTest001(ifTe001MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			logger.debug("ifTe001MobReqVO="+ifTe001MobReqVO);
			IfTe001MobResVO ifTe001MobResVO = testService.requestTest001(ifTe001MobReqVO);
			if ( ifTe001MobResVO == null) return commonService.getMobErrorResponseMsg(ifTe001MobReqVO.getRequest().getHeader(), "TE00001");
			return ifTe001MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifTe001MobReqVO.getRequest().getHeader(), "TE00001", errorMsg);			
		}
	}

}