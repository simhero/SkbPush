package com.skt.ssp.ih.vo.imageConvert;

import java.util.List;

import com.skt.ssp.ih.vo.BaseVO;

/**
 * IfIh003BodyReqVO (IfIh003BodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfIh003BodyReqVO.java,v 1.0 2011/10/31 00:00:00 ChoKyuJin Express $
 */
public class IfIh003BodyReqVO extends BaseVO {
	private String transactionId	= "";
	private String adminCode		= "";
	private String convReqDt		= "";
	private List<IfIh003BodyFileReqVO> fileList;
	
	public IfIh003BodyReqVO() {
		super();
	}

	public String getTransactionId() {
		return transactionId;
	}

	public String getAdminCode() {
		return adminCode;
	}

	public String getConvReqDt() {
		return convReqDt;
	}

	public List<IfIh003BodyFileReqVO> getFileList() {
		return fileList;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setConvReqDt(String convReqDt) {
		this.convReqDt = convReqDt;
	}

	public void setFileList(List<IfIh003BodyFileReqVO> fileList) {
		this.fileList = fileList;
	}

}