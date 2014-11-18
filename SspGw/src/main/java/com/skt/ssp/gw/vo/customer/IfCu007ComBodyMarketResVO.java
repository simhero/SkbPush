package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCu007ComBodyMarketRes VO (IfCu007ComBodyMarketResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu007ComBodyMarketResVO.java,v1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu007ComBodyMarketResVO extends BaseVO {
	private String mainCode = "";
	private String mainName = "";
	private String uid = "";
	private String stts = "";

	public IfCu007ComBodyMarketResVO() {
		super();
		this.mainCode = "";
		this.mainName = "";
		this.uid = "";
		this.stts = "";
	}

	public String getMainCode() {
		return mainCode;
	}

	public String getMainName() {
		return mainName;
	}

	public String getUid() {
		return uid;
	}

	public String getStts() {
		return stts;
	}

	public void setMainCode(String mainCode) {
		this.mainCode = mainCode;
	}

	public void setMainName(String mainName) {
		this.mainName = mainName;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setStts(String stts) {
		this.stts = stts;
	}

}
