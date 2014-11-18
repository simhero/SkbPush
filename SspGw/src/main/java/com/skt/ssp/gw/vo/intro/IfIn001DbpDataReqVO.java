package com.skt.ssp.gw.vo.intro;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpReqVO;

/**
 * IfIn001DbpDataReqVO (IfIn001DbpDataReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfIn001DbpDataReqVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfIn001DbpDataReqVO extends BaseVO {
	private IfHeaderDbpReqVO header;
	private IfIn001ComBodyReqVO body;

	public IfIn001DbpDataReqVO() {
		super();
	}

	public IfHeaderDbpReqVO getHeader() {
		return header;
	}

	public void setHeader(IfHeaderDbpReqVO header) {
		this.header = header;
	}

	public IfIn001ComBodyReqVO getBody() {
		return body;
	}

	public void setBody(IfIn001ComBodyReqVO body) {
		this.body = body;
	}

}
