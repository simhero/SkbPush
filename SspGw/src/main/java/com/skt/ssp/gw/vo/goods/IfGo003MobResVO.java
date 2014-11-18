package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo003MobResVO (IfGo003MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo003MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo003MobResVO extends BaseVO {
	private IfGo003MobDataResVO response;

	public IfGo003MobResVO() {
		super();
	}

	public IfGo003MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfGo003MobDataResVO response) {
		this.response = response;
	}



}