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
import com.skt.ssp.gw.service.CustomerService;
import com.skt.ssp.gw.vo.IfErrMobResVO;
import com.skt.ssp.gw.vo.customer.IfCu001MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu001MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu002MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu002MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu003MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu003MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu004MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu004MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu005MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu005MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu006MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu006MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu007MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu007MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu008MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu008MobResVO;
import com.skt.ssp.gw.web.validator.CustomerValidator;

/**
 * CustomerController (CustomerController)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: CustomerController.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
@Controller
@RequestMapping("/mobileInterface")
public class CustomerController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;
	@Autowired
	private CustomerValidator customerValidator;
	@Autowired
	private CustomerService customerService;
//	@Autowired
//	private AuthService authService;

	@RequestMapping(value = "/IF-CU-001", method=RequestMethod.POST)
	public @ResponseBody Object requestCustomer001(@RequestBody IfCu001MobReqVO ifCu001MobReqVO) throws Exception {
		try {
			logger.debug("ifCu001MobReqVO="+ifCu001MobReqVO);
			IfErrMobResVO ifErrMobResVO = customerValidator.validateCustomer001Req(ifCu001MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			IfCu001MobResVO ifCu001MobResVO = customerService.requestCustomer001(ifCu001MobReqVO);
			if ( ifCu001MobResVO == null) return commonService.getMobErrorResponseMsg(ifCu001MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = customerValidator.validateCustomer001Res(ifCu001MobReqVO, ifCu001MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			return ifCu001MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCu001MobReqVO.getRequest().getHeader(), "CU01999", errorMsg);			
		}
	}

	@RequestMapping(value = "/IF-CU-002", method=RequestMethod.POST)
	public @ResponseBody Object requestCustomer002(@RequestBody IfCu002MobReqVO ifCu002MobReqVO) {
		try {
			logger.debug("ifCu002MobReqVO="+ifCu002MobReqVO);
			IfErrMobResVO ifErrMobResVO = customerValidator.validateCustomer002Req(ifCu002MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
//			// AuthInfo Check
//			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifCu002MobReqVO.getRequest().getHeader(), ifCu002MobReqVO.getRequest().getBody().getAdminCode(), ifCu002MobReqVO.getRequest().getBody().getUserId());
//			if( authIfErrMobResVO != null) return authIfErrMobResVO;
			
			// demo not use interface check
			IfErrMobResVO authIfErrMobResVO = commonService.chkDemoInterface(ifCu002MobReqVO.getRequest().getHeader(), ifCu002MobReqVO.getRequest().getBody().getAdminCode(), ifCu002MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfCu002MobResVO ifCu002MobResVO = customerService.requestCustomer002(ifCu002MobReqVO);
			if ( ifCu002MobResVO == null) return commonService.getMobErrorResponseMsg(ifCu002MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = customerValidator.validateCustomer002Res(ifCu002MobReqVO, ifCu002MobResVO);
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifCu002MobReqVO.getRequest().getHeader(), ifCu002MobResVO.getResponse().getHeader());
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			return ifCu002MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCu002MobReqVO.getRequest().getHeader(), "CU02999", errorMsg);			
		}
	}

	@RequestMapping(value = "/IF-CU-003", method=RequestMethod.POST)
	public @ResponseBody Object requestCustomer003(@RequestBody IfCu003MobReqVO ifCu003MobReqVO) {
		try {
			logger.debug("ifCu003MobReqVO="+ifCu003MobReqVO);
			IfErrMobResVO ifErrMobResVO = customerValidator.validateCustomer003Req(ifCu003MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
//			// AuthInfo Check
//			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifCu003MobReqVO.getRequest().getHeader(), ifCu003MobReqVO.getRequest().getBody().getAdminCode(), ifCu003MobReqVO.getRequest().getBody().getUserId());
//			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfCu003MobResVO ifCu003MobResVO = customerService.requestCustomer003(ifCu003MobReqVO);
			if ( ifCu003MobResVO == null) return commonService.getMobErrorResponseMsg(ifCu003MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = customerValidator.validateCustomer003Res(ifCu003MobReqVO, ifCu003MobResVO);
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifCu003MobReqVO.getRequest().getHeader(), ifCu003MobResVO.getResponse().getHeader());
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			return ifCu003MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCu003MobReqVO.getRequest().getHeader(), "CU03999", errorMsg);			
		}
	}


	@RequestMapping(value = "/IF-CU-004", method=RequestMethod.POST)
	public @ResponseBody Object requestCustomer004(@RequestBody IfCu004MobReqVO ifCu004MobReqVO) {
		try {
			logger.debug("IfGo005MobReqVO="+ifCu004MobReqVO);
			IfErrMobResVO ifErrMobResVO = customerValidator.validateCustomer004Req(ifCu004MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifCu004MobReqVO.getRequest().getHeader(), ifCu004MobReqVO.getRequest().getBody().getAdminCode(), ifCu004MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfCu004MobResVO ifCu004MobResVO = customerService.requestCustomer004(ifCu004MobReqVO);
			if ( ifCu004MobResVO == null) return commonService.getMobErrorResponseMsg(ifCu004MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = customerValidator.validateCustomer004Res(ifCu004MobReqVO, ifCu004MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifCu004MobReqVO.getRequest().getHeader(), ifCu004MobResVO.getResponse().getHeader());
			return ifCu004MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCu004MobReqVO.getRequest().getHeader(), "CU04999", errorMsg);			
		}
	}


	@RequestMapping(value = "/IF-CU-005", method=RequestMethod.POST)
	public @ResponseBody Object requestCustomer005(@RequestBody IfCu005MobReqVO ifCu005MobReqVO) {
		try {
			logger.debug("ifCu005MobReqVO="+ifCu005MobReqVO);
			IfErrMobResVO ifErrMobResVO = customerValidator.validateCustomer005Req(ifCu005MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifCu005MobReqVO.getRequest().getHeader(), ifCu005MobReqVO.getRequest().getBody().getAdminCode(), ifCu005MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfCu005MobResVO ifCu005MobResVO = customerService.requestCustomer005(ifCu005MobReqVO);
			if ( ifCu005MobResVO == null) return commonService.getMobErrorResponseMsg(ifCu005MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = customerValidator.validateCustomer005Res(ifCu005MobReqVO, ifCu005MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifCu005MobReqVO.getRequest().getHeader(), ifCu005MobResVO.getResponse().getHeader());
			return ifCu005MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCu005MobReqVO.getRequest().getHeader(), "CU05999", errorMsg);			
		}
	}

	@RequestMapping(value = "/IF-CU-006", method=RequestMethod.POST)
	public @ResponseBody Object requestCustomer006(@RequestBody IfCu006MobReqVO ifCu006MobReqVO) {
		try {
			logger.debug("ifCu006MobReqVO="+ifCu006MobReqVO);
			IfErrMobResVO ifErrMobResVO = customerValidator.validateCustomer006Req(ifCu006MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifCu006MobReqVO.getRequest().getHeader(), ifCu006MobReqVO.getRequest().getBody().getAdminCode(), ifCu006MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfCu006MobResVO ifCu006MobResVO = customerService.requestCustomer006(ifCu006MobReqVO);
			if ( ifCu006MobResVO == null) return commonService.getMobErrorResponseMsg(ifCu006MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = customerValidator.validateCustomer006Res(ifCu006MobReqVO, ifCu006MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifCu006MobReqVO.getRequest().getHeader(), ifCu006MobResVO.getResponse().getHeader());
			return ifCu006MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCu006MobReqVO.getRequest().getHeader(), "CU06999", errorMsg);			
		}
	}

	@RequestMapping(value = "/IF-CU-007", method=RequestMethod.POST)
	public @ResponseBody Object requestCustomer007(@RequestBody IfCu007MobReqVO ifCu007MobReqVO) {
		try {
			logger.debug("ifCu007MobReqVO="+ifCu007MobReqVO);
			IfErrMobResVO ifErrMobResVO = customerValidator.validateCustomer007Req(ifCu007MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifCu007MobReqVO.getRequest().getHeader(), ifCu007MobReqVO.getRequest().getBody().getAdminCode(), ifCu007MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfCu007MobResVO ifCu007MobResVO = customerService.requestCustomer007(ifCu007MobReqVO);
			if ( ifCu007MobResVO == null) return commonService.getMobErrorResponseMsg(ifCu007MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = customerValidator.validateCustomer007Res(ifCu007MobReqVO, ifCu007MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifCu007MobReqVO.getRequest().getHeader(), ifCu007MobResVO.getResponse().getHeader());
			return ifCu007MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCu007MobReqVO.getRequest().getHeader(), "CU07999", errorMsg);			
		}
	}

	@RequestMapping(value = "/IF-CU-008", method=RequestMethod.POST)
	public @ResponseBody Object requestCustomer008(@RequestBody IfCu008MobReqVO ifCu008MobReqVO) {
		try {
			logger.debug("ifCu008MobReqVO="+ifCu008MobReqVO);
			IfErrMobResVO ifErrMobResVO = customerValidator.validateCustomer008Req(ifCu008MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifCu008MobReqVO.getRequest().getHeader(), ifCu008MobReqVO.getRequest().getBody().getAdminCode(), ifCu008MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfCu008MobResVO ifCu008MobResVO = customerService.requestCustomer008(ifCu008MobReqVO);
			if ( ifCu008MobResVO == null) return commonService.getMobErrorResponseMsg(ifCu008MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = customerValidator.validateCustomer008Res(ifCu008MobReqVO, ifCu008MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifCu008MobReqVO.getRequest().getHeader(), ifCu008MobResVO.getResponse().getHeader());
			return ifCu008MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCu008MobReqVO.getRequest().getHeader(), "CU08999", errorMsg);			
		}
	}
	
}