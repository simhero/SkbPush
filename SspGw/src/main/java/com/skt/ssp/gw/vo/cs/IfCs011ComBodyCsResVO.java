package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs011ComBodyCsResVO (IfCs011ComBodyCsResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs011ComBodyCsResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs011ComBodyCsResVO extends BaseVO {
	private String csNo		= "";
	private String rsltCode	= "";
	private String rsltMsg	= "";
	
	public IfCs011ComBodyCsResVO() {
		super();
	}

	public String getCsNo() {
		return csNo;
	}

	public String getRsltCode() {
		return rsltCode;
	}

	public String getRsltMsg() {
		return rsltMsg;
	}

	public void setCsNo(String csNo) {
		this.csNo = csNo;
	}

	public void setRsltCode(String rsltCode) {
		this.rsltCode = rsltCode;
	}

	public void setRsltMsg(String rsltMsg) {
		this.rsltMsg = rsltMsg;
	}

}