package com.skt.ssp.gw.vo.statistics;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpResVO;

/**
 * IfSt002DbpDataResVO (IfSt002DbpDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSt002DbpDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSt002DbpDataResVO extends BaseVO {
	private IfHeaderDbpResVO header;
	private IfSt002ComBodyResVO body;

	public IfSt002DbpDataResVO() {
		super();
	}

	public IfHeaderDbpResVO getHeader() {
		return header;
	}

	public IfSt002ComBodyResVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderDbpResVO header) {
		this.header = header;
	}

	public void setBody(IfSt002ComBodyResVO body) {
		this.body = body;
	}

}