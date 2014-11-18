package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo004DbpResVO (IfGo004DbpResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo004DbpResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo004DbpResVO extends BaseVO {
	private IfGo004DbpDataResVO response;

	public IfGo004DbpResVO() {
		super();
	}

	public IfGo004DbpDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfGo004DbpDataResVO response) {
		this.response = response;
	}


}