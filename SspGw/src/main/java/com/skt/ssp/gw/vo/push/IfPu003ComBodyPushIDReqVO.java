package com.skt.ssp.gw.vo.push;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfPu003ComBodyPushIDReqVO (IfPu003ComBodyPushIDReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfPu003ComBodyPushIDReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfPu003ComBodyPushIDReqVO extends BaseVO {
	private String pushId	= "";
	private String reqDevCd	= "";
	private String phoneNum	= "";

	public IfPu003ComBodyPushIDReqVO() {
		super();
	}

	public String getPushId() {
		return pushId;
	}

	public String getReqDevCd() {
		return reqDevCd;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPushId(String pushId) {
		this.pushId = pushId;
	}

	public void setReqDevCd(String reqDevCd) {
		this.reqDevCd = reqDevCd;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

}