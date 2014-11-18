package com.skt.ssp.gw.vo.push;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpReqVO;

/**
 * IfPu002DbpDataReqVO (IfPu002DbpDataReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfPu002DbpDataReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfPu002DbpDataReqVO extends BaseVO {
	private IfHeaderDbpReqVO header;
	private IfPu002ComBodyReqVO body;

	public IfPu002DbpDataReqVO() {
		super();
	}

	public IfHeaderDbpReqVO getHeader() {
		return header;
	}

	public IfPu002ComBodyReqVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderDbpReqVO header) {
		this.header = header;
	}

	public void setBody(IfPu002ComBodyReqVO body) {
		this.body = body;
	}

}