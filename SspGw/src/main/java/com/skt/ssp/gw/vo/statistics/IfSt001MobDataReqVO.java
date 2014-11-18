package com.skt.ssp.gw.vo.statistics;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobReqVO;

/**
 * IfSt001MobDataReqVO (IfSt001MobDataReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSt001MobDataReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSt001MobDataReqVO extends BaseVO {
	private IfHeaderMobReqVO header;
	private IfSt001ComBodyReqVO body;

	public IfSt001MobDataReqVO() {
		super();
	}

	public IfHeaderMobReqVO getHeader() {
		return header;
	}

	public IfSt001ComBodyReqVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderMobReqVO header) {
		this.header = header;
	}

	public void setBody(IfSt001ComBodyReqVO body) {
		this.body = body;
	}

}