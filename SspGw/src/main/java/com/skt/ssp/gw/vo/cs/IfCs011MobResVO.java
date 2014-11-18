package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs011MobResVO (IfCs011MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs011MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs011MobResVO extends BaseVO {
	private IfCs011MobDataResVO response;

	public IfCs011MobResVO() {
		super();
	}

	public IfCs011MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCs011MobDataResVO response) {
		this.response = response;
	}



}