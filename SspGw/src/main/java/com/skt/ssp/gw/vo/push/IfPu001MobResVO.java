package com.skt.ssp.gw.vo.push;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfPu001MobResVO (IfPu001MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfPu001MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfPu001MobResVO extends BaseVO {
	private IfPu001MobDataResVO response;

	public IfPu001MobResVO() {
		super();
	}

	public IfPu001MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfPu001MobDataResVO response) {
		this.response = response;
	}



}