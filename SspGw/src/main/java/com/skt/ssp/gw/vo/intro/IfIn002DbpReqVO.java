package com.skt.ssp.gw.vo.intro;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfIn002DbpReq VO (IfIn002DbpReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfIn002DbpReqVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfIn002DbpReqVO extends BaseVO {
	private IfIn002DbpDataReqVO request;

	public IfIn002DbpReqVO() {
		super();
	}

	public IfIn002DbpDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfIn002DbpDataReqVO request) {
		this.request = request;
	}



}