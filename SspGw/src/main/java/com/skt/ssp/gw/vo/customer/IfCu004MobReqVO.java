package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfTe001MobReq VO (IfTe001MobReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfTe001MobReqVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu004MobReqVO extends BaseVO {
	private IfCu004MobDataReqVO request;

	public IfCu004MobReqVO() {
		super();
	}

	public IfCu004MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCu004MobDataReqVO request) {
		this.request = request;
	}

}