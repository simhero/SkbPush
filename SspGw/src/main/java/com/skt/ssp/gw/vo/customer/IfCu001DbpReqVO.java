package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCu001DbpReq VO (IfCu001DbpReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu001DbpReqVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu001DbpReqVO extends BaseVO {
	private IfCu001DbpDataReqVO request;

	public IfCu001DbpReqVO() {
		super();
	}

	public IfCu001DbpDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCu001DbpDataReqVO request) {
		this.request = request;
	}



}