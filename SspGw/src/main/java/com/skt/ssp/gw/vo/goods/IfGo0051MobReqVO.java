package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo0051MobReqVO (IfGo0051MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo0051MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo0051MobReqVO extends BaseVO {
	private IfGo0051MobDataReqVO request;

	public IfGo0051MobReqVO() {
		super();
	}

	public IfGo0051MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfGo0051MobDataReqVO request) {
		this.request = request;
	}

}