package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs002ComBodyReqVO (IfCs002ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs002ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs002ComBodyReqVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String mainCode		= "";
	private String uid			= "";
	private String csNo			= "";

	public IfCs002ComBodyReqVO() {
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

}