package com.skt.ssp.gw.vo.statistics;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfSt002ComBodySummaryResVO (IfSt002ComBodySummaryResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSt002ComBodySummaryResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSt002ComBodySummaryResVO extends BaseVO {
	private String visitorCnt			= "";
	private String orderCnt				= "";
	private String goodsCnt				= "";
	private String salePrice			= "";
	private String conversionFactor		= "";

	public IfSt002ComBodySummaryResVO() {
		super();
	}

	public String getVisitorCnt() {
		return visitorCnt;
	}

	public String getOrderCnt() {
		return orderCnt;
	}

	public String getGoodsCnt() {
		return goodsCnt;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public String getConversionFactor() {
		return conversionFactor;
	}

	public void setVisitorCnt(String visitorCnt) {
		this.visitorCnt = visitorCnt;
	}

	public void setOrderCnt(String orderCnt) {
		this.orderCnt = orderCnt;
	}

	public void setGoodsCnt(String goodsCnt) {
		this.goodsCnt = goodsCnt;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	public void setConversionFactor(String conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

}