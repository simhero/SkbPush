package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCu007DbpDataRes VO (IfCu007DbpDataResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu007DbpDataResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu008MobResVO extends BaseVO {
	private IfCu008MobDataResVO response;

	public IfCu008MobResVO() {
		super();
	}

	public IfCu008MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCu008MobDataResVO response) {
		this.response = response;
	}

}
