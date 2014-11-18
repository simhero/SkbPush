package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpReqVO;

/**
 * IfGo001DbpDataReqVO (IfGo001DbpDataReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo001DbpDataReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo001DbpDataReqVO extends BaseVO {
	private IfHeaderDbpReqVO header;
	private IfGo001ComBodyReqVO body;

	public IfGo001DbpDataReqVO() {
		super();
	}

	public IfHeaderDbpReqVO getHeader() {
		return header;
	}

	public void setHeader(IfHeaderDbpReqVO header) {
		this.header = header;
	}

	public IfGo001ComBodyReqVO getBody() {
		return body;
	}

	public void setBody(IfGo001ComBodyReqVO body) {
		this.body = body;
	}
	
}
