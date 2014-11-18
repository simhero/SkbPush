package com.skt.ssp.gw.vo.order;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfOr003ComBodyReqVO (IfOr003ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfOr003ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfOr003ComBodyReqVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private List<IfOr003ComBodyOrderReqVO> orderList;

	public IfOr003ComBodyReqVO() {
		super();
	}

	public String getAdminCode() {
		return adminCode;
	}

	public String getUserId() {
		return userId;
	}

	public List<IfOr003ComBodyOrderReqVO> getOrderList() {
		return orderList;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setOrderList(List<IfOr003ComBodyOrderReqVO> orderList) {
		this.orderList = orderList;
	}

}