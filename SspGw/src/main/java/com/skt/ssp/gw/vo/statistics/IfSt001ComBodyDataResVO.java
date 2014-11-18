package com.skt.ssp.gw.vo.statistics;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfSt001ComBodyDataResVO (IfSt001ComBodyDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSt001ComBodyDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSt001ComBodyDataResVO extends BaseVO {
	private String mainCode			= "";
	private String mainName			= "";
	private String mImgUrl			= "";
	private String uid				= "";
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

	public IfSt001ComBodyDataResVO() {
		super();
	}

	public String getMainCode() {
		return mainCode;
	}

	public String getMainName() {
		return mainName;
	}

	public String getmImgUrl() {
		return mImgUrl;
	}

	public String getUid() {
		return uid;
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

	public void setMainCode(String mainCode) {
		this.mainCode = mainCode;
	}

	public void setMainName(String mainName) {
		this.mainName = mainName;
	}

	public void setmImgUrl(String mImgUrl) {
		this.mImgUrl = mImgUrl;
	}

	public void setUid(String uid) {
		this.uid = uid;
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