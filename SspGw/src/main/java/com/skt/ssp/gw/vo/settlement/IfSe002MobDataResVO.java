package com.skt.ssp.gw.vo.settlement;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobResVO;

/**
 * IfSe002MobDataResVO (IfSe002MobDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSe002MobDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSe002MobDataResVO extends BaseVO {
	private IfHeaderMobResVO header;
	private IfSe002ComBodyResVO body;

	public IfSe002MobDataResVO() {
		super();
	}

	public IfHeaderMobResVO getHeader() {
		return header;
	}

	public IfSe002ComBodyResVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderMobResVO header) {
		this.header = header;
	}

	public void setBody(IfSe002ComBodyResVO body) {
		this.body = body;
	}

}