package com.skt.ssp.gw.vo.goods;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo012ComBodyResVO (IfGo012ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo012ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo012ComBodyResVO extends BaseVO {
	private String totalCnt	= "";
	private List<IfGo012ComBodyMyPriceResVO> myPriceList;

	public IfGo012ComBodyResVO() {
		super();
	}

	public String getTotalCnt() {
		return totalCnt;
	}

	public List<IfGo012ComBodyMyPriceResVO> getMyPriceList() {
		return myPriceList;
	}

	public void setTotalCnt(String totalCnt) {
		this.totalCnt = totalCnt;
	}

	public void setMyPriceList(List<IfGo012ComBodyMyPriceResVO> myPriceList) {
		this.myPriceList = myPriceList;
	}

}