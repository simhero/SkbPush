package com.skt.ssp.gw.vo.statistics;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfSt002ComBodyUidReqVO (IfSt002ComBodyUidReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSt002ComBodyUidReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSt002ComBodyUidReqVO extends BaseVO {
	private String uid	= "";

	public IfSt002ComBodyUidReqVO() {
		super();
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}