package com.skt.ssp.gw.vo.test;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfTe001DbpReq VO (IfTe001DbpReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfTe001DbpReqVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfTe001DbpReqVO extends BaseVO {
	private IfTe001DbpDataReqVO request;

	public IfTe001DbpReqVO() {
		super();
	}

	public IfTe001DbpDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfTe001DbpDataReqVO request) {
		this.request = request;
	}



}