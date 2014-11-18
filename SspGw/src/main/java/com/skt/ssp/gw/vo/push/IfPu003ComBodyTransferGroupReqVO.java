package com.skt.ssp.gw.vo.push;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfPu003ComBodyTransferGroupReqVO (IfPu003ComBodyTransferGroupReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfPu003ComBodyTransferGroupReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfPu003ComBodyTransferGroupReqVO extends BaseVO {
	private String transferGroupIdx	= "";
	private String mainCode			= "";
	private String uid				= "";
	private String pushMsg			= "";
	private String requestDate		= "";

	public IfPu003ComBodyTransferGroupReqVO() {
		super();
	}

	public String getTransferGroupIdx() {
		return transferGroupIdx;
	}

	public String getMainCode() {
		return mainCode;
	}

	public String getUid() {
		return uid;
	}

	public String getPushMsg() {
		return pushMsg;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setTransferGroupIdx(String transferGroupIdx) {
		this.transferGroupIdx = transferGroupIdx;
	}

	public void setMainCode(String mainCode) {
		this.mainCode = mainCode;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setPushMsg(String pushMsg) {
		this.pushMsg = pushMsg;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

}