package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpResVO;

/**
 * IfGo0051DbpDataResVO (IfGo0051DbpDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo0051DbpDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo0051DbpDataResVO extends BaseVO {
	private IfHeaderDbpResVO header;
	private IfGo0051ComBodyResVO body;

	public IfGo0051DbpDataResVO() {
		super();
	}

	public IfHeaderDbpResVO getHeader() {
		return header;
	}

	public IfGo0051ComBodyResVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderDbpResVO header) {
		this.header = header;
	}

	public void setBody(IfGo0051ComBodyResVO body) {
		this.body = body;
	}

}