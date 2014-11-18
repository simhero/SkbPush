package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo011MobResVO (IfGo011MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo011MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo011MobResVO extends BaseVO {
	private IfGo011MobDataResVO response;

	public IfGo011MobResVO() {
		super();
	}

	public IfGo011MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfGo011MobDataResVO response) {
		this.response = response;
	}



}