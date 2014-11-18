package com.skt.ssp.gw.vo.config;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCf001MobResVO (IfCf001MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCf001MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCf001MobResVO extends BaseVO {
	private IfCf001MobDataResVO response;

	public IfCf001MobResVO() {
		super();
	}

	public IfCf001MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCf001MobDataResVO response) {
		this.response = response;
	}



}