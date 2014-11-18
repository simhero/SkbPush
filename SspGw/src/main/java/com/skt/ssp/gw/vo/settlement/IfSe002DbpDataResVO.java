package com.skt.ssp.gw.vo.settlement;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpResVO;

/**
 * IfSe002DbpDataResVO (IfSe002DbpDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSe002DbpDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSe002DbpDataResVO extends BaseVO {
	private IfHeaderDbpResVO header;
	private IfSe002ComBodyResVO body;

	public IfSe002DbpDataResVO() {
		super();
	}

	public IfHeaderDbpResVO getHeader() {
		return header;
	}

	public IfSe002ComBodyResVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderDbpResVO header) {
		this.header = header;
	}

	public void setBody(IfSe002ComBodyResVO body) {
		this.body = body;
	}

}