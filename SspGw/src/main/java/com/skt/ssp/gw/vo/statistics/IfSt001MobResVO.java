package com.skt.ssp.gw.vo.statistics;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfSt001MobResVO (IfSt001MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSt001MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSt001MobResVO extends BaseVO {
	private IfSt001MobDataResVO response;

	public IfSt001MobResVO() {
		super();
	}

	public IfSt001MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfSt001MobDataResVO response) {
		this.response = response;
	}



}