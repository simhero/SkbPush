package com.skt.ssp.gw.vo.intro;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpResVO;

/**
 * IfIn001DbpDataRes VO (IfIn001DbpDataResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfIn001DbpDataResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfIn001DbpDataResVO extends BaseVO {
	private IfHeaderDbpResVO header;
	private IfIn001ComBodyResVO body;

	public IfIn001DbpDataResVO() {
		super();
	}

	public IfHeaderDbpResVO getHeader() {
		return header;
	}

	public void setHeader(IfHeaderDbpResVO header) {
		this.header = header;
	}

	public IfIn001ComBodyResVO getBody() {
		return body;
	}

	public void setBody(IfIn001ComBodyResVO body) {
		this.body = body;
	}

}
