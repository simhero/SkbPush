package com.skt.ssp.gw.vo.intro;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpReqVO;

public class IfIn002DbpDataReqVO extends BaseVO {
	private IfHeaderDbpReqVO header;
	private IfIn002ComBodyReqVO body;

	public IfIn002DbpDataReqVO() {
		super();
	}

	public IfHeaderDbpReqVO getHeader() {
		return header;
	}

	public void setHeader(IfHeaderDbpReqVO header) {
		this.header = header;
	}

	public IfIn002ComBodyReqVO getBody() {
		return body;
	}

	public void setBody(IfIn002ComBodyReqVO body) {
		this.body = body;
	}

}
