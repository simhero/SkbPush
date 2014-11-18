package com.skt.ssp.gw.vo;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpResVO;

/**
 * IfHeaderDbpRes VO (IfHeaderDbpResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfHeaderDbpResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfHeaderDbpResVO extends BaseVO {
	private String authKey = "";
	private String interfaceId = "";
	private String resultCode = "";
	private String resultMsg = "";
	private String responseDate = "";

	public IfHeaderDbpResVO() {
		super();
		this.authKey = "";
		this.interfaceId = "";
		this.resultCode = "";
		this.resultMsg = "";
		this.responseDate = "";
	}

	public String getAuthKey() {
		return authKey;
	}

	public String getInterfaceId() {
		return interfaceId;
	}

	public String getResultCode() {
		return resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public String getResponseDate() {
		return responseDate;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

	public void setInterfaceId(String interfaceId) {
		this.interfaceId = interfaceId;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public void setResponseDate(String responseDate) {
		this.responseDate = responseDate;
	}

}