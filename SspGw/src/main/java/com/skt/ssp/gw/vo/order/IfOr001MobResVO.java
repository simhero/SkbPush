package com.skt.ssp.gw.vo.order;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfOr001MobResVO (IfOr001MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfOr001MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfOr001MobResVO extends BaseVO {
	private IfOr001MobDataResVO response;

	public IfOr001MobResVO() {
		super();
	}

	public IfOr001MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfOr001MobDataResVO response) {
		this.response = response;
	}



}