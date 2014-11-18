package com.skt.ssp.ih.vo.imageConvert;

import java.util.List;

import com.skt.ssp.ih.vo.BaseVO;

/**
 * IfIh001BodyFileReqVO (IfIh001BodyFileReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfIh001BodyFileReqVO.java,v 1.0 2011/10/31 00:00:00 ChoKyuJin Express $
 */
public class IfIh001BodyFileResVO extends BaseVO {
	private String keyVal	= "";
	private List<IfIh001BodyUrlResVO> urlList;
	
	public IfIh001BodyFileResVO() {
		super();
	}

	public String getKeyVal() {
		return keyVal;
	}

	public List<IfIh001BodyUrlResVO> getUrlList() {
		return urlList;
	}

	public void setKeyVal(String keyVal) {
		this.keyVal = keyVal;
	}

	public void setUrlList(List<IfIh001BodyUrlResVO> urlList) {
		this.urlList = urlList;
	}

}