package com.skt.ssp.gw.vo.push;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobResVO;

/**
 * IfPu004MobDataResVO (IfPu004MobDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfPu004MobDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfPu004MobDataResVO extends BaseVO {
	private IfHeaderMobResVO header;
	private IfPu004ComBodyResVO body;

	public IfPu004MobDataResVO() {
		super();
	}

	public IfHeaderMobResVO getHeader() {
		return header;
	}

	public IfPu004ComBodyResVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderMobResVO header) {
		this.header = header;
	}

	public void setBody(IfPu004ComBodyResVO body) {
		this.body = body;
	}

}