package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobReqVO;

/**
 * IfGo0051MobDataReqVO (IfGo0051MobDataReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo0051MobDataReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo0051MobDataReqVO extends BaseVO {
	private IfHeaderMobReqVO header;
	private IfGo0051ComBodyReqVO body;

	public IfGo0051MobDataReqVO() {
		super();
	}

	public IfHeaderMobReqVO getHeader() {
		return header;
	}

	public IfGo0051ComBodyReqVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderMobReqVO header) {
		this.header = header;
	}

	public void setBody(IfGo0051ComBodyReqVO body) {
		this.body = body;
	}

}