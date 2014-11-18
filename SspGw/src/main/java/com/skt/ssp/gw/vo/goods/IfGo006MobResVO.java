package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo006MobResVO (IfGo006MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo006MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo006MobResVO extends BaseVO {
	private IfGo006MobDataResVO response;

	public IfGo006MobResVO() {
		super();
	}

	public IfGo006MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfGo006MobDataResVO response) {
		this.response = response;
	}



}