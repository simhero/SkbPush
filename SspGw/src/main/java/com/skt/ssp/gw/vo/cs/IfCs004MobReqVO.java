package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs004MobReqVO (IfCs004MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs004MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs004MobReqVO extends BaseVO {
	private IfCs004MobDataReqVO request;

	public IfCs004MobReqVO() {
		super();
	}

	public IfCs004MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCs004MobDataReqVO request) {
		this.request = request;
	}

}