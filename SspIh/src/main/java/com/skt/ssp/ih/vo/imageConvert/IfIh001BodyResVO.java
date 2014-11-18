package com.skt.ssp.ih.vo.imageConvert;

import java.util.List;

import com.skt.ssp.ih.vo.BaseVO;

/**
 * IfIh001BodyFileReqVO (IfIh001BodyFileReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfIh001BodyFileReqVO.java,v 1.0 2011/10/31 00:00:00 ChoKyuJin Express $
 */
public class IfIh001BodyResVO extends BaseVO {
	private String resultCode		= "";
	private String resultMsg		= "";
	private String responseDate		= "";
	private List<IfIh001BodyFileResVO> fileList;
	
	public IfIh001BodyResVO() {
		super();
	}

	public String getResultCode() {
		return resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public String getResponseDate() {
		return responseDate;
	}

	public List<IfIh001BodyFileResVO> getFileList() {
		return fileList;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public void setResponseDate(String responseDate) {
		this.responseDate = responseDate;
	}

	public void setFileList(List<IfIh001BodyFileResVO> fileList) {
		this.fileList = fileList;
	}

}