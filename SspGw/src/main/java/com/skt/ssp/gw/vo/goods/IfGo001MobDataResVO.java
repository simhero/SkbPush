package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobResVO;

/**
 * IfGo001MobDataResVO (IfGo001MobDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo001MobDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo001MobDataResVO extends BaseVO {
	private IfHeaderMobResVO header;
	private IfGo001ComBodyResVO body;
	
	public IfGo001MobDataResVO() {
		super();
	}

	public IfHeaderMobResVO getHeader() {
		return header;
	}

	public void setHeader(IfHeaderMobResVO header) {
		this.header = header;
	}

	public IfGo001ComBodyResVO getBody() {
		return body;
	}

	public void setBody(IfGo001ComBodyResVO body) {
		this.body = body;
	}
}
