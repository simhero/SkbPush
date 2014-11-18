package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCu006ComBodyReq VO (IfCu006ComBodyReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu006ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu006ComBodyReqVO extends BaseVO {
	private String adminCode = "";
	private String userId = "";
	private String pushID = "";

	public IfCu006ComBodyReqVO() {
		super();
		this.adminCode = "";
		this.userId = "";
		this.pushID = "";
	}

	public String getAdminCode() {
		return adminCode;
	}

	public String getUserId() {
		return userId;
	}

	public String getPushID() {
		return pushID;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPushID(String pushID) {
		this.pushID = pushID;
	}

}
