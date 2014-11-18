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
import com.skt.ssp.gw.service.GoodsService;
import com.skt.ssp.gw.vo.IfErrMobResVO;
import com.skt.ssp.gw.vo.goods.IfGo001MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo001MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo002MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo002MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo003MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo003MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo004MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo004MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo0051MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo0051MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo005MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo005MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo006MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo006MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo007MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo007MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo008MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo008MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo009MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo009MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo010MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo010MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo011MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo011MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo012MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo012MobResVO;
import com.skt.ssp.gw.web.validator.GoodsValidator;

/**
 * GoodsController (GoodsController)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: GoodsController.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Controller
@RequestMapping("/mobileInterface")
public class GoodsController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;
	@Autowired
	private GoodsValidator goodsValidator;
	@Autowired
	private GoodsService goodsService;

	@RequestMapping(value = "/IF-GO-001", method=RequestMethod.POST)
	public @ResponseBody Object requestGoods001(@RequestBody IfGo001MobReqVO ifGo001MobReqVO) {
		try {
			logger.debug("ifGo001MobReqVO="+ifGo001MobReqVO);
			IfErrMobResVO ifErrMobResVO = goodsValidator.validateGoods001Req(ifGo001MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifGo001MobReqVO.getRequest().getHeader(), ifGo001MobReqVO.getRequest().getBody().getAdminCode(), ifGo001MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfGo001MobResVO ifGo001MobResVO = goodsService.requestGoods001(ifGo001MobReqVO);
			if ( ifGo001MobResVO == null) return commonService.getMobErrorResponseMsg(ifGo001MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = goodsValidator.validateGoods001Res(ifGo001MobReqVO, ifGo001MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifGo001MobReqVO.getRequest().getHeader(), ifGo001MobResVO.getResponse().getHeader());
			return ifGo001MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifGo001MobReqVO.getRequest().getHeader(), "GO01999", errorMsg);			
		}
	}

	@RequestMapping(value = "/IF-GO-002", method=RequestMethod.POST)
	public @ResponseBody Object requestGoods002(@RequestBody IfGo002MobReqVO ifGo002MobReqVO) {
		try {
			logger.debug("IfGo002MobReqVO="+ifGo002MobReqVO);
			IfErrMobResVO ifErrMobResVO = goodsValidator.validateGoods002Req(ifGo002MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifGo002MobReqVO.getRequest().getHeader(), ifGo002MobReqVO.getRequest().getBody().getAdminCode(), ifGo002MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfGo002MobResVO ifGo002MobResVO = goodsService.requestGoods002(ifGo002MobReqVO);
			if ( ifGo002MobResVO == null) return commonService.getMobErrorResponseMsg(ifGo002MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = goodsValidator.validateGoods002Res(ifGo002MobReqVO, ifGo002MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifGo002MobReqVO.getRequest().getHeader(), ifGo002MobResVO.getResponse().getHeader());
			return ifGo002MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifGo002MobReqVO.getRequest().getHeader(), "GO02999", errorMsg);			
		}
	}

	@RequestMapping(value = "/IF-GO-003", method=RequestMethod.POST)
	public @ResponseBody Object requestGoods003(@RequestBody IfGo003MobReqVO ifGo003MobReqVO) {
		try {
			logger.debug("IfGo003MobReqVO="+ifGo003MobReqVO);
			IfErrMobResVO ifErrMobResVO = goodsValidator.validateGoods003Req(ifGo003MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifGo003MobReqVO.getRequest().getHeader(), ifGo003MobReqVO.getRequest().getBody().getAdminCode(), ifGo003MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfGo003MobResVO ifGo003MobResVO = goodsService.requestGoods003(ifGo003MobReqVO);
			if ( ifGo003MobResVO == null) return commonService.getMobErrorResponseMsg(ifGo003MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = goodsValidator.validateGoods003Res(ifGo003MobReqVO, ifGo003MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifGo003MobReqVO.getRequest().getHeader(), ifGo003MobResVO.getResponse().getHeader());
			return ifGo003MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifGo003MobReqVO.getRequest().getHeader(), "GO03999", errorMsg);			
		}
	}

	@RequestMapping(value = "/IF-GO-004", method=RequestMethod.POST)
	public @ResponseBody Object requestGoods004(@RequestBody IfGo004MobReqVO ifGo004MobReqVO) {
		try {
			logger.debug("IfGo004MobReqVO="+ifGo004MobReqVO);
			IfErrMobResVO ifErrMobResVO = goodsValidator.validateGoods004Req(ifGo004MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifGo004MobReqVO.getRequest().getHeader(), ifGo004MobReqVO.getRequest().getBody().getAdminCode(), ifGo004MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfGo004MobResVO ifGo004MobResVO = goodsService.requestGoods004(ifGo004MobReqVO);
			if ( ifGo004MobResVO == null) return commonService.getMobErrorResponseMsg(ifGo004MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = goodsValidator.validateGoods004Res(ifGo004MobReqVO, ifGo004MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifGo004MobReqVO.getRequest().getHeader(), ifGo004MobResVO.getResponse().getHeader());
			return ifGo004MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifGo004MobReqVO.getRequest().getHeader(), "GO04999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-GO-005", method=RequestMethod.POST)
	public @ResponseBody Object requestGoods005(@RequestBody IfGo005MobReqVO ifGo005MobReqVO) {
		try {
			logger.debug("IfGo005MobReqVO="+ifGo005MobReqVO);
			IfErrMobResVO ifErrMobResVO = goodsValidator.validateGoods005Req(ifGo005MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifGo005MobReqVO.getRequest().getHeader(), ifGo005MobReqVO.getRequest().getBody().getAdminCode(), ifGo005MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfGo005MobResVO ifGo005MobResVO = goodsService.requestGoods005(ifGo005MobReqVO);
			if ( ifGo005MobResVO == null) return commonService.getMobErrorResponseMsg(ifGo005MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = goodsValidator.validateGoods005Res(ifGo005MobReqVO, ifGo005MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifGo005MobReqVO.getRequest().getHeader(), ifGo005MobResVO.getResponse().getHeader());
			return ifGo005MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifGo005MobReqVO.getRequest().getHeader(), "GO05999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-GO-0051", method=RequestMethod.POST)
	public @ResponseBody Object requestGoods0051(@RequestBody IfGo0051MobReqVO ifGo0051MobReqVO) {
		try {
			logger.debug("IfGo0051MobReqVO="+ifGo0051MobReqVO);
			IfErrMobResVO ifErrMobResVO = goodsValidator.validateGoods0051Req(ifGo0051MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifGo0051MobReqVO.getRequest().getHeader(), ifGo0051MobReqVO.getRequest().getBody().getAdminCode(), ifGo0051MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfGo0051MobResVO ifGo0051MobResVO = goodsService.requestGoods0051(ifGo0051MobReqVO);
			if ( ifGo0051MobResVO == null) return commonService.getMobErrorResponseMsg(ifGo0051MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = goodsValidator.validateGoods0051Res(ifGo0051MobReqVO, ifGo0051MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifGo0051MobReqVO.getRequest().getHeader(), ifGo0051MobResVO.getResponse().getHeader());
			return ifGo0051MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifGo0051MobReqVO.getRequest().getHeader(), "GO051999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-GO-006", method=RequestMethod.POST)
	public @ResponseBody Object requestGoods006(@RequestBody IfGo006MobReqVO ifGo006MobReqVO) {
		try {
			logger.debug("IfGo006MobReqVO="+ifGo006MobReqVO);
			IfErrMobResVO ifErrMobResVO = goodsValidator.validateGoods006Req(ifGo006MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifGo006MobReqVO.getRequest().getHeader(), ifGo006MobReqVO.getRequest().getBody().getAdminCode(), ifGo006MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfGo006MobResVO ifGo006MobResVO = goodsService.requestGoods006(ifGo006MobReqVO);
			if ( ifGo006MobResVO == null) return commonService.getMobErrorResponseMsg(ifGo006MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = goodsValidator.validateGoods006Res(ifGo006MobReqVO, ifGo006MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifGo006MobReqVO.getRequest().getHeader(), ifGo006MobResVO.getResponse().getHeader());
			return ifGo006MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifGo006MobReqVO.getRequest().getHeader(), "GO06999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-GO-007", method=RequestMethod.POST)
	public @ResponseBody Object requestGoods007(@RequestBody IfGo007MobReqVO ifGo007MobReqVO) {
		try {
			logger.debug("IfGo007MobReqVO="+ifGo007MobReqVO);
			IfErrMobResVO ifErrMobResVO = goodsValidator.validateGoods007Req(ifGo007MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifGo007MobReqVO.getRequest().getHeader(), ifGo007MobReqVO.getRequest().getBody().getAdminCode(), ifGo007MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfGo007MobResVO ifGo007MobResVO = goodsService.requestGoods007(ifGo007MobReqVO);
			if ( ifGo007MobResVO == null) return commonService.getMobErrorResponseMsg(ifGo007MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = goodsValidator.validateGoods007Res(ifGo007MobReqVO, ifGo007MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifGo007MobReqVO.getRequest().getHeader(), ifGo007MobResVO.getResponse().getHeader());
			return ifGo007MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifGo007MobReqVO.getRequest().getHeader(), "GO07999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-GO-008", method=RequestMethod.POST)
	public @ResponseBody Object requestGoods008(@RequestBody IfGo008MobReqVO ifGo008MobReqVO) {
		try {
			logger.debug("IfGo008MobReqVO="+ifGo008MobReqVO);
			IfErrMobResVO ifErrMobResVO = goodsValidator.validateGoods008Req(ifGo008MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifGo008MobReqVO.getRequest().getHeader(), ifGo008MobReqVO.getRequest().getBody().getAdminCode(), ifGo008MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfGo008MobResVO ifGo008MobResVO = goodsService.requestGoods008(ifGo008MobReqVO);
			if ( ifGo008MobResVO == null) return commonService.getMobErrorResponseMsg(ifGo008MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = goodsValidator.validateGoods008Res(ifGo008MobReqVO, ifGo008MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifGo008MobReqVO.getRequest().getHeader(), ifGo008MobResVO.getResponse().getHeader());
			return ifGo008MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifGo008MobReqVO.getRequest().getHeader(), "GO08999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-GO-009", method=RequestMethod.POST)
	public @ResponseBody Object requestGoods009(@RequestBody IfGo009MobReqVO ifGo009MobReqVO) {
		try {
			logger.debug("IfGo009MobReqVO="+ifGo009MobReqVO);
			IfErrMobResVO ifErrMobResVO = goodsValidator.validateGoods009Req(ifGo009MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifGo009MobReqVO.getRequest().getHeader(), ifGo009MobReqVO.getRequest().getBody().getAdminCode(), ifGo009MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfGo009MobResVO ifGo009MobResVO = goodsService.requestGoods009(ifGo009MobReqVO);
			if ( ifGo009MobResVO == null) return commonService.getMobErrorResponseMsg(ifGo009MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = goodsValidator.validateGoods009Res(ifGo009MobReqVO, ifGo009MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifGo009MobReqVO.getRequest().getHeader(), ifGo009MobResVO.getResponse().getHeader());
			return ifGo009MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifGo009MobReqVO.getRequest().getHeader(), "GO09999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-GO-010", method=RequestMethod.POST)
	public @ResponseBody Object requestGoods010(@RequestBody IfGo010MobReqVO ifGo010MobReqVO) {
		try {
			logger.debug("IfGo010MobReqVO="+ifGo010MobReqVO);
			IfErrMobResVO ifErrMobResVO = goodsValidator.validateGoods010Req(ifGo010MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifGo010MobReqVO.getRequest().getHeader(), ifGo010MobReqVO.getRequest().getBody().getAdminCode(), ifGo010MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfGo010MobResVO ifGo010MobResVO = goodsService.requestGoods010(ifGo010MobReqVO);
			if ( ifGo010MobResVO == null) return commonService.getMobErrorResponseMsg(ifGo010MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = goodsValidator.validateGoods010Res(ifGo010MobReqVO, ifGo010MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifGo010MobReqVO.getRequest().getHeader(), ifGo010MobResVO.getResponse().getHeader());
			return ifGo010MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifGo010MobReqVO.getRequest().getHeader(), "GO10999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-GO-011", method=RequestMethod.POST)
	public @ResponseBody Object requestGoods011(@RequestBody IfGo011MobReqVO ifGo011MobReqVO) {
		try {
			logger.debug("IfGo011MobReqVO="+ifGo011MobReqVO);
			IfErrMobResVO ifErrMobResVO = goodsValidator.validateGoods011Req(ifGo011MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifGo011MobReqVO.getRequest().getHeader(), ifGo011MobReqVO.getRequest().getBody().getAdminCode(), ifGo011MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfGo011MobResVO ifGo011MobResVO = goodsService.requestGoods011(ifGo011MobReqVO);
			if ( ifGo011MobResVO == null) return commonService.getMobErrorResponseMsg(ifGo011MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = goodsValidator.validateGoods011Res(ifGo011MobReqVO, ifGo011MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifGo011MobReqVO.getRequest().getHeader(), ifGo011MobResVO.getResponse().getHeader());
			return ifGo011MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifGo011MobReqVO.getRequest().getHeader(), "GO11999", errorMsg);			
		}
	}
	
	@RequestMapping(value = "/IF-GO-012", method=RequestMethod.POST)
	public @ResponseBody Object requestGoods012(@RequestBody IfGo012MobReqVO ifGo012MobReqVO) {
		try {
			logger.debug("IfGo012MobReqVO="+ifGo012MobReqVO);
			IfErrMobResVO ifErrMobResVO = goodsValidator.validateGoods012Req(ifGo012MobReqVO);
			if (ifErrMobResVO != null) return ifErrMobResVO;
			// AuthInfo Check
			IfErrMobResVO authIfErrMobResVO = commonService.chkAuthInfo(ifGo012MobReqVO.getRequest().getHeader(), ifGo012MobReqVO.getRequest().getBody().getAdminCode(), ifGo012MobReqVO.getRequest().getBody().getUserId());
			if( authIfErrMobResVO != null) return authIfErrMobResVO;
	
			IfGo012MobResVO ifGo012MobResVO = goodsService.requestGoods012(ifGo012MobReqVO);
			if ( ifGo012MobResVO == null) return commonService.getMobErrorResponseMsg(ifGo012MobReqVO.getRequest().getHeader(), "CO00900");
			IfErrMobResVO ifErrMobResVO2 = goodsValidator.validateGoods012Res(ifGo012MobReqVO, ifGo012MobResVO);
			if (ifErrMobResVO2 != null) return ifErrMobResVO2;
			
			// 인증키에 인증시간 및 라스트 업데이트 시간 추가
			commonService.addResAuthTime(ifGo012MobReqVO.getRequest().getHeader(), ifGo012MobResVO.getResponse().getHeader());
			return ifGo012MobResVO;
		} catch (Exception e) {
			String errorMsg = StringUtils.substring(StringUtils.stripToEmpty(e.getMessage()), 0, config.getInt("ERROR_MSG_LENGTH"));
			return commonService.getMobErrorResponseMsg(ifGo012MobReqVO.getRequest().getHeader(), "GO12999", errorMsg);			
		}
	}

}