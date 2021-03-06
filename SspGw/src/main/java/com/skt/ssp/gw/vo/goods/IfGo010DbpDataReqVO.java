package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpReqVO;

/**
 * IfGo010DbpDataReqVO (IfGo010DbpDataReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo010DbpDataReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo010DbpDataReqVO extends BaseVO {
	private IfHeaderDbpReqVO header;
	private IfGo010ComBodyReqVO body;

	public IfGo010DbpDataReqVO() {
		super();
	}

	public IfHeaderDbpReqVO getHeader() {
		return header;
	}

	public IfGo010ComBodyReqVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderDbpReqVO header) {
		this.header = header;
	}

	public void setBody(IfGo010ComBodyReqVO body) {
		this.body = body;
	}

}