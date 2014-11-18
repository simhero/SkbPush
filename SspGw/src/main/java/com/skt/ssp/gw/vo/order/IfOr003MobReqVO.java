package com.skt.ssp.gw.vo.order;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfOr003MobReqVO (IfOr003MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfOr003MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfOr003MobReqVO extends BaseVO {
	private IfOr003MobDataReqVO request;

	public IfOr003MobReqVO() {
		super();
	}

	public IfOr003MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfOr003MobDataReqVO request) {
		this.request = request;
	}

}