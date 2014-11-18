package com.skt.ssp.gw.vo.settlement;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfSe001ComBodyUidReqVO (IfSe001ComBodyUidReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSe001ComBodyUidReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSe001ComBodyUidReqVO extends BaseVO {
	private String uid	= "";
	
	public IfSe001ComBodyUidReqVO() {
		super();
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}
