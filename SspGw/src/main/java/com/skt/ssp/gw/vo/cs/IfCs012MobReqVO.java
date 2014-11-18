package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs012MobReqVO (IfCs012MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs012MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs012MobReqVO extends BaseVO {
	private IfCs012MobDataReqVO request;

	public IfCs012MobReqVO() {
		super();
	}

	public IfCs012MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCs012MobDataReqVO request) {
		this.request = request;
	}

}