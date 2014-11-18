package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo003ComBodyGoodsReqVO (IfGo003ComBodyGoodsReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo003ComBodyGoodsReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo003ComBodyGoodsReqVO extends BaseVO {
	private String gJcode				= "";
	private String mainCode				= "";
	private String uid					= "";
	private String cmd					= "";
	private String useWpriceYn			= "";
	private String gWprice				= "";
	private String gQty					= "";
	private String safetyQtyYn			= "";
	private String safetyQty			= "";
	private String gPriceBatchUpdateYn	= "";
	private String gPrice				= "";
	private String stts					= "";

	public IfGo003ComBodyGoodsReqVO() {
		super();
		this.gJcode					= "";
		this.mainCode				= "";
		this.uid					= "";
		this.cmd					= "";
		this.useWpriceYn			= "";
		this.gWprice				= "";
		this.gQty					= "";
		this.safetyQtyYn			= "";
		this.safetyQty				= "";
		this.gPriceBatchUpdateYn	= "";
		this.gPrice					= "";
		this.stts					= "";
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

	public String getCmd() {
		return cmd;
	}

	public String getUseWpriceYn() {
		return useWpriceYn;
	}

	public String getgWprice() {
		return gWprice;
	}

	public String getgQty() {
		return gQty;
	}

	public String getSafetyQtyYn() {
		return safetyQtyYn;
	}

	public String getSafetyQty() {
		return safetyQty;
	}

	public String getgPriceBatchUpdateYn() {
		return gPriceBatchUpdateYn;
	}

	public String getgPrice() {
		return gPrice;
	}

	public String getStts() {
		return stts;
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

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public void setUseWpriceYn(String useWpriceYn) {
		this.useWpriceYn = useWpriceYn;
	}

	public void setgWprice(String gWprice) {
		this.gWprice = gWprice;
	}

	public void setgQty(String gQty) {
		this.gQty = gQty;
	}

	public void setSafetyQtyYn(String safetyQtyYn) {
		this.safetyQtyYn = safetyQtyYn;
	}

	public void setSafetyQty(String safetyQty) {
		this.safetyQty = safetyQty;
	}

	public void setgPriceBatchUpdateYn(String gPriceBatchUpdateYn) {
		this.gPriceBatchUpdateYn = gPriceBatchUpdateYn;
	}

	public void setgPrice(String gPrice) {
		this.gPrice = gPrice;
	}

	public void setStts(String stts) {
		this.stts = stts;
	}

}