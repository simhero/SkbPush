package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpResVO;

/**
 * IfCu001DbpDataRes VO (IfCu001DbpDataResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu001DbpDataResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu005DbpDataResVO extends BaseVO {
	private IfHeaderDbpResVO header;
	private IfCu005ComBodyResVO body;

	public IfCu005DbpDataResVO() {
		super();
	}

	public IfHeaderDbpResVO getHeader() {
		return header;
	}

	public void setHeader(IfHeaderDbpResVO header) {
		this.header = header;
	}

	public IfCu005ComBodyResVO getBody() {
		return body;
	}

	public void setBody(IfCu005ComBodyResVO body) {
		this.body = body;
	}

}
