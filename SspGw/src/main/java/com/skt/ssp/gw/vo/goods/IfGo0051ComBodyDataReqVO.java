package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo0051ComBodyDataReqVO (IfGo0051ComBodyDataReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo0051ComBodyDataReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo0051ComBodyDataReqVO extends BaseVO {
	private String groupCode	= "";
	private String cmdValue		= "";

	public IfGo0051ComBodyDataReqVO() {
		super();
	}

	public String getGroupCode() {
		return groupCode;
	}

	public String getCmdValue() {
		return cmdValue;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public void setCmdValue(String cmdValue) {
		this.cmdValue = cmdValue;
	}

}