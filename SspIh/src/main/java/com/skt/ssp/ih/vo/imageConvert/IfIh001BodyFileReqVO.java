package com.skt.ssp.ih.vo.imageConvert;

import com.skt.ssp.ih.vo.BaseVO;

/**
 * IfIh001BodyFileReqVO (IfIh001BodyFileReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfIh001BodyFileReqVO.java,v 1.0 2011/10/31 00:00:00 ChoKyuJin Express $
 */
public class IfIh001BodyFileReqVO extends BaseVO {
	private String keyVal	= "";
	private String imgUrl	= "";
	
	public IfIh001BodyFileReqVO() {
		super();
	}

	public String getKeyVal() {
		return keyVal;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setKeyVal(String keyVal) {
		this.keyVal = keyVal;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}