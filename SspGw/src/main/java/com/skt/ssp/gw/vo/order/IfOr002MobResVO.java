package com.skt.ssp.gw.vo.order;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfOr002MobResVO (IfOr002MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfOr002MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfOr002MobResVO extends BaseVO {
	private IfOr002MobDataResVO response;

	public IfOr002MobResVO() {
		super();
	}

	public IfOr002MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfOr002MobDataResVO response) {
		this.response = response;
	}



}