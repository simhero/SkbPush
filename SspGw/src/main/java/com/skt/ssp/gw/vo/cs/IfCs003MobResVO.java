package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs003MobResVO (IfCs003MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs003MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs003MobResVO extends BaseVO {
	private IfCs003MobDataResVO response;

	public IfCs003MobResVO() {
		super();
	}

	public IfCs003MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCs003MobDataResVO response) {
		this.response = response;
	}



}