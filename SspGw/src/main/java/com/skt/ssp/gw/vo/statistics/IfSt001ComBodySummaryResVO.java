package com.skt.ssp.gw.vo.statistics;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfSt001ComBodySummaryResVO (IfSt001ComBodySummaryResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSt001ComBodySummaryResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSt001ComBodySummaryResVO extends BaseVO {
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

	public IfSt001ComBodySummaryResVO() {
		super();
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

}