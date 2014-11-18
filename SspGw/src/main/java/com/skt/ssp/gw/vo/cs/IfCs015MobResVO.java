package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs015MobResVO (IfCs015MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs015MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs015MobResVO extends BaseVO {
	private IfCs015MobDataResVO response;

	public IfCs015MobResVO() {
		super();
	}

	public IfCs015MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCs015MobDataResVO response) {
		this.response = response;
	}



}