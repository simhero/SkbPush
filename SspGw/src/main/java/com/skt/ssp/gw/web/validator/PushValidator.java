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
import com.skt.ssp.gw.vo.push.IfPu001ComBodyReqVO;
import com.skt.ssp.gw.vo.push.IfPu001MobReqVO;
import com.skt.ssp.gw.vo.push.IfPu001MobResVO;
import com.skt.ssp.gw.vo.push.IfPu002ComBodyReqVO;
import com.skt.ssp.gw.vo.push.IfPu002MobReqVO;
import com.skt.ssp.gw.vo.push.IfPu002MobResVO;
import com.skt.ssp.gw.vo.push.IfPu004ComBodyReqVO;
import com.skt.ssp.gw.vo.push.IfPu004MobReqVO;
import com.skt.ssp.gw.vo.push.IfPu004MobResVO;

/**
 * PushValidator (PushValidator)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: PushValidator.java,v1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Component
public class PushValidator {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public PushValidator() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public IfErrMobResVO validatePush001(IfPu001MobReqVO ifPu001MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifPu001MobReqVO.getRequest().getHeader();
		IfPu001ComBodyReqVO ifPu001ComBodyReqVO = ifPu001MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifPu001ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "PU01001");
		else if (commonService.isEmptyOrMaxLengthOver(ifPu001ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "PU01002");
		else if (commonService.isEmptyOrMaxLengthOver(ifPu001ComBodyReqVO.getMainCode(), 3, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "PU01003");
		else if (commonService.isEmptyOrMaxLengthOver(ifPu001ComBodyReqVO.getPushId(), 256, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "PU01005");
		else if (commonService.isEmptyOrMaxLengthOver(ifPu001ComBodyReqVO.getPageCnt(), 5, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "PU01006");
		else if (commonService.isEmptyOrMaxLengthOver(ifPu001ComBodyReqVO.getPageNo(), 5, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "PU01007");
		return null;
	}

	public IfErrMobResVO validatePush001Res(IfPu001MobReqVO ifPu001MobReqVO, IfPu001MobResVO ifPu001MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifPu001MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifPu001MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validatePush002(IfPu002MobReqVO ifPu002MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifPu002MobReqVO.getRequest().getHeader();
		IfPu002ComBodyReqVO ifPu002ComBodyReqVO = ifPu002MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifPu002ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "PU02001");
		else if (commonService.isEmptyOrMaxLengthOver(ifPu002ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "PU02002");
		else if (commonService.isEmptyOrMaxLengthOver(ifPu002ComBodyReqVO.getMainCode(), 3, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "PU02003");
		else if (commonService.isEmptyOrMaxLengthOver(ifPu002ComBodyReqVO.getPushId(), 256, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "PU02005");
		else if (commonService.isEmptyOrMaxLengthOver(ifPu002ComBodyReqVO.getTransferGroupIdx(), 20, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "PU02006");
		else if (commonService.isEmptyOrMaxLengthOver(ifPu002ComBodyReqVO.getPageCnt(), 5, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "PU02007");
		else if (commonService.isEmptyOrMaxLengthOver(ifPu002ComBodyReqVO.getPageNo(), 5, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "PU02008");
		return null;
	}

	public IfErrMobResVO validatePush002Res(IfPu002MobReqVO ifPu002MobReqVO, IfPu002MobResVO ifPu002MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifPu002MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifPu002MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}

	public IfErrMobResVO validatePush004(IfPu004MobReqVO ifPu004MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifPu004MobReqVO.getRequest().getHeader();
		IfPu004ComBodyReqVO ifPu004ComBodyReqVO = ifPu004MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifPu004ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "PU04001");
		else if (commonService.isEmptyOrMaxLengthOver(ifPu004ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "PU04002");
		else if (commonService.isEmptyOrMaxLengthOver(ifPu004ComBodyReqVO.getMainCode(), 3, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "PU04003");
		else if (commonService.isEmptyOrMaxLengthOver(ifPu004ComBodyReqVO.getUid(), 50, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "PU04004");
		else if (commonService.isEmptyOrMaxLengthOver(ifPu004ComBodyReqVO.getPushId(), 256, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "PU04005");
		else if (commonService.isEmptyOrMaxLengthOver(ifPu004ComBodyReqVO.getCmd(), 3, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "PU04006");
		else if (commonService.isEmptyOrMaxLengthOver(ifPu004ComBodyReqVO.getCsNew(), 1, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "PU04007");
		return null;
	}

	public IfErrMobResVO validatePush004Res(IfPu004MobReqVO ifPu004MobReqVO, IfPu004MobResVO ifPu004MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifPu004MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifPu004MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
}