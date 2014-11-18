package com.skt.ssp.gw.vo.intro;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfIn002ComBodyReq VO (IfIn002ComBodyReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfIn002ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfIn002ComBodyReqVO extends BaseVO {
	private String cName = "";
	private String cHp = "";
	private String cQcontents = "";

	public IfIn002ComBodyReqVO() {
		super();
		this.cName = "";
		this.cHp = "";
		this.cQcontents = "";
	}

	public String getcName() {
		return cName;
	}

	public String getcHp() {
		return cHp;
	}

	public String getcQcontents() {
		return cQcontents;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public void setcHp(String cHp) {
		this.cHp = cHp;
	}

	public void setcQcontents(String cQcontents) {
		this.cQcontents = cQcontents;
	}

}
