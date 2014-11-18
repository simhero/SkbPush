package com.skt.ssp.gw.vo.config;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCf004ComBodyReqVO (IfCf004ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCf004ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCf004ComBodyReqVO extends BaseVO {
	private String adminCode			= "";
	private String userId				= "";
	private String useGlobalWpriceYn	= "";
	
	public IfCf004ComBodyReqVO() {
		super();
	}

	public String getAdminCode() {
		return adminCode;
	}

	public String getUserId() {
		return userId;
	}

	public String getUseGlobalWpriceYn() {
		return useGlobalWpriceYn;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUseGlobalWpriceYn(String useGlobalWpriceYn) {
		this.useGlobalWpriceYn = useGlobalWpriceYn;
	}

}