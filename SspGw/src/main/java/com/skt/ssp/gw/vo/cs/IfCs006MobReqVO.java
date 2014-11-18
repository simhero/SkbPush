package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs006MobReqVO (IfCs006MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs006MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs006MobReqVO extends BaseVO {
	private IfCs006MobDataReqVO request;

	public IfCs006MobReqVO() {
		super();
	}

	public IfCs006MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCs006MobDataReqVO request) {
		this.request = request;
	}

}