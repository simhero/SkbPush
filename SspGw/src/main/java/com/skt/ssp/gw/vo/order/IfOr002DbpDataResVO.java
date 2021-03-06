package com.skt.ssp.gw.vo.order;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpResVO;

/**
 * IfOr002DbpDataResVO (IfOr002DbpDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfOr002DbpDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfOr002DbpDataResVO extends BaseVO {
	private IfHeaderDbpResVO header;
	private IfOr002ComBodyResVO body;

	public IfOr002DbpDataResVO() {
		super();
	}

	public IfHeaderDbpResVO getHeader() {
		return header;
	}

	public IfOr002ComBodyResVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderDbpResVO header) {
		this.header = header;
	}

	public void setBody(IfOr002ComBodyResVO body) {
		this.body = body;
	}

}