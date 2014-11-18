package com.skt.ssp.gw.vo.settlement;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfSe002ComBodySettleResVO (IfSe002ComBodySettleResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSe002ComBodySettleResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSe002ComBodySettleResVO extends BaseVO {
	private String gB2bcode	= "";
	private String gName	= "";
	private String gQty		= "";
	private String gPrice	= "";
	private String sPrice	= "";
	private String jPrice	= "";
	private String gGubun	= "";

	public IfSe002ComBodySettleResVO() {
		super();
	}

	public String getgB2bcode() {
		return gB2bcode;
	}

	public String getgName() {
		return gName;
	}

	public String getgQty() {
		return gQty;
	}

	public String getgPrice() {
		return gPrice;
	}

	public String getsPrice() {
		return sPrice;
	}

	public String getjPrice() {
		return jPrice;
	}

	public String getgGubun() {
		return gGubun;
	}

	public void setgB2bcode(String gB2bcode) {
		this.gB2bcode = gB2bcode;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public void setgQty(String gQty) {
		this.gQty = gQty;
	}

	public void setgPrice(String gPrice) {
		this.gPrice = gPrice;
	}

	public void setsPrice(String sPrice) {
		this.sPrice = sPrice;
	}

	public void setjPrice(String jPrice) {
		this.jPrice = jPrice;
	}

	public void setgGubun(String gGubun) {
		this.gGubun = gGubun;
	}

}