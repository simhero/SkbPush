package com.skt.ssp.gw.vo.test;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpReqVO;

/**
 * IfTe001DbpDataReq VO (IfTe001DbpDataReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfTe001DbpDataReqVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfTe001DbpDataReqVO extends BaseVO {
	private IfHeaderDbpReqVO header;
	private IfTe001ComBodyReqVO body;

	public IfTe001DbpDataReqVO() {
		super();
	}

	public IfHeaderDbpReqVO getHeader() {
		return header;
	}

	public IfTe001ComBodyReqVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderDbpReqVO header) {
		this.header = header;
	}

	public void setBody(IfTe001ComBodyReqVO body) {
		this.body = body;
	}

}