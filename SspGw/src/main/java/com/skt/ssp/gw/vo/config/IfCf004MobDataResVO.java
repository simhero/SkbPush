package com.skt.ssp.gw.vo.config;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobResVO;

/**
 * IfCf004MobDataResVO VO (IfCf004MobDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCf004MobDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCf004MobDataResVO extends BaseVO {
	private IfHeaderMobResVO header;
//	private IfCf004ComBodyResVO body;

	public IfCf004MobDataResVO() {
		super();
	}

	public IfHeaderMobResVO getHeader() {
		return header;
	}

//	public IfCf004ComBodyResVO getBody() {
//		return body;
//	}

	public void setHeader(IfHeaderMobResVO header) {
		this.header = header;
	}

//	public void setBody(IfCf004ComBodyResVO body) {
//		this.body = body;
//	}

}