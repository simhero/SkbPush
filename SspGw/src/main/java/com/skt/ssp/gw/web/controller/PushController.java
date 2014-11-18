package com.skt.ssp.gw.web.controller;


import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skt.ssp.gw.parse.PushDbpMsgReader;
import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.service.PushService;
import com.skt.ssp.gw.vo.IfErrMobResVO;
import com.skt.ssp.gw.vo.push.IfPu001MobReqVO;
import com.skt.ssp.gw.vo.push.IfPu001MobResVO;
import com.skt.ssp.gw.vo.push.IfPu002MobReqVO;
import com.skt.ssp.gw.vo.push.IfPu002MobResVO;
import com.skt.ssp.gw.vo.push.IfPu003DbpDataReqVO;
import com.skt.ssp.gw.vo.push.IfPu004MobReqVO;
import com.skt.ssp.gw.vo.push.IfPu004MobResVO;
import com.skt.ssp.gw.web.validator.PushValidator;

/**
 * Push Controller (PushController)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: PushController.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Controller
@RequestMapping("/mobileInterface")
public class PushController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;
	@Autowired
	private PushValidator pushValidator;
	@Autowired
	private PushService pushService;
	@Autowired
	private PushDbpMsgReader pushDbpMsgReader;
	
	@RequestMapping(value = "/IF-PU-001", method=RequestMethod.POST)
	public @ResponseBody Object requestPush001(@RequestBody IfPu001MobReqVO ifPu001MobReqVO) {
		try {
			logger.debug("ifPu001MobReqVO="+ifPu001MobReqVO);
			
			// request validate
			IfErrMobResVO ifErrMobResVO = pushValidator.validatePush001(ifPu001MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifPu001MobReqVO.getRequest().getHeader(), ifPu001MobReqVO.getRequest().getBody().getAdminCode(), ifPu001MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
			
			// response data call
			IfPu001MobResVO ifPu001MobResVO = pushService.requestPush001(ifPu001MobReqVO);
			if ( ifPu001MobResVO == null) return commonService.getMobErrorResponseMsg(ifPu001MobReqVO.getRequest().getHeader(), "CO00900");
			
			// response validate
			IfErrMobResVO ifErrMobResVO2 = pushValidator.validatePush001Res(ifPu001MobReqVO, ifPu001MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// authkey add create date & last date
			commonService.addResAuthTime(ifPu001MobReqVO.getRequest().getHeader(), ifPu001MobResVO.getResponse().getHeader());
			return ifPu001MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifPu001MobReqVO.getRequest().getHeader(), "PU01999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-PU-002", method=RequestMethod.POST)
	public @ResponseBody Object requestPush002(@RequestBody IfPu002MobReqVO ifPu002MobReqVO) {
		try {
			logger.debug("ifPu002MobReqVO="+ifPu002MobReqVO);
			
			// request validate
			IfErrMobResVO ifErrMobResVO = pushValidator.validatePush002(ifPu002MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifPu002MobReqVO.getRequest().getHeader(), ifPu002MobReqVO.getRequest().getBody().getAdminCode(), ifPu002MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
			
			// response data call
			IfPu002MobResVO ifPu002MobResVO = pushService.requestPush002(ifPu002MobReqVO);
			if ( ifPu002MobResVO == null) return commonService.getMobErrorResponseMsg(ifPu002MobReqVO.getRequest().getHeader(), "CO00900");
			
			// response validate
			IfErrMobResVO ifErrMobResVO2 = pushValidator.validatePush002Res(ifPu002MobReqVO, ifPu002MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// authkey add create date & last date
			commonService.addResAuthTime(ifPu002MobReqVO.getRequest().getHeader(), ifPu002MobResVO.getResponse().getHeader());
			return ifPu002MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifPu002MobReqVO.getRequest().getHeader(), "PU02999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-PU-003", method=RequestMethod.POST)
	public ResponseEntity<String> requestPush003(@RequestBody String bodyStr) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/plain; charset=UTF-8");
		try {
			IfPu003DbpDataReqVO ifPu003DbpDataReqVO = pushDbpMsgReader.getPu003DbpReqMessage(bodyStr);
			if(ifPu003DbpDataReqVO.getBody().getAdminCode().equals(config.getString("DEMO.ADMIN_CODE"))) {
				return new ResponseEntity<String>(pushService.getPush003ErrorResponseMsg("CO00901"), responseHeaders, HttpStatus.CREATED);
			}
			return new ResponseEntity<String>(pushService.requestPush003(bodyStr), responseHeaders, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(pushService.getPush003ErrorResponseMsg("CO00900"), responseHeaders, HttpStatus.CREATED);
		}
	}
	
	@RequestMapping(value = "/IF-PU-004", method=RequestMethod.POST)
	public @ResponseBody Object requestPush004(@RequestBody IfPu004MobReqVO ifPu004MobReqVO) {
		try {
			logger.debug("ifPu004MobReqVO="+ifPu004MobReqVO);
			
			// request validate
			IfErrMobResVO ifErrMobResVO = pushValidator.validatePush004(ifPu004MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifPu004MobReqVO.getRequest().getHeader(), ifPu004MobReqVO.getRequest().getBody().getAdminCode(), ifPu004MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
			
			// response data call
			IfPu004MobResVO ifPu004MobResVO = pushService.requestPush004(ifPu004MobReqVO);
			if ( ifPu004MobResVO == null) return commonService.getMobErrorResponseMsg(ifPu004MobReqVO.getRequest().getHeader(), "CO00900");
			
			// response validate
			IfErrMobResVO ifErrMobResVO2 = pushValidator.validatePush004Res(ifPu004MobReqVO, ifPu004MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// authkey add create date & last date
			commonService.addResAuthTime(ifPu004MobReqVO.getRequest().getHeader(), ifPu004MobResVO.getResponse().getHeader());
			return ifPu004MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifPu004MobReqVO.getRequest().getHeader(), "PU04999", errorMsg);			
		}
	}

}