package com.skt.ssp.ih.vo.imageConvert;

import com.skt.ssp.ih.vo.BaseVO;

/**
 * IfIh001BodySizeReqVO (IfIh001BodySizeReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfIh001BodySizeReqVO.java,v 1.0 2011/10/31 00:00:00 ChoKyuJin Express $
 */
public class IfIh001BodySizeReqVO extends BaseVO {
	private String reqDevCd	= "";
	private String imgSize	= "";
	
	public IfIh001BodySizeReqVO() {
		super();
	}

	public String getReqDevCd() {
		return reqDevCd;
	}

	public String getImgSize() {
		return imgSize;
	}

	public void setReqDevCd(String reqDevCd) {
		this.reqDevCd = reqDevCd;
	}

	public void setImgSize(String imgSize) {
		this.imgSize = imgSize;
	}

}