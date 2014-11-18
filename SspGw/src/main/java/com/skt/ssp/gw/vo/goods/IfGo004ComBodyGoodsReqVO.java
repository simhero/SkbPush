package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo004ComBodyGoodsReqVO (IfGo004ComBodyGoodsReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo004ComBodyGoodsReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo004ComBodyGoodsReqVO extends BaseVO {
	private String gJcode	= "";
	private String mainCode	= "";
	private String uid		= "";
	
	public IfGo004ComBodyGoodsReqVO() {
		super();
		this.gJcode		= "";
		this.mainCode	= "";
		this.uid		= "";
	}

	public String getgJcode() {
		return gJcode;
	}

	public void setgJcode(String gJcode) {
		this.gJcode = gJcode;
	}

	public String getMainCode() {
		return mainCode;
	}

	public void setMainCode(String mainCode) {
		this.mainCode = mainCode;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}