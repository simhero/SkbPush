package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobResVO;

/**
 * IfGo002MobDataResVO (IfGo002MobDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo002MobDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo002MobDataResVO extends BaseVO {
	private IfHeaderMobResVO header;
	private IfGo002ComBodyResVO body;

	public IfGo002MobDataResVO() {
		super();
	}

	public IfHeaderMobResVO getHeader() {
		return header;
	}

	public IfGo002ComBodyResVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderMobResVO header) {
		this.header = header;
	}

	public void setBody(IfGo002ComBodyResVO body) {
		this.body = body;
	}

}