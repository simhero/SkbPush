package com.skt.ssp.gw.vo.statistics;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfSt002MobReqVO (IfSt002MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSt002MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSt002MobReqVO extends BaseVO {
	private IfSt002MobDataReqVO request;

	public IfSt002MobReqVO() {
		super();
	}

	public IfSt002MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfSt002MobDataReqVO request) {
		this.request = request;
	}

}