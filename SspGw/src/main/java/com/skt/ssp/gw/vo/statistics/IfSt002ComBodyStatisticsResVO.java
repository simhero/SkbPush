package com.skt.ssp.gw.vo.statistics;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfSt002ComBodyStatisticsResVO (IfSt002ComBodyStatisticsResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSt002ComBodyStatisticsResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSt002ComBodyStatisticsResVO extends BaseVO {
	private String categoryName		= "";
	private String visitorCnt		= "";
	private String orderCnt			= "";
	private String goodsCnt				= "";
	private String salePrice		= "";
	private String conversionFactor	= "";
	private List<IfSt002ComBodyDataResVO> dataList;

	public IfSt002ComBodyStatisticsResVO() {
		super();
	}

	public String getCategoryName() {
		return categoryName;
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

	public List<IfSt002ComBodyDataResVO> getDataList() {
		return dataList;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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

	public void setDataList(List<IfSt002ComBodyDataResVO> dataList) {
		this.dataList = dataList;
	}
}