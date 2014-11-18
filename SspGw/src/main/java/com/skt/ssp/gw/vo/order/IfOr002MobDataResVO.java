package com.skt.ssp.gw.vo.order;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobResVO;

/**
 * IfOr002MobDataResVO (IfOr002MobDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfOr002MobDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfOr002MobDataResVO extends BaseVO {
	private IfHeaderMobResVO header;
	private IfOr002ComBodyResVO body;

	public IfOr002MobDataResVO() {
		super();
	}

	public IfHeaderMobResVO getHeader() {
		return header;
	}

	public IfOr002ComBodyResVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderMobResVO header) {
		this.header = header;
	}

	public void setBody(IfOr002ComBodyResVO body) {
		this.body = body;
	}

}