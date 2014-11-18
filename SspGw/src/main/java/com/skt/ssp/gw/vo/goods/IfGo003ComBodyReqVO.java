package com.skt.ssp.gw.vo.goods;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo003ComBodyReqVO (IfGo003ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo003ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo003ComBodyReqVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private List<IfGo003ComBodyGoodsReqVO> goodsList;

	public IfGo003ComBodyReqVO() {
		super();
		this.adminCode	= "";
		this.userId		= "";
	}

	public String getAdminCode() {
		return adminCode;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<IfGo003ComBodyGoodsReqVO> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<IfGo003ComBodyGoodsReqVO> goodsList) {
		this.goodsList = goodsList;
	}

}