package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo012MobResVO (IfGo012MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo012MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo012MobResVO extends BaseVO {
	private IfGo012MobDataResVO response;

	public IfGo012MobResVO() {
		super();
	}

	public IfGo012MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfGo012MobDataResVO response) {
		this.response = response;
	}



}