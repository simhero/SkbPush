package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs012ComBodyReqVO (IfCs012ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs012ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs012ComBodyReqVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String pageCnt		= "";
	private String pageNo		= "";

	public IfCs012ComBodyReqVO() {
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

}