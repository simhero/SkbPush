package com.skt.ssp.gw.vo.config;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCf002MobResVO (IfCf002MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCf002MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCf002MobResVO extends BaseVO {
	private IfCf002MobDataResVO response;

	public IfCf002MobResVO() {
		super();
	}

	public IfCf002MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCf002MobDataResVO response) {
		this.response = response;
	}



}