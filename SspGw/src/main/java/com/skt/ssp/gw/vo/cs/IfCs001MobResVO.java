package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs001MobResVO (IfCs001MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs001MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs001MobResVO extends BaseVO {
	private IfCs001MobDataResVO response;

	public IfCs001MobResVO() {
		super();
	}

	public IfCs001MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCs001MobDataResVO response) {
		this.response = response;
	}



}