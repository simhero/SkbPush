package com.skt.ssp.gw.vo.push;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfPu004ComBodyPushInfoReqVO (IfPu004ComBodyPushInfoReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfPu004ComBodyPushInfoReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfPu004ComBodyPushInfoReqVO extends BaseVO {
	private String transferGroupIdx	= "";
	private String idx				= "";

	public IfPu004ComBodyPushInfoReqVO() {
		super();
	}

	public String getTransferGroupIdx() {
		return transferGroupIdx;
	}

	public String getIdx() {
		return idx;
	}

	public void setTransferGroupIdx(String transferGroupIdx) {
		this.transferGroupIdx = transferGroupIdx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

}