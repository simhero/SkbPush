package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo007MobResVO (IfGo007MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo007MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo007MobResVO extends BaseVO {
	private IfGo007MobDataResVO response;

	public IfGo007MobResVO() {
		super();
	}

	public IfGo007MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfGo007MobDataResVO response) {
		this.response = response;
	}



}