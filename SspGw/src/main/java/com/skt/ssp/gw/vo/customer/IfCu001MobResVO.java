package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCu001DbpDataRes VO (IfCu001DbpDataResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu001DbpDataResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu001MobResVO extends BaseVO {
	private IfCu001MobDataResVO response;

	public IfCu001MobResVO() {
		super();
	}

	public IfCu001MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCu001MobDataResVO response) {
		this.response = response;
	}

}
