package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobResVO;

/**
 * IfCs015MobDataResVO (IfCs015MobDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs015MobDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs015MobDataResVO extends BaseVO {
	private IfHeaderMobResVO header;
//	private IfCs015ComBodyResVO body;

	public IfCs015MobDataResVO() {
		super();
	}

	public IfHeaderMobResVO getHeader() {
		return header;
	}

//	public IfCs015ComBodyResVO getBody() {
//		return body;
//	}

	public void setHeader(IfHeaderMobResVO header) {
		this.header = header;
	}

//	public void setBody(IfCs015ComBodyResVO body) {
//		this.body = body;
//	}

}