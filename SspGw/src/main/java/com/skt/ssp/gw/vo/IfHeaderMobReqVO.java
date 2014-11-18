package com.skt.ssp.gw.vo;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderMobReqVO;

/**
 * IfHeaderMobReq VO (IfHeaderMobReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfHeaderMobReqVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfHeaderMobReqVO extends BaseVO {
	private String comAuthKey		= "";
	private String comInterfaceId	= "";
	private String comAppVersion	= "";
	private String comTrId			= "";
	private String comReqDevCd		= "";
	private String comResolution	= "";
	private String comCc			= "";
	private String comPhoneNum		= "";
	private String comModel			= "";
	private String comManufacturer	= "";
	private String comDataType		= "";
	private String comRequestDate	= "";

	public IfHeaderMobReqVO() {
		super();
		this.comAuthKey = "";
		this.comInterfaceId = "";
		this.comAppVersion = "";
		this.comTrId = "";
		this.comReqDevCd = "";
		this.comResolution = "";
		this.comCc = "";
		this.comPhoneNum = "";
		this.comModel = "";
		this.comManufacturer = "";
		this.comDataType = "";
		this.comRequestDate = "";
	}

	public String getComAuthKey() {
		return comAuthKey;
	}

	public void setComAuthKey(String comAuthKey) {
		this.comAuthKey = comAuthKey;
	}

	public String getComInterfaceId() {
		return comInterfaceId;
	}

	public void setComInterfaceId(String comInterfaceId) {
		this.comInterfaceId = comInterfaceId;
	}

	public String getComAppVersion() {
		return comAppVersion;
	}

	public void setComAppVersion(String comAppVersion) {
		this.comAppVersion = comAppVersion;
	}

	public String getComTrId() {
		return comTrId;
	}

	public void setComTrId(String comTrId) {
		this.comTrId = comTrId;
	}

	public String getComReqDevCd() {
		return comReqDevCd;
	}

	public void setComReqDevCd(String comReqDevCd) {
		this.comReqDevCd = comReqDevCd;
	}

	public String getComResolution() {
		return comResolution;
	}

	public void setComResolution(String comResolution) {
		this.comResolution = comResolution;
	}

	public String getComCc() {
		return comCc;
	}

	public void setComCc(String comCc) {
		this.comCc = comCc;
	}

	public String getComPhoneNum() {
		return comPhoneNum;
	}

	public void setComPhoneNum(String comPhoneNum) {
		this.comPhoneNum = comPhoneNum;
	}

	public String getComModel() {
		return comModel;
	}

	public void setComModel(String comModel) {
		this.comModel = comModel;
	}

	public String getComManufacturer() {
		return comManufacturer;
	}

	public void setComManufacturer(String comManufacturer) {
		this.comManufacturer = comManufacturer;
	}

	public String getComDataType() {
		return comDataType;
	}

	public void setComDataType(String comDataType) {
		this.comDataType = comDataType;
	}

	public String getComRequestDate() {
		return comRequestDate;
	}

	public void setComRequestDate(String comRequestDate) {
		this.comRequestDate = comRequestDate;
	}

}