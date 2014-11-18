package com.skt.ssp.gw.vo.cs;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs009ComBodyResVO (IfCs009ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs009ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs009ComBodyResVO extends BaseVO {
	private String csCnt	= "";
	private List<IfCs009ComBodyCsResVO> csList;

	public IfCs009ComBodyResVO() {
		super();
	}

	public String getCsCnt() {
		return csCnt;
	}

	public List<IfCs009ComBodyCsResVO> getCsList() {
		return csList;
	}

	public void setCsCnt(String csCnt) {
		this.csCnt = csCnt;
	}

	public void setCsList(List<IfCs009ComBodyCsResVO> csList) {
		this.csList = csList;
	}

}