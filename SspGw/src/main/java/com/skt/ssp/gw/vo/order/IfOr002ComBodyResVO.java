package com.skt.ssp.gw.vo.order;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfOr002ComBodyResVO (IfOr002ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfOr002ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfOr002ComBodyResVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String mainCode		= "";
	private String mainName		= "";
	private String mImgUrl		= "";
	private String uid			= "";
	private String jumunNo		= "";
	private String jumunDate	= "";
	private String oName		= "";
	private String oTel			= "";
	private String oHp			= "";
	private String oAmt			= "";
	private String kAmt			= "";
	private String oState		= "";
	private String csMsg		= "";
	private List<IfOr002ComBodyGoodsResVO> goodsList;
	private List<IfOr002ComBodyBeaResVO> beaList;
	private IfOr002ComBodyJengSanResVO jengSan;
	private List<IfOr002ComBodyClaimInfoResVO> claimInfoList;
	
	public IfOr002ComBodyResVO() {
		super();
	}

	public String getAdminCode() {
		return adminCode;
	}

	public String getUserId() {
		return userId;
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

	public String getJumunNo() {
		return jumunNo;
	}

	public String getJumunDate() {
		return jumunDate;
	}

	public String getoName() {
		return oName;
	}

	public String getoTel() {
		return oTel;
	}

	public String getoHp() {
		return oHp;
	}

	public String getoAmt() {
		return oAmt;
	}

	public String getkAmt() {
		return kAmt;
	}

	public String getoState() {
		return oState;
	}

	public String getCsMsg() {
		return csMsg;
	}

	public List<IfOr002ComBodyGoodsResVO> getGoodsList() {
		return goodsList;
	}

	public List<IfOr002ComBodyBeaResVO> getBeaList() {
		return beaList;
	}

	public IfOr002ComBodyJengSanResVO getJengSan() {
		return jengSan;
	}

	public List<IfOr002ComBodyClaimInfoResVO> getClaimInfoList() {
		return claimInfoList;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public void setJumunNo(String jumunNo) {
		this.jumunNo = jumunNo;
	}

	public void setJumunDate(String jumunDate) {
		this.jumunDate = jumunDate;
	}

	public void setoName(String oName) {
		this.oName = oName;
	}

	public void setoTel(String oTel) {
		this.oTel = oTel;
	}

	public void setoHp(String oHp) {
		this.oHp = oHp;
	}

	public void setoAmt(String oAmt) {
		this.oAmt = oAmt;
	}

	public void setkAmt(String kAmt) {
		this.kAmt = kAmt;
	}

	public void setoState(String oState) {
		this.oState = oState;
	}

	public void setCsMsg(String csMsg) {
		this.csMsg = csMsg;
	}

	public void setGoodsList(List<IfOr002ComBodyGoodsResVO> goodsList) {
		this.goodsList = goodsList;
	}

	public void setBeaList(List<IfOr002ComBodyBeaResVO> beaList) {
		this.beaList = beaList;
	}

	public void setJengSan(IfOr002ComBodyJengSanResVO jengSan) {
		this.jengSan = jengSan;
	}

	public void setClaimInfoList(List<IfOr002ComBodyClaimInfoResVO> claimInfoList) {
		this.claimInfoList = claimInfoList;
	}

}