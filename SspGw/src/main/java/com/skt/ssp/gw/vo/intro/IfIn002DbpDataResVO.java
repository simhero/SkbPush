package com.skt.ssp.gw.vo.intro;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpResVO;

public class IfIn002DbpDataResVO extends BaseVO {
	private IfHeaderDbpResVO header;

	public IfIn002DbpDataResVO() {
		super();
	}

	public IfHeaderDbpResVO getHeader() {
		return header;
	}

	public void setHeader(IfHeaderDbpResVO header) {
		this.header = header;
	}

}
