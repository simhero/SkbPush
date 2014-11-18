package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo009MobResVO (IfGo009MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo009MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo009MobResVO extends BaseVO {
	private IfGo009MobDataResVO response;

	public IfGo009MobResVO() {
		super();
	}

	public IfGo009MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfGo009MobDataResVO response) {
		this.response = response;
	}



}