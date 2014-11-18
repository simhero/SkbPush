package com.skt.ssp.gw.vo.push;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfPu003DbpDataResVO (IfPu003DbpDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfPu003DbpDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfPu003DbpDataResVO extends BaseVO {
	private IfPu003ComBodyResVO body;

	public IfPu003DbpDataResVO() {
		super();
	}

	public IfPu003ComBodyResVO getBody() {
		return body;
	}

	public void setBody(IfPu003ComBodyResVO body) {
		this.body = body;
	}

}