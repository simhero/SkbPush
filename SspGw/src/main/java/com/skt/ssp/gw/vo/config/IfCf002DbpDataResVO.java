package com.skt.ssp.gw.vo.config;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpResVO;

/**
 * IfCf002DbpDataResVO (IfCf002DbpDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCf002DbpDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCf002DbpDataResVO extends BaseVO {
	private IfHeaderDbpResVO header;
//	private IfCf002ComBodyResVO body;

	public IfCf002DbpDataResVO() {
		super();
	}

	public IfHeaderDbpResVO getHeader() {
		return header;
	}

//	public IfCf002ComBodyResVO getBody() {
//		return body;
//	}

	public void setHeader(IfHeaderDbpResVO header) {
		this.header = header;
	}

//	public void setBody(IfCf002ComBodyResVO body) {
//		this.body = body;
//	}

}