package com.skt.ssp.gw.vo.config;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobResVO;

/**
 * IfCf002MobDataResVO (IfCf002MobDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCf002MobDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCf002MobDataResVO extends BaseVO {
	private IfHeaderMobResVO header;
//	private IfCf002ComBodyResVO body;

	public IfCf002MobDataResVO() {
		super();
	}

	public IfHeaderMobResVO getHeader() {
		return header;
	}

//	public IfCf002ComBodyResVO getBody() {
//		return body;
//	}

	public void setHeader(IfHeaderMobResVO header) {
		this.header = header;
	}

//	public void setBody(IfCf002ComBodyResVO body) {
//		this.body = body;
//	}

}