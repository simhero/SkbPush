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
import com.skt.ssp.gw.service.OrderService;
import com.skt.ssp.gw.vo.IfErrMobResVO;
import com.skt.ssp.gw.vo.order.IfOr001MobReqVO;
import com.skt.ssp.gw.vo.order.IfOr001MobResVO;
import com.skt.ssp.gw.vo.order.IfOr002MobReqVO;
import com.skt.ssp.gw.vo.order.IfOr002MobResVO;
import com.skt.ssp.gw.vo.order.IfOr003MobReqVO;
import com.skt.ssp.gw.vo.order.IfOr003MobResVO;
import com.skt.ssp.gw.web.validator.OrderValidator;

/**
 * OrderController (OrderController)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: OrderController.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Controller
@RequestMapping("/mobileInterface")
public class OrderController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;
	@Autowired
	private OrderValidator orderValidator;
	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/IF-OR-001", method=RequestMethod.POST)
	public @ResponseBody Object requestOrder001(@RequestBody IfOr001MobReqVO ifOr001MobReqVO) {
		try {
			logger.debug("IfOr001MobReqVO="+ifOr001MobReqVO);
			IfErrMobResVO ifErrMobResVO = orderValidator.validateOrder001Req(ifOr001MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifOr001MobReqVO.getRequest().getHeader(), ifOr001MobReqVO.getRequest().getBody().getAdminCode(), ifOr001MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfOr001MobResVO ifOr001MobResVO = orderService.requestOrder001(ifOr001MobReqVO);
			if ( ifOr001MobResVO == null) return commonService.getMobErrorResponseMsg(ifOr001MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = orderValidator.validateOrder001Res(ifOr001MobReqVO, ifOr001MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifOr001MobReqVO.getRequest().getHeader(), ifOr001MobResVO.getResponse().getHeader());
			return ifOr001MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifOr001MobReqVO.getRequest().getHeader(), "OR01999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-OR-002", method=RequestMethod.POST)
	public @ResponseBody Object requestOrder002(@RequestBody IfOr002MobReqVO ifOr002MobReqVO) {
		try {
			logger.debug("IfOr002MobReqVO="+ifOr002MobReqVO);
			IfErrMobResVO ifErrMobResVO = orderValidator.validateOrder002Req(ifOr002MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifOr002MobReqVO.getRequest().getHeader(), ifOr002MobReqVO.getRequest().getBody().getAdminCode(), ifOr002MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfOr002MobResVO ifOr002MobResVO = orderService.requestOrder002(ifOr002MobReqVO);
			if ( ifOr002MobResVO == null) return commonService.getMobErrorResponseMsg(ifOr002MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = orderValidator.validateOrder002Res(ifOr002MobReqVO, ifOr002MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifOr002MobReqVO.getRequest().getHeader(), ifOr002MobResVO.getResponse().getHeader());
			return ifOr002MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifOr002MobReqVO.getRequest().getHeader(), "OR02999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-OR-003", method=RequestMethod.POST)
	public @ResponseBody Object requestOrder003(@RequestBody IfOr003MobReqVO ifOr003MobReqVO) {
		try {
			logger.debug("IfOr003MobReqVO="+ifOr003MobReqVO);
			IfErrMobResVO ifErrMobResVO = orderValidator.validateOrder003Req(ifOr003MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifOr003MobReqVO.getRequest().getHeader(), ifOr003MobReqVO.getRequest().getBody().getAdminCode(), ifOr003MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfOr003MobResVO ifOr003MobResVO = orderService.requestOrder003(ifOr003MobReqVO);
			if ( ifOr003MobResVO == null) return commonService.getMobErrorResponseMsg(ifOr003MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = orderValidator.validateOrder003Res(ifOr003MobReqVO, ifOr003MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifOr003MobReqVO.getRequest().getHeader(), ifOr003MobResVO.getResponse().getHeader());
			return ifOr003MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifOr003MobReqVO.getRequest().getHeader(), "OR03999", errorMsg);			
		}
	}

}