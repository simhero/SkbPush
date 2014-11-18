package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs012MobResVO (IfCs012MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs012MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs012MobResVO extends BaseVO {
	private IfCs012MobDataResVO response;

	public IfCs012MobResVO() {
		super();
	}

	public IfCs012MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCs012MobDataResVO response) {
		this.response = response;
	}



}