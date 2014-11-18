package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfTe001DbpReq VO (IfTe001DbpReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfTe001DbpReqVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu004DbpReqVO extends BaseVO {
	private IfCu004DbpDataReqVO request;

	public IfCu004DbpReqVO() {
		super();
	}

	public IfCu004DbpDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCu004DbpDataReqVO request) {
		this.request = request;
	}



}