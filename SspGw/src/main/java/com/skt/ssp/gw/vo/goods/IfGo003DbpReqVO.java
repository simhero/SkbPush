package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo003DbpReqVO (IfGo003DbpReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo003DbpReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo003DbpReqVO extends BaseVO {
	private IfGo003DbpDataReqVO request;

	public IfGo003DbpReqVO() {
		super();
	}

	public IfGo003DbpDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfGo003DbpDataReqVO request) {
		this.request = request;
	}



}