package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs009ComBodyCsResVO (IfCs009ComBodyCsResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs009ComBodyCsResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs009ComBodyCsResVO extends BaseVO {
	private String csNo		= "";
	private String qSubject	= "";
	private String csDate	= "";
	private String csState	= "";

	public IfCs009ComBodyCsResVO() {
		super();
	}

	public String getCsNo() {
		return csNo;
	}

	public String getqSubject() {
		return qSubject;
	}

	public String getCsDate() {
		return csDate;
	}

	public String getCsState() {
		return csState;
	}

	public void setCsNo(String csNo) {
		this.csNo = csNo;
	}

	public void setqSubject(String qSubject) {
		this.qSubject = qSubject;
	}

	public void setCsDate(String csDate) {
		this.csDate = csDate;
	}

	public void setCsState(String csState) {
		this.csState = csState;
	}

}