package com.skt.ssp.gw.vo.cs;

import java.util.ArrayList;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs001ComBodyReqVO (IfCs001ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs001ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs001ComBodyReqVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String mainCode		= "";
	private ArrayList<IfCs001ComBodyUidReqVO> uidList;
	private String csKind		= "";
	private String pageCnt		= "";
	private String pageNo		= "";
	private String searchGubun	= "";
	private String searchWord	= "";
	private String csState		= "";
	private String termGubun	= "";
	private String dateFrom		= "";
	private String dateTo		= "";

	public IfCs001ComBodyReqVO() {
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

	public ArrayList<IfCs001ComBodyUidReqVO> getUidList() {
		return uidList;
	}

	public String getCsKind() {
		return csKind;
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

	public String getCsState() {
		return csState;
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

	public void setUidList(ArrayList<IfCs001ComBodyUidReqVO> uidList) {
		this.uidList = uidList;
	}

	public void setCsKind(String csKind) {
		this.csKind = csKind;
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

	public void setCsState(String csState) {
		this.csState = csState;
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