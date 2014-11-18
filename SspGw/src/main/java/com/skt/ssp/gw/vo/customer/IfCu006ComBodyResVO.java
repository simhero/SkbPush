package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCu006ComBodyRes VO (IfCu006ComBodyResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu006ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu006ComBodyResVO extends BaseVO {
	private String adminCode = "";
	private String userId = "";

	public IfCu006ComBodyResVO() {
		super();
		this.adminCode = "";
		this.userId = "";
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
