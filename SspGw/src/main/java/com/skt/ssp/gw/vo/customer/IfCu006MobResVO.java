package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCu001DbpDataRes VO (IfCu001DbpDataResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu001DbpDataResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu006MobResVO extends BaseVO {
	private IfCu006MobDataResVO response;

	public IfCu006MobResVO() {
		super();
	}

	public IfCu006MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCu006MobDataResVO response) {
		this.response = response;
	}

}
