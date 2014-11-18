package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs014MobReqVO (IfCs014MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs014MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs014MobReqVO extends BaseVO {
	private IfCs014MobDataReqVO request;

	public IfCs014MobReqVO() {
		super();
	}

	public IfCs014MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCs014MobDataReqVO request) {
		this.request = request;
	}

}