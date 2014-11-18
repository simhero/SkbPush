package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo009MobReqVO (IfGo009MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo009MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo009MobReqVO extends BaseVO {
	private IfGo009MobDataReqVO request;

	public IfGo009MobReqVO() {
		super();
	}

	public IfGo009MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfGo009MobDataReqVO request) {
		this.request = request;
	}

}