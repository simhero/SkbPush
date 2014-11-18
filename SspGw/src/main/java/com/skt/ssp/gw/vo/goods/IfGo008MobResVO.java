package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo008MobResVO (IfGo008MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo008MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo008MobResVO extends BaseVO {
	private IfGo008MobDataResVO response;

	public IfGo008MobResVO() {
		super();
	}

	public IfGo008MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfGo008MobDataResVO response) {
		this.response = response;
	}



}