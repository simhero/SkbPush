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
import com.skt.ssp.gw.vo.statistics.IfSt001ComBodyReqVO;
import com.skt.ssp.gw.vo.statistics.IfSt001MobReqVO;
import com.skt.ssp.gw.vo.statistics.IfSt001MobResVO;
import com.skt.ssp.gw.vo.statistics.IfSt002ComBodyReqVO;
import com.skt.ssp.gw.vo.statistics.IfSt002MobReqVO;
import com.skt.ssp.gw.vo.statistics.IfSt002MobResVO;

/**
 * StatisticsValidator (StatisticsValidator)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: StatisticsValidator.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Component
public class StatisticsValidator {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public StatisticsValidator() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}
	
	public IfErrMobResVO validateStatistics001Req(IfSt001MobReqVO ifSt001MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifSt001MobReqVO.getRequest().getHeader();
		IfSt001ComBodyReqVO ifSt001ComBodyReqVO = ifSt001MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifSt001ComBodyReqVO.getAdminCode(), 50, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "ST01001");
		else if (commonService.isEmptyOrMaxLengthOver(ifSt001ComBodyReqVO.getUserId(), 50, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "ST01002");
		else if (commonService.isEmptyOrMaxLengthOver(ifSt001ComBodyReqVO.getMainCode(), 3, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "ST01003");
		else if (commonService.isEmptyOrMaxLengthOver(ifSt001ComBodyReqVO.getSearchGubun(), 20, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "ST01005");
		else if (commonService.isEmptyOrMaxLengthOver(ifSt001ComBodyReqVO.getDateFrom(), 20, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "ST01006");
		else if (commonService.isEmptyOrMaxLengthOver(ifSt001ComBodyReqVO.getDateTo(), 20, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "ST01007");
		else if (commonService.isEmptyOrMaxLengthOver(ifSt001ComBodyReqVO.getPageCnt(), 5, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "ST01008");
		else if (commonService.isEmptyOrMaxLengthOver(ifSt001ComBodyReqVO.getPageNo(), 5, "M"))			return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "ST01009");
		else if (commonService.isEmptyOrMaxLengthOver(ifSt001ComBodyReqVO.getgName(), 200, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "ST01010");
		return null;
	}

	public IfErrMobResVO validateStatistics001Res(IfSt001MobReqVO ifSt001MobReqVO, IfSt001MobResVO ifSt001MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifSt001MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifSt001MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateStatistics002Req(IfSt002MobReqVO ifSt002MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifSt002MobReqVO.getRequest().getHeader();
		IfSt002ComBodyReqVO ifSt002ComBodyReqVO = ifSt002MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifSt002ComBodyReqVO.getAdminCode(), 50, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "ST02001");
		else if (commonService.isEmptyOrMaxLengthOver(ifSt002ComBodyReqVO.getUserId(), 50, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "ST02002");
		return null;
	}

	public IfErrMobResVO validateStatistics002Res(IfSt002MobReqVO ifSt002MobReqVO, IfSt002MobResVO ifSt002MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifSt002MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifSt002MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}

}