package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo001MobResVO (IfGo001MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo001MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo001MobResVO extends BaseVO {
	private IfGo001MobDataResVO response;
	
	public IfGo001MobResVO() {
		super();
	}

	public IfGo001MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfGo001MobDataResVO response) {
		this.response = response;
	}
	
}
