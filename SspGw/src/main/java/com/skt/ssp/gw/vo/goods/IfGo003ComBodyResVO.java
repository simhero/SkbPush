package com.skt.ssp.gw.vo.goods;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo003ComBodyResVO (IfGo003ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo003ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo003ComBodyResVO extends BaseVO {
	private List<IfGo003ComBodyGoodsResVO> goodsList;

	public IfGo003ComBodyResVO() {
		super();
	}

	public List<IfGo003ComBodyGoodsResVO> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<IfGo003ComBodyGoodsResVO> goodsList) {
		this.goodsList = goodsList;
	}

}