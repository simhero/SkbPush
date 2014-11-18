package com.skt.ssp.gw.vo.cs;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs011ComBodyReqVO (IfCs011ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs011ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs011ComBodyReqVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String cmd			= "";
	private List<IfCs011ComBodyCsReqVO> csList;

	public IfCs011ComBodyReqVO() {
		super();
	}

	public String getAdminCode() {
		return adminCode;
	}

	public String getUserId() {
		return userId;
	}

	public String getCmd() {
		return cmd;
	}

	public List<IfCs011ComBodyCsReqVO> getCsList() {
		return csList;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public void setCsList(List<IfCs011ComBodyCsReqVO> csList) {
		this.csList = csList;
	}

}