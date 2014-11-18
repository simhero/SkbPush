package com.skt.ssp.gw.vo.intro;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobResVO;

/**
 * IfIn002MobDataRes VO (IfIn002MobDataResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfIn002MobDataResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfIn002MobDataResVO extends BaseVO {
	private IfHeaderMobResVO header;

	public IfIn002MobDataResVO() {
		super();
	}

	public IfHeaderMobResVO getHeader() {
		return header;
	}

	public void setHeader(IfHeaderMobResVO header) {
		this.header = header;
	}

}