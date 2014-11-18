package com.skt.ssp.ih.vo.imageConvert;

import com.skt.ssp.ih.vo.BaseVO;

/**
 * IfIh003BodyResVO (IfIh003BodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfIh003BodyResVO.java,v 1.0 2011/10/31 00:00:00 ChoKyuJin Express $
 */
public class IfIh003BodyResVO extends BaseVO {
	private String transactionId	= "";
	private String adminCode		= "";
	private String resultCode		= "";
	private String resultMsg		= "";
	private String responseDate		= "";
	
	public IfIh003BodyResVO() {
		super();
	}

	public String getTransactionId() {
		return transactionId;
	}

	public String getAdminCode() {
		return adminCode;
	}

	public String getResultCode() {
		return resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public String getResponseDate() {
		return responseDate;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public void setResponseDate(String responseDate) {
		this.responseDate = responseDate;
	}

}