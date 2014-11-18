package com.skt.ssp.gw.vo.push;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfPu004MobResVO (IfPu004MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfPu004MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfPu004MobResVO extends BaseVO {
	private IfPu004MobDataResVO response;

	public IfPu004MobResVO() {
		super();
	}

	public IfPu004MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfPu004MobDataResVO response) {
		this.response = response;
	}



}