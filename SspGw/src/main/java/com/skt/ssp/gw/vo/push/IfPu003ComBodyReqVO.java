package com.skt.ssp.gw.vo.push;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfPu003ComBodyReqVO (IfPu003ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfPu003ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfPu003ComBodyReqVO extends BaseVO {
	private String adminCode		= "";
	private List<IfPu003ComBodyTransferGroupReqVO> transferGroupList;
	private List<IfPu003ComBodyPushIDReqVO> pushIdList;

	public IfPu003ComBodyReqVO() {
		super();
	}

	public String getAdminCode() {
		return adminCode;
	}

	public List<IfPu003ComBodyTransferGroupReqVO> getTransferGroupList() {
		return transferGroupList;
	}

	public List<IfPu003ComBodyPushIDReqVO> getPushIdList() {
		return pushIdList;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setTransferGroupList(
			List<IfPu003ComBodyTransferGroupReqVO> transferGroupList) {
		this.transferGroupList = transferGroupList;
	}

	public void setPushIdList(List<IfPu003ComBodyPushIDReqVO> pushIdList) {
		this.pushIdList = pushIdList;
	}

}