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
import com.skt.ssp.gw.service.SettlementService;
import com.skt.ssp.gw.vo.IfErrMobResVO;
import com.skt.ssp.gw.vo.settlement.IfSe001MobReqVO;
import com.skt.ssp.gw.vo.settlement.IfSe001MobResVO;
import com.skt.ssp.gw.vo.settlement.IfSe002MobReqVO;
import com.skt.ssp.gw.vo.settlement.IfSe002MobResVO;
import com.skt.ssp.gw.web.validator.SettlementValidator;

/**
 * SettlementController (SettlementController)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: SettlementController.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Controller
@RequestMapping("/mobileInterface")
public class SettlementController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;
	@Autowired
	private SettlementValidator settlementValidator;
	@Autowired
	private SettlementService settlementService;
	
	@RequestMapping(value = "/IF-SE-001", method=RequestMethod.POST)
	public @ResponseBody Object requestSettlement001(@RequestBody IfSe001MobReqVO ifSe001MobReqVO) {
		try {
			logger.debug("ifSe001MobReqVO="+ifSe001MobReqVO);
			IfErrMobResVO ifErrMobResVO = settlementValidator.validateSettlement001Req(ifSe001MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifSe001MobReqVO.getRequest().getHeader(), ifSe001MobReqVO.getRequest().getBody().getAdminCode(), ifSe001MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfSe001MobResVO ifSe001MobResVO = settlementService.requestSettlement001(ifSe001MobReqVO);
			if ( ifSe001MobResVO == null) return commonService.getMobErrorResponseMsg(ifSe001MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = settlementValidator.validateSettlement001Res(ifSe001MobReqVO, ifSe001MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifSe001MobReqVO.getRequest().getHeader(), ifSe001MobResVO.getResponse().getHeader());
			return ifSe001MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifSe001MobReqVO.getRequest().getHeader(), "SE01999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-SE-002", method=RequestMethod.POST)
	public @ResponseBody Object requestSettlement002(@RequestBody IfSe002MobReqVO ifSe002MobReqVO) {
		try {
			logger.debug("ifSe002MobReqVO="+ifSe002MobReqVO);
			IfErrMobResVO ifErrMobResVO = settlementValidator.validateSettlement002Req(ifSe002MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifSe002MobReqVO.getRequest().getHeader(), ifSe002MobReqVO.getRequest().getBody().getAdminCode(), ifSe002MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfSe002MobResVO ifSe002MobResVO = settlementService.requestSettlement002(ifSe002MobReqVO);
			if ( ifSe002MobResVO == null) return commonService.getMobErrorResponseMsg(ifSe002MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = settlementValidator.validateSettlement002Res(ifSe002MobReqVO, ifSe002MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifSe002MobReqVO.getRequest().getHeader(), ifSe002MobResVO.getResponse().getHeader());
			return ifSe002MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifSe002MobReqVO.getRequest().getHeader(), "SE02999", errorMsg);			
		}
	}

}