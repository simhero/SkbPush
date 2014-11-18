package com.skt.ssp.gw.vo.test;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfTe001ComBodyReq VO (IfTe001ComBodyReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfTe001ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfTe001ComBodyReqVO extends BaseVO {
	private String out = "";
	private List<IfTe001ComBodyOrderReqVO> orderList;

	public IfTe001ComBodyReqVO() {
		super();
		this.out = "";
	}

	public String getOut() {
		return out;
	}

	public List<IfTe001ComBodyOrderReqVO> getOrderList() {
		return orderList;
	}

	public void setOut(String out) {
		this.out = out;
	}

	public void setOrderList(List<IfTe001ComBodyOrderReqVO> orderList) {
		this.orderList = orderList;
	}

}