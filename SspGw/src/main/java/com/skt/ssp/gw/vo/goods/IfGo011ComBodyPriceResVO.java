package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo011ComBodyPriceResVO (IfGo011ComBodyPriceResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo011ComBodyPriceResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo011ComBodyPriceResVO extends BaseVO {
	private String sgPrice	= "";
	private String sgQty	= "";

	public IfGo011ComBodyPriceResVO() {
		super();
	}

	public String getSgPrice() {
		return sgPrice;
	}

	public String getSgQty() {
		return sgQty;
	}

	public void setSgPrice(String sgPrice) {
		this.sgPrice = sgPrice;
	}

	public void setSgQty(String sgQty) {
		this.sgQty = sgQty;
	}

}