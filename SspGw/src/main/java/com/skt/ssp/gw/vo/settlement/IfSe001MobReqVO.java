package com.skt.ssp.gw.vo.settlement;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfSe001MobReqVO (IfSe001MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSe001MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSe001MobReqVO extends BaseVO {
	private IfSe001MobDataReqVO request;

	public IfSe001MobReqVO() {
		super();
	}

	public IfSe001MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfSe001MobDataReqVO request) {
		this.request = request;
	}

}