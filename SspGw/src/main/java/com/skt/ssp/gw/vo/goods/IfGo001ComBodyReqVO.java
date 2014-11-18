package com.skt.ssp.gw.vo.goods;

import java.util.ArrayList;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo001ComBodyReqVO (IfGo001ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo001ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo001ComBodyReqVO extends BaseVO {
	private String adminCode		= "";
	private String userId			= "";
	private String mainCode			= "";
	private ArrayList<IfGo001ComBodyUidReqVO> uidList;
	private String pageCnt			= "";
	private String pageNo			= "";
	private String searchGubun		= "";
	private String searchWord		= "";
	private String stts				= "";
	private String gPqtyGubun		= "";
	private String termGubun		= "";
	private String dateFrom			= "";
	private String dateTo			= "";
	private String safetyQtyYn		= "";
	private String useWpriceYn		= "";
	private String orderBy			= "";
	private String reSearchGubun	= "";
	private String reSearchWord		= "";
	
	public IfGo001ComBodyReqVO() {
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

	public ArrayList<IfGo001ComBodyUidReqVO> getUidList() {
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

	public String getStts() {
		return stts;
	}

	public String getgPqtyGubun() {
		return gPqtyGubun;
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

	public String getSafetyQtyYn() {
		return safetyQtyYn;
	}

	public String getUseWpriceYn() {
		return useWpriceYn;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public String getReSearchGubun() {
		return reSearchGubun;
	}

	public String getReSearchWord() {
		return reSearchWord;
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

	public void setUidList(ArrayList<IfGo001ComBodyUidReqVO> uidList) {
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

	public void setStts(String stts) {
		this.stts = stts;
	}

	public void setgPqtyGubun(String gPqtyGubun) {
		this.gPqtyGubun = gPqtyGubun;
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

	public void setSafetyQtyYn(String safetyQtyYn) {
		this.safetyQtyYn = safetyQtyYn;
	}

	public void setUseWpriceYn(String useWpriceYn) {
		this.useWpriceYn = useWpriceYn;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public void setReSearchGubun(String reSearchGubun) {
		this.reSearchGubun = reSearchGubun;
	}

	public void setReSearchWord(String reSearchWord) {
		this.reSearchWord = reSearchWord;
	}

}
