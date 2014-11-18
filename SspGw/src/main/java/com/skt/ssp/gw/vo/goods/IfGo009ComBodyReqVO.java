package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo009ComBodyReqVO (IfGo009ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo009ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo009ComBodyReqVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String gJcode		= "";
	private String pageCnt		= "";
	private String pageNo		= "";
	private String orderBy		= "";

	public IfGo009ComBodyReqVO() {
		super();
	}

	public String getAdminCode() {
		return adminCode;
	}

	public String getUserId() {
		return userId;
	}

	public String getgJcode() {
		return gJcode;
	}

	public String getPageCnt() {
		return pageCnt;
	}

	public String getPageNo() {
		return pageNo;
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

	public void setgJcode(String gJcode) {
		this.gJcode = gJcode;
	}

	public void setPageCnt(String pageCnt) {
		this.pageCnt = pageCnt;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

}