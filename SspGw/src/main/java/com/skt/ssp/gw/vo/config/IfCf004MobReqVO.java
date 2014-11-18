package com.skt.ssp.gw.vo.config;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCf004MobReqVO (IfCf004MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCf004MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCf004MobReqVO extends BaseVO {
	private IfCf004MobDataReqVO request;

	public IfCf004MobReqVO() {
		super();
	}

	public IfCf004MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCf004MobDataReqVO request) {
		this.request = request;
	}

}