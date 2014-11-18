package com.skt.ssp.gw.vo.order;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfOr001ComBodyOrderResVO (IfOr001ComBodyOrderResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfOr001ComBodyOrderResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfOr001ComBodyOrderResVO extends BaseVO {
	private String mainCode		= "";
	private String mainName		= "";
	private String mImgUrl		= "";
	private String uid			= "";
	private String jumunNo		= "";
	private String jumunDate	= "";
	private String oName		= "";
	private String oHp			= "";
	private String gName		= "";
	private String oAmt			= "";
	private String oState		= "";
	
	public IfOr001ComBodyOrderResVO() {
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

	public String getJumunNo() {
		return jumunNo;
	}

	public String getJumunDate() {
		return jumunDate;
	}

	public String getoName() {
		return oName;
	}

	public String getoHp() {
		return oHp;
	}

	public String getgName() {
		return gName;
	}

	public String getoAmt() {
		return oAmt;
	}

	public String getoState() {
		return oState;
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

	public void setoHp(String oHp) {
		this.oHp = oHp;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public void setoAmt(String oAmt) {
		this.oAmt = oAmt;
	}

	public void setoState(String oState) {
		this.oState = oState;
	}

}