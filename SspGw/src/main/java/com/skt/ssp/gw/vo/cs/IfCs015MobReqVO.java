package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs015MobReqVO (IfCs015MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs015MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs015MobReqVO extends BaseVO {
	private IfCs015MobDataReqVO request;

	public IfCs015MobReqVO() {
		super();
	}

	public IfCs015MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCs015MobDataReqVO request) {
		this.request = request;
	}

}