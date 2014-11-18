package com.skt.ssp.gw.vo.statistics;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfSt002ComBodyReqVO (IfSt002ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSt002ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSt002ComBodyReqVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String mainCode		= "";
	private List<IfSt002ComBodyUidReqVO> uidList;
	private String searchGubun	= "";
	private String gJcode		= "";
	private String gName		= "";
	private String dateFrom		= "";
	private String dateTo		= "";
	private String orderBy		= "";
	private String pageCnt		= "";
	private String pageNo		= "";

	public IfSt002ComBodyReqVO() {
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

	public List<IfSt002ComBodyUidReqVO> getUidList() {
		return uidList;
	}

	public String getSearchGubun() {
		return searchGubun;
	}

	public String getgJcode() {
		return gJcode;
	}

	public String getgName() {
		return gName;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public String getPageCnt() {
		return pageCnt;
	}

	public String getPageNo() {
		return pageNo;
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

	public void setUidList(List<IfSt002ComBodyUidReqVO> uidList) {
		this.uidList = uidList;
	}

	public void setSearchGubun(String searchGubun) {
		this.searchGubun = searchGubun;
	}

	public void setgJcode(String gJcode) {
		this.gJcode = gJcode;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public void setPageCnt(String pageCnt) {
		this.pageCnt = pageCnt;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

}