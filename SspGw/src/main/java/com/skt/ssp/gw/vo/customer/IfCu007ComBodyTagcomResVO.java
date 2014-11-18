package com.skt.ssp.gw.vo.customer;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCu007ComBodyMarketRes VO (IfCu007ComBodyMarketResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfCu007ComBodyMarketResVO.java,v1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfCu007ComBodyTagcomResVO extends BaseVO {
	private String tagcomCode = "";
	private String tagcomName = "";

	public IfCu007ComBodyTagcomResVO() {
		super();
		this.tagcomCode = "";
		this.tagcomName = "";
	}

	public String getTagcomCode() {
		return tagcomCode;
	}

	public String getTagcomName() {
		return tagcomName;
	}

	public void setTagcomCode(String tagcomCode) {
		this.tagcomCode = tagcomCode;
	}

	public void setTagcomName(String tagcomName) {
		this.tagcomName = tagcomName;
	}

}
