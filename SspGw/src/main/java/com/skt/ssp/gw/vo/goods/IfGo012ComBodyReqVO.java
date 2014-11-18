package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo012ComBodyReqVO (IfGo012ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo012ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo012ComBodyReqVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String pageCnt		= "";
	private String pageNo		= "";
	private String searchGubun	= "";
	private String searchWord	= "";
	private String orderBy		= "";

	public IfGo012ComBodyReqVO() {
		super();
	}

	public String getAdminCode() {
		return adminCode;
	}

	public String getUserId() {
		return userId;
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

	public String getOrderBy() {
		return orderBy;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

}