package com.skt.ssp.gw.vo.config;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCf002MobReqVO (IfCf002MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCf002MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCf002MobReqVO extends BaseVO {
	private IfCf002MobDataReqVO request;

	public IfCf002MobReqVO() {
		super();
	}

	public IfCf002MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCf002MobDataReqVO request) {
		this.request = request;
	}

}