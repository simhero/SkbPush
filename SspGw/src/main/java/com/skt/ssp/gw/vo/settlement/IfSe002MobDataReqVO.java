package com.skt.ssp.gw.vo.settlement;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobReqVO;

/**
 * IfSe002MobDataReqVO (IfSe002MobDataReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSe002MobDataReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSe002MobDataReqVO extends BaseVO {
	private IfHeaderMobReqVO header;
	private IfSe002ComBodyReqVO body;

	public IfSe002MobDataReqVO() {
		super();
	}

	public IfHeaderMobReqVO getHeader() {
		return header;
	}

	public IfSe002ComBodyReqVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderMobReqVO header) {
		this.header = header;
	}

	public void setBody(IfSe002ComBodyReqVO body) {
		this.body = body;
	}

}