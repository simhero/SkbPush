package com.skt.ssp.gw.vo.push;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfPu001ComBodyReqVO (IfPu001ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfPu001ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfPu001ComBodyReqVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String mainCode		= "";
	private List<IfPu001ComBodyUidReqVO> uidList;
	private String pushId		= "";
	private String pageCnt		= "";
	private String pageNo		= "";

	public IfPu001ComBodyReqVO() {
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

	public List<IfPu001ComBodyUidReqVO> getUidList() {
		return uidList;
	}

	public String getPushId() {
		return pushId;
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

	public void setUidList(List<IfPu001ComBodyUidReqVO> uidList) {
		this.uidList = uidList;
	}

	public void setPushId(String pushId) {
		this.pushId = pushId;
	}

	public void setPageCnt(String pageCnt) {
		this.pageCnt = pageCnt;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

}