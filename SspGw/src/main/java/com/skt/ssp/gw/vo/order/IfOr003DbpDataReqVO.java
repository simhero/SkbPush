package com.skt.ssp.gw.vo.order;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpReqVO;

/**
 * IfOr003DbpDataReqVO (IfOr003DbpDataReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfOr003DbpDataReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfOr003DbpDataReqVO extends BaseVO {
	private IfHeaderDbpReqVO header;
	private IfOr003ComBodyReqVO body;

	public IfOr003DbpDataReqVO() {
		super();
	}

	public IfHeaderDbpReqVO getHeader() {
		return header;
	}

	public IfOr003ComBodyReqVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderDbpReqVO header) {
		this.header = header;
	}

	public void setBody(IfOr003ComBodyReqVO body) {
		this.body = body;
	}

}