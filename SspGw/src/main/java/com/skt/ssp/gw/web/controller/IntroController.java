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

import com.skt.ssp.gw.vo.IfErrMobResVO;
import com.skt.ssp.gw.vo.intro.IfIn001MobReqVO;
import com.skt.ssp.gw.vo.intro.IfIn001MobResVO;
import com.skt.ssp.gw.vo.intro.IfIn002MobReqVO;
import com.skt.ssp.gw.vo.intro.IfIn002MobResVO;
import com.skt.ssp.gw.web.validator.IntroValidator;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.service.IntroService;

/**
 * IntroController (IntroController)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IntroController.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
@Controller
@RequestMapping("/mobileInterface")
public class IntroController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;
	@Autowired
	private IntroValidator introValidator;
	@Autowired
	private IntroService introService;

	@RequestMapping(value = "/IF-IN-001", method=RequestMethod.POST)
	public @ResponseBody Object requestIntro001(@RequestBody IfIn001MobReqVO ifIn001MobReqVO) {
		try {
			logger.debug("ifIn001MobReqVO="+ifIn001MobReqVO);
			IfErrMobResVO ifErrMobResVO = introValidator.validateIntro001Req(ifIn001MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			IfIn001MobResVO ifIn001MobResVO = introService.requestIntro001(ifIn001MobReqVO);
			if ( ifIn001MobResVO == null) return commonService.getMobErrorResponseMsg(ifIn001MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = introValidator.validateIntro001Res(ifIn001MobReqVO, ifIn001MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifIn001MobReqVO.getRequest().getHeader(), ifIn001MobResVO.getResponse().getHeader());
			return ifIn001MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifIn001MobReqVO.getRequest().getHeader(), "IN01999", errorMsg);			
		}
	}

	@RequestMapping(value = "/IF-IN-002", method=RequestMethod.POST)
	public @ResponseBody Object requestIntro002(@RequestBody IfIn002MobReqVO ifIn002MobReqVO) {
		try {
			logger.debug("ifIn002MobReqVO="+ifIn002MobReqVO);
			IfErrMobResVO ifErrMobResVO = introValidator.validateIntro002Req(ifIn002MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			IfIn002MobResVO ifIn002MobResVO = introService.requestIntro002(ifIn002MobReqVO);
			if ( ifIn002MobResVO == null) return commonService.getMobErrorResponseMsg(ifIn002MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = introValidator.validateIntro002Res(ifIn002MobReqVO, ifIn002MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifIn002MobReqVO.getRequest().getHeader(), ifIn002MobResVO.getResponse().getHeader());
			return ifIn002MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifIn002MobReqVO.getRequest().getHeader(), "IN02999", errorMsg);			
		}
	}

}