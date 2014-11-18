package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo004ComBodyGoodsResVO (IfGo004ComBodyGoodsResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo004ComBodyGoodsResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo004ComBodyGoodsResVO extends BaseVO {
	private String regDate		= "";
	private String exeDate		= "";
	private String jobKind		= "";
	private String result		= "";
	private String gPrice		= "";
	private String regUser		= "";

	public IfGo004ComBodyGoodsResVO() {
		super();
		this.regDate		= "";
		this.exeDate		= "";
		this.jobKind		= "";
		this.result			= "";
		this.gPrice			= "";
		this.regUser		= "";
	}

	public String getRegDate() {
		return regDate;
	}

	public String getExeDate() {
		return exeDate;
	}

	public String getJobKind() {
		return jobKind;
	}

	public String getResult() {
		return result;
	}

	public String getgPrice() {
		return gPrice;
	}

	public String getRegUser() {
		return regUser;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public void setExeDate(String exeDate) {
		this.exeDate = exeDate;
	}

	public void setJobKind(String jobKind) {
		this.jobKind = jobKind;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setgPrice(String gPrice) {
		this.gPrice = gPrice;
	}

	public void setRegUser(String regUser) {
		this.regUser = regUser;
	}

}