package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs013MobReqVO (IfCs013MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs013MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs013MobReqVO extends BaseVO {
	private IfCs013MobDataReqVO request;

	public IfCs013MobReqVO() {
		super();
	}

	public IfCs013MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCs013MobDataReqVO request) {
		this.request = request;
	}

}