package com.skt.ssp.gw.vo.customer;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCu006ComBodyRes VO (IfCu006ComBodyResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu006ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu007ComBodyResVO extends BaseVO {
	private String adminCode = "";
	private String userId = "";
	private String baseDate = "";
	private String saleBaseDate = "";
	private String goodsBaseDate = "";
	private String oCnt = "";
	private String oAmt = "";
	private String sAmt = "";
	private String gSaleCnt = "";
	private String gSaleReadyCnt = "";
	private String gStopCnt = "";
	private String gStopReadyCnt = "";
	private String oPaidCnt = "";
	private String oNewCnt = "";
	private String oShipCnt = "";
	private String oDeliCnt = "";
	private String oCanCnt = "";
	private String oCanedCnt = "";
	private String oRetCnt = "";
	private String oRetedCnt = "";
	private String oExcCnt = "";
	private String oExcedCnt = "";
	private String csNewCnt = "";
	private String csEmeCnt = "";
	private List<IfCu007ComBodyMarketResVO> marketList;
	private List<IfCu007ComBodyTagcomResVO> tagcomList;

	public IfCu007ComBodyResVO() {
		super();
	}

	public String getAdminCode() {
		return adminCode;
	}

	public String getUserId() {
		return userId;
	}

	public String getBaseDate() {
		return baseDate;
	}

	public String getSaleBaseDate() {
		return saleBaseDate;
	}

	public String getGoodsBaseDate() {
		return goodsBaseDate;
	}

	public String getoCnt() {
		return oCnt;
	}

	public String getoAmt() {
		return oAmt;
	}

	public String getsAmt() {
		return sAmt;
	}

	public String getgSaleCnt() {
		return gSaleCnt;
	}

	public String getgSaleReadyCnt() {
		return gSaleReadyCnt;
	}

	public String getgStopCnt() {
		return gStopCnt;
	}

	public String getgStopReadyCnt() {
		return gStopReadyCnt;
	}

	public String getoPaidCnt() {
		return oPaidCnt;
	}

	public String getoNewCnt() {
		return oNewCnt;
	}

	public String getoShipCnt() {
		return oShipCnt;
	}

	public String getoDeliCnt() {
		return oDeliCnt;
	}

	public String getoCanCnt() {
		return oCanCnt;
	}

	public String getoCanedCnt() {
		return oCanedCnt;
	}

	public String getoRetCnt() {
		return oRetCnt;
	}

	public String getoRetedCnt() {
		return oRetedCnt;
	}

	public String getoExcCnt() {
		return oExcCnt;
	}

	public String getoExcedCnt() {
		return oExcedCnt;
	}

	public String getCsNewCnt() {
		return csNewCnt;
	}

	public String getCsEmeCnt() {
		return csEmeCnt;
	}

	public List<IfCu007ComBodyMarketResVO> getMarketList() {
		return marketList;
	}

	public List<IfCu007ComBodyTagcomResVO> getTagcomList() {
		return tagcomList;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setBaseDate(String baseDate) {
		this.baseDate = baseDate;
	}

	public void setSaleBaseDate(String saleBaseDate) {
		this.saleBaseDate = saleBaseDate;
	}

	public void setGoodsBaseDate(String goodsBaseDate) {
		this.goodsBaseDate = goodsBaseDate;
	}

	public void setoCnt(String oCnt) {
		this.oCnt = oCnt;
	}

	public void setoAmt(String oAmt) {
		this.oAmt = oAmt;
	}

	public void setsAmt(String sAmt) {
		this.sAmt = sAmt;
	}

	public void setgSaleCnt(String gSaleCnt) {
		this.gSaleCnt = gSaleCnt;
	}

	public void setgSaleReadyCnt(String gSaleReadyCnt) {
		this.gSaleReadyCnt = gSaleReadyCnt;
	}

	public void setgStopCnt(String gStopCnt) {
		this.gStopCnt = gStopCnt;
	}

	public void setgStopReadyCnt(String gStopReadyCnt) {
		this.gStopReadyCnt = gStopReadyCnt;
	}

	public void setoPaidCnt(String oPaidCnt) {
		this.oPaidCnt = oPaidCnt;
	}

	public void setoNewCnt(String oNewCnt) {
		this.oNewCnt = oNewCnt;
	}

	public void setoShipCnt(String oShipCnt) {
		this.oShipCnt = oShipCnt;
	}

	public void setoDeliCnt(String oDeliCnt) {
		this.oDeliCnt = oDeliCnt;
	}

	public void setoCanCnt(String oCanCnt) {
		this.oCanCnt = oCanCnt;
	}

	public void setoCanedCnt(String oCanedCnt) {
		this.oCanedCnt = oCanedCnt;
	}

	public void setoRetCnt(String oRetCnt) {
		this.oRetCnt = oRetCnt;
	}

	public void setoRetedCnt(String oRetedCnt) {
		this.oRetedCnt = oRetedCnt;
	}

	public void setoExcCnt(String oExcCnt) {
		this.oExcCnt = oExcCnt;
	}

	public void setoExcedCnt(String oExcedCnt) {
		this.oExcedCnt = oExcedCnt;
	}

	public void setCsNewCnt(String csNewCnt) {
		this.csNewCnt = csNewCnt;
	}

	public void setCsEmeCnt(String csEmeCnt) {
		this.csEmeCnt = csEmeCnt;
	}

	public void setMarketList(List<IfCu007ComBodyMarketResVO> marketList) {
		this.marketList = marketList;
	}

	public void setTagcomList(List<IfCu007ComBodyTagcomResVO> tagcomList) {
		this.tagcomList = tagcomList;
	}

}
