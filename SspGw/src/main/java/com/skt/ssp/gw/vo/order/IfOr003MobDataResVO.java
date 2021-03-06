package com.skt.ssp.gw.vo.order;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobResVO;

/**
 * IfOr003MobDataResVO (IfOr003MobDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfOr003MobDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfOr003MobDataResVO extends BaseVO {
	private IfHeaderMobResVO header;
	private IfOr003ComBodyResVO body;

	public IfOr003MobDataResVO() {
		super();
	}

	public IfHeaderMobResVO getHeader() {
		return header;
	}

	public IfOr003ComBodyResVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderMobResVO header) {
		this.header = header;
	}

	public void setBody(IfOr003ComBodyResVO body) {
		this.body = body;
	}

}