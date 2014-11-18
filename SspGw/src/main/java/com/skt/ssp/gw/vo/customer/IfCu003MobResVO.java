package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCu001DbpDataRes VO (IfCu001DbpDataResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu001DbpDataResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu003MobResVO extends BaseVO {
	private IfCu003MobDataResVO response;

	public IfCu003MobResVO() {
		super();
	}

	public IfCu003MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCu003MobDataResVO response) {
		this.response = response;
	}

}
