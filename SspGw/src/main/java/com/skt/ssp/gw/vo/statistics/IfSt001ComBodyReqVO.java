package com.skt.ssp.gw.vo.statistics;

import java.util.ArrayList;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfSt001ComBodyReqVO (IfSt001ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSt001ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSt001ComBodyReqVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String mainCode		= "";
	private ArrayList<IfSt001ComBodyUidReqVO> uidList;
	private String searchGubun	= "";
	private String gName		= "";
	private String dateFrom		= "";
	private String dateTo		= "";
	private String pageCnt		= "";
	private String pageNo		= "";

	public IfSt001ComBodyReqVO() {
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

	public ArrayList<IfSt001ComBodyUidReqVO> getUidList() {
		return uidList;
	}

	public String getSearchGubun() {
		return searchGubun;
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

	public void setUidList(ArrayList<IfSt001ComBodyUidReqVO> uidList) {
		this.uidList = uidList;
	}

	public void setSearchGubun(String searchGubun) {
		this.searchGubun = searchGubun;
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

	public void setPageCnt(String pageCnt) {
		this.pageCnt = pageCnt;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

}