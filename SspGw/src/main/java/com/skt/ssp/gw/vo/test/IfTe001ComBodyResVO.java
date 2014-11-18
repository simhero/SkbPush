package com.skt.ssp.gw.vo.test;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfTe001ComBodyRes VO (IfTe001ComBodyResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfTe001ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfTe001ComBodyResVO extends BaseVO {
	private String out = "";
	private List<IfTe001ComBodyOrderResVO> orderList;

	public IfTe001ComBodyResVO() {
		super();
		this.out = "";
	}

	public String getOut() {
		return out;
	}

	public List<IfTe001ComBodyOrderResVO> getOrderList() {
		return orderList;
	}

	public void setOut(String out) {
		this.out = out;
	}

	public void setOrderList(List<IfTe001ComBodyOrderResVO> orderList) {
		this.orderList = orderList;
	}

}