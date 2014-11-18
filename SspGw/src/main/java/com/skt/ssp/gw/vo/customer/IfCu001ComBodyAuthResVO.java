package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCu001ComBodyRes VO (IfCu001ComBodyResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu001ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu001ComBodyAuthResVO extends BaseVO {
	private String menuItem		= "";
	private String authority	= "";
	
	public IfCu001ComBodyAuthResVO() {
		super();
	}

	public String getMenuItem() {
		return menuItem;
	}

	public String getAuthority() {
		return authority;
	}

	public void setMenuItem(String menuItem) {
		this.menuItem = menuItem;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
