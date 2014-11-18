package com.skt.ssp.gw.vo.statistics;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfSt001ComBodyUidReqVO (IfSt001ComBodyUidReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSt001ComBodyUidReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSt001ComBodyUidReqVO extends BaseVO {
	private String uid	= "";

	public IfSt001ComBodyUidReqVO() {
		super();
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}