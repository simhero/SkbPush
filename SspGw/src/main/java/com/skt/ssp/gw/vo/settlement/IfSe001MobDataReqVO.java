package com.skt.ssp.gw.vo.settlement;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobReqVO;

/**
 * IfSe001MobDataReqVO (IfSe001MobDataReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSe001MobDataReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSe001MobDataReqVO extends BaseVO {
	private IfHeaderMobReqVO header;
	private IfSe001ComBodyReqVO body;

	public IfSe001MobDataReqVO() {
		super();
	}

	public IfHeaderMobReqVO getHeader() {
		return header;
	}

	public IfSe001ComBodyReqVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderMobReqVO header) {
		this.header = header;
	}

	public void setBody(IfSe001ComBodyReqVO body) {
		this.body = body;
	}

}