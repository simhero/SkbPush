package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpResVO;

/**
 * IfCs004DbpDataResVO (IfCs004DbpDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs004DbpDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs004DbpDataResVO extends BaseVO {
	private IfHeaderDbpResVO header;
	private IfCs004ComBodyResVO body;

	public IfCs004DbpDataResVO() {
		super();
	}

	public IfHeaderDbpResVO getHeader() {
		return header;
	}

	public IfCs004ComBodyResVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderDbpResVO header) {
		this.header = header;
	}

	public void setBody(IfCs004ComBodyResVO body) {
		this.body = body;
	}

}