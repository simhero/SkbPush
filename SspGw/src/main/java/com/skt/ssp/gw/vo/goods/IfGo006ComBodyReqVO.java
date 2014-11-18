package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo006ComBodyReqVO (IfGo006ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo006ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo006ComBodyReqVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String pageCnt		= "";
	private String pageNo		= "";
	private String cmd			= "";
	private String cmdValue		= "";
	
	public IfGo006ComBodyReqVO() {
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

	public String getCmd() {
		return cmd;
	}

	public String getCmdValue() {
		return cmdValue;
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

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public void setCmdValue(String cmdValue) {
		this.cmdValue = cmdValue;
	}

}