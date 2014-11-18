package com.skt.ssp.gw.vo.customer;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfTe001ComBodyRes VO (IfTe001ComBodyResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfTe001ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu004ComBodyResVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private List<IfCu004ComBodyMarketResVO> marketList;

	public IfCu004ComBodyResVO() {
		super();
		this.adminCode	= "";
		this.userId		= "";
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

	public List<IfCu004ComBodyMarketResVO> getMarketList() {
		return marketList;
	}

	public void setMarketList(List<IfCu004ComBodyMarketResVO> marketList) {
		this.marketList = marketList;
	}

}