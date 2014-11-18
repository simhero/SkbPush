package com.skt.ssp.gw.vo.customer;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCu001ComBodyRes VO (IfCu001ComBodyResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu001ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu001ComBodyResVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private List<IfCu001ComBodyAuthResVO> authList;
	
	public IfCu001ComBodyResVO() {
		super();
	}

	public String getAdminCode() {
		return adminCode;
	}

	public String getUserId() {
		return userId;
	}

	public List<IfCu001ComBodyAuthResVO> getAuthList() {
		return authList;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setAuthList(List<IfCu001ComBodyAuthResVO> authList) {
		this.authList = authList;
	}

}
