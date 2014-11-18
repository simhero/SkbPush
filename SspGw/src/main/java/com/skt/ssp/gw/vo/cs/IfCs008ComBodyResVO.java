package com.skt.ssp.gw.vo.cs;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs008ComBodyResVO (IfCs008ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs008ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs008ComBodyResVO extends BaseVO {
	private String csCnt = "";
	private List<IfCs008ComBodyCsResVO> csList;

	public IfCs008ComBodyResVO() {
		super();
	}

	public String getCsCnt() {
		return csCnt;
	}

	public List<IfCs008ComBodyCsResVO> getCsList() {
		return csList;
	}

	public void setCsCnt(String csCnt) {
		this.csCnt = csCnt;
	}

	public void setCsList(List<IfCs008ComBodyCsResVO> csList) {
		this.csList = csList;
	}

}