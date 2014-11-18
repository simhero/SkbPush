package com.skt.ssp.gw.vo.push;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfPu004MobReqVO (IfPu004MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfPu004MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfPu004MobReqVO extends BaseVO {
	private IfPu004MobDataReqVO request;

	public IfPu004MobReqVO() {
		super();
	}

	public IfPu004MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfPu004MobDataReqVO request) {
		this.request = request;
	}

}