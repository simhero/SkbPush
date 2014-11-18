package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo002MobResVO (IfGo002MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo002MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo002MobResVO extends BaseVO {
	private IfGo002MobDataResVO response;

	public IfGo002MobResVO() {
		super();
	}

	public IfGo002MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfGo002MobDataResVO response) {
		this.response = response;
	}



}