package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobResVO;

/**
 * IfCs001MobDataResVO (IfCs001MobDataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs001MobDataResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs001MobDataResVO extends BaseVO {
	private IfHeaderMobResVO header;
	private IfCs001ComBodyResVO body;

	public IfCs001MobDataResVO() {
		super();
	}

	public IfHeaderMobResVO getHeader() {
		return header;
	}

	public IfCs001ComBodyResVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderMobResVO header) {
		this.header = header;
	}

	public void setBody(IfCs001ComBodyResVO body) {
		this.body = body;
	}

}