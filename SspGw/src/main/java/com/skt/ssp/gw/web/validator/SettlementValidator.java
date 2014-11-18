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
import com.skt.ssp.gw.vo.settlement.IfSe001ComBodyReqVO;
import com.skt.ssp.gw.vo.settlement.IfSe001MobReqVO;
import com.skt.ssp.gw.vo.settlement.IfSe001MobResVO;
import com.skt.ssp.gw.vo.settlement.IfSe002ComBodyReqVO;
import com.skt.ssp.gw.vo.settlement.IfSe002MobReqVO;
import com.skt.ssp.gw.vo.settlement.IfSe002MobResVO;

/**
 * SettlementValidator (SettlementValidator)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: SettlementValidator.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Component
public class SettlementValidator {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public SettlementValidator() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public IfErrMobResVO validateSettlement001Req(IfSe001MobReqVO ifSe001MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifSe001MobReqVO.getRequest().getHeader();
		IfSe001ComBodyReqVO ifSe001ComBodyReqVO = ifSe001MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifSe001ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "SE01001");
		else if (commonService.isEmptyOrMaxLengthOver(ifSe001ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "SE01002");
		else if (commonService.isEmptyOrMaxLengthOver(ifSe001ComBodyReqVO.getMainCode(), 3, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "SE01003");
		else if (commonService.isEmptyOrMaxLengthOver(ifSe001ComBodyReqVO.getPageCnt(), 5, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "SE01005");
		else if (commonService.isEmptyOrMaxLengthOver(ifSe001ComBodyReqVO.getPageNo(), 5, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "SE01006");
		else if (commonService.isEmptyOrMaxLengthOver(ifSe001ComBodyReqVO.getTermGubun(), 3, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "SE01007");
		else if (commonService.isEmptyOrMaxLengthOver(ifSe001ComBodyReqVO.getDateFrom(), 20, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "SE01008");
		else if (commonService.isEmptyOrMaxLengthOver(ifSe001ComBodyReqVO.getDateTo(), 20, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "SE01009");
		return null;
	}

	public IfErrMobResVO validateSettlement001Res(IfSe001MobReqVO ifSe001MobReqVO, IfSe001MobResVO ifSe001MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifSe001MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifSe001MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateSettlement002Req(IfSe002MobReqVO ifSe002MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifSe002MobReqVO.getRequest().getHeader();
		IfSe002ComBodyReqVO ifSe002ComBodyReqVO = ifSe002MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifSe002ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "SE02001");
		else if (commonService.isEmptyOrMaxLengthOver(ifSe002ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "SE02002");
		else if (commonService.isEmptyOrMaxLengthOver(ifSe002ComBodyReqVO.getMainCode(), 3, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "SE02003");
		else if (commonService.isEmptyOrMaxLengthOver(ifSe002ComBodyReqVO.getUid(), 50, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "SE02004");
		else if (commonService.isEmptyOrMaxLengthOver(ifSe002ComBodyReqVO.getJumunNo(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "SE02005");
		return null;
	}

	public IfErrMobResVO validateSettlement002Res(IfSe002MobReqVO ifSe002MobReqVO, IfSe002MobResVO ifSe002MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifSe002MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifSe002MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
}