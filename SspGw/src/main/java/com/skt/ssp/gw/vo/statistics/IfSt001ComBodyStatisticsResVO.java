package com.skt.ssp.gw.vo.statistics;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfSt001ComBodyStatisticsResVO (IfSt001ComBodyStatisticsResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSt001ComBodyStatisticsResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSt001ComBodyStatisticsResVO extends BaseVO {
	private String categoryName		= "";
	private String salePrice		= "";
	private String saleQty			= "";
	private String calculatePrice	= "";
	private String calculateQty		= "";
	private String cancelPrice		= "";
	private String cancelQty		= "";
	private String exchangePrice	= "";
	private String exchangeQty		= "";
	private String takebackPrice	= "";
	private String takebackQty		= "";
	private List<IfSt001ComBodyDataResVO> dataList;
	
	public IfSt001ComBodyStatisticsResVO() {
		super();
	}

	public String getCategoryName() {
		return categoryName;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public String getSaleQty() {
		return saleQty;
	}

	public String getCalculatePrice() {
		return calculatePrice;
	}

	public String getCalculateQty() {
		return calculateQty;
	}

	public String getCancelPrice() {
		return cancelPrice;
	}

	public String getCancelQty() {
		return cancelQty;
	}

	public String getExchangePrice() {
		return exchangePrice;
	}

	public String getExchangeQty() {
		return exchangeQty;
	}

	public String getTakebackPrice() {
		return takebackPrice;
	}

	public String getTakebackQty() {
		return takebackQty;
	}

	public List<IfSt001ComBodyDataResVO> getDataList() {
		return dataList;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	public void setSaleQty(String saleQty) {
		this.saleQty = saleQty;
	}

	public void setCalculatePrice(String calculatePrice) {
		this.calculatePrice = calculatePrice;
	}

	public void setCalculateQty(String calculateQty) {
		this.calculateQty = calculateQty;
	}

	public void setCancelPrice(String cancelPrice) {
		this.cancelPrice = cancelPrice;
	}

	public void setCancelQty(String cancelQty) {
		this.cancelQty = cancelQty;
	}

	public void setExchangePrice(String exchangePrice) {
		this.exchangePrice = exchangePrice;
	}

	public void setExchangeQty(String exchangeQty) {
		this.exchangeQty = exchangeQty;
	}

	public void setTakebackPrice(String takebackPrice) {
		this.takebackPrice = takebackPrice;
	}

	public void setTakebackQty(String takebackQty) {
		this.takebackQty = takebackQty;
	}

	public void setDataList(List<IfSt001ComBodyDataResVO> dataList) {
		this.dataList = dataList;
	}

}