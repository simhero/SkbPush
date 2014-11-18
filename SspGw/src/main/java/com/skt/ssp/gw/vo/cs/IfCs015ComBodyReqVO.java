package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs015ComBodyReqVO (IfCs015ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs015ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs015ComBodyReqVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String mainCode		= "";
	private String uid			= "";
	private String csNo			= "";
	private String cmd			= "";
	private String receiveYn	= "";

	public IfCs015ComBodyReqVO() {
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

	public String getUid() {
		return uid;
	}

	public String getCsNo() {
		return csNo;
	}

	public String getCmd() {
		return cmd;
	}

	public String getReceiveYn() {
		return receiveYn;
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

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setCsNo(String csNo) {
		this.csNo = csNo;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public void setReceiveYn(String receiveYn) {
		this.receiveYn = receiveYn;
	}

}