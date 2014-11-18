package com.skt.ssp.gw.vo.push;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfPu003ComBodyResVO (IfPu003ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfPu003ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfPu003ComBodyResVO extends BaseVO {
	private String responseDate	= "";
	private String resultCode	= "";
	private String resultMsg	= "";

	public IfPu003ComBodyResVO() {
		super();
	}

	public String getResponseDate() {
		return responseDate;
	}

	public String getResultCode() {
		return resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResponseDate(String responseDate) {
		this.responseDate = responseDate;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

}