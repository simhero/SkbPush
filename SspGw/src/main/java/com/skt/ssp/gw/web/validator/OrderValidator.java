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
import com.skt.ssp.gw.vo.order.IfOr001ComBodyReqVO;
import com.skt.ssp.gw.vo.order.IfOr001MobReqVO;
import com.skt.ssp.gw.vo.order.IfOr001MobResVO;
import com.skt.ssp.gw.vo.order.IfOr002ComBodyReqVO;
import com.skt.ssp.gw.vo.order.IfOr002MobReqVO;
import com.skt.ssp.gw.vo.order.IfOr002MobResVO;
import com.skt.ssp.gw.vo.order.IfOr003ComBodyReqVO;
import com.skt.ssp.gw.vo.order.IfOr003MobReqVO;
import com.skt.ssp.gw.vo.order.IfOr003MobResVO;

/**
 * OrderValidator (OrderValidator)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: OrderValidator.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Component
public class OrderValidator {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public OrderValidator() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public IfErrMobResVO validateOrder001Req(IfOr001MobReqVO ifOr001MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifOr001MobReqVO.getRequest().getHeader();
		IfOr001ComBodyReqVO ifOr001ComBodyReqVO = ifOr001MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifOr001ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "OR01001");
		else if (commonService.isEmptyOrMaxLengthOver(ifOr001ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "OR01002");
		else if (commonService.isEmptyOrMaxLengthOver(ifOr001ComBodyReqVO.getMainCode(), 3, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "OR01003");
		else if (commonService.isEmptyOrMaxLengthOver(ifOr001ComBodyReqVO.getPageCnt(), 5, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "OR01005");
		else if (commonService.isEmptyOrMaxLengthOver(ifOr001ComBodyReqVO.getPageNo(), 5, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "OR01006");
		else if (commonService.isEmptyOrMaxLengthOver(ifOr001ComBodyReqVO.getSearchGubun(), 3, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "OR01007");
		else if (commonService.isEmptyOrMaxLengthOver(ifOr001ComBodyReqVO.getSearchWord(), 100, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "OR01008");
		else if (commonService.isEmptyOrMaxLengthOver(ifOr001ComBodyReqVO.getoState(), 3, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "OR01009");
		else if (commonService.isEmptyOrMaxLengthOver(ifOr001ComBodyReqVO.getTermGubun(), 3, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "OR01010");
		else if (commonService.isEmptyOrMaxLengthOver(ifOr001ComBodyReqVO.getDateFrom(), 20, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "OR01011");
		else if (commonService.isEmptyOrMaxLengthOver(ifOr001ComBodyReqVO.getDateTo(), 20, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "OR01012");
		return null;
	}

	public IfErrMobResVO validateOrder001Res(IfOr001MobReqVO ifOr001MobReqVO, IfOr001MobResVO ifOr001MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifOr001MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifOr001MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateOrder002Req(IfOr002MobReqVO ifOr002MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifOr002MobReqVO.getRequest().getHeader();
		IfOr002ComBodyReqVO ifOr002ComBodyReqVO = ifOr002MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifOr002ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "OR02001");
		else if (commonService.isEmptyOrMaxLengthOver(ifOr002ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "OR02002");
		else if (commonService.isEmptyOrMaxLengthOver(ifOr002ComBodyReqVO.getMainCode(), 3, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "OR02003");
		else if (commonService.isEmptyOrMaxLengthOver(ifOr002ComBodyReqVO.getUid(), 50, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "OR02004");
		else if (commonService.isEmptyOrMaxLengthOver(ifOr002ComBodyReqVO.getJumunNo(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "OR02005");
		return null;
	}

	public IfErrMobResVO validateOrder002Res(IfOr002MobReqVO ifOr002MobReqVO, IfOr002MobResVO ifOr002MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifOr002MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifOr002MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateOrder003Req(IfOr003MobReqVO ifOr003MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifOr003MobReqVO.getRequest().getHeader();
		IfOr003ComBodyReqVO ifOr003ComBodyReqVO = ifOr003MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifOr003ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "OR02001");
		else if (commonService.isEmptyOrMaxLengthOver(ifOr003ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "OR02002");
		else if(ifOr003ComBodyReqVO.getOrderList().size() > 0) {
			if (commonService.isEmptyOrMaxLengthOver(ifOr003ComBodyReqVO.getOrderList().get(0).getMainCode(), 3, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "OR02003");
			else if (commonService.isEmptyOrMaxLengthOver(ifOr003ComBodyReqVO.getOrderList().get(0).getUid(), 50, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "OR02004");
			else if (commonService.isEmptyOrMaxLengthOver(ifOr003ComBodyReqVO.getOrderList().get(0).getJumunNo(), 50, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "OR02005");
			else if (commonService.isEmptyOrMaxLengthOver(ifOr003ComBodyReqVO.getOrderList().get(0).getCmd(), 3, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "OR02006");
			else if (commonService.isEmptyOrMaxLengthOver(ifOr003ComBodyReqVO.getOrderList().get(0).getoState(), 2, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "OR02007");
			else if (commonService.isEmptyOrMaxLengthOver(ifOr003ComBodyReqVO.getOrderList().get(0).getTagcom(), 10, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "OR02008");
			else if (commonService.isEmptyOrMaxLengthOver(ifOr003ComBodyReqVO.getOrderList().get(0).getSongjangNo(), 20, "O"))return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "OR02009");
		}
		return null;
	}

	public IfErrMobResVO validateOrder003Res(IfOr003MobReqVO ifOr003MobReqVO, IfOr003MobResVO ifOr003MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifOr003MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifOr003MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
}