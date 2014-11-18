package com.skt.ssp.gw.vo.config;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCf003MobReqVO (IfCf003MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCf003MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCf003MobReqVO extends BaseVO {
	private IfCf003MobDataReqVO request;

	public IfCf003MobReqVO() {
		super();
	}

	public IfCf003MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCf003MobDataReqVO request) {
		this.request = request;
	}

}