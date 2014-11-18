package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo0051MobResVO (IfGo0051MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo0051MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo0051MobResVO extends BaseVO {
	private IfGo0051MobDataResVO response;

	public IfGo0051MobResVO() {
		super();
	}

	public IfGo0051MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfGo0051MobDataResVO response) {
		this.response = response;
	}



}