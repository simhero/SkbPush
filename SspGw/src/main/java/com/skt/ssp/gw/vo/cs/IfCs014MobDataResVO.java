package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobResVO;

/**
 * IfCs014MobDataResVO (IfCs014MobDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs014MobDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs014MobDataResVO extends BaseVO {
	private IfHeaderMobResVO header;
//	private IfCs014ComBodyResVO body;

	public IfCs014MobDataResVO() {
		super();
	}

	public IfHeaderMobResVO getHeader() {
		return header;
	}

//	public IfCs014ComBodyResVO getBody() {
//		return body;
//	}

	public void setHeader(IfHeaderMobResVO header) {
		this.header = header;
	}

//	public void setBody(IfCs014ComBodyResVO body) {
//		this.body = body;
//	}

}