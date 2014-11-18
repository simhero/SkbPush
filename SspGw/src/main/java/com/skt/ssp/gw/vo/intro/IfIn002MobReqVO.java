package com.skt.ssp.gw.vo.intro;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfIn002MobReq VO (IfIn002MobReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfIn002MobReqVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfIn002MobReqVO extends BaseVO {
	private IfIn002MobDataReqVO request;

	public IfIn002MobReqVO() {
		super();
	}

	public IfIn002MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfIn002MobDataReqVO request) {
		this.request = request;
	}

}