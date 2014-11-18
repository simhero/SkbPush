package com.skt.ssp.ih.vo.imageConvert;

import com.skt.ssp.ih.vo.BaseVO;

/**
 * IfIh002BodySizeReqVO (IfIh002BodySizeReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfIh002BodySizeReqVO.java,v 1.0 2011/10/31 00:00:00 ChoKyuJin Express $
 */
public class IfIh002BodySizeReqVO extends BaseVO {
	private String reqDevCd	= "";
	private String imgSize	= "";
	
	public IfIh002BodySizeReqVO() {
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