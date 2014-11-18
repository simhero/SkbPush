package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs003MobReqVO (IfCs003MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs003MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs003MobReqVO extends BaseVO {
	private IfCs003MobDataReqVO request;

	public IfCs003MobReqVO() {
		super();
	}

	public IfCs003MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCs003MobDataReqVO request) {
		this.request = request;
	}

}