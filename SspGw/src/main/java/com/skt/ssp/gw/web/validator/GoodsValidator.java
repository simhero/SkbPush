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
import com.skt.ssp.gw.vo.goods.IfGo001ComBodyReqVO;
import com.skt.ssp.gw.vo.goods.IfGo001MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo001MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo002ComBodyReqVO;
import com.skt.ssp.gw.vo.goods.IfGo002MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo002MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo003ComBodyReqVO;
import com.skt.ssp.gw.vo.goods.IfGo003MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo003MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo004ComBodyReqVO;
import com.skt.ssp.gw.vo.goods.IfGo004MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo004MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo0051ComBodyReqVO;
import com.skt.ssp.gw.vo.goods.IfGo0051MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo0051MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo005ComBodyReqVO;
import com.skt.ssp.gw.vo.goods.IfGo005MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo005MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo006ComBodyReqVO;
import com.skt.ssp.gw.vo.goods.IfGo006MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo006MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo007ComBodyReqVO;
import com.skt.ssp.gw.vo.goods.IfGo007MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo007MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo008ComBodyReqVO;
import com.skt.ssp.gw.vo.goods.IfGo008MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo008MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo009ComBodyReqVO;
import com.skt.ssp.gw.vo.goods.IfGo009MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo009MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo010ComBodyReqVO;
import com.skt.ssp.gw.vo.goods.IfGo010MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo010MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo011ComBodyReqVO;
import com.skt.ssp.gw.vo.goods.IfGo011MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo011MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo012ComBodyReqVO;
import com.skt.ssp.gw.vo.goods.IfGo012MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo012MobResVO;

/**
 * GoodsValidator (GoodsValidator)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: GoodsValidator.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Component
public class GoodsValidator {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public GoodsValidator() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}

	public IfErrMobResVO validateGoods001Req(IfGo001MobReqVO ifGo001MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifGo001MobReqVO.getRequest().getHeader();
		IfGo001ComBodyReqVO ifGo001ComBodyReqVO = ifGo001MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifGo001ComBodyReqVO.getAdminCode(), 50, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO01001");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo001ComBodyReqVO.getUserId(), 50, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO01002");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo001ComBodyReqVO.getMainCode(), 3, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO01003");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo001ComBodyReqVO.getPageCnt(), 5, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO01005");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo001ComBodyReqVO.getPageNo(), 5, "M"))			return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO01006");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo001ComBodyReqVO.getSearchGubun(), 20, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO01007");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo001ComBodyReqVO.getSearchWord(), 100, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO01008");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo001ComBodyReqVO.getStts(), 2, "M"))			return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO01009");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo001ComBodyReqVO.getgPqtyGubun(), 3, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO01010");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo001ComBodyReqVO.getTermGubun(), 20, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO01011");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo001ComBodyReqVO.getDateFrom(), 20, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO01012");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo001ComBodyReqVO.getDateTo(), 20, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO01013");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo001ComBodyReqVO.getSafetyQtyYn(), 3, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO01014");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo001ComBodyReqVO.getUseWpriceYn(), 4, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO01015");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo001ComBodyReqVO.getOrderBy(), 20, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO01016");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo001ComBodyReqVO.getReSearchGubun(), 20, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO01017");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo001ComBodyReqVO.getReSearchWord(), 100, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO01018");
		return null;
	}

	public IfErrMobResVO validateGoods002Req(IfGo002MobReqVO ifGo002MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifGo002MobReqVO.getRequest().getHeader();
		IfGo002ComBodyReqVO ifGo002ComBodyReqVO = ifGo002MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifGo002ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO02001");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo002ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO02002");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo002ComBodyReqVO.getMainCode(), 3, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO02003");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo002ComBodyReqVO.getUid(), 50, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO02004");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo002ComBodyReqVO.getgJcode(), 20, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO02005");
		return null;
	}
	
	public IfErrMobResVO validateGoods003Req(IfGo003MobReqVO ifGo003MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifGo003MobReqVO.getRequest().getHeader();
		IfGo003ComBodyReqVO ifGo003ComBodyReqVO = ifGo003MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifGo003ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO03001");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo003ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO03002");
		else if (ifGo003ComBodyReqVO.getGoodsList() == null || ifGo003ComBodyReqVO.getGoodsList().size() == 0)	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO03015");
		else if (ifGo003ComBodyReqVO.getGoodsList() != null) {
			for(int i = 0; i < ifGo003ComBodyReqVO.getGoodsList().size(); i++) {
				if (commonService.isEmptyOrMaxLengthOver(ifGo003ComBodyReqVO.getGoodsList().get(i).getgJcode(), 50, "M"))				return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO03003");
				if (commonService.isEmptyOrMaxLengthOver(ifGo003ComBodyReqVO.getGoodsList().get(i).getMainCode(), 3, "M"))				return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO03004");
				if (commonService.isEmptyOrMaxLengthOver(ifGo003ComBodyReqVO.getGoodsList().get(i).getUid(), 50, "O"))					return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO03005");
				if (commonService.isEmptyOrMaxLengthOver(ifGo003ComBodyReqVO.getGoodsList().get(i).getCmd(), 3, "M"))					return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO03006");
				if (commonService.isEmptyOrMaxLengthOver(ifGo003ComBodyReqVO.getGoodsList().get(i).getUseWpriceYn(), 1, "O"))			return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO03007");
				if (commonService.isEmptyOrMaxLengthOver(ifGo003ComBodyReqVO.getGoodsList().get(i).getgWprice(), 10, "O"))				return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO03008");
				if (commonService.isEmptyOrMaxLengthOver(ifGo003ComBodyReqVO.getGoodsList().get(i).getgQty(), 10, "O"))					return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO03009");
				if (commonService.isEmptyOrMaxLengthOver(ifGo003ComBodyReqVO.getGoodsList().get(i).getSafetyQtyYn(), 1, "O"))			return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO03010");
				if (commonService.isEmptyOrMaxLengthOver(ifGo003ComBodyReqVO.getGoodsList().get(i).getSafetyQty(), 10, "O"))			return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO03011");
				if (commonService.isEmptyOrMaxLengthOver(ifGo003ComBodyReqVO.getGoodsList().get(i).getgPriceBatchUpdateYn(), 1, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO03012");
				if (commonService.isEmptyOrMaxLengthOver(ifGo003ComBodyReqVO.getGoodsList().get(i).getgPrice(), 10, "O"))				return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO03013");
				if (commonService.isEmptyOrMaxLengthOver(ifGo003ComBodyReqVO.getGoodsList().get(i).getStts(), 20, "O"))					return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO03014");
			}
		}
		return null;
	}
	
	public IfErrMobResVO validateGoods004Req(IfGo004MobReqVO ifGo004MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifGo004MobReqVO.getRequest().getHeader();
		IfGo004ComBodyReqVO ifGo004ComBodyReqVO = ifGo004MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifGo004ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO04001");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo004ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO04002");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo004ComBodyReqVO.getPageCnt(), 5, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO04003");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo004ComBodyReqVO.getPageNo(), 5, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO04004");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo004ComBodyReqVO.getgJcode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO04005");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo004ComBodyReqVO.getMainCode(), 3, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO04006");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo004ComBodyReqVO.getUid(), 50, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO04007");
		return null;
	}

	public IfErrMobResVO validateGoods005Req(IfGo005MobReqVO ifGo005MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifGo005MobReqVO.getRequest().getHeader();
		IfGo005ComBodyReqVO ifGo005ComBodyReqVO = ifGo005MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifGo005ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO05001");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo005ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO05002");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo005ComBodyReqVO.getGroupCode(), 8000, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO05003");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo005ComBodyReqVO.getCmd(), 3, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO05004");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo005ComBodyReqVO.getCmdValue(), 8000, "O"))return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO05005");
		return null;
	}
	
	public IfErrMobResVO validateGoods0051Req(IfGo0051MobReqVO ifGo0051MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifGo0051MobReqVO.getRequest().getHeader();
		IfGo0051ComBodyReqVO ifGo0051ComBodyReqVO = ifGo0051MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifGo0051ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO051001");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo0051ComBodyReqVO.getUserId(), 50, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO051002");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo0051ComBodyReqVO.getCmd(), 3, "M"))			return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO051003");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo0051ComBodyReqVO.getTargetGroupCode(), 3, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO051004");
		return null;
	}
	
	public IfErrMobResVO validateGoods006Req(IfGo006MobReqVO ifGo006MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifGo006MobReqVO.getRequest().getHeader();
		IfGo006ComBodyReqVO ifGo006ComBodyReqVO = ifGo006MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifGo006ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO06001");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo006ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO06002");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo006ComBodyReqVO.getPageCnt(), 5, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO06003");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo006ComBodyReqVO.getPageNo(), 5, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO06004");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo006ComBodyReqVO.getCmd(), 3, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO06005");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo006ComBodyReqVO.getCmdValue(), 50, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO06006");
		return null;
	}
	
	public IfErrMobResVO validateGoods007Req(IfGo007MobReqVO ifGo007MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifGo007MobReqVO.getRequest().getHeader();
		IfGo007ComBodyReqVO ifGo007ComBodyReqVO = ifGo007MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifGo007ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO07001");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo007ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO07002");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo007ComBodyReqVO.getPageCnt(), 5, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO07003");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo007ComBodyReqVO.getPageNo(), 5, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO07004");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo007ComBodyReqVO.getSearchGubun(), 3, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO07005");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo007ComBodyReqVO.getSearchWord(), 100, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO07006");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo007ComBodyReqVO.getOrderBy(), 3, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO07007");
		return null;
	}
	
	public IfErrMobResVO validateGoods008Req(IfGo008MobReqVO ifGo008MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifGo008MobReqVO.getRequest().getHeader();
		IfGo008ComBodyReqVO ifGo008ComBodyReqVO = ifGo008MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifGo008ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO08001");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo008ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO08002");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo008ComBodyReqVO.getgJcode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO08003");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo008ComBodyReqVO.getMainCode(), 3, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO08004");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo008ComBodyReqVO.getgB2bcode(), 50, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO08005");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo008ComBodyReqVO.getCmd(), 3, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO08006");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo008ComBodyReqVO.getKeyWord(), 100, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO08007");
		return null;
	}
	
	public IfErrMobResVO validateGoods009Req(IfGo009MobReqVO ifGo009MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifGo009MobReqVO.getRequest().getHeader();
		IfGo009ComBodyReqVO ifGo009ComBodyReqVO = ifGo009MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifGo009ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO09001");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo009ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO09002");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo009ComBodyReqVO.getgJcode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO09003");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo009ComBodyReqVO.getPageCnt(), 5, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO09004");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo009ComBodyReqVO.getPageNo(), 5, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO09005");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo009ComBodyReqVO.getOrderBy(), 3, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO09006");
		return null;
	}
	
	public IfErrMobResVO validateGoods010Req(IfGo010MobReqVO ifGo010MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifGo010MobReqVO.getRequest().getHeader();
		IfGo010ComBodyReqVO ifGo010ComBodyReqVO = ifGo010MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifGo010ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO10001");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo010ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO10002");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo010ComBodyReqVO.getgJcode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO10003");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo010ComBodyReqVO.getMainCode(), 3, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO10004");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo010ComBodyReqVO.getgB2bcode(), 50, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO10005");
		return null;
	}
	
	public IfErrMobResVO validateGoods011Req(IfGo011MobReqVO ifGo011MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifGo011MobReqVO.getRequest().getHeader();
		IfGo011ComBodyReqVO ifGo011ComBodyReqVO = ifGo011MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifGo011ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO11001");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo011ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO11002");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo011ComBodyReqVO.getgJcode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO11003");
		return null;
	}
	
	public IfErrMobResVO validateGoods012Req(IfGo012MobReqVO ifGo012MobReqVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifGo012MobReqVO.getRequest().getHeader();
		IfGo012ComBodyReqVO ifGo012ComBodyReqVO = ifGo012MobReqVO.getRequest().getBody();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderReq(ifHeaderMobReqVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		else if (commonService.isEmptyOrMaxLengthOver(ifGo012ComBodyReqVO.getAdminCode(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO12001");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo012ComBodyReqVO.getUserId(), 50, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO12002");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo012ComBodyReqVO.getPageCnt(), 5, "M"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO12003");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo012ComBodyReqVO.getPageNo(), 5, "M"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO12004");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo012ComBodyReqVO.getSearchGubun(), 3, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO12005");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo012ComBodyReqVO.getSearchWord(), 100, "O"))	return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO12006");
		else if (commonService.isEmptyOrMaxLengthOver(ifGo012ComBodyReqVO.getOrderBy(), 3, "O"))		return commonService.getMobErrorResponseMsg(ifHeaderMobReqVO, "GO12007");
		return null;
	}
	
	public IfErrMobResVO validateGoods001Res(IfGo001MobReqVO ifGo001MobReqVO, IfGo001MobResVO ifGo001MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifGo001MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifGo001MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateGoods002Res(IfGo002MobReqVO ifGo002MobReqVO, IfGo002MobResVO ifGo002MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifGo002MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifGo002MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateGoods003Res(IfGo003MobReqVO ifGo003MobReqVO, IfGo003MobResVO ifGo003MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifGo003MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifGo003MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateGoods004Res(IfGo004MobReqVO ifGo004MobReqVO, IfGo004MobResVO ifGo004MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifGo004MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifGo004MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateGoods005Res(IfGo005MobReqVO ifGo005MobReqVO, IfGo005MobResVO ifGo005MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifGo005MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifGo005MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateGoods0051Res(IfGo0051MobReqVO ifGo0051MobReqVO, IfGo0051MobResVO ifGo0051MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifGo0051MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifGo0051MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateGoods006Res(IfGo006MobReqVO ifGo006MobReqVO, IfGo006MobResVO ifGo006MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifGo006MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifGo006MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateGoods007Res(IfGo007MobReqVO ifGo007MobReqVO, IfGo007MobResVO ifGo007MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifGo007MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifGo007MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateGoods008Res(IfGo008MobReqVO ifGo008MobReqVO, IfGo008MobResVO ifGo008MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifGo008MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifGo008MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateGoods009Res(IfGo009MobReqVO ifGo009MobReqVO, IfGo009MobResVO ifGo009MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifGo009MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifGo009MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateGoods010Res(IfGo010MobReqVO ifGo010MobReqVO, IfGo010MobResVO ifGo010MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifGo010MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifGo010MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateGoods011Res(IfGo011MobReqVO ifGo011MobReqVO, IfGo011MobResVO ifGo011MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifGo011MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifGo011MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
	public IfErrMobResVO validateGoods012Res(IfGo012MobReqVO ifGo012MobReqVO, IfGo012MobResVO ifGo012MobResVO) {
		IfHeaderMobReqVO ifHeaderMobReqVO = ifGo012MobReqVO.getRequest().getHeader();
		IfHeaderMobResVO ifHeaderMobResVO = ifGo012MobResVO.getResponse().getHeader();
		IfErrMobResVO ifErrMobResVO = commonService.validateMobHeaderRes(ifHeaderMobReqVO, ifHeaderMobResVO);
		if (ifErrMobResVO != null) return ifErrMobResVO;
		return null;
	}
	
}