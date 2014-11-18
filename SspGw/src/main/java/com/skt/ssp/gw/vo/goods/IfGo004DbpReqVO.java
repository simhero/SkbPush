package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo004DbpReqVO (IfGo004DbpReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo004DbpReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo004DbpReqVO extends BaseVO {
	private IfGo004DbpDataReqVO request;

	public IfGo004DbpReqVO() {
		super();
	}

	public IfGo004DbpDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfGo004DbpDataReqVO request) {
		this.request = request;
	}



}