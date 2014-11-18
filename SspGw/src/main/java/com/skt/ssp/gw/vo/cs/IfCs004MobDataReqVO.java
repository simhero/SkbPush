package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobReqVO;

/**
 * IfCs004MobDataReqVO (IfCs004MobDataReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs004MobDataReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs004MobDataReqVO extends BaseVO {
	private IfHeaderMobReqVO header;
	private IfCs004ComBodyReqVO body;

	public IfCs004MobDataReqVO() {
		super();
	}

	public IfHeaderMobReqVO getHeader() {
		return header;
	}

	public IfCs004ComBodyReqVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderMobReqVO header) {
		this.header = header;
	}

	public void setBody(IfCs004ComBodyReqVO body) {
		this.body = body;
	}

}