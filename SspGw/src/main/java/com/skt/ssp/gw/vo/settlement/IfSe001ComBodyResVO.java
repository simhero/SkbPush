package com.skt.ssp.gw.vo.settlement;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfSe001ComBodyResVO (IfSe001ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSe001ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSe001ComBodyResVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String settleCnt	= "";
	private List<IfSe001ComBodySettleResVO> settleList;

	public IfSe001ComBodyResVO() {
		super();
	}

	public String getAdminCode() {
		return adminCode;
	}

	public String getUserId() {
		return userId;
	}

	public String getSettleCnt() {
		return settleCnt;
	}

	public List<IfSe001ComBodySettleResVO> getSettleList() {
		return settleList;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setSettleCnt(String settleCnt) {
		this.settleCnt = settleCnt;
	}

	public void setSettleList(List<IfSe001ComBodySettleResVO> settleList) {
		this.settleList = settleList;
	}

}