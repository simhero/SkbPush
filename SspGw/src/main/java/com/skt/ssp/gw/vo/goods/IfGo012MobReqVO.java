package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo012MobReqVO (IfGo012MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo012MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo012MobReqVO extends BaseVO {
	private IfGo012MobDataReqVO request;

	public IfGo012MobReqVO() {
		super();
	}

	public IfGo012MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfGo012MobDataReqVO request) {
		this.request = request;
	}

}