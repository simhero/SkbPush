package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs006MobResVO (IfCs006MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs006MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs006MobResVO extends BaseVO {
	private IfCs006MobDataResVO response;

	public IfCs006MobResVO() {
		super();
	}

	public IfCs006MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCs006MobDataResVO response) {
		this.response = response;
	}



}