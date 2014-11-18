package com.skt.ssp.ih.vo.imageConvert;

import java.util.List;

import com.skt.ssp.ih.vo.BaseVO;

/**
 * IfIh002BodyReqVO (IfIh002BodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfIh002BodyReqVO.java,v 1.0 2011/10/31 00:00:00 ChoKyuJin Express $
 */
public class IfIh002BodyReqVO extends BaseVO {
	private String transactionId		= "";
	private String adminCode			= "";
	private String convReqSysCd			= "";
	private String convReqDt			= "";
	private List<IfIh002BodySizeReqVO> sizeList;
	private List<IfIh002BodyFileReqVO> fileList;
	
	public IfIh002BodyReqVO() {}

	public String getTransactionId() {
		return transactionId;
	}

	public String getAdminCode() {
		return adminCode;
	}

	public String getConvReqSysCd() {
		return convReqSysCd;
	}

	public String getConvReqDt() {
		return convReqDt;
	}

	public List<IfIh002BodySizeReqVO> getSizeList() {
		return sizeList;
	}

	public List<IfIh002BodyFileReqVO> getFileList() {
		return fileList;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setConvReqSysCd(String convReqSysCd) {
		this.convReqSysCd = convReqSysCd;
	}

	public void setConvReqDt(String convReqDt) {
		this.convReqDt = convReqDt;
	}

	public void setSizeList(List<IfIh002BodySizeReqVO> sizeList) {
		this.sizeList = sizeList;
	}

	public void setFileList(List<IfIh002BodyFileReqVO> fileList) {
		this.fileList = fileList;
	}
	
}
