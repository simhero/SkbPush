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

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.service.StatisticsService;
import com.skt.ssp.gw.vo.IfErrMobResVO;
import com.skt.ssp.gw.vo.statistics.IfSt001MobReqVO;
import com.skt.ssp.gw.vo.statistics.IfSt001MobResVO;
import com.skt.ssp.gw.vo.statistics.IfSt002MobReqVO;
import com.skt.ssp.gw.vo.statistics.IfSt002MobResVO;
import com.skt.ssp.gw.web.validator.StatisticsValidator;

/**
 * StatisticsController (StatisticsController)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: StatisticsController.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Controller
@RequestMapping("/mobileInterface")
public class StatisticsController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;
	@Autowired
	private StatisticsValidator statisticsValidator;
	@Autowired
	private StatisticsService statisticsService;

	@RequestMapping(value = "/IF-ST-001", method=RequestMethod.POST)
	public @ResponseBody Object requestStatistics001(@RequestHeader("User-Agent") String userAgent, @RequestBody IfSt001MobReqVO ifSt001MobReqVO) {
		try {
			logger.debug("ifSt001MobReqVO="+ifSt001MobReqVO);
			IfErrMobResVO ifErrMobResVO = statisticsValidator.validateStatistics001Req(ifSt001MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifSt001MobReqVO.getRequest().getHeader(), ifSt001MobReqVO.getRequest().getBody().getAdminCode(), ifSt001MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfSt001MobResVO ifSt001MobResVO = statisticsService.requestStatistics001(ifSt001MobReqVO);
			if ( ifSt001MobResVO == null) return commonService.getMobErrorResponseMsg(ifSt001MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = statisticsValidator.validateStatistics001Res(ifSt001MobReqVO, ifSt001MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifSt001MobReqVO.getRequest().getHeader(), ifSt001MobResVO.getResponse().getHeader());
			return ifSt001MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifSt001MobReqVO.getRequest().getHeader(), "ST01999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-ST-002", method=RequestMethod.POST)
	public @ResponseBody Object requestStatistics001(@RequestHeader("User-Agent") String userAgent, @RequestBody IfSt002MobReqVO ifSt002MobReqVO) {
		try {
			logger.debug("ifSt002MobReqVO="+ifSt002MobReqVO);
			IfErrMobResVO ifErrMobResVO = statisticsValidator.validateStatistics002Req(ifSt002MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifSt002MobReqVO.getRequest().getHeader(), ifSt002MobReqVO.getRequest().getBody().getAdminCode(), ifSt002MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfSt002MobResVO ifSt002MobResVO = statisticsService.requestStatistics002(ifSt002MobReqVO);
			if ( ifSt002MobResVO == null) return commonService.getMobErrorResponseMsg(ifSt002MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = statisticsValidator.validateStatistics002Res(ifSt002MobReqVO, ifSt002MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifSt002MobReqVO.getRequest().getHeader(), ifSt002MobResVO.getResponse().getHeader());
			return ifSt002MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifSt002MobReqVO.getRequest().getHeader(), "ST01999", errorMsg);			
		}
	}

}