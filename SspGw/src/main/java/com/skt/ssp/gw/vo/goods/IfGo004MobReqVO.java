package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo004MobReqVO (IfGo004MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo004MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo004MobReqVO extends BaseVO {
	private IfGo004MobDataReqVO request;

	public IfGo004MobReqVO() {
		super();
	}

	public IfGo004MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfGo004MobDataReqVO request) {
		this.request = request;
	}

}