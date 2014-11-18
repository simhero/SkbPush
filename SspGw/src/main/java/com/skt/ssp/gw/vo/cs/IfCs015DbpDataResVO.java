package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpResVO;

/**
 * IfCs015DbpDataResVO (IfCs015DbpDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs015DbpDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs015DbpDataResVO extends BaseVO {
	private IfHeaderDbpResVO header;
//	private IfCs015ComBodyResVO body;

	public IfCs015DbpDataResVO() {
		super();
	}

	public IfHeaderDbpResVO getHeader() {
		return header;
	}

//	public IfCs015ComBodyResVO getBody() {
//		return body;
//	}

	public void setHeader(IfHeaderDbpResVO header) {
		this.header = header;
	}

//	public void setBody(IfCs015ComBodyResVO body) {
//		this.body = body;
//	}

}