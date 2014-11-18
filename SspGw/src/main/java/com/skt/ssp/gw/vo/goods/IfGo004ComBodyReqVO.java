package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo004ComBodyReqVO (IfGo004ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo004ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo004ComBodyReqVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String pageCnt		= "";
	private String pageNo		= "";
	private String gJcode		= "";
	private String mainCode		= "";
	private String uid			= "";

	public IfGo004ComBodyReqVO() {
		super();
		this.adminCode	= "";
		this.userId		= "";
		this.pageCnt	= "";
		this.pageNo		= "";
		this.gJcode		= "";
		this.mainCode	= "";
		this.uid		= "";
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

	public String getgJcode() {
		return gJcode;
	}

	public String getMainCode() {
		return mainCode;
	}

	public String getUid() {
		return uid;
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

	public void setgJcode(String gJcode) {
		this.gJcode = gJcode;
	}

	public void setMainCode(String mainCode) {
		this.mainCode = mainCode;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}