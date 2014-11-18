package com.skt.ssp.gw.vo;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobResVO;

/**
 * IfHeaderMobRes VO (IfHeaderMobResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfHeaderMobResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfHeaderMobResVO extends BaseVO {
	private String comAuthKey = "";
	private String comTrId = "";
	private String comInterfaceId = "";
	private String comResultCode = "";
	private String comResultMsg = "";
	private String comResponseDate = "";

	public IfHeaderMobResVO() {
		super();
		this.comAuthKey = "";
		this.comTrId = "";
		this.comInterfaceId = "";
		this.comResultCode = "";
		this.comResultMsg = "";
		this.comResponseDate = "";
	}

	public String getComAuthKey() {
		return comAuthKey;
	}

	public String getComTrId() {
		return comTrId;
	}

	public String getComInterfaceId() {
		return comInterfaceId;
	}

	public String getComResultCode() {
		return comResultCode;
	}

	public String getComResultMsg() {
		return comResultMsg;
	}

	public String getComResponseDate() {
		return comResponseDate;
	}

	public void setComAuthKey(String comAuthKey) {
		this.comAuthKey = comAuthKey;
	}

	public void setComTrId(String comTrId) {
		this.comTrId = comTrId;
	}

	public void setComInterfaceId(String comInterfaceId) {
		this.comInterfaceId = comInterfaceId;
	}

	public void setComResultCode(String comResultCode) {
		this.comResultCode = comResultCode;
	}

	public void setComResultMsg(String comResultMsg) {
		this.comResultMsg = comResultMsg;
	}

	public void setComResponseDate(String comResponseDate) {
		this.comResponseDate = comResponseDate;
	}

}