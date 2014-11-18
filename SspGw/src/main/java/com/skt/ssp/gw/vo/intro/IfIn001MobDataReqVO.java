package com.skt.ssp.gw.vo.intro;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobReqVO;

/**
 * IfIn001MobDataReq VO (IfIn001MobDataReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfIn001MobDataReqVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfIn001MobDataReqVO extends BaseVO {
	private IfHeaderMobReqVO header;
	private IfIn001ComBodyReqVO body;

	public IfIn001MobDataReqVO() {
		super();
	}

	public IfHeaderMobReqVO getHeader() {
		return header;
	}

	public IfIn001ComBodyReqVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderMobReqVO header) {
		this.header = header;
	}

	public void setBody(IfIn001ComBodyReqVO body) {
		this.body = body;
	}

}