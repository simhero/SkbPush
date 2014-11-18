package com.skt.ssp.gw.vo.goods;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo009ComBodyResVO (IfGo009ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo009ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo009ComBodyResVO extends BaseVO {
	private String groupCode	= "";
	private String groupName	= "";
	private String gJcode		= "";
	private String gB2bcode		= "";
	private String gName		= "";
	private String gPrice		= "";
	private String keyWord		= "";
	private String keyWordRegDate	= "";
	private String priceCnt		= "";
	private List<IfGo009ComBodyPriceResVO> priceList;

	public IfGo009ComBodyResVO() {
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

	public String getKeyWordRegDate() {
		return keyWordRegDate;
	}

	public String getPriceCnt() {
		return priceCnt;
	}

	public List<IfGo009ComBodyPriceResVO> getPriceList() {
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

	public void setKeyWordRegDate(String keyWordRegDate) {
		this.keyWordRegDate = keyWordRegDate;
	}

	public void setPriceCnt(String priceCnt) {
		this.priceCnt = priceCnt;
	}

	public void setPriceList(List<IfGo009ComBodyPriceResVO> priceList) {
		this.priceList = priceList;
	}

}