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
import com.skt.ssp.gw.vo.cs.IfCs001ComBodyReqVO;
import com.skt.ssp.gw.vo.cs.IfCs001MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs001MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs002ComBodyReqVO;
import com.skt.ssp.gw.vo.cs.IfCs002MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs002MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs003ComBodyReqVO;
import com.skt.ssp.gw.vo.cs.IfCs003MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs003MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs004ComBodyReqVO;
import com.skt.ssp.gw.vo.cs.IfCs004MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs004MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs005ComBodyReqVO;
import com.skt.ssp.gw.vo.cs.IfCs005MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs005MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs006ComBodyReqVO;
import com.skt.ssp.gw.vo.cs.IfCs006MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs006MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs007ComBodyReqVO;
import com.skt.ssp.gw.vo.cs.IfCs007MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs007MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs008ComBodyReqVO;
import com.skt.ssp.gw.vo.cs.IfCs008MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs008MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs009ComBodyReqVO;
import com.skt.ssp.gw.vo.cs.IfCs009MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs009MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs010ComBodyReqVO;
import com.skt.ssp.gw.vo.cs.IfCs010MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs010MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs011ComBodyReqVO;
import com.skt.ssp.gw.vo.cs.IfCs011MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs011MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs012ComBodyReqVO;
import com.skt.ssp.gw.vo.cs.IfCs012MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs012MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs013ComBodyReqVO;
import com.skt.ssp.gw.vo.cs.IfCs013MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs013MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs014ComBodyReqVO;
import com.skt.ssp.gw.vo.cs.IfCs014MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs014MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs015ComBodyReqVO;
import com.skt.ssp.gw.vo.cs.IfCs015MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs015MobResVO;

/**
 * CsValidator (CsValidator)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: CsValidator.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Component
public class CsValidator {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public CsValidator() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public IfErrMobResVO validateCs001Req(IfCs001MobReqVO ifCs001MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs001MobReqVO.getRequest().getHeader();
		IfCs001ComBodyReqVO ifCs001ComBodyReqVO = ifCs001MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifCs001ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS01001");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs001ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS01002");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs001ComBodyReqVO.getMainCode(), 3, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS01003");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs001ComBodyReqVO.getCsKind(), 2, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS01005");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs001ComBodyReqVO.getPageCnt(), 5, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS01006");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs001ComBodyReqVO.getPageNo(), 5, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS01007");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs001ComBodyReqVO.getSearchGubun(), 20, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS01008");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs001ComBodyReqVO.getSearchWord(), 100, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS01009");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs001ComBodyReqVO.getCsState(), 2, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS01010");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs001ComBodyReqVO.getTermGubun(), 20, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS01011");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs001ComBodyReqVO.getDateFrom(), 20, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS01012");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs001ComBodyReqVO.getDateTo(), 20, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS01013");
		return null;
	}

	public IfErrMobResVO validateCs001Res(IfCs001MobReqVO ifCs001MobReqVO, IfCs001MobResVO ifCs001MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs001MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCs001MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateCs002Req(IfCs002MobReqVO ifCs002MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs002MobReqVO.getRequest().getHeader();
		IfCs002ComBodyReqVO ifCs002ComBodyReqVO = ifCs002MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifCs002ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS02001");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs002ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS02002");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs002ComBodyReqVO.getMainCode(), 3, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS02003");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs002ComBodyReqVO.getUid(), 50, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS02004");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs002ComBodyReqVO.getCsNo(), 20, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS02005");
		return null;
	}

	public IfErrMobResVO validateCs002Res(IfCs002MobReqVO ifCs002MobReqVO, IfCs002MobResVO ifCs002MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs002MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCs002MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateCs003Req(IfCs003MobReqVO ifCs003MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs003MobReqVO.getRequest().getHeader();
		IfCs003ComBodyReqVO ifCs003ComBodyReqVO = ifCs003MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifCs003ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS03001");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs003ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS03002");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs003ComBodyReqVO.getMainCode(), 3, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS03003");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs003ComBodyReqVO.getUid(), 50, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS03004");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs003ComBodyReqVO.getCsNo(), 50, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS03005");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs003ComBodyReqVO.getCmd(), 3, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS03006");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs003ComBodyReqVO.getCsState(), 2, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS03007");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs003ComBodyReqVO.getaSubject(), 200, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS03008");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs003ComBodyReqVO.getaContents(), 8000, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS03009");
		return null;
	}

	public IfErrMobResVO validateCs003Res(IfCs003MobReqVO ifCs003MobReqVO, IfCs003MobResVO ifCs003MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs003MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCs003MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateCs004Req(IfCs004MobReqVO ifCs004MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs004MobReqVO.getRequest().getHeader();
		IfCs004ComBodyReqVO ifCs004ComBodyReqVO = ifCs004MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifCs004ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS04001");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs004ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS04002");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs004ComBodyReqVO.getMainCode(), 3, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS04003");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs004ComBodyReqVO.getPageCnt(), 5, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS04005");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs004ComBodyReqVO.getPageNo(), 5, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS04006");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs004ComBodyReqVO.getSearchGubun(), 20, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS04007");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs004ComBodyReqVO.getSearchWord(), 100, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS04008");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs004ComBodyReqVO.getCsState(), 2, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS04009");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs004ComBodyReqVO.getTermGubun(), 20, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS04010");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs004ComBodyReqVO.getDateFrom(), 20, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS04011");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs004ComBodyReqVO.getDateTo(), 20, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS04012");
		return null;
	}

	public IfErrMobResVO validateCs004Res(IfCs004MobReqVO ifCs004MobReqVO, IfCs004MobResVO ifCs004MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs004MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCs004MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateCs005Req(IfCs005MobReqVO ifCs005MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs005MobReqVO.getRequest().getHeader();
		IfCs005ComBodyReqVO ifCs005ComBodyReqVO = ifCs005MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifCs005ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS05001");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs005ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS05002");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs005ComBodyReqVO.getMainCode(), 3, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS05003");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs005ComBodyReqVO.getUid(), 50, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS05004");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs005ComBodyReqVO.getCsNo(), 20, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS05005");
		return null;
	}

	public IfErrMobResVO validateCs005Res(IfCs005MobReqVO ifCs005MobReqVO, IfCs005MobResVO ifCs005MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs005MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCs005MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateCs006Req(IfCs006MobReqVO ifCs006MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs006MobReqVO.getRequest().getHeader();
		IfCs006ComBodyReqVO ifCs006ComBodyReqVO = ifCs006MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifCs006ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS06001");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs006ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS06002");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs006ComBodyReqVO.getPageCnt(), 5, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS06003");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs006ComBodyReqVO.getPageNo(), 5, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS06004");
		return null;
	}

	public IfErrMobResVO validateCs006Res(IfCs006MobReqVO ifCs006MobReqVO, IfCs006MobResVO ifCs006MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs006MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCs006MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateCs007Req(IfCs007MobReqVO ifCs007MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs007MobReqVO.getRequest().getHeader();
		IfCs007ComBodyReqVO ifCs007ComBodyReqVO = ifCs007MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifCs007ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS07001");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs007ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS07002");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs007ComBodyReqVO.getCmd(), 3, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS07003");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs007ComBodyReqVO.getCsNo(), 20, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS07004");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs007ComBodyReqVO.getaSubject(), 200, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS07005");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs007ComBodyReqVO.getaContents(), 8000, "O"))return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS07006");
		return null;
	}

	public IfErrMobResVO validateCs007Res(IfCs007MobReqVO ifCs007MobReqVO, IfCs007MobResVO ifCs007MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs007MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCs007MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateCs008Req(IfCs008MobReqVO ifCs008MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs008MobReqVO.getRequest().getHeader();
		IfCs008ComBodyReqVO ifCs008ComBodyReqVO = ifCs008MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifCs008ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS08001");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs008ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS08002");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs008ComBodyReqVO.getPageCnt(), 5, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS08003");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs008ComBodyReqVO.getPageNo(), 5, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS08004");
		return null;
	}

	public IfErrMobResVO validateCs008Res(IfCs008MobReqVO ifCs008MobReqVO, IfCs008MobResVO ifCs008MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs008MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCs008MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateCs009Req(IfCs009MobReqVO ifCs009MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs009MobReqVO.getRequest().getHeader();
		IfCs009ComBodyReqVO ifCs009ComBodyReqVO = ifCs009MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifCs009ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS09001");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs009ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS09002");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs009ComBodyReqVO.getPageCnt(), 5, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS09003");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs009ComBodyReqVO.getPageNo(), 5, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS09004");
		return null;
	}

	public IfErrMobResVO validateCs009Res(IfCs009MobReqVO ifCs009MobReqVO, IfCs009MobResVO ifCs009MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs009MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCs009MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateCs010Req(IfCs010MobReqVO ifCs010MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs010MobReqVO.getRequest().getHeader();
		IfCs010ComBodyReqVO ifCs010ComBodyReqVO = ifCs010MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifCs010ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS10001");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs010ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS10002");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs010ComBodyReqVO.getCsNo(), 20, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS10003");
		return null;
	}

	public IfErrMobResVO validateCs010Res(IfCs010MobReqVO ifCs010MobReqVO, IfCs010MobResVO ifCs010MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs010MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCs010MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateCs011Req(IfCs011MobReqVO ifCs011MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs011MobReqVO.getRequest().getHeader();
		IfCs011ComBodyReqVO ifCs011ComBodyReqVO = ifCs011MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifCs011ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS11001");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs011ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS11002");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs011ComBodyReqVO.getCmd(), 3, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS11003");
		if(ifCs011ComBodyReqVO.getCsList() != null && ifCs011ComBodyReqVO.getCsList().size() > 0) {
			if (commonService.isEmptyOrMaxLengthOver(ifCs011ComBodyReqVO.getCsList().get(0).getCsNo(), 20, "O"))			return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS11004");
			else if (commonService.isEmptyOrMaxLengthOver(ifCs011ComBodyReqVO.getCsList().get(0).getaSubject(), 200, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS11005");
			else if (commonService.isEmptyOrMaxLengthOver(ifCs011ComBodyReqVO.getCsList().get(0).getaContents(), 8000, "O"))return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS11006");
		}
		return null;
	}

	public IfErrMobResVO validateCs011Res(IfCs011MobReqVO ifCs011MobReqVO, IfCs011MobResVO ifCs011MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs011MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCs011MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateCs012Req(IfCs012MobReqVO ifCs012MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs012MobReqVO.getRequest().getHeader();
		IfCs012ComBodyReqVO ifCs012ComBodyReqVO = ifCs012MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifCs012ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS12001");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs012ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS12002");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs012ComBodyReqVO.getPageCnt(), 5, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS12003");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs012ComBodyReqVO.getPageNo(), 5, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS12004");
		return null;
	}

	public IfErrMobResVO validateCs012Res(IfCs012MobReqVO ifCs012MobReqVO, IfCs012MobResVO ifCs012MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs012MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCs012MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}

	public IfErrMobResVO validateCs013Req(IfCs013MobReqVO ifCs013MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs013MobReqVO.getRequest().getHeader();
		IfCs013ComBodyReqVO ifCs013ComBodyReqVO = ifCs013MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifCs013ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS13001");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs013ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS13002");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs013ComBodyReqVO.getMainCode(), 3, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS13003");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs013ComBodyReqVO.getUid(), 50, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS13004");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs013ComBodyReqVO.getCsNo(), 20, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS13005");
		return null;
	}

	public IfErrMobResVO validateCs013Res(IfCs013MobReqVO ifCs013MobReqVO, IfCs013MobResVO ifCs013MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs013MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCs013MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateCs014Req(IfCs014MobReqVO ifCs014MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs014MobReqVO.getRequest().getHeader();
		IfCs014ComBodyReqVO ifCs014ComBodyReqVO = ifCs014MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifCs014ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS14001");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs014ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS14002");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs014ComBodyReqVO.getMainCode(), 3, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS14003");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs014ComBodyReqVO.getUid(), 50, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS14004");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs014ComBodyReqVO.getCsNo(), 50, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS14005");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs014ComBodyReqVO.getCmd(), 3, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS14006");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs014ComBodyReqVO.getCsState(), 2, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS14007");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs014ComBodyReqVO.getaSubject(), 200, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS14008");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs014ComBodyReqVO.getaContents(), 8000, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS14009");
		return null;
	}

	public IfErrMobResVO validateCs014Res(IfCs014MobReqVO ifCs014MobReqVO, IfCs014MobResVO ifCs014MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs014MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCs014MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateCs015Req(IfCs015MobReqVO ifCs015MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs015MobReqVO.getRequest().getHeader();
		IfCs015ComBodyReqVO ifCs015ComBodyReqVO = ifCs015MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifCs015ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS15001");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs015ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS15002");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs015ComBodyReqVO.getMainCode(), 3, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS15003");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs015ComBodyReqVO.getUid(), 50, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS15004");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs015ComBodyReqVO.getCsNo(), 20, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS15005");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs015ComBodyReqVO.getCmd(), 3, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS15006");
		else if (commonService.isEmptyOrMaxLengthOver(ifCs015ComBodyReqVO.getReceiveYn(), 1, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "CS15007");
		return null;
	}

	public IfErrMobResVO validateCs015Res(IfCs015MobReqVO ifCs015MobReqVO, IfCs015MobResVO ifCs015MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifCs015MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifCs015MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
}