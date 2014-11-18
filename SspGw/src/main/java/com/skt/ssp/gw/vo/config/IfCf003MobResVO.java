package com.skt.ssp.gw.vo.config;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCf003MobResVO (IfCf003MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCf003MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCf003MobResVO extends BaseVO {
	private IfCf003MobDataResVO response;

	public IfCf003MobResVO() {
		super();
	}

	public IfCf003MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCf003MobDataResVO response) {
		this.response = response;
	}



}