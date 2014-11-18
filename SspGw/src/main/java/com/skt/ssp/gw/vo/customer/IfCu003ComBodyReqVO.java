package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCu003ComBodyReq VO (IfCu003ComBodyReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu003ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu003ComBodyReqVO extends BaseVO {
	private String adminCode = "";
	private String userId = "";
	private String cmd = "";
	private String cmdValue = "";
	private String phoneNum = "";

	public IfCu003ComBodyReqVO() {
		super();
		this.adminCode = "";
		this.userId = "";
		this.cmd = "";
		this.cmdValue = "";
		this.phoneNum = "";
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

	public String getCmdValue() {
		return cmdValue;
	}

	public String getPhoneNum() {
		return phoneNum;
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

	public void setCmdValue(String cmdValue) {
		this.cmdValue = cmdValue;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

}
