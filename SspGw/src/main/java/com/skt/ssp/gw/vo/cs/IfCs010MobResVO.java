package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs010MobResVO (IfCs010MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs010MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs010MobResVO extends BaseVO {
	private IfCs010MobDataResVO response;

	public IfCs010MobResVO() {
		super();
	}

	public IfCs010MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCs010MobDataResVO response) {
		this.response = response;
	}



}