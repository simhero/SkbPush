package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs009MobReqVO (IfCs009MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs009MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs009MobReqVO extends BaseVO {
	private IfCs009MobDataReqVO request;

	public IfCs009MobReqVO() {
		super();
	}

	public IfCs009MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCs009MobDataReqVO request) {
		this.request = request;
	}

}