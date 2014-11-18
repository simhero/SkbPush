package com.skt.ssp.gw.vo.statistics;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfSt002MobResVO (IfSt002MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSt002MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSt002MobResVO extends BaseVO {
	private IfSt002MobDataResVO response;

	public IfSt002MobResVO() {
		super();
	}

	public IfSt002MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfSt002MobDataResVO response) {
		this.response = response;
	}



}