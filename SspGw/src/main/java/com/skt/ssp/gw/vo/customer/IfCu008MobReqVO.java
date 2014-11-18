package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCu001DbpDataRes VO (IfCu001DbpDataResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu001DbpDataResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu008MobReqVO extends BaseVO {
	private IfCu008MobDataReqVO request;

	public IfCu008MobReqVO() {
		super();
	}

	public IfCu008MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCu008MobDataReqVO request) {
		this.request = request;
	}

}
