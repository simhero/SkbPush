package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs004MobResVO (IfCs004MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs004MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs004MobResVO extends BaseVO {
	private IfCs004MobDataResVO response;

	public IfCs004MobResVO() {
		super();
	}

	public IfCs004MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCs004MobDataResVO response) {
		this.response = response;
	}



}