package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo010ComBodyIdxResVO (IfGo010ComBodyIdxResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo010ComBodyIdxResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo010ComBodyIdxResVO extends BaseVO {
	private String idx		= "";
	private String rsltCode	= "";
	private String rsltMsg	= "";
	
	public IfGo010ComBodyIdxResVO() {
		super();
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
