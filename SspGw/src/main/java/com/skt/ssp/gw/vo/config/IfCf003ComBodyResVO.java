package com.skt.ssp.gw.vo.config;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCf003ComBodyResVO (IfCf003ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCf003ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCf003ComBodyResVO extends BaseVO {
	private String useGlobalWpriceYn	= "";

	public IfCf003ComBodyResVO() {
		super();
	}

	public String getUseGlobalWpriceYn() {
		return useGlobalWpriceYn;
	}

	public void setUseGlobalWpriceYn(String useGlobalWpriceYn) {
		this.useGlobalWpriceYn = useGlobalWpriceYn;
	}

}