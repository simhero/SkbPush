package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpResVO;

/**
 * IfCs003DbpDataResVO (IfCs003DbpDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs003DbpDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs003DbpDataResVO extends BaseVO {
	private IfHeaderDbpResVO header;
//	private IfCs003ComBodyResVO body;

	public IfCs003DbpDataResVO() {
		super();
	}

	public IfHeaderDbpResVO getHeader() {
		return header;
	}

//	public IfCs003ComBodyResVO getBody() {
//		return body;
//	}

	public void setHeader(IfHeaderDbpResVO header) {
		this.header = header;
	}

//	public void setBody(IfCs003ComBodyResVO body) {
//		this.body = body;
//	}

}