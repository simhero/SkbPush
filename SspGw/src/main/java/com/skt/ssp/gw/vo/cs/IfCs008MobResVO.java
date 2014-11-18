package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs008MobResVO (IfCs008MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs008MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs008MobResVO extends BaseVO {
	private IfCs008MobDataResVO response;

	public IfCs008MobResVO() {
		super();
	}

	public IfCs008MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCs008MobDataResVO response) {
		this.response = response;
	}



}