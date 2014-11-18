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
import com.skt.ssp.gw.vo.intro.IfIn001ComBodyReqVO;
import com.skt.ssp.gw.vo.intro.IfIn001MobReqVO;
import com.skt.ssp.gw.vo.intro.IfIn001MobResVO;
import com.skt.ssp.gw.vo.intro.IfIn002ComBodyReqVO;
import com.skt.ssp.gw.vo.intro.IfIn002MobReqVO;
import com.skt.ssp.gw.vo.intro.IfIn002MobResVO;

/**
 * IntroValidator (IntroValidator)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IntroValidator.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
@Component
public class IntroValidator {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public IntroValidator() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public IfErrMobResVO validateIntro001Req(IfIn001MobReqVO ifIn001MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifIn001MobReqVO.getRequest().getHeader();
		IfIn001ComBodyReqVO ifIn001ComBodyReqVO = ifIn001MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		if (commonService.isEmptyOrMaxLengthOver(ifIn001ComBodyReqVO.getMainCode(), 3, "M")) return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "IN01001");
		return null;
	}

	public IfErrMobResVO validateIntro002Req(IfIn002MobReqVO ifIn002MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifIn002MobReqVO.getRequest().getHeader();
		IfIn002ComBodyReqVO ifIn002ComBodyReqVO = ifIn002MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		if (commonService.isEmptyOrMaxLengthOver(ifIn002ComBodyReqVO.getcName(), 50, "M")) return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "IN02001");
		if (commonService.isEmptyOrMaxLengthOver(ifIn002ComBodyReqVO.getcHp(), 20, "M")) return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "IN02002");
		if (commonService.isEmptyOrMaxLengthOver(ifIn002ComBodyReqVO.getcQcontents(), 2000, "M")) return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "IN02003");
		return null;
	}

	public IfErrMobResVO validateIntro001Res(IfIn001MobReqVO ifIn001MobReqVO, IfIn001MobResVO ifIn001MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifIn001MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifIn001MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateIntro002Res(IfIn002MobReqVO ifIn002MobReqVO, IfIn002MobResVO ifIn002MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifIn002MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifIn002MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
}