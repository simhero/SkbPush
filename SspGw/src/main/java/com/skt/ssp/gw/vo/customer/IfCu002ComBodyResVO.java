package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCu002ComBodyRes VO (IfCu002ComBodyResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu002ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu002ComBodyResVO extends BaseVO {
	private String adminCode = "";
	private String userId = "";

	public IfCu002ComBodyResVO() {
		super();
		this.adminCode = "";
		this.userId = "";
	}

	public String getAdminCode() {
		return adminCode;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
