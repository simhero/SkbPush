package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpReqVO;

/**
 * IfCs009DbpDataReqVO (IfCs009DbpDataReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs009DbpDataReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs009DbpDataReqVO extends BaseVO {
	private IfHeaderDbpReqVO header;
	private IfCs009ComBodyReqVO body;

	public IfCs009DbpDataReqVO() {
		super();
	}

	public IfHeaderDbpReqVO getHeader() {
		return header;
	}

	public IfCs009ComBodyReqVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderDbpReqVO header) {
		this.header = header;
	}

	public void setBody(IfCs009ComBodyReqVO body) {
		this.body = body;
	}

}