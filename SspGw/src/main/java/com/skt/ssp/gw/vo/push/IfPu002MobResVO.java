package com.skt.ssp.gw.vo.push;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfPu002MobResVO (IfPu002MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfPu002MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfPu002MobResVO extends BaseVO {
	private IfPu002MobDataResVO response;

	public IfPu002MobResVO() {
		super();
	}

	public IfPu002MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfPu002MobDataResVO response) {
		this.response = response;
	}



}