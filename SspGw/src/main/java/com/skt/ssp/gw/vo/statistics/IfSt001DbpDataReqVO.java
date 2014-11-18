package com.skt.ssp.gw.vo.statistics;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpReqVO;

/**
 * IfSt001DbpDataReqVO (IfSt001DbpDataReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSt001DbpDataReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSt001DbpDataReqVO extends BaseVO {
	private IfHeaderDbpReqVO header;
	private IfSt001ComBodyReqVO body;

	public IfSt001DbpDataReqVO() {
		super();
	}

	public IfHeaderDbpReqVO getHeader() {
		return header;
	}

	public IfSt001ComBodyReqVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderDbpReqVO header) {
		this.header = header;
	}

	public void setBody(IfSt001ComBodyReqVO body) {
		this.body = body;
	}

}