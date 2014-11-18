package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobResVO;

/**
 * IfCs007MobDataResVO (IfCs007MobDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs007MobDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs007MobDataResVO extends BaseVO {
	private IfHeaderMobResVO header;
//	private IfCs007ComBodyResVO body;

	public IfCs007MobDataResVO() {
		super();
	}

	public IfHeaderMobResVO getHeader() {
		return header;
	}

//	public IfCs007ComBodyResVO getBody() {
//		return body;
//	}

	public void setHeader(IfHeaderMobResVO header) {
		this.header = header;
	}

//	public void setBody(IfCs007ComBodyResVO body) {
//		this.body = body;
//	}

}