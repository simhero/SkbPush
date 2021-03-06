package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobResVO;

/**
 * IfTe001MobDataRes VO (IfTe001MobDataResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfTe001MobDataResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu004MobDataResVO extends BaseVO {
	private IfHeaderMobResVO header;
	private IfCu004ComBodyResVO body;

	public IfCu004MobDataResVO() {
		super();
	}

	public IfHeaderMobResVO getHeader() {
		return header;
	}

	public IfCu004ComBodyResVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderMobResVO header) {
		this.header = header;
	}

	public void setBody(IfCu004ComBodyResVO body) {
		this.body = body;
	}

}