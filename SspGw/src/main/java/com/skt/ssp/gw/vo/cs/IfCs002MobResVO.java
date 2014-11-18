package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs002MobResVO (IfCs002MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs002MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs002MobResVO extends BaseVO {
	private IfCs002MobDataResVO response;

	public IfCs002MobResVO() {
		super();
	}

	public IfCs002MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCs002MobDataResVO response) {
		this.response = response;
	}



}