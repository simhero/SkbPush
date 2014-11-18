package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo008MobReqVO (IfGo008MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo008MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo008MobReqVO extends BaseVO {
	private IfGo008MobDataReqVO request;

	public IfGo008MobReqVO() {
		super();
	}

	public IfGo008MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfGo008MobDataReqVO request) {
		this.request = request;
	}

}