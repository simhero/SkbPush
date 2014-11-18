package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpResVO;

/**
 * IfGo001DbpDataResVO (IfGo001DbpDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo001DbpDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo001DbpDataResVO extends BaseVO {
	private IfHeaderDbpResVO header;
	private IfGo001ComBodyResVO body;
	
	public IfGo001DbpDataResVO() {
		super();
	}

	public IfHeaderDbpResVO getHeader() {
		return header;
	}

	public void setHeader(IfHeaderDbpResVO header) {
		this.header = header;
	}

	public IfGo001ComBodyResVO getBody() {
		return body;
	}

	public void setBody(IfGo001ComBodyResVO body) {
		this.body = body;
	}
	
}
