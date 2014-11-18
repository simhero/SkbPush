package com.skt.ssp.gw.vo.intro;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobResVO;

/**
 * IfIn001MobDataRes VO (IfIn001MobDataResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfIn001MobDataResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfIn001MobDataResVO extends BaseVO {
	private IfHeaderMobResVO header;
	private IfIn001ComBodyResVO body;

	public IfIn001MobDataResVO() {
		super();
	}

	public IfHeaderMobResVO getHeader() {
		return header;
	}

	public IfIn001ComBodyResVO getBody() {
		return body;
	}

	public void setHeader(IfHeaderMobResVO header) {
		this.header = header;
	}

	public void setBody(IfIn001ComBodyResVO body) {
		this.body = body;
	}

}