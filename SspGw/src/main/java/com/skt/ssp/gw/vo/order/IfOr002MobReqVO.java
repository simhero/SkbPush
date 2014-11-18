package com.skt.ssp.gw.vo.order;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfOr002MobReqVO (IfOr002MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfOr002MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfOr002MobReqVO extends BaseVO {
	private IfOr002MobDataReqVO request;

	public IfOr002MobReqVO() {
		super();
	}

	public IfOr002MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfOr002MobDataReqVO request) {
		this.request = request;
	}

}