package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobReqVO;

/**
 * IfGo001MobDataReqVO (IfGo001MobDataReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo001MobDataReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo001MobDataReqVO extends BaseVO {
	private IfHeaderMobReqVO header;
	private IfGo001ComBodyReqVO body;
	
	public IfGo001MobDataReqVO() {
		super();
	}

	public IfHeaderMobReqVO getHeader() {
		return header;
	}

	public void setHeader(IfHeaderMobReqVO header) {
		this.header = header;
	}

	public IfGo001ComBodyReqVO getBody() {
		return body;
	}

	public void setBody(IfGo001ComBodyReqVO body) {
		this.body = body;
	}
	
}
