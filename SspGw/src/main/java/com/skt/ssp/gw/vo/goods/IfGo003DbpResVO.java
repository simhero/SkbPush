package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo003DbpResVO (IfGo003DbpResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo003DbpResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo003DbpResVO extends BaseVO {
	private IfGo003DbpDataResVO response;

	public IfGo003DbpResVO() {
		super();
	}

	public IfGo003DbpDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfGo003DbpDataResVO response) {
		this.response = response;
	}


}