package com.skt.ssp.gw.vo;

/**
 * Auth VO (AuthVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: AuthVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Exp $
 */
public class AuthVO extends BaseVO {
	private String userId		= "";
	private String adminId		= "";
	private String loginId		= "";
	private String authKey		= "";
	private String authReqDate	= "";
	private String authUpdDate	= "";
	private String authHeader	= "";
	private String authBody		= "";
	private String pushNotiId	= "";
	private String registerDate	= "";
	private String registerId	= "";
	private String updateDate	= "";
	private String updateId		= "";
	
	public AuthVO() {}
	
	public AuthVO(String loginId, String authKey, String authReqDate) {
		super();
		this.loginId = loginId;
		this.authKey = authKey;
		this.authReqDate = authReqDate;
	}

	public AuthVO(String adminId, String loginId, String authKey,
			String authHeader, String authBody, String pushNotiId) {
		super();
		this.adminId = adminId;
		this.loginId = loginId;
		this.authKey = authKey;
		this.authHeader = authHeader;
		this.authBody = authBody;
		this.pushNotiId = pushNotiId;
	}

	public AuthVO(String userId, String adminId, String loginId,
			String authKey, String authReqDate, String authUpdDate,
			String authHeader, String authBody, String pushNotiId,
			String registerDate, String registerId, String updateDate,
			String updateId) {
		super();
		this.userId = userId;
		this.adminId = adminId;
		this.loginId = loginId;
		this.authKey = authKey;
		this.authReqDate = authReqDate;
		this.authUpdDate = authUpdDate;
		this.authHeader = authHeader;
		this.authBody = authBody;
		this.pushNotiId = pushNotiId;
		this.registerDate = registerDate;
		this.registerId = registerId;
		this.updateDate = updateDate;
		this.updateId = updateId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getAuthKey() {
		return authKey;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

	public String getAuthReqDate() {
		return authReqDate;
	}

	public void setAuthReqDate(String authReqDate) {
		this.authReqDate = authReqDate;
	}

	public String getAuthUpdDate() {
		return authUpdDate;
	}

	public void setAuthUpdDate(String authUpdDate) {
		this.authUpdDate = authUpdDate;
	}

	public String getAuthHeader() {
		return authHeader;
	}

	public void setAuthHeader(String authHeader) {
		this.authHeader = authHeader;
	}

	public String getAuthBody() {
		return authBody;
	}

	public void setAuthBody(String authBody) {
		this.authBody = authBody;
	}

	public String getPushNotiId() {
		return pushNotiId;
	}

	public void setPushNotiId(String pushNotiId) {
		this.pushNotiId = pushNotiId;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}
	
	
}
