package com.skt.ssp.gw.vo.test;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfTe001MobRes VO (IfTe001MobResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfTe001MobResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfTe001MobResVO extends BaseVO {
	private IfTe001MobDataResVO response;

	public IfTe001MobResVO() {
		super();
	}

	public IfTe001MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfTe001MobDataResVO response) {
		this.response = response;
	}



}