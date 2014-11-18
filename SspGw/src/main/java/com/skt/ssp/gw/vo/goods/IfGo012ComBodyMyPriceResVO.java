package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo012ComBodyMyPriceResVO (IfGo012ComBodyMyPriceResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo012ComBodyMyPriceResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo012ComBodyMyPriceResVO extends BaseVO {
	private String gubun		= "";
	private String groupCode	= "";
	private String groupName	= "";
	private String gJcode		= "";
	private String gB2bcode		= "";
	private String gName		= "";
	private String gPrice		= "";
	
	public IfGo012ComBodyMyPriceResVO() {
		super();
	}

	public String getGubun() {
		return gubun;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public String getGroupName() {
		return groupName;
	}

	public String getgJcode() {
		return gJcode;
	}

	public String getgB2bcode() {
		return gB2bcode;
	}

	public String getgName() {
		return gName;
	}

	public String getgPrice() {
		return gPrice;
	}

	public void setGubun(String gubun) {
		this.gubun = gubun;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setgJcode(String gJcode) {
		this.gJcode = gJcode;
	}

	public void setgB2bcode(String gB2bcode) {
		this.gB2bcode = gB2bcode;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public void setgPrice(String gPrice) {
		this.gPrice = gPrice;
	}

}