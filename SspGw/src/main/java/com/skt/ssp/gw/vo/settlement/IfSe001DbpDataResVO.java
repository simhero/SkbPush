package com.skt.ssp.gw.vo.settlement;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpResVO;

/**
 * IfSe001DbpDataResVO (IfSe001DbpDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSe001DbpDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSe001DbpDataResVO extends BaseVO {
	private IfHeaderDbpResVO header;
	private IfSe001ComBodyResVO body;

	public IfSe001DbpDataResVO() {
		super();
	}

	public IfHeaderDbpResVO getHeader() {
		return header;
	}

	public IfSe001ComBodyResVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderDbpResVO header) {
		this.header = header;
	}

	public void setBody(IfSe001ComBodyResVO body) {
		this.body = body;
	}

}