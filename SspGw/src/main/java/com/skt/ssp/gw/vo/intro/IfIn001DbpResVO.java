package com.skt.ssp.gw.vo.intro;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfIn001DbpRes VO (IfIn001DbpResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfIn001DbpResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfIn001DbpResVO extends BaseVO {
	private IfIn001DbpDataResVO response;

	public IfIn001DbpResVO() {
		super();
	}

	public IfIn001DbpDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfIn001DbpDataResVO response) {
		this.response = response;
	}


}