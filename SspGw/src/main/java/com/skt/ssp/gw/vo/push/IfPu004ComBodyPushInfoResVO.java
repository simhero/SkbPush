package com.skt.ssp.gw.vo.push;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfPu004ComBodyPushInfoResVO (IfPu004ComBodyPushInfoResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfPu004ComBodyPushInfoResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfPu004ComBodyPushInfoResVO extends BaseVO {
	private String transferGroupIdx	= "";
	private String idx				= "";
	private String rsltCode			= "";
	private String rsltMsg			= "";
	
	public IfPu004ComBodyPushInfoResVO() {
		super();
	}

	public String getTransferGroupIdx() {
		return transferGroupIdx;
	}

	public String getIdx() {
		return idx;
	}

	public String getRsltCode() {
		return rsltCode;
	}

	public String getRsltMsg() {
		return rsltMsg;
	}

	public void setTransferGroupIdx(String transferGroupIdx) {
		this.transferGroupIdx = transferGroupIdx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public void setRsltCode(String rsltCode) {
		this.rsltCode = rsltCode;
	}

	public void setRsltMsg(String rsltMsg) {
		this.rsltMsg = rsltMsg;
	}

}