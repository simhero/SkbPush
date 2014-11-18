package com.skt.ssp.gw.vo.statistics;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfSt001MobReqVO (IfSt001MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSt001MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSt001MobReqVO extends BaseVO {
	private IfSt001MobDataReqVO request;

	public IfSt001MobReqVO() {
		super();
	}

	public IfSt001MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfSt001MobDataReqVO request) {
		this.request = request;
	}

}