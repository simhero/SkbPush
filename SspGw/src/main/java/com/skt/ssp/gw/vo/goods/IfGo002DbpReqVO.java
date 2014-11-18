package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo002DbpReqVO (IfGo002DbpReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo002DbpReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo002DbpReqVO extends BaseVO {
	private IfGo002DbpDataReqVO request;

	public IfGo002DbpReqVO() {
		super();
	}

	public IfGo002DbpDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfGo002DbpDataReqVO request) {
		this.request = request;
	}



}