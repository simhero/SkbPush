package com.skt.ssp.gw.vo.goods;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo007ComBodyResVO (IfGo007ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo007ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo007ComBodyResVO extends BaseVO {
	private String priceCnt		= "";
	private String groupName	= "";
	private List<IfGo007ComBodyPriceResVO> priceList;

	public IfGo007ComBodyResVO() {
		super();
	}

	public String getPriceCnt() {
		return priceCnt;
	}

	public String getGroupName() {
		return groupName;
	}

	public List<IfGo007ComBodyPriceResVO> getPriceList() {
		return priceList;
	}

	public void setPriceCnt(String priceCnt) {
		this.priceCnt = priceCnt;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setPriceList(List<IfGo007ComBodyPriceResVO> priceList) {
		this.priceList = priceList;
	}

}