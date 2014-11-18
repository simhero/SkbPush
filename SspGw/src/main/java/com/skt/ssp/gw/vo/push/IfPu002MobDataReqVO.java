package com.skt.ssp.gw.vo.push;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobReqVO;

/**
 * IfPu002MobDataReqVO (IfPu002MobDataReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfPu002MobDataReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfPu002MobDataReqVO extends BaseVO {
	private IfHeaderMobReqVO header;
	private IfPu002ComBodyReqVO body;

	public IfPu002MobDataReqVO() {
		super();
	}

	public IfHeaderMobReqVO getHeader() {
		return header;
	}

	public IfPu002ComBodyReqVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderMobReqVO header) {
		this.header = header;
	}

	public void setBody(IfPu002ComBodyReqVO body) {
		this.body = body;
	}

}