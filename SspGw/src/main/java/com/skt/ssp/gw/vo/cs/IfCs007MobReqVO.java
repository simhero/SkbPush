package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs007MobReqVO (IfCs007MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs007MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs007MobReqVO extends BaseVO {
	private IfCs007MobDataReqVO request;

	public IfCs007MobReqVO() {
		super();
	}

	public IfCs007MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCs007MobDataReqVO request) {
		this.request = request;
	}

}