package com.skt.ssp.gw.vo.goods;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo011ComBodyResVO (IfGo011ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo011ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo011ComBodyResVO extends BaseVO {
	private String groupCode	= "";
	private String groupName	= "";
	private String gJcode		= "";
	private String gB2bcode		= "";
	private String gName		= "";
	private String gPrice		= "";
	private String keyWord		= "";
	private List<IfGo011ComBodyPriceResVO> priceList;

	public IfGo011ComBodyResVO() {
		super();
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

	public String getKeyWord() {
		return keyWord;
	}

	public List<IfGo011ComBodyPriceResVO> getPriceList() {
		return priceList;
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

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public void setPriceList(List<IfGo011ComBodyPriceResVO> priceList) {
		this.priceList = priceList;
	}

}