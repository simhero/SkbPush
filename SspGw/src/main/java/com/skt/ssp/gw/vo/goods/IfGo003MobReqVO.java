package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo003MobReqVO (IfGo003MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo003MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo003MobReqVO extends BaseVO {
	private IfGo003MobDataReqVO request;

	public IfGo003MobReqVO() {
		super();
	}

	public IfGo003MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfGo003MobDataReqVO request) {
		this.request = request;
	}

}