package com.skt.ssp.gw.vo.order;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfOr001MobReqVO (IfOr001MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfOr001MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfOr001MobReqVO extends BaseVO {
	private IfOr001MobDataReqVO request;

	public IfOr001MobReqVO() {
		super();
	}

	public IfOr001MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfOr001MobDataReqVO request) {
		this.request = request;
	}

}