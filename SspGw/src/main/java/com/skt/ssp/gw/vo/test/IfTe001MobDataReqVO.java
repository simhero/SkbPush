package com.skt.ssp.gw.vo.test;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobReqVO;

/**
 * IfTe001MobDataReq VO (IfTe001MobDataReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfTe001MobDataReqVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfTe001MobDataReqVO extends BaseVO {
	private IfHeaderMobReqVO header;
	private IfTe001ComBodyReqVO body;

	public IfTe001MobDataReqVO() {
		super();
	}

	public IfHeaderMobReqVO getHeader() {
		return header;
	}

	public IfTe001ComBodyReqVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderMobReqVO header) {
		this.header = header;
	}

	public void setBody(IfTe001ComBodyReqVO body) {
		this.body = body;
	}

}