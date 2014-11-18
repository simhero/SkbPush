package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpResVO;

/**
 * IfCs013DbpDataResVO (IfCs013DbpDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs013DbpDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs013DbpDataResVO extends BaseVO {
	private IfHeaderDbpResVO header;
//	private IfCs013ComBodyResVO body;

	public IfCs013DbpDataResVO() {
		super();
	}

	public IfHeaderDbpResVO getHeader() {
		return header;
	}

//	public IfCs013ComBodyResVO getBody() {
//		return body;
//	}

	public void setHeader(IfHeaderDbpResVO header) {
		this.header = header;
	}

//	public void setBody(IfCs013ComBodyResVO body) {
//		this.body = body;
//	}

}