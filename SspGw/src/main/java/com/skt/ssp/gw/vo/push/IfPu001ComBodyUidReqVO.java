package com.skt.ssp.gw.vo.push;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfPu001ComBodyUidReqVO (IfPu001ComBodyUidReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfPu001ComBodyUidReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfPu001ComBodyUidReqVO extends BaseVO {
	private String uid			= "";

	public IfPu001ComBodyUidReqVO() {
		super();
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}