package com.skt.ssp.gw.vo.settlement;

import java.util.ArrayList;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfSe001ComBodyReqVO (IfSe001ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSe001ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSe001ComBodyReqVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String mainCode		= "";
	private ArrayList<IfSe001ComBodyUidReqVO> uidList;
	private String pageCnt		= "";
	private String pageNo		= "";
	private String termGubun	= "";
	private String dateFrom		= "";
	private String dateTo		= "";

	public IfSe001ComBodyReqVO() {
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

	public ArrayList<IfSe001ComBodyUidReqVO> getUidList() {
		return uidList;
	}

	public String getPageCnt() {
		return pageCnt;
	}

	public String getPageNo() {
		return pageNo;
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

	public void setUidList(ArrayList<IfSe001ComBodyUidReqVO> uidList) {
		this.uidList = uidList;
	}

	public void setPageCnt(String pageCnt) {
		this.pageCnt = pageCnt;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
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