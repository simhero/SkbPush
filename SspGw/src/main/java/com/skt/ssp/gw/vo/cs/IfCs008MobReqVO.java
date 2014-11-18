package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs008MobReqVO (IfCs008MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs008MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs008MobReqVO extends BaseVO {
	private IfCs008MobDataReqVO request;

	public IfCs008MobReqVO() {
		super();
	}

	public IfCs008MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCs008MobDataReqVO request) {
		this.request = request;
	}

}