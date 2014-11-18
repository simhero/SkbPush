package com.skt.ssp.gw.vo.cs;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs001ComBodyResVO (IfCs001ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs001ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs001ComBodyResVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String csCnt		= "";
	private List<IfCs001ComBodyCsResVO> csList;

	public IfCs001ComBodyResVO() {
		super();
	}

	public String getAdminCode() {
		return adminCode;
	}

	public String getUserId() {
		return userId;
	}

	public String getCsCnt() {
		return csCnt;
	}

	public List<IfCs001ComBodyCsResVO> getCsList() {
		return csList;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setCsCnt(String csCnt) {
		this.csCnt = csCnt;
	}

	public void setCsList(List<IfCs001ComBodyCsResVO> csList) {
		this.csList = csList;
	}

}