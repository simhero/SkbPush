package com.skt.ssp.gw.vo.statistics;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobResVO;

/**
 * IfSt002MobDataResVO (IfSt002MobDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSt002MobDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSt002MobDataResVO extends BaseVO {
	private IfHeaderMobResVO header;
	private IfSt002ComBodyResVO body;

	public IfSt002MobDataResVO() {
		super();
	}

	public IfHeaderMobResVO getHeader() {
		return header;
	}

	public IfSt002ComBodyResVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderMobResVO header) {
		this.header = header;
	}

	public void setBody(IfSt002ComBodyResVO body) {
		this.body = body;
	}

}