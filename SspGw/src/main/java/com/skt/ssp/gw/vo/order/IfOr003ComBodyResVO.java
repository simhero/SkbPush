package com.skt.ssp.gw.vo.order;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfOr003ComBodyResVO (IfOr003ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfOr003ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfOr003ComBodyResVO extends BaseVO {
	private List<IfOr003ComBodyOrderResVO> orderList;
	
	public IfOr003ComBodyResVO() {
		super();
	}

	public List<IfOr003ComBodyOrderResVO> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<IfOr003ComBodyOrderResVO> orderList) {
		this.orderList = orderList;
	}

}