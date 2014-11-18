package com.skt.ssp.gw.vo.order;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfOr001ComBodyResVO (IfOr001ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfOr001ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfOr001ComBodyResVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String orderCnt		= "";
	private List<IfOr001ComBodyOrderResVO> orderList;

	public IfOr001ComBodyResVO() {
		super();
	}

	public String getAdminCode() {
		return adminCode;
	}

	public String getUserId() {
		return userId;
	}

	public String getOrderCnt() {
		return orderCnt;
	}

	public List<IfOr001ComBodyOrderResVO> getOrderList() {
		return orderList;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setOrderCnt(String orderCnt) {
		this.orderCnt = orderCnt;
	}

	public void setOrderList(List<IfOr001ComBodyOrderResVO> orderList) {
		this.orderList = orderList;
	}

}