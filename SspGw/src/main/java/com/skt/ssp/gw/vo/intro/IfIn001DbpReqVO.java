package com.skt.ssp.gw.vo.intro;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfIn001DbpReq VO (IfIn001DbpReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfIn001DbpReqVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfIn001DbpReqVO extends BaseVO {
	private IfIn001DbpDataReqVO request;

	public IfIn001DbpReqVO() {
		super();
	}

	public IfIn001DbpDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfIn001DbpDataReqVO request) {
		this.request = request;
	}



}