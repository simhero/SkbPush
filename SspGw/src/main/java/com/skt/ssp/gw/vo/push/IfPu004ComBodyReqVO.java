package com.skt.ssp.gw.vo.push;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfPu004ComBodyReqVO (IfPu004ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfPu004ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfPu004ComBodyReqVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String mainCode		= "";
	private String uid			= "";
	private String pushId		= "";
	private String cmd			= "";
	private String csNew		= "";
	private List<IfPu004ComBodyPushInfoReqVO> pushInfoList;
	
	public IfPu004ComBodyReqVO() {
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

	public String getUid() {
		return uid;
	}

	public String getPushId() {
		return pushId;
	}

	public String getCmd() {
		return cmd;
	}

	public String getCsNew() {
		return csNew;
	}

	public List<IfPu004ComBodyPushInfoReqVO> getPushInfoList() {
		return pushInfoList;
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

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setPushId(String pushId) {
		this.pushId = pushId;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public void setCsNew(String csNew) {
		this.csNew = csNew;
	}

	public void setPushInfoList(List<IfPu004ComBodyPushInfoReqVO> pushInfoList) {
		this.pushInfoList = pushInfoList;
	}

}