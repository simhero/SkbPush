package com.skt.ssp.gw.vo.settlement;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfSe002MobResVO (IfSe002MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSe002MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSe002MobResVO extends BaseVO {
	private IfSe002MobDataResVO response;

	public IfSe002MobResVO() {
		super();
	}

	public IfSe002MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfSe002MobDataResVO response) {
		this.response = response;
	}



}