package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo011MobReqVO (IfGo011MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo011MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo011MobReqVO extends BaseVO {
	private IfGo011MobDataReqVO request;

	public IfGo011MobReqVO() {
		super();
	}

	public IfGo011MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfGo011MobDataReqVO request) {
		this.request = request;
	}

}