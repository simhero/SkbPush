package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo002MobReqVO (IfGo002MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo002MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo002MobReqVO extends BaseVO {
	private IfGo002MobDataReqVO request;

	public IfGo002MobReqVO() {
		super();
	}

	public IfGo002MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfGo002MobDataReqVO request) {
		this.request = request;
	}

}