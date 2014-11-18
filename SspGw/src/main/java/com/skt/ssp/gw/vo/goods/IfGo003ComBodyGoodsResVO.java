package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo003ComBodyGoodsResVO (IfGo003ComBodyGoodsResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo003ComBodyGoodsResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo003ComBodyGoodsResVO extends BaseVO {
	private String gJcode	= "";
	private String mainCode	= "";
	private String uid		= "";
	private String stts		= "";
	private String rsltCode	= "";
	private String rsltMsg	= "";

	public IfGo003ComBodyGoodsResVO() {
		super();
		this.gJcode		= "";
		this.mainCode	= "";
		this.uid		= "";
		this.stts		= "";
		this.rsltCode	= "";
		this.rsltMsg	= "";
	}

	public String getgJcode() {
		return gJcode;
	}

	public String getMainCode() {
		return mainCode;
	}

	public String getUid() {
		return uid;
	}

	public String getStts() {
		return stts;
	}

	public String getRsltCode() {
		return rsltCode;
	}

	public String getRsltMsg() {
		return rsltMsg;
	}

	public void setgJcode(String gJcode) {
		this.gJcode = gJcode;
	}

	public void setMainCode(String mainCode) {
		this.mainCode = mainCode;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setStts(String stts) {
		this.stts = stts;
	}

	public void setRsltCode(String rsltCode) {
		this.rsltCode = rsltCode;
	}

	public void setRsltMsg(String rsltMsg) {
		this.rsltMsg = rsltMsg;
	}

}