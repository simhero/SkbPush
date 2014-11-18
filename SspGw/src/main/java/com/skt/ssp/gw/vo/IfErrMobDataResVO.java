package com.skt.ssp.gw.vo;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobResVO;

/**
 * IfErrMobDataRes VO (IfErrMobDataResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfErrMobDataResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfErrMobDataResVO extends BaseVO {
	private IfHeaderMobResVO header;

	public IfErrMobDataResVO() {
		super();
	}

	public IfHeaderMobResVO getHeader() {
		return header;
	}

	public void setHeader(IfHeaderMobResVO header) {
		this.header = header;
	}

}