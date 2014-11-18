package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfTe001MobRes VO (IfTe001MobResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfTe001MobResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu004MobResVO extends BaseVO {
	private IfCu004MobDataResVO response;

	public IfCu004MobResVO() {
		super();
	}

	public IfCu004MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCu004MobDataResVO response) {
		this.response = response;
	}



}