package com.skt.ssp.gw.vo.test;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfTe001DbpRes VO (IfTe001DbpResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfTe001DbpResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfTe001DbpResVO extends BaseVO {
	private IfTe001DbpDataResVO response;

	public IfTe001DbpResVO() {
		super();
	}

	public IfTe001DbpDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfTe001DbpDataResVO response) {
		this.response = response;
	}


}