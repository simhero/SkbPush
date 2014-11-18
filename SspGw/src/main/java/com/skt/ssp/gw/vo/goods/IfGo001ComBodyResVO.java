package com.skt.ssp.gw.vo.goods;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo001ComBodyResVO (IfGo001ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo001ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo001ComBodyResVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String goodsCnt		= "";
	private List<IfGo001ComBodyGoodsResVO> goodsList;
	
	public IfGo001ComBodyResVO() {
		super();
		this.adminCode = "";
		this.userId = "";
		this.goodsCnt = "";
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
	
	public String getGoodsCnt() {
		return goodsCnt;
	}

	public void setGoodsCnt(String goodsCnt) {
		this.goodsCnt = goodsCnt;
	}

	public List<IfGo001ComBodyGoodsResVO> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<IfGo001ComBodyGoodsResVO> goodsList) {
		this.goodsList = goodsList;
	}
	
}
