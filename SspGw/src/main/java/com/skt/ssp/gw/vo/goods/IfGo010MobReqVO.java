package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo010MobReqVO (IfGo010MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo010MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo010MobReqVO extends BaseVO {
	private IfGo010MobDataReqVO request;

	public IfGo010MobReqVO() {
		super();
	}

	public IfGo010MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfGo010MobDataReqVO request) {
		this.request = request;
	}

}