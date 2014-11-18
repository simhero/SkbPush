package com.skt.ssp.gw.vo.settlement;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfSe001MobResVO (IfSe001MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSe001MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSe001MobResVO extends BaseVO {
	private IfSe001MobDataResVO response;

	public IfSe001MobResVO() {
		super();
	}

	public IfSe001MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfSe001MobDataResVO response) {
		this.response = response;
	}



}