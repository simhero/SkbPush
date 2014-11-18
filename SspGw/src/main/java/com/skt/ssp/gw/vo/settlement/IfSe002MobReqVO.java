package com.skt.ssp.gw.vo.settlement;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfSe002MobReqVO (IfSe002MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSe002MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSe002MobReqVO extends BaseVO {
	private IfSe002MobDataReqVO request;

	public IfSe002MobReqVO() {
		super();
	}

	public IfSe002MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfSe002MobDataReqVO request) {
		this.request = request;
	}

}