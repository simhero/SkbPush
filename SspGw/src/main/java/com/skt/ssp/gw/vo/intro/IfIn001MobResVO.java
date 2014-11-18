package com.skt.ssp.gw.vo.intro;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfIn001MobRes VO (IfIn001MobResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfIn001MobResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfIn001MobResVO extends BaseVO {
	private IfIn001MobDataResVO response;

	public IfIn001MobResVO() {
		super();
	}

	public IfIn001MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfIn001MobDataResVO response) {
		this.response = response;
	}



}