package com.skt.ssp.gw.vo.test;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfTe001ComBodyOrderReq VO (IfTe001ComBodyOrderReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfTe001ComBodyOrderReqVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfTe001ComBodyOrderReqVO extends BaseVO {
	private String orderId = "";

	public IfTe001ComBodyOrderReqVO() {
		super();
		this.orderId = "";
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

}