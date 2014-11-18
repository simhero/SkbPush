package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCu005ComBodyRes VO (IfCu005ComBodyResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu005ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu003ComBodyResVO extends BaseVO {
	private String adminCode = "";
	private String userId = "";
	private String comName = "";
	private String userName = "";
	private String userPhone = "";
	private String userEmail = "";
	private String userLevel = "";
	private String userMasters = "";
	private String authValue = "";

	public IfCu003ComBodyResVO() {
		super();
		this.adminCode = "";
		this.userId = "";
		this.comName = "";
		this.userName = "";
		this.userPhone = "";
		this.userEmail = "";
		this.userLevel = "";
		this.userMasters = "";
		this.authValue = "";
	}

	public String getAdminCode() {
		return adminCode;
	}

	public String getUserId() {
		return userId;
	}

	public String getComName() {
		return comName;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public String getUserMasters() {
		return userMasters;
	}

	public String getAuthValue() {
		return authValue;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public void setUserMasters(String userMasters) {
		this.userMasters = userMasters;
	}

	public void setAuthValue(String authValue) {
		this.authValue = authValue;
	}

}
