package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs002MobReqVO (IfCs002MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs002MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs002MobReqVO extends BaseVO {
	private IfCs002MobDataReqVO request;

	public IfCs002MobReqVO() {
		super();
	}

	public IfCs002MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCs002MobDataReqVO request) {
		this.request = request;
	}

}