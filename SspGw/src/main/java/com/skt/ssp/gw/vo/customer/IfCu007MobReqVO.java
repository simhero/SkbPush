package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCu007DbpDataRes VO (IfCu007DbpDataResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu007DbpDataResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu007MobReqVO extends BaseVO {
	private IfCu007MobDataReqVO request;

	public IfCu007MobReqVO() {
		super();
	}

	public IfCu007MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCu007MobDataReqVO request) {
		this.request = request;
	}

}
