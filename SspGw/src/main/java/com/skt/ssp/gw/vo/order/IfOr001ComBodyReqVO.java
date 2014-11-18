package com.skt.ssp.gw.vo.order;

import java.util.ArrayList;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfOr001ComBodyReqVO (IfOr001ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfOr001ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfOr001ComBodyReqVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String mainCode		= "";
	private ArrayList<IfOr001ComBodyUidReqVO> uidList;
	private String pageCnt		= "";
	private String pageNo		= "";
	private String searchGubun	= "";
	private String searchWord	= "";
	private String oState		= "";
	private String termGubun	= "";
	private String dateFrom		= "";
	private String dateTo		= "";

	public IfOr001ComBodyReqVO() {
		super();
	}

	public String getAdminCode() {
		return adminCode;
	}

	public String getUserId() {
		return userId;
	}

	public String getMainCode() {
		return mainCode;
	}

	public ArrayList<IfOr001ComBodyUidReqVO> getUidList() {
		return uidList;
	}

	public String getPageCnt() {
		return pageCnt;
	}

	public String getPageNo() {
		return pageNo;
	}

	public String getSearchGubun() {
		return searchGubun;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public String getoState() {
		return oState;
	}

	public String getTermGubun() {
		return termGubun;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setMainCode(String mainCode) {
		this.mainCode = mainCode;
	}

	public void setUidList(ArrayList<IfOr001ComBodyUidReqVO> uidList) {
		this.uidList = uidList;
	}

	public void setPageCnt(String pageCnt) {
		this.pageCnt = pageCnt;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public void setSearchGubun(String searchGubun) {
		this.searchGubun = searchGubun;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public void setoState(String oState) {
		this.oState = oState;
	}

	public void setTermGubun(String termGubun) {
		this.termGubun = termGubun;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

}