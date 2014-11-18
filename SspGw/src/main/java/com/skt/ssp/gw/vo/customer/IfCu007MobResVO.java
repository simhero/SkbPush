package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCu007DbpDataRes VO (IfCu007DbpDataResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu007DbpDataResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu007MobResVO extends BaseVO {
	private IfCu007MobDataResVO response;

	public IfCu007MobResVO() {
		super();
	}

	public IfCu007MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCu007MobDataResVO response) {
		this.response = response;
	}

}
