package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo006MobReqVO (IfGo006MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo006MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo006MobReqVO extends BaseVO {
	private IfGo006MobDataReqVO request;

	public IfGo006MobReqVO() {
		super();
	}

	public IfGo006MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfGo006MobDataReqVO request) {
		this.request = request;
	}

}