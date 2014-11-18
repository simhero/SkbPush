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
import com.skt.ssp.gw.vo.customer.IfCu001ComBodyReqVO;
import com.skt.ssp.gw.vo.customer.IfCu001MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu001MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu002ComBodyReqVO;
import com.skt.ssp.gw.vo.customer.IfCu002MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu002MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu003ComBodyReqVO;
import com.skt.ssp.gw.vo.customer.IfCu003MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu003MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu004ComBodyReqVO;
import com.skt.ssp.gw.vo.customer.IfCu004MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu004MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu005ComBodyReqVO;
import com.skt.ssp.gw.vo.customer.IfCu005MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu005MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu006ComBodyReqVO;
import com.skt.ssp.gw.vo.customer.IfCu006MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu006MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu007ComBodyReqVO;
import com.skt.ssp.gw.vo.customer.IfCu007MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu007MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu008ComBodyReqVO;
import com.skt.ssp.gw.vo.customer.IfCu008MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu008MobResVO;

/**
 * CustomerValidator (CustomerValidator)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: CustomerValidator.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
@Component
public class CustomerValidator {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public CustomerValidator() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public IfErrMobResVO validateCustomer001Req(IfCu001MobReqVO ifCu001MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCu001MobReqVO.getRequest().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		IfCu001ComBodyReqVO ifCu001ComBodyReqVO = ifCu001MobReqVO.getRequest().getBody();
		if (commonService.isEmptyOrMaxLengthOver(ifCu001ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU01001");
		if (commonService.isEmptyOrMaxLengthOver(ifCu001ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU01002");
		if (commonService.isEmptyOrMaxLengthOver(ifCu001ComBodyReqVO.getUserPW(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU01003");
		if (commonService.isEmptyOrMaxLengthOver(ifCu001ComBodyReqVO.getPushID(), 300, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU01004");
		return null;
	}

	public IfErrMobResVO validateCustomer002Req(IfCu002MobReqVO ifCu002MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCu002MobReqVO.getRequest().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		IfCu002ComBodyReqVO ifCu002ComBodyReqVO = ifCu002MobReqVO.getRequest().getBody();
		if (commonService.isEmptyOrMaxLengthOver(ifCu002ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU02001");
		if (commonService.isEmptyOrMaxLengthOver(ifCu002ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU02002");
		if (commonService.isEmptyOrMaxLengthOver(ifCu002ComBodyReqVO.getAuthValue(), 20, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU02003");
		if (commonService.isEmptyOrMaxLengthOver(ifCu002ComBodyReqVO.getCmd(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU02004");
		if (commonService.isEmptyOrMaxLengthOver(ifCu002ComBodyReqVO.getCmdValue(), 100, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU02005");
		return null;
	}

	public IfErrMobResVO validateCustomer003Req(IfCu003MobReqVO ifCu003MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCu003MobReqVO.getRequest().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		IfCu003ComBodyReqVO ifCu003ComBodyReqVO = ifCu003MobReqVO.getRequest().getBody();
		if (commonService.isEmptyOrMaxLengthOver(ifCu003ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU03001");
		if (commonService.isEmptyOrMaxLengthOver(ifCu003ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU03002");
		if (commonService.isEmptyOrMaxLengthOver(ifCu003ComBodyReqVO.getCmd(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU03003");
		if (commonService.isEmptyOrMaxLengthOver(ifCu003ComBodyReqVO.getCmdValue(), 100, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU03004");
		if (commonService.isEmptyOrMaxLengthOver(ifCu003ComBodyReqVO.getPhoneNum(), 17, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU03005");

		return null;
	}
	

	public IfErrMobResVO validateCustomer004Req(IfCu004MobReqVO ifCu004MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCu004MobReqVO.getRequest().getHeader();
		IfCu004ComBodyReqVO ifCu004ComBodyReqVO = ifCu004MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifCu004ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU04001");
		else if (commonService.isEmptyOrMaxLengthOver(ifCu004ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU04002");
		else if (commonService.isEmptyOrMaxLengthOver(ifCu004ComBodyReqVO.getMainCode(), 3, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU04003");
		else if (commonService.isEmptyOrMaxLengthOver(ifCu004ComBodyReqVO.getUid(), 50, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU04004");
		return null;
	}

	public IfErrMobResVO validateCustomer005Req(IfCu005MobReqVO ifCu005MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCu005MobReqVO.getRequest().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		IfCu005ComBodyReqVO ifCu005ComBodyReqVO = ifCu005MobReqVO.getRequest().getBody();
		if (commonService.isEmptyOrMaxLengthOver(ifCu005ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU05001");
		if (commonService.isEmptyOrMaxLengthOver(ifCu005ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU05002");
		if (commonService.isEmptyOrMaxLengthOver(ifCu005ComBodyReqVO.getDateFrom(), 20, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU05003");
		if (commonService.isEmptyOrMaxLengthOver(ifCu005ComBodyReqVO.getDateTo(), 20, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU05004");
		return null;
	}

	public IfErrMobResVO validateCustomer006Req(IfCu006MobReqVO ifCu006MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCu006MobReqVO.getRequest().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		IfCu006ComBodyReqVO ifCu006ComBodyReqVO = ifCu006MobReqVO.getRequest().getBody();
		if (commonService.isEmptyOrMaxLengthOver(ifCu006ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU06001");
		if (commonService.isEmptyOrMaxLengthOver(ifCu006ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU06002");
		if (commonService.isEmptyOrMaxLengthOver(ifCu006ComBodyReqVO.getPushID(), 300, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU06003");
		return null;
	}

	public IfErrMobResVO validateCustomer007Req(IfCu007MobReqVO ifCu007MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCu007MobReqVO.getRequest().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		IfCu007ComBodyReqVO ifCu007ComBodyReqVO = ifCu007MobReqVO.getRequest().getBody();
		if (commonService.isEmptyOrMaxLengthOver(ifCu007ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU07001");
		if (commonService.isEmptyOrMaxLengthOver(ifCu007ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU07002");
		if (commonService.isEmptyOrMaxLengthOver(ifCu007ComBodyReqVO.getDateFrom(), 20, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU07003");
		if (commonService.isEmptyOrMaxLengthOver(ifCu007ComBodyReqVO.getDateTo(), 20, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU07004");
		return null;
	}
	
	public IfErrMobResVO validateCustomer008Req(IfCu008MobReqVO ifCu008MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCu008MobReqVO.getRequest().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		IfCu008ComBodyReqVO ifCu008ComBodyReqVO = ifCu008MobReqVO.getRequest().getBody();
		if (commonService.isEmptyOrMaxLengthOver(ifCu008ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU08001");
		if (commonService.isEmptyOrMaxLengthOver(ifCu008ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU08002");
		if (commonService.isEmptyOrMaxLengthOver(ifCu008ComBodyReqVO.getUserPw(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU08003");
		if (commonService.isEmptyOrMaxLengthOver(ifCu008ComBodyReqVO.getNewUserPw(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CU08004");
		return null;
	}

	public IfErrMobResVO validateCustomer001Res(IfCu001MobReqVO ifCu001MobReqVO, IfCu001MobResVO ifCu001MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCu001MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCu001MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateCustomer002Res(IfCu002MobReqVO ifCu002MobReqVO, IfCu002MobResVO ifCu002MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCu002MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCu002MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateCustomer003Res(IfCu003MobReqVO ifCu003MobReqVO, IfCu003MobResVO ifCu003MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCu003MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCu003MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateCustomer004Res(IfCu004MobReqVO ifCu004MobReqVO, IfCu004MobResVO ifCu004MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCu004MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCu004MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateCustomer005Res(IfCu005MobReqVO ifCu005MobReqVO, IfCu005MobResVO ifCu005MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCu005MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCu005MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateCustomer006Res(IfCu006MobReqVO ifCu006MobReqVO, IfCu006MobResVO ifCu006MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCu006MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCu006MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateCustomer007Res(IfCu007MobReqVO ifCu007MobReqVO, IfCu007MobResVO ifCu007MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCu007MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCu007MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateCustomer008Res(IfCu008MobReqVO ifCu008MobReqVO, IfCu008MobResVO ifCu008MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCu008MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCu008MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}

}