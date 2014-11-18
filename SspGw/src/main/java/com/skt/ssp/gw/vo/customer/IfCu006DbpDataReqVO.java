package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpReqVO;

/**
 * IfCu001DbpDataReq VO (IfCu001DbpDataReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu001DbpDataReqVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu006DbpDataReqVO extends BaseVO {
	private IfHeaderDbpReqVO header;
	private IfCu006ComBodyReqVO body;

	public IfCu006DbpDataReqVO() {
		super();
	}

	public IfHeaderDbpReqVO getHeader() {
		return header;
	}

	public void setHeader(IfHeaderDbpReqVO header) {
		this.header = header;
	}

	public IfCu006ComBodyReqVO getBody() {
		return body;
	}

	public void setBody(IfCu006ComBodyReqVO body) {
		this.body = body;
	}

}
