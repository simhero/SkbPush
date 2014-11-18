package com.skt.ssp.ih.vo.imageConvert;

import com.skt.ssp.ih.vo.BaseVO;

/**
 * IfIh003BodyUrlReqVO (IfIh003BodyUrlReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfIh003BodyUrlReqVO.java,v 1.0 2011/10/31 00:00:00 ChoKyuJin Express $
 */
public class IfIh003BodyUrlReqVO extends BaseVO {
	private String reqDevCd		= "";
	private String imgUrl		= "";
	private String resultCode	= "";
	private String resultMsg	= "";
	
	public IfIh003BodyUrlReqVO() {
		super();
	}

	public String getReqDevCd() {
		return reqDevCd;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getResultCode() {
		return resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setReqDevCd(String reqDevCd) {
		this.reqDevCd = reqDevCd;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

}