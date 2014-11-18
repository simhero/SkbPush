package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCu001DbpReq VO (IfCu001DbpReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu001DbpReqVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu007DbpReqVO extends BaseVO {
	private IfCu007DbpDataReqVO request;

	public IfCu007DbpReqVO() {
		super();
	}

	public IfCu007DbpDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCu007DbpDataReqVO request) {
		this.request = request;
	}



}