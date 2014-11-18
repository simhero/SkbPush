package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCu001ComBodyReq VO (IfCu001ComBodyReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu001ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu008ComBodyReqVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String userPw		= "";
	private String newUserPw	= "";

	public IfCu008ComBodyReqVO() {
		super();
	}

	public String getAdminCode() {
		return adminCode;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public String getNewUserPw() {
		return newUserPw;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public void setNewUserPw(String newUserPw) {
		this.newUserPw = newUserPw;
	}

}
