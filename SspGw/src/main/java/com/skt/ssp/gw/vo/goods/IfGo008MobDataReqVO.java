package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobReqVO;

/**
 * IfGo008MobDataReqVO (IfGo008MobDataReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo008MobDataReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo008MobDataReqVO extends BaseVO {
	private IfHeaderMobReqVO header;
	private IfGo008ComBodyReqVO body;

	public IfGo008MobDataReqVO() {
		super();
	}

	public IfHeaderMobReqVO getHeader() {
		return header;
	}

	public IfGo008ComBodyReqVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderMobReqVO header) {
		this.header = header;
	}

	public void setBody(IfGo008ComBodyReqVO body) {
		this.body = body;
	}

}