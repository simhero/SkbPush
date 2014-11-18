package com.skt.ssp.gw.vo.config;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCf004MobResVO (IfCf004MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCf004MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCf004MobResVO extends BaseVO {
	private IfCf004MobDataResVO response;

	public IfCf004MobResVO() {
		super();
	}

	public IfCf004MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCf004MobDataResVO response) {
		this.response = response;
	}



}