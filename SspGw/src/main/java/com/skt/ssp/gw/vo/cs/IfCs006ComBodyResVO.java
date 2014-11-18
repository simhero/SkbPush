package com.skt.ssp.gw.vo.cs;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs006ComBodyResVO (IfCs006ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs006ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs006ComBodyResVO extends BaseVO {
	private String csCnt = "";
	private List<IfCs006ComBodyCsResVO> csList;

	public IfCs006ComBodyResVO() {
		super();
	}

	public String getCsCnt() {
		return csCnt;
	}

	public List<IfCs006ComBodyCsResVO> getCsList() {
		return csList;
	}

	public void setCsCnt(String csCnt) {
		this.csCnt = csCnt;
	}

	public void setCsList(List<IfCs006ComBodyCsResVO> csList) {
		this.csList = csList;
	}

}