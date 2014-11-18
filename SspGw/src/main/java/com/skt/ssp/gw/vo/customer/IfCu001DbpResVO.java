package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCu001DbpRes VO (IfCu001DbpResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu001DbpResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu001DbpResVO extends BaseVO {
	private IfCu001DbpDataResVO response;

	public IfCu001DbpResVO() {
		super();
	}

	public IfCu001DbpDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCu001DbpDataResVO response) {
		this.response = response;
	}


}