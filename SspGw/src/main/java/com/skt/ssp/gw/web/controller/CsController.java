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
import com.skt.ssp.gw.service.CsService;
import com.skt.ssp.gw.vo.IfErrMobResVO;
import com.skt.ssp.gw.vo.cs.IfCs001MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs001MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs002MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs002MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs003MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs003MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs004MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs004MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs005MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs005MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs006MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs006MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs007MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs007MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs008MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs008MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs009MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs009MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs010MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs010MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs011MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs011MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs012MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs012MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs013MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs013MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs014MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs014MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs015MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs015MobResVO;
import com.skt.ssp.gw.web.validator.CsValidator;

/**
 * CsController (CsController)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: CsController.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Controller
@RequestMapping("/mobileInterface")
public class CsController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;
	@Autowired
	private CsValidator csValidator;
	@Autowired
	private CsService csService;
	
	@RequestMapping(value = "/IF-CS-001", method=RequestMethod.POST)
	public @ResponseBody Object requestCs001(@RequestBody IfCs001MobReqVO ifCs001MobReqVO) {
		try {
			logger.debug("ifCs001MobReqVO="+ifCs001MobReqVO);
			IfErrMobResVO ifErrMobResVO = csValidator.validateCs001Req(ifCs001MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifCs001MobReqVO.getRequest().getHeader(), ifCs001MobReqVO.getRequest().getBody().getAdminCode(), ifCs001MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfCs001MobResVO ifCs001MobResVO = csService.requestCs001(ifCs001MobReqVO);
			if ( ifCs001MobResVO == null) return commonService.getMobErrorResponseMsg(ifCs001MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = csValidator.validateCs001Res(ifCs001MobReqVO, ifCs001MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifCs001MobReqVO.getRequest().getHeader(), ifCs001MobResVO.getResponse().getHeader());
			return ifCs001MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCs001MobReqVO.getRequest().getHeader(), "CS01999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-CS-002", method=RequestMethod.POST)
	public @ResponseBody Object requestCs002(@RequestBody IfCs002MobReqVO ifCs002MobReqVO) {
		try {
			logger.debug("ifCs002MobReqVO="+ifCs002MobReqVO);
			IfErrMobResVO ifErrMobResVO = csValidator.validateCs002Req(ifCs002MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifCs002MobReqVO.getRequest().getHeader(), ifCs002MobReqVO.getRequest().getBody().getAdminCode(), ifCs002MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfCs002MobResVO ifCs002MobResVO = csService.requestCs002(ifCs002MobReqVO);
			if ( ifCs002MobResVO == null) return commonService.getMobErrorResponseMsg(ifCs002MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = csValidator.validateCs002Res(ifCs002MobReqVO, ifCs002MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifCs002MobReqVO.getRequest().getHeader(), ifCs002MobResVO.getResponse().getHeader());
			return ifCs002MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCs002MobReqVO.getRequest().getHeader(), "CS02999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-CS-003", method=RequestMethod.POST)
	public @ResponseBody Object requestCs003(@RequestBody IfCs003MobReqVO ifCs003MobReqVO) {
		try {
			logger.debug("ifCs003MobReqVO="+ifCs003MobReqVO);
			IfErrMobResVO ifErrMobResVO = csValidator.validateCs003Req(ifCs003MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifCs003MobReqVO.getRequest().getHeader(), ifCs003MobReqVO.getRequest().getBody().getAdminCode(), ifCs003MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfCs003MobResVO ifCs003MobResVO = csService.requestCs003(ifCs003MobReqVO);
			if ( ifCs003MobResVO == null) return commonService.getMobErrorResponseMsg(ifCs003MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = csValidator.validateCs003Res(ifCs003MobReqVO, ifCs003MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifCs003MobReqVO.getRequest().getHeader(), ifCs003MobResVO.getResponse().getHeader());
			return ifCs003MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCs003MobReqVO.getRequest().getHeader(), "CS03999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-CS-004", method=RequestMethod.POST)
	public @ResponseBody Object requestCs004(@RequestBody IfCs004MobReqVO ifCs004MobReqVO) {
		try {
			logger.debug("ifCs004MobReqVO="+ifCs004MobReqVO);
			IfErrMobResVO ifErrMobResVO = csValidator.validateCs004Req(ifCs004MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifCs004MobReqVO.getRequest().getHeader(), ifCs004MobReqVO.getRequest().getBody().getAdminCode(), ifCs004MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfCs004MobResVO ifCs004MobResVO = csService.requestCs004(ifCs004MobReqVO);
			if ( ifCs004MobResVO == null) return commonService.getMobErrorResponseMsg(ifCs004MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = csValidator.validateCs004Res(ifCs004MobReqVO, ifCs004MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifCs004MobReqVO.getRequest().getHeader(), ifCs004MobResVO.getResponse().getHeader());
			return ifCs004MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCs004MobReqVO.getRequest().getHeader(), "CS04999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-CS-005", method=RequestMethod.POST)
	public @ResponseBody Object requestCs005(@RequestBody IfCs005MobReqVO ifCs005MobReqVO) {
		try {
			logger.debug("ifCs005MobReqVO="+ifCs005MobReqVO);
			IfErrMobResVO ifErrMobResVO = csValidator.validateCs005Req(ifCs005MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifCs005MobReqVO.getRequest().getHeader(), ifCs005MobReqVO.getRequest().getBody().getAdminCode(), ifCs005MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfCs005MobResVO ifCs005MobResVO = csService.requestCs005(ifCs005MobReqVO);
			if ( ifCs005MobResVO == null) return commonService.getMobErrorResponseMsg(ifCs005MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = csValidator.validateCs005Res(ifCs005MobReqVO, ifCs005MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifCs005MobReqVO.getRequest().getHeader(), ifCs005MobResVO.getResponse().getHeader());
			return ifCs005MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCs005MobReqVO.getRequest().getHeader(), "CS05999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-CS-006", method=RequestMethod.POST)
	public @ResponseBody Object requestCs006(@RequestBody IfCs006MobReqVO ifCs006MobReqVO) {
		try {
			logger.debug("ifCs006MobReqVO="+ifCs006MobReqVO);
			IfErrMobResVO ifErrMobResVO = csValidator.validateCs006Req(ifCs006MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifCs006MobReqVO.getRequest().getHeader(), ifCs006MobReqVO.getRequest().getBody().getAdminCode(), ifCs006MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfCs006MobResVO ifCs006MobResVO = csService.requestCs006(ifCs006MobReqVO);
			if ( ifCs006MobResVO == null) return commonService.getMobErrorResponseMsg(ifCs006MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = csValidator.validateCs006Res(ifCs006MobReqVO, ifCs006MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifCs006MobReqVO.getRequest().getHeader(), ifCs006MobResVO.getResponse().getHeader());
			return ifCs006MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCs006MobReqVO.getRequest().getHeader(), "CS06999", errorMsg);			
		}
	}

	@RequestMapping(value = "/IF-CS-007", method=RequestMethod.POST)
	public @ResponseBody Object requestCs007(@RequestBody IfCs007MobReqVO ifCs007MobReqVO) {
		try {
			logger.debug("ifCs007MobReqVO="+ifCs007MobReqVO);
			IfErrMobResVO ifErrMobResVO = csValidator.validateCs007Req(ifCs007MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifCs007MobReqVO.getRequest().getHeader(), ifCs007MobReqVO.getRequest().getBody().getAdminCode(), ifCs007MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfCs007MobResVO ifCs007MobResVO = csService.requestCs007(ifCs007MobReqVO);
			if ( ifCs007MobResVO == null) return commonService.getMobErrorResponseMsg(ifCs007MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = csValidator.validateCs007Res(ifCs007MobReqVO, ifCs007MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifCs007MobReqVO.getRequest().getHeader(), ifCs007MobResVO.getResponse().getHeader());
			return ifCs007MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCs007MobReqVO.getRequest().getHeader(), "CS07999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-CS-008", method=RequestMethod.POST)
	public @ResponseBody Object requestCs008(@RequestBody IfCs008MobReqVO ifCs008MobReqVO) {
		try {
			logger.debug("ifCs008MobReqVO="+ifCs008MobReqVO);
			IfErrMobResVO ifErrMobResVO = csValidator.validateCs008Req(ifCs008MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifCs008MobReqVO.getRequest().getHeader(), ifCs008MobReqVO.getRequest().getBody().getAdminCode(), ifCs008MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfCs008MobResVO ifCs008MobResVO = csService.requestCs008(ifCs008MobReqVO);
			if ( ifCs008MobResVO == null) return commonService.getMobErrorResponseMsg(ifCs008MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = csValidator.validateCs008Res(ifCs008MobReqVO, ifCs008MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifCs008MobReqVO.getRequest().getHeader(), ifCs008MobResVO.getResponse().getHeader());
			return ifCs008MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCs008MobReqVO.getRequest().getHeader(), "CS08999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-CS-009", method=RequestMethod.POST)
	public @ResponseBody Object requestCs009(@RequestBody IfCs009MobReqVO ifCs009MobReqVO) {
		try {
			logger.debug("ifCs009MobReqVO="+ifCs009MobReqVO);
			IfErrMobResVO ifErrMobResVO = csValidator.validateCs009Req(ifCs009MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifCs009MobReqVO.getRequest().getHeader(), ifCs009MobReqVO.getRequest().getBody().getAdminCode(), ifCs009MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfCs009MobResVO ifCs009MobResVO = csService.requestCs009(ifCs009MobReqVO);
			if ( ifCs009MobResVO == null) return commonService.getMobErrorResponseMsg(ifCs009MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = csValidator.validateCs009Res(ifCs009MobReqVO, ifCs009MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifCs009MobReqVO.getRequest().getHeader(), ifCs009MobResVO.getResponse().getHeader());
			return ifCs009MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCs009MobReqVO.getRequest().getHeader(), "CS09999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-CS-010", method=RequestMethod.POST)
	public @ResponseBody Object requestCs010(@RequestBody IfCs010MobReqVO ifCs010MobReqVO) {
		try {
			logger.debug("ifCs010MobReqVO="+ifCs010MobReqVO);
			IfErrMobResVO ifErrMobResVO = csValidator.validateCs010Req(ifCs010MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifCs010MobReqVO.getRequest().getHeader(), ifCs010MobReqVO.getRequest().getBody().getAdminCode(), ifCs010MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfCs010MobResVO ifCs010MobResVO = csService.requestCs010(ifCs010MobReqVO);
			if ( ifCs010MobResVO == null) return commonService.getMobErrorResponseMsg(ifCs010MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = csValidator.validateCs010Res(ifCs010MobReqVO, ifCs010MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifCs010MobReqVO.getRequest().getHeader(), ifCs010MobResVO.getResponse().getHeader());
			return ifCs010MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCs010MobReqVO.getRequest().getHeader(), "CS10999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-CS-011", method=RequestMethod.POST)
	public @ResponseBody Object requestCs011(@RequestBody IfCs011MobReqVO ifCs011MobReqVO) {
		try {
			logger.debug("ifCs011MobReqVO="+ifCs011MobReqVO);
			IfErrMobResVO ifErrMobResVO = csValidator.validateCs011Req(ifCs011MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifCs011MobReqVO.getRequest().getHeader(), ifCs011MobReqVO.getRequest().getBody().getAdminCode(), ifCs011MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfCs011MobResVO ifCs011MobResVO = csService.requestCs011(ifCs011MobReqVO);
			if ( ifCs011MobResVO == null) return commonService.getMobErrorResponseMsg(ifCs011MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = csValidator.validateCs011Res(ifCs011MobReqVO, ifCs011MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifCs011MobReqVO.getRequest().getHeader(), ifCs011MobResVO.getResponse().getHeader());
			return ifCs011MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCs011MobReqVO.getRequest().getHeader(), "CS11999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-CS-012", method=RequestMethod.POST)
	public @ResponseBody Object requestCs012(@RequestBody IfCs012MobReqVO ifCs012MobReqVO) {
		try {
			logger.debug("ifCs012MobReqVO="+ifCs012MobReqVO);
			IfErrMobResVO ifErrMobResVO = csValidator.validateCs012Req(ifCs012MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifCs012MobReqVO.getRequest().getHeader(), ifCs012MobReqVO.getRequest().getBody().getAdminCode(), ifCs012MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfCs012MobResVO ifCs012MobResVO = csService.requestCs012(ifCs012MobReqVO);
			if ( ifCs012MobResVO == null) return commonService.getMobErrorResponseMsg(ifCs012MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = csValidator.validateCs012Res(ifCs012MobReqVO, ifCs012MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifCs012MobReqVO.getRequest().getHeader(), ifCs012MobResVO.getResponse().getHeader());
			return ifCs012MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCs012MobReqVO.getRequest().getHeader(), "CS12999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-CS-013", method=RequestMethod.POST)
	public @ResponseBody Object requestCs013(@RequestBody IfCs013MobReqVO ifCs013MobReqVO) {
		try {
			logger.debug("ifCs013MobReqVO="+ifCs013MobReqVO);
			IfErrMobResVO ifErrMobResVO = csValidator.validateCs013Req(ifCs013MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifCs013MobReqVO.getRequest().getHeader(), ifCs013MobReqVO.getRequest().getBody().getAdminCode(), ifCs013MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfCs013MobResVO ifCs013MobResVO = csService.requestCs013(ifCs013MobReqVO);
			if ( ifCs013MobResVO == null) return commonService.getMobErrorResponseMsg(ifCs013MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = csValidator.validateCs013Res(ifCs013MobReqVO, ifCs013MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifCs013MobReqVO.getRequest().getHeader(), ifCs013MobResVO.getResponse().getHeader());
			return ifCs013MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCs013MobReqVO.getRequest().getHeader(), "CS13999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-CS-014", method=RequestMethod.POST)
	public @ResponseBody Object requestCs014(@RequestBody IfCs014MobReqVO ifCs014MobReqVO) {
		try {
			logger.debug("ifCs014MobReqVO="+ifCs014MobReqVO);
			IfErrMobResVO ifErrMobResVO = csValidator.validateCs014Req(ifCs014MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifCs014MobReqVO.getRequest().getHeader(), ifCs014MobReqVO.getRequest().getBody().getAdminCode(), ifCs014MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfCs014MobResVO ifCs014MobResVO = csService.requestCs014(ifCs014MobReqVO);
			if ( ifCs014MobResVO == null) return commonService.getMobErrorResponseMsg(ifCs014MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = csValidator.validateCs014Res(ifCs014MobReqVO, ifCs014MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifCs014MobReqVO.getRequest().getHeader(), ifCs014MobResVO.getResponse().getHeader());
			return ifCs014MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCs014MobReqVO.getRequest().getHeader(), "CS14999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-CS-015", method=RequestMethod.POST)
	public @ResponseBody Object requestCs015(@RequestBody IfCs015MobReqVO ifCs015MobReqVO) {
		try {
			logger.debug("ifCs015MobReqVO="+ifCs015MobReqVO);
			IfErrMobResVO ifErrMobResVO = csValidator.validateCs015Req(ifCs015MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifCs015MobReqVO.getRequest().getHeader(), ifCs015MobReqVO.getRequest().getBody().getAdminCode(), ifCs015MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfCs015MobResVO ifCs015MobResVO = csService.requestCs015(ifCs015MobReqVO);
			if ( ifCs015MobResVO == null) return commonService.getMobErrorResponseMsg(ifCs015MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = csValidator.validateCs015Res(ifCs015MobReqVO, ifCs015MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifCs015MobReqVO.getRequest().getHeader(), ifCs015MobResVO.getResponse().getHeader());
			return ifCs015MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifCs015MobReqVO.getRequest().getHeader(), "CS15999", errorMsg);			
		}
	}
	
}