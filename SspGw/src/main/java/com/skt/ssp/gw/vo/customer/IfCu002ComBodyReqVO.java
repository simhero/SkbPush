package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCu002ComBodyReq VO (IfCu002ComBodyReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu002ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu002ComBodyReqVO extends BaseVO {
	private String adminCode = "";
	private String userId = "";
	private String authValue = "";
	private String cmd = "";
	private String cmdValue = "";

	public IfCu002ComBodyReqVO() {
		super();
		this.adminCode = "";
		this.userId = "";
		this.authValue = "";
		this.cmd = "";
		this.cmdValue = "";
	}

	public String getAdminCode() {
		return adminCode;
	}

	public String getUserId() {
		return userId;
	}

	public String getAuthValue() {
		return authValue;
	}

	public String getCmd() {
		return cmd;
	}

	public String getCmdValue() {
		return cmdValue;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setAuthValue(String authValue) {
		this.authValue = authValue;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public void setCmdValue(String cmdValue) {
		this.cmdValue = cmdValue;
	}

}
