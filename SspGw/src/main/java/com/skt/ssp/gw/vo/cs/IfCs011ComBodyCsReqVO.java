package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs011ComBodyCsReqVO (IfCs011ComBodyCsReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs011ComBodyCsReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs011ComBodyCsReqVO extends BaseVO {
	private String csNo			= "";
	private String aSubject		= "";
	private String aContents	= "";

	public IfCs011ComBodyCsReqVO() {
		super();
	}

	public String getCsNo() {
		return csNo;
	}

	public String getaSubject() {
		return aSubject;
	}

	public String getaContents() {
		return aContents;
	}

	public void setCsNo(String csNo) {
		this.csNo = csNo;
	}

	public void setaSubject(String aSubject) {
		this.aSubject = aSubject;
	}

	public void setaContents(String aContents) {
		this.aContents = aContents;
	}

}