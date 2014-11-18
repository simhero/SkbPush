package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfTe001DbpRes VO (IfTe001DbpResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfTe001DbpResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu004DbpResVO extends BaseVO {
	private IfCu004DbpDataResVO response;

	public IfCu004DbpResVO() {
		super();
	}

	public IfCu004DbpDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCu004DbpDataResVO response) {
		this.response = response;
	}


}