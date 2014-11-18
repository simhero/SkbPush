package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo005ComBodyReqVO (IfGo005ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo005ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo005ComBodyReqVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String groupCode	= "";
	private String cmd			= "";
	private String cmdValue		= "";
	
	public IfGo005ComBodyReqVO() {
		super();
	}

	public String getAdminCode() {
		return adminCode;
	}

	public String getUserId() {
		return userId;
	}

	public String getGroupCode() {
		return groupCode;
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

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public void setCmdValue(String cmdValue) {
		this.cmdValue = cmdValue;
	}

}