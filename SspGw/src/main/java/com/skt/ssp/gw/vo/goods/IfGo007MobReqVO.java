package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo007MobReqVO (IfGo007MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo007MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo007MobReqVO extends BaseVO {
	private IfGo007MobDataReqVO request;

	public IfGo007MobReqVO() {
		super();
	}

	public IfGo007MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfGo007MobDataReqVO request) {
		this.request = request;
	}

}