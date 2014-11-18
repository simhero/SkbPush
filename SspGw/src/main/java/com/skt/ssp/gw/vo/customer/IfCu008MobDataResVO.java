package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobResVO;

/**
 * IfCu007DbpDataRes VO (IfCu007DbpDataResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu007DbpDataResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu008MobDataResVO extends BaseVO {
	private IfHeaderMobResVO header;
//	private IfCu008ComBodyResVO body;

	public IfCu008MobDataResVO() {
		super();
	}

	public IfHeaderMobResVO getHeader() {
		return header;
	}

	public void setHeader(IfHeaderMobResVO header) {
		this.header = header;
	}
	/*
	public IfCu008ComBodyResVO getBody() {
		return body;
	}

	public void setBody(IfCu008ComBodyResVO body) {
		this.body = body;
	}
	*/
}
