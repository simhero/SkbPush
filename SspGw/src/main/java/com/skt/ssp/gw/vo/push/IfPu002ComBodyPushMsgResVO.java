package com.skt.ssp.gw.vo.push;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfPu002ComBodyPushMsgResVO (IfPu002ComBodyPushMsgResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfPu002ComBodyPushMsgResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfPu002ComBodyPushMsgResVO extends BaseVO {
	private String idx				= "";
	private String transferGroupIdx	= "";
	private String mainCode			= "";
	private String mainName			= "";
	private String mImgUrl			= "";
	private String uid				= "";
	private String pushCategory		= "";
	private String title			= "";
	private String procDate			= "";
	private String csNo				= "";
	private String userId			= "";
	private String userName			= "";
	private String jumunNo			= "";
	private String gJcode			= "";
	private String gName			= "";
	private String stts				= "";
	
	public IfPu002ComBodyPushMsgResVO() {
		super();
	}

	public String getIdx() {
		return idx;
	}

	public String getTransferGroupIdx() {
		return transferGroupIdx;
	}

	public String getMainCode() {
		return mainCode;
	}

	public String getMainName() {
		return mainName;
	}

	public String getmImgUrl() {
		return mImgUrl;
	}

	public String getUid() {
		return uid;
	}

	public String getPushCategory() {
		return pushCategory;
	}

	public String getTitle() {
		return title;
	}

	public String getProcDate() {
		return procDate;
	}

	public String getCsNo() {
		return csNo;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getJumunNo() {
		return jumunNo;
	}

	public String getgJcode() {
		return gJcode;
	}

	public String getgName() {
		return gName;
	}

	public String getStts() {
		return stts;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public void setTransferGroupIdx(String transferGroupIdx) {
		this.transferGroupIdx = transferGroupIdx;
	}

	public void setMainCode(String mainCode) {
		this.mainCode = mainCode;
	}

	public void setMainName(String mainName) {
		this.mainName = mainName;
	}

	public void setmImgUrl(String mImgUrl) {
		this.mImgUrl = mImgUrl;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setPushCategory(String pushCategory) {
		this.pushCategory = pushCategory;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setProcDate(String procDate) {
		this.procDate = procDate;
	}

	public void setCsNo(String csNo) {
		this.csNo = csNo;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setJumunNo(String jumunNo) {
		this.jumunNo = jumunNo;
	}

	public void setgJcode(String gJcode) {
		this.gJcode = gJcode;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public void setStts(String stts) {
		this.stts = stts;
	}

}