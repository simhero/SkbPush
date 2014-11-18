package com.skt.ssp.gw.web.controller;


import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.service.ConfigService;
import com.skt.ssp.gw.vo.IfErrMobResVO;
import com.skt.ssp.gw.vo.config.IfCf001MobReqVO;
import com.skt.ssp.gw.vo.config.IfCf001MobResVO;
import com.skt.ssp.gw.vo.config.IfCf002MobReqVO;
import com.skt.ssp.gw.vo.config.IfCf002MobResVO;
import com.skt.ssp.gw.vo.config.IfCf003MobReqVO;
import com.skt.ssp.gw.vo.config.IfCf003MobResVO;
import com.skt.ssp.gw.vo.config.IfCf004MobReqVO;
import com.skt.ssp.gw.vo.config.IfCf004MobResVO;
import com.skt.ssp.gw.web.validator.ConfigValidator;

/**
 * Config Controller (ConfigController)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: ConfigController.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Controller
@RequestMapping("/mobileInterface")
public class ConfigController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;
	@Autowired
	private ConfigValidator configValidator;
	@Autowired
	private ConfigService configService;
	
	@RequestMapping(value = "/IF-CF-001", method=RequestMethod.POST)
	public @ResponseBody Object requestConfig001(@RequestBody IfCf001MobReqVO ifCf001MobReqVO) {
		try {
			logger.debug("ifCf001MobReqVO="+ifCf001MobReqVO);
			
			// request validate
			IfErrMobResVO ifErrMobResVO = configValidator.validateConfig001(ifCf001MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifCf001MobReqVO.getRequest().getHeader(), ifCf001MobReqVO.getRequest().getBody().getAdminCode(), ifCf001MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
			
			// response data call
			IfCf001MobResVO ifCf001MobResVO = configService.requestConfig001(ifCf001MobReqVO);
			if ( ifCf001MobResVO == null) return commonService.getMobErrorResponseMsg(ifCf001MobReqVO.getRequest().getHeader(), "CO00900");
			
			// response validate
			IfErrMobResVO ifErrMobResVO2 = configValidator.validateConfig001Res(ifCf001MobReqVO, ifCf001MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// authkey add create date & last date
			commonService.addResAuthTime(ifCf001MobReqVO.getRequest().getHeader(), ifCf001MobResVO.getResponse().getHeader());
			return ifCf001MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCf001MobReqVO.getRequest().getHeader(), "CF01999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-CF-002", method=RequestMethod.POST)
	public @ResponseBody Object requestConfig002(@RequestBody IfCf002MobReqVO ifCf002MobReqVO) {
		try {
			logger.debug("ifCf002MobReqVO="+ifCf002MobReqVO);
			
			// request validate
			IfErrMobResVO ifErrMobResVO = configValidator.validateConfig002(ifCf002MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifCf002MobReqVO.getRequest().getHeader(), ifCf002MobReqVO.getRequest().getBody().getAdminCode(), ifCf002MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
			
			// response data call
			IfCf002MobResVO ifCf002MobResVO = configService.requestConfig002(ifCf002MobReqVO);
			if ( ifCf002MobResVO == null) return commonService.getMobErrorResponseMsg(ifCf002MobReqVO.getRequest().getHeader(), "CO00900");
			
			// response validate
			IfErrMobResVO ifErrMobResVO2 = configValidator.validateConfig002Res(ifCf002MobReqVO, ifCf002MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// authkey add create date & last date
			commonService.addResAuthTime(ifCf002MobReqVO.getRequest().getHeader(), ifCf002MobResVO.getResponse().getHeader());
			return ifCf002MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCf002MobReqVO.getRequest().getHeader(), "CF02999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-CF-003", method=RequestMethod.POST)
	public @ResponseBody Object requestConfig003(@RequestBody IfCf003MobReqVO ifCf003MobReqVO) {
		try {
			logger.debug("ifCf003MobReqVO="+ifCf003MobReqVO);
			
			// request validate
			IfErrMobResVO ifErrMobResVO = configValidator.validateConfig003(ifCf003MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifCf003MobReqVO.getRequest().getHeader(), ifCf003MobReqVO.getRequest().getBody().getAdminCode(), ifCf003MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
			
			// response data call
			IfCf003MobResVO ifCf003MobResVO = configService.requestConfig003(ifCf003MobReqVO);
			if ( ifCf003MobResVO == null) return commonService.getMobErrorResponseMsg(ifCf003MobReqVO.getRequest().getHeader(), "CO00900");
			
			// response validate
			IfErrMobResVO ifErrMobResVO2 = configValidator.validateConfig003Res(ifCf003MobReqVO, ifCf003MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// authkey add create date & last date
			commonService.addResAuthTime(ifCf003MobReqVO.getRequest().getHeader(), ifCf003MobResVO.getResponse().getHeader());
			return ifCf003MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCf003MobReqVO.getRequest().getHeader(), "CF03999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-CF-004", method=RequestMethod.POST)
	public @ResponseBody Object requestConfig004(@RequestBody IfCf004MobReqVO ifCf004MobReqVO) {
		try {
			logger.debug("ifCf004MobReqVO="+ifCf004MobReqVO);
			
			// request validate
			IfErrMobResVO ifErrMobResVO = configValidator.validateConfig004(ifCf004MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifCf004MobReqVO.getRequest().getHeader(), ifCf004MobReqVO.getRequest().getBody().getAdminCode(), ifCf004MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
			
			// response data call
			IfCf004MobResVO ifCf004MobResVO = configService.requestConfig004(ifCf004MobReqVO);
			if ( ifCf004MobResVO == null) return commonService.getMobErrorResponseMsg(ifCf004MobReqVO.getRequest().getHeader(), "CO00900");
			
			// response validate
			IfErrMobResVO ifErrMobResVO2 = configValidator.validateConfig004Res(ifCf004MobReqVO, ifCf004MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// authkey add create date & last date
			commonService.addResAuthTime(ifCf004MobReqVO.getRequest().getHeader(), ifCf004MobResVO.getResponse().getHeader());
			return ifCf004MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCf004MobReqVO.getRequest().getHeader(), "CF04999", errorMsg);			
		}
	}
	
}