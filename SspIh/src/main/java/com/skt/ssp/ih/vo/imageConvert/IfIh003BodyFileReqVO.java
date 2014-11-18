package com.skt.ssp.ih.vo.imageConvert;

import java.util.List;

import com.skt.ssp.ih.vo.BaseVO;

/**
 * IfIh003BodyFileReqVO (IfIh003BodyFileReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfIh003BodyFileReqVO.java,v 1.0 2011/10/31 00:00:00 ChoKyuJin Express $
 */
public class IfIh003BodyFileReqVO extends BaseVO {
	private String keyVal	= "";
	private List<IfIh003BodyUrlReqVO> urlList;
	
	public IfIh003BodyFileReqVO() {
		super();
	}

	public String getKeyVal() {
		return keyVal;
	}

	public List<IfIh003BodyUrlReqVO> getUrlList() {
		return urlList;
	}

	public void setKeyVal(String keyVal) {
		this.keyVal = keyVal;
	}

	public void setUrlList(List<IfIh003BodyUrlReqVO> urlList) {
		this.urlList = urlList;
	}

}