package com.skt.ssp.gw.vo.order;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfOr002ComBodyGoodsResVO (IfOr002ComBodyGoodsResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfOr002ComBodyGoodsResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfOr002ComBodyGoodsResVO extends BaseVO {
	private String gB2bcode			= "";
	private String gName			= "";
	private String gStand			= "";
	private String gQty				= "";
	private String gPrice			= "";
	private String gGubun			= "";
	private String gDeliveryCode	= "";

	public IfOr002ComBodyGoodsResVO() {
		super();
	}

	public String getgB2bcode() {
		return gB2bcode;
	}

	public String getgName() {
		return gName;
	}

	public String getgStand() {
		return gStand;
	}

	public String getgQty() {
		return gQty;
	}

	public String getgPrice() {
		return gPrice;
	}

	public String getgGubun() {
		return gGubun;
	}

	public String getgDeliveryCode() {
		return gDeliveryCode;
	}

	public void setgB2bcode(String gB2bcode) {
		this.gB2bcode = gB2bcode;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public void setgStand(String gStand) {
		this.gStand = gStand;
	}

	public void setgQty(String gQty) {
		this.gQty = gQty;
	}

	public void setgPrice(String gPrice) {
		this.gPrice = gPrice;
	}

	public void setgGubun(String gGubun) {
		this.gGubun = gGubun;
	}

	public void setgDeliveryCode(String gDeliveryCode) {
		this.gDeliveryCode = gDeliveryCode;
	}

}