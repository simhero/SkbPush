package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo002DbpResVO (IfGo002DbpResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo002DbpResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo002DbpResVO extends BaseVO {
	private IfGo002DbpDataResVO response;

	public IfGo002DbpResVO() {
		super();
	}

	public IfGo002DbpDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfGo002DbpDataResVO response) {
		this.response = response;
	}


}