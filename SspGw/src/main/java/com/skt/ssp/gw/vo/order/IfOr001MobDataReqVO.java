package com.skt.ssp.gw.vo.order;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobReqVO;

/**
 * IfOr001MobDataReqVO (IfOr001MobDataReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfOr001MobDataReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfOr001MobDataReqVO extends BaseVO {
	private IfHeaderMobReqVO header;
	private IfOr001ComBodyReqVO body;

	public IfOr001MobDataReqVO() {
		super();
	}

	public IfHeaderMobReqVO getHeader() {
		return header;
	}

	public IfOr001ComBodyReqVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderMobReqVO header) {
		this.header = header;
	}

	public void setBody(IfOr001ComBodyReqVO body) {
		this.body = body;
	}

}