package com.skt.ssp.gw.vo.intro;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfIn001MobReq VO (IfIn001MobReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfIn001MobReqVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfIn001MobReqVO extends BaseVO {
	private IfIn001MobDataReqVO request;

	public IfIn001MobReqVO() {
		super();
	}

	public IfIn001MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfIn001MobDataReqVO request) {
		this.request = request;
	}

}