package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs011MobReqVO (IfCs011MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs011MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs011MobReqVO extends BaseVO {
	private IfCs011MobDataReqVO request;

	public IfCs011MobReqVO() {
		super();
	}

	public IfCs011MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCs011MobDataReqVO request) {
		this.request = request;
	}

}