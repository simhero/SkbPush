package com.skt.ssp.gw.vo.test;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfTe001MobReq VO (IfTe001MobReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfTe001MobReqVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfTe001MobReqVO extends BaseVO {
	private IfTe001MobDataReqVO request;

	public IfTe001MobReqVO() {
		super();
	}

	public IfTe001MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfTe001MobDataReqVO request) {
		this.request = request;
	}

}