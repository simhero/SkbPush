package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs001MobReqVO (IfCs001MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs001MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs001MobReqVO extends BaseVO {
	private IfCs001MobDataReqVO request;

	public IfCs001MobReqVO() {
		super();
	}

	public IfCs001MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCs001MobDataReqVO request) {
		this.request = request;
	}

}