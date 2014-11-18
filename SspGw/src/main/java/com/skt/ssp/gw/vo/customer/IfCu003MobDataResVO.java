package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobResVO;

/**
 * IfCu001DbpDataRes VO (IfCu001DbpDataResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu001DbpDataResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu003MobDataResVO extends BaseVO {
	private IfHeaderMobResVO header;
	private IfCu003ComBodyResVO body;

	public IfCu003MobDataResVO() {
		super();
	}

	public IfHeaderMobResVO getHeader() {
		return header;
	}

	public void setHeader(IfHeaderMobResVO header) {
		this.header = header;
	}

	public IfCu003ComBodyResVO getBody() {
		return body;
	}

	public void setBody(IfCu003ComBodyResVO body) {
		this.body = body;
	}
}
