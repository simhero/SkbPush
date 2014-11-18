package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs007MobResVO (IfCs007MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs007MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs007MobResVO extends BaseVO {
	private IfCs007MobDataResVO response;

	public IfCs007MobResVO() {
		super();
	}

	public IfCs007MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCs007MobDataResVO response) {
		this.response = response;
	}



}