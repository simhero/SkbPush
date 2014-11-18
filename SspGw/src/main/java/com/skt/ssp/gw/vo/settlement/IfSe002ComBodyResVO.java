package com.skt.ssp.gw.vo.settlement;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfSe002ComBodyResVO (IfSe002ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSe002ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSe002ComBodyResVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String mainCode		= "";
	private String mainName		= "";
	private String mImgUrl		= "";
	private String uid			= "";
	private String jumunNo		= "";
	private String jsDate		= "";
	private String jsPamt		= "";
	private String jsSamt		= "";
	private String jsJamt		= "";
	private List<IfSe002ComBodySettleResVO> settleList;

	public IfSe002ComBodyResVO() {
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

	public String getJsDate() {
		return jsDate;
	}

	public String getJsPamt() {
		return jsPamt;
	}

	public String getJsSamt() {
		return jsSamt;
	}

	public String getJsJamt() {
		return jsJamt;
	}

	public List<IfSe002ComBodySettleResVO> getSettleList() {
		return settleList;
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

	public void setJsDate(String jsDate) {
		this.jsDate = jsDate;
	}

	public void setJsPamt(String jsPamt) {
		this.jsPamt = jsPamt;
	}

	public void setJsSamt(String jsSamt) {
		this.jsSamt = jsSamt;
	}

	public void setJsJamt(String jsJamt) {
		this.jsJamt = jsJamt;
	}

	public void setSettleList(List<IfSe002ComBodySettleResVO> settleList) {
		this.settleList = settleList;
	}

}