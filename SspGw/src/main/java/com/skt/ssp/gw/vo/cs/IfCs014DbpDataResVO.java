package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpResVO;

/**
 * IfCs014DbpDataResVO (IfCs014DbpDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs014DbpDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs014DbpDataResVO extends BaseVO {
	private IfHeaderDbpResVO header;
//	private IfCs014ComBodyResVO body;

	public IfCs014DbpDataResVO() {
		super();
	}

	public IfHeaderDbpResVO getHeader() {
		return header;
	}

//	public IfCs014ComBodyResVO getBody() {
//		return body;
//	}

	public void setHeader(IfHeaderDbpResVO header) {
		this.header = header;
	}

//	public void setBody(IfCs014ComBodyResVO body) {
//		this.body = body;
//	}

}