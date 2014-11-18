package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs014MobResVO (IfCs014MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs014MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs014MobResVO extends BaseVO {
	private IfCs014MobDataResVO response;

	public IfCs014MobResVO() {
		super();
	}

	public IfCs014MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCs014MobDataResVO response) {
		this.response = response;
	}



}