package com.skt.ssp.gw.vo.order;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfOr002ComBodyBeaResVO (IfOr002ComBodyBeaResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfOr002ComBodyBeaResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfOr002ComBodyBeaResVO extends BaseVO {
	private String gDeliveryCode	= "";
	private String sName			= "";
	private String sTel				= "";
	private String sHp				= "";
	private String receiveType		= "";
	private String tagcom			= "";
	private String songjangNo		= "";
	
	public IfOr002ComBodyBeaResVO() {
		super();
	}

	public String getgDeliveryCode() {
		return gDeliveryCode;
	}

	public String getsName() {
		return sName;
	}

	public String getsTel() {
		return sTel;
	}

	public String getsHp() {
		return sHp;
	}

	public String getReceiveType() {
		return receiveType;
	}

	public String getTagcom() {
		return tagcom;
	}

	public String getSongjangNo() {
		return songjangNo;
	}

	public void setgDeliveryCode(String gDeliveryCode) {
		this.gDeliveryCode = gDeliveryCode;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public void setsTel(String sTel) {
		this.sTel = sTel;
	}

	public void setsHp(String sHp) {
		this.sHp = sHp;
	}

	public void setReceiveType(String receiveType) {
		this.receiveType = receiveType;
	}

	public void setTagcom(String tagcom) {
		this.tagcom = tagcom;
	}

	public void setSongjangNo(String songjangNo) {
		this.songjangNo = songjangNo;
	}

}