package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs007ComBodyReqVO (IfCs007ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs007ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs007ComBodyReqVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String cmd			= "";
	private String csNo			= "";
	private String aSubject		= "";
	private String aContents	= "";

	public IfCs007ComBodyReqVO() {
		super();
	}

	public String getAdminCode() {
		return adminCode;
	}

	public String getUserId() {
		return userId;
	}

	public String getCmd() {
		return cmd;
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

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
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