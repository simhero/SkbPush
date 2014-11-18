package com.skt.ssp.ih.vo.imageConvert;

import java.util.List;

import com.skt.ssp.ih.vo.BaseVO;

/**
 * IfIh001BodyFileReqVO (IfIh001BodyFileReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfIh001BodyFileReqVO.java,v 1.0 2011/10/31 00:00:00 ChoKyuJin Express $
 */
public class IfIh001BodyReqVO extends BaseVO {
	private String adminCode			= "";
	private String userId				= "";
	private String convReqSysCd			= "";
	private String convReqDt			= "";
	private List<IfIh001BodySizeReqVO> sizeList;
	private List<IfIh001BodyFileReqVO> fileList;
	
	public IfIh001BodyReqVO() {}

	public String getAdminCode() {
		return adminCode;
	}

	public String getUserId() {
		return userId;
	}

	public String getConvReqSysCd() {
		return convReqSysCd;
	}

	public String getConvReqDt() {
		return convReqDt;
	}

	public List<IfIh001BodySizeReqVO> getSizeList() {
		return sizeList;
	}

	public List<IfIh001BodyFileReqVO> getFileList() {
		return fileList;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setConvReqSysCd(String convReqSysCd) {
		this.convReqSysCd = convReqSysCd;
	}

	public void setConvReqDt(String convReqDt) {
		this.convReqDt = convReqDt;
	}

	public void setSizeList(List<IfIh001BodySizeReqVO> sizeList) {
		this.sizeList = sizeList;
	}

	public void setFileList(List<IfIh001BodyFileReqVO> fileList) {
		this.fileList = fileList;
	}
	
	
}
