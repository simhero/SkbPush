package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs010ComBodyResVO (IfCs010ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs010ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs010ComBodyResVO extends BaseVO {
	private String qSubject		= "";
	private String qContents	= "";
	private String csDate		= "";
	private String aSubject		= "";
	private String aContents	= "";
	private String aDate		= "";
	private String csState		= "";

	public IfCs010ComBodyResVO() {
		super();
	}

	public String getqSubject() {
		return qSubject;
	}

	public String getqContents() {
		return qContents;
	}

	public String getCsDate() {
		return csDate;
	}

	public String getaSubject() {
		return aSubject;
	}

	public String getaContents() {
		return aContents;
	}

	public String getaDate() {
		return aDate;
	}

	public String getCsState() {
		return csState;
	}

	public void setqSubject(String qSubject) {
		this.qSubject = qSubject;
	}

	public void setqContents(String qContents) {
		this.qContents = qContents;
	}

	public void setCsDate(String csDate) {
		this.csDate = csDate;
	}

	public void setaSubject(String aSubject) {
		this.aSubject = aSubject;
	}

	public void setaContents(String aContents) {
		this.aContents = aContents;
	}

	public void setaDate(String aDate) {
		this.aDate = aDate;
	}

	public void setCsState(String csState) {
		this.csState = csState;
	}

}