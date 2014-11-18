package com.skt.ssp.gw.vo.push;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfPu003DbpDataReqVO (IfPu003DbpDataReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfPu003DbpDataReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfPu003DbpDataReqVO extends BaseVO {
	private IfPu003ComBodyReqVO body;

	public IfPu003DbpDataReqVO() {
		super();
	}

	public IfPu003ComBodyReqVO getBody() {
		return body;
	}

	public void setBody(IfPu003ComBodyReqVO body) {
		this.body = body;
	}

}