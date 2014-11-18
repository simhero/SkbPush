package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCu001DbpReq VO (IfCu001DbpReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu001DbpReqVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu002DbpReqVO extends BaseVO {
	private IfCu002DbpDataReqVO request;

	public IfCu002DbpReqVO() {
		super();
	}

	public IfCu002DbpDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCu002DbpDataReqVO request) {
		this.request = request;
	}



}