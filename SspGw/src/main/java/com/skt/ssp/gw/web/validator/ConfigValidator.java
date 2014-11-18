package com.skt.ssp.gw.web.validator;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.vo.IfErrMobResVO;
import com.skt.ssp.gw.vo.IfHeaderMobReqVO;
import com.skt.ssp.gw.vo.IfHeaderMobResVO;
import com.skt.ssp.gw.vo.config.IfCf001ComBodyReqVO;
import com.skt.ssp.gw.vo.config.IfCf001MobReqVO;
import com.skt.ssp.gw.vo.config.IfCf001MobResVO;
import com.skt.ssp.gw.vo.config.IfCf002ComBodyReqVO;
import com.skt.ssp.gw.vo.config.IfCf002MobReqVO;
import com.skt.ssp.gw.vo.config.IfCf002MobResVO;
import com.skt.ssp.gw.vo.config.IfCf003ComBodyReqVO;
import com.skt.ssp.gw.vo.config.IfCf003MobReqVO;
import com.skt.ssp.gw.vo.config.IfCf003MobResVO;
import com.skt.ssp.gw.vo.config.IfCf004ComBodyReqVO;
import com.skt.ssp.gw.vo.config.IfCf004MobReqVO;
import com.skt.ssp.gw.vo.config.IfCf004MobResVO;

/**
 * ConfigValidator (ConfigValidator)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: ConfigValidator.java,v1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Component
public class ConfigValidator {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public ConfigValidator() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public IfErrMobResVO validateConfig001(IfCf001MobReqVO ifCf001MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCf001MobReqVO.getRequest().getHeader();
		IfCf001ComBodyReqVO ifCf001ComBodyReqVO = ifCf001MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifCf001ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CF01001");
		else if (commonService.isEmptyOrMaxLengthOver(ifCf001ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CF01002");
		return null;
	}

	public IfErrMobResVO validateConfig001Res(IfCf001MobReqVO ifCf001MobReqVO, IfCf001MobResVO ifCf001MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCf001MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCf001MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateConfig002(IfCf002MobReqVO ifCf002MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCf002MobReqVO.getRequest().getHeader();
		IfCf002ComBodyReqVO ifCf002ComBodyReqVO = ifCf002MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifCf002ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CF02001");
		else if (commonService.isEmptyOrMaxLengthOver(ifCf002ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CF02002");
		else if (commonService.isEmptyOrMaxLengthOver(ifCf002ComBodyReqVO.getAlarmYn(), 1, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CF02003");
		else if (commonService.isEmptyOrMaxLengthOver(ifCf002ComBodyReqVO.getNewOrderAlarmYn(), 1, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CF02004");
		else if (commonService.isEmptyOrMaxLengthOver(ifCf002ComBodyReqVO.getCancelOrderAlarmYn(), 1, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CF02005");
		else if (commonService.isEmptyOrMaxLengthOver(ifCf002ComBodyReqVO.getReturnOrderAlarmYn(), 1, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CF02006");
		else if (commonService.isEmptyOrMaxLengthOver(ifCf002ComBodyReqVO.getExchangeOrderAlarmYn(), 1, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CF02007");
		else if (commonService.isEmptyOrMaxLengthOver(ifCf002ComBodyReqVO.getGoodsProcAlarmYn(), 1, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CF02008");
		else if (commonService.isEmptyOrMaxLengthOver(ifCf002ComBodyReqVO.getCsAlarmYn(), 1, "M"))			return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CF02009");
		else if (commonService.isEmptyOrMaxLengthOver(ifCf002ComBodyReqVO.getSafetyQtyYn(), 1, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CF02010");
		else if (commonService.isEmptyOrMaxLengthOver(ifCf002ComBodyReqVO.getAlarmStartPeriod(), 5, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CF02011");
		else if (commonService.isEmptyOrMaxLengthOver(ifCf002ComBodyReqVO.getAlarmEndPeriod(), 5, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CF02012");
		else if (commonService.isEmptyOrMaxLengthOver(ifCf002ComBodyReqVO.getAlarmInterval(), 2, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CF02013");
		else if (commonService.isEmptyOrMaxLengthOver(ifCf002ComBodyReqVO.getUrgencyYn(), 1, "M"))			return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CF02014");
		return null;
	}

	public IfErrMobResVO validateConfig002Res(IfCf002MobReqVO ifCf002MobReqVO, IfCf002MobResVO ifCf002MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCf002MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCf002MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateConfig003(IfCf003MobReqVO ifCf003MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCf003MobReqVO.getRequest().getHeader();
		IfCf003ComBodyReqVO ifCf003ComBodyReqVO = ifCf003MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifCf003ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CF03001");
		else if (commonService.isEmptyOrMaxLengthOver(ifCf003ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CF03002");
		return null;
	}

	public IfErrMobResVO validateConfig003Res(IfCf003MobReqVO ifCf003MobReqVO, IfCf003MobResVO ifCf003MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCf003MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCf003MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateConfig004(IfCf004MobReqVO ifCf004MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCf004MobReqVO.getRequest().getHeader();
		IfCf004ComBodyReqVO ifCf004ComBodyReqVO = ifCf004MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifCf004ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CF04001");
		else if (commonService.isEmptyOrMaxLengthOver(ifCf004ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CF04002");
		else if (commonService.isEmptyOrMaxLengthOver(ifCf004ComBodyReqVO.getUseGlobalWpriceYn(), 1, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CF04003");
		return null;
	}

	public IfErrMobResVO validateConfig004Res(IfCf004MobReqVO ifCf004MobReqVO, IfCf004MobResVO ifCf004MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCf004MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCf004MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
}