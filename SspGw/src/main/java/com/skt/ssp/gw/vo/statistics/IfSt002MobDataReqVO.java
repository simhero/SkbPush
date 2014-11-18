package com.skt.ssp.gw.vo.statistics;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobReqVO;

/**
 * IfSt002MobDataReqVO (IfSt002MobDataReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSt002MobDataReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSt002MobDataReqVO extends BaseVO {
	private IfHeaderMobReqVO header;
	private IfSt002ComBodyReqVO body;

	public IfSt002MobDataReqVO() {
		super();
	}

	public IfHeaderMobReqVO getHeader() {
		return header;
	}

	public IfSt002ComBodyReqVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderMobReqVO header) {
		this.header = header;
	}

	public void setBody(IfSt002ComBodyReqVO body) {
		this.body = body;
	}

}