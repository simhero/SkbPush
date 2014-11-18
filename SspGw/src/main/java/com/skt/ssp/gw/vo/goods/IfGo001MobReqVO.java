package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo001MobReqVO (IfGo001MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo001MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo001MobReqVO extends BaseVO {
	private IfGo001MobDataReqVO request;
	
	public IfGo001MobReqVO() {
		super();
	}

	public IfGo001MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfGo001MobDataReqVO request) {
		this.request = request;
	}
	
}
