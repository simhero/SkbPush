package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpResVO;

/**
 * IfGo012DbpDataResVO (IfGo012DbpDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo012DbpDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo012DbpDataResVO extends BaseVO {
	private IfHeaderDbpResVO header;
	private IfGo012ComBodyResVO body;

	public IfGo012DbpDataResVO() {
		super();
	}

	public IfHeaderDbpResVO getHeader() {
		return header;
	}

	public IfGo012ComBodyResVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderDbpResVO header) {
		this.header = header;
	}

	public void setBody(IfGo012ComBodyResVO body) {
		this.body = body;
	}

}