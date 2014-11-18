package com.skt.ssp.gw.vo.intro;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfIn002DbpRes VO (IfIn002DbpResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfIn002DbpResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfIn002DbpResVO extends BaseVO {
	private IfIn002DbpDataResVO response;

	public IfIn002DbpResVO() {
		super();
	}

	public IfIn002DbpDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfIn002DbpDataResVO response) {
		this.response = response;
	}


}