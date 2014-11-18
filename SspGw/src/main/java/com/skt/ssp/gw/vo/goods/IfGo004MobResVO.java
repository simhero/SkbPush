package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo004MobResVO (IfGo004MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo004MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo004MobResVO extends BaseVO {
	private IfGo004MobDataResVO response;

	public IfGo004MobResVO() {
		super();
	}

	public IfGo004MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfGo004MobDataResVO response) {
		this.response = response;
	}



}