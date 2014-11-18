package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs010MobReqVO (IfCs010MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs010MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs010MobReqVO extends BaseVO {
	private IfCs010MobDataReqVO request;

	public IfCs010MobReqVO() {
		super();
	}

	public IfCs010MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCs010MobDataReqVO request) {
		this.request = request;
	}

}