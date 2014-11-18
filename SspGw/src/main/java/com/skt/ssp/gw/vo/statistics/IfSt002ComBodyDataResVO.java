package com.skt.ssp.gw.vo.statistics;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfSt002ComBodyDataResVO (IfSt002ComBodyDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSt002ComBodyDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSt002ComBodyDataResVO extends BaseVO {
	private String mainCode			= "";
	private String mainName			= "";
	private String mImgUrl			= "";
	private String uid				= "";
	private String visitorCnt		= "";
	private String orderCnt			= "";
	private String goodsCnt			= "";
	private String salePrice		= "";
	private String conversionFactor	= "";

	public IfSt002ComBodyDataResVO() {
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