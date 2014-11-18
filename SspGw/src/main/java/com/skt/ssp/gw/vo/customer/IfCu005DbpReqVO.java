package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCu001DbpReq VO (IfCu001DbpReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu001DbpReqVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu005DbpReqVO extends BaseVO {
	private IfCu005DbpDataReqVO request;

	public IfCu005DbpReqVO() {
		super();
	}

	public IfCu005DbpDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCu005DbpDataReqVO request) {
		this.request = request;
	}



}