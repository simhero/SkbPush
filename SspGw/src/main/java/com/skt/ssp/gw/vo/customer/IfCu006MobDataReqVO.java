package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobReqVO;

/**
 * IfCu001DbpDataRes VO (IfCu001DbpDataResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu001DbpDataResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu006MobDataReqVO extends BaseVO {
	private IfHeaderMobReqVO header;
	private IfCu006ComBodyReqVO body;

	public IfCu006MobDataReqVO() {
		super();
	}

	public IfHeaderMobReqVO getHeader() {
		return header;
	}

	public void setHeader(IfHeaderMobReqVO header) {
		this.header = header;
	}

	public IfCu006ComBodyReqVO getBody() {
		return body;
	}

	public void setBody(IfCu006ComBodyReqVO body) {
		this.body = body;
	}

}
