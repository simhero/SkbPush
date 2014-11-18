package com.skt.ssp.gw.web.validator;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.vo.IfErrMobResVO;
import com.skt.ssp.gw.vo.IfHeaderMobReqVO;
import com.skt.ssp.gw.vo.test.IfTe001ComBodyReqVO;
import com.skt.ssp.gw.vo.test.IfTe001MobReqVO;

/**
 * TestValidator (TestValidator)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: TestValidator.java,v1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
@Component
public class TestValidator {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public TestValidator() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public IfErrMobResVO validateTest001(IfTe001MobReqVO ifTe001MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifTe001MobReqVO.getRequest().getHeader();
		IfTe001ComBodyReqVO ifTe001ComBodyReqVO = ifTe001MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		if (StringUtils.stripToEmpty(ifTe001ComBodyReqVO.getOut()).length() == 0) return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "Y01001");
		// To Do
		return null;
	}


}