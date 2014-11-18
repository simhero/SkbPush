package com.skt.ssp.gw.vo.goods;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo0051ComBodyReqVO (IfGo0051ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo0051ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo0051ComBodyReqVO extends BaseVO {
	private String adminCode		= "";
	private String userId			= "";
	private String cmd				= "";
	private String targetGroupCode	= "";
	private List<IfGo0051ComBodyDataReqVO> dataList;

	public IfGo0051ComBodyReqVO() {
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

	public String getTargetGroupCode() {
		return targetGroupCode;
	}

	public List<IfGo0051ComBodyDataReqVO> getDataList() {
		return dataList;
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

	public void setTargetGroupCode(String targetGroupCode) {
		this.targetGroupCode = targetGroupCode;
	}

	public void setDataList(List<IfGo0051ComBodyDataReqVO> dataList) {
		this.dataList = dataList;
	}

}