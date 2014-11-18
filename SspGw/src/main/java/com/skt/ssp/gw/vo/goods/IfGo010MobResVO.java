package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo010MobResVO (IfGo010MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo010MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo010MobResVO extends BaseVO {
	private IfGo010MobDataResVO response;

	public IfGo010MobResVO() {
		super();
	}

	public IfGo010MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfGo010MobDataResVO response) {
		this.response = response;
	}



}