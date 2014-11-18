package com.skt.ssp.gw.vo.config;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCf003ComBodyReqVO (IfCf003ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCf003ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCf003ComBodyReqVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";

	public IfCf003ComBodyReqVO() {
		super();
	}

	public String getAdminCode() {
		return adminCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}