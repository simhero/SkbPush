package com.skt.ssp.gw.vo.order;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfOr003MobResVO (IfOr003MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfOr003MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfOr003MobResVO extends BaseVO {
	private IfOr003MobDataResVO response;

	public IfOr003MobResVO() {
		super();
	}

	public IfOr003MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfOr003MobDataResVO response) {
		this.response = response;
	}



}