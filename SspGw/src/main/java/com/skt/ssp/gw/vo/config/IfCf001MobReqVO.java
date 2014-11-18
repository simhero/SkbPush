package com.skt.ssp.gw.vo.config;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCf001MobReqVO (IfCf001MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCf001MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCf001MobReqVO extends BaseVO {
	private IfCf001MobDataReqVO request;

	public IfCf001MobReqVO() {
		super();
	}

	public IfCf001MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCf001MobDataReqVO request) {
		this.request = request;
	}

}