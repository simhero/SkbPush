package com.skt.ssp.gw.vo.push;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfPu001ComBodyPushMsgResVO (IfPu001ComBodyPushMsgResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfPu001ComBodyPushMsgResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfPu001ComBodyPushMsgResVO extends BaseVO {
	private String transferGroupIdx	= "";
	private String csNew			= "";
	private String pushMsg			= "";
	private String procDate			= "";

	public IfPu001ComBodyPushMsgResVO() {
		super();
	}

	public String getTransferGroupIdx() {
		return transferGroupIdx;
	}

	public String getCsNew() {
		return csNew;
	}

	public String getPushMsg() {
		return pushMsg;
	}

	public String getProcDate() {
		return procDate;
	}

	public void setTransferGroupIdx(String transferGroupIdx) {
		this.transferGroupIdx = transferGroupIdx;
	}

	public void setCsNew(String csNew) {
		this.csNew = csNew;
	}

	public void setPushMsg(String pushMsg) {
		this.pushMsg = pushMsg;
	}

	public void setProcDate(String procDate) {
		this.procDate = procDate;
	}

}