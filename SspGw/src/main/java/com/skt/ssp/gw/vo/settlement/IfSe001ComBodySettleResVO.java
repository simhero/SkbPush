package com.skt.ssp.gw.vo.settlement;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfSe001ComBodySettleResVO (IfSe001ComBodySettleResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSe001ComBodySettleResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSe001ComBodySettleResVO extends BaseVO {
	private String mainCode	= "";
	private String mainName	= "";
	private String mImgUrl	= "";
	private String uid		= "";
	private String jumunNo	= "";
	private String jsDate	= "";
	private String jsPamt	= "";
	private String jsSamt	= "";
	private String jsJamt	= "";

	public IfSe001ComBodySettleResVO() {
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

}