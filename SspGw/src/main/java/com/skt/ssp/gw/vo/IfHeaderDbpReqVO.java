package com.skt.ssp.gw.vo;

import com.skt.ssp.gw.vo.BaseVO;
import com.skt.ssp.gw.vo.IfHeaderDbpReqVO;

/**
 * IfHeaderDbpReq VO (IfHeaderDbpReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfHeaderDbpReqVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfHeaderDbpReqVO extends BaseVO {
	private String authKey		= "";
	private String interfaceId	= "";
	private String reqDevCd		= "";
	private String cc			= "";
	private String phoneNum		= "";
	private String model		= "";
	private String manufacturer	= "";
	private String dataType		= "";
	private String requestDate	= "";

	public IfHeaderDbpReqVO() {
		super();
		this.authKey = "";
		this.interfaceId = "";
		this.reqDevCd = "";
		this.cc = "";
		this.phoneNum = "";
		this.model = "";
		this.manufacturer = "";
		this.dataType = "";
		this.requestDate = "";
	}

	public String getAuthKey() {
		return authKey;
	}

	public String getInterfaceId() {
		return interfaceId;
	}

	public String getReqDevCd() {
		return reqDevCd;
	}

	public String getCc() {
		return cc;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getModel() {
		return model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getDataType() {
		return dataType;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

	public void setInterfaceId(String interfaceId) {
		this.interfaceId = interfaceId;
	}

	public void setReqDevCd(String reqDevCd) {
		this.reqDevCd = reqDevCd;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

}