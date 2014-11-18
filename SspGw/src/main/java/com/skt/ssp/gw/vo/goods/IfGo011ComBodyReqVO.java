package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo011ComBodyReqVO (IfGo011ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo011ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo011ComBodyReqVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String gJcode		= "";

	public IfGo011ComBodyReqVO() {
		super();
	}

	public String getAdminCode() {
		return adminCode;
	}

	public String getUserId() {
		return userId;
	}

	public String getgJcode() {
		return gJcode;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setgJcode(String gJcode) {
		this.gJcode = gJcode;
	}

}