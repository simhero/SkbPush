package com.skt.ssp.gw.vo.intro;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfIn002MobRes VO (IfIn002MobResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfIn002MobResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfIn002MobResVO extends BaseVO {
	private IfIn002MobDataResVO response;

	public IfIn002MobResVO() {
		super();
	}

	public IfIn002MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfIn002MobDataResVO response) {
		this.response = response;
	}



}