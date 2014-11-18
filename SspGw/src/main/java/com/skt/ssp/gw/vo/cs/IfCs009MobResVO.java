package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs009MobResVO (IfCs009MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs009MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs009MobResVO extends BaseVO {
	private IfCs009MobDataResVO response;

	public IfCs009MobResVO() {
		super();
	}

	public IfCs009MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCs009MobDataResVO response) {
		this.response = response;
	}



}