package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCu001DbpRes VO (IfCu001DbpResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu001DbpResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu006DbpResVO extends BaseVO {
	private IfCu006DbpDataResVO response;

	public IfCu006DbpResVO() {
		super();
	}

	public IfCu006DbpDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCu006DbpDataResVO response) {
		this.response = response;
	}


}