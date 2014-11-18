package com.skt.ssp.gw.vo.cs;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs011ComBodyResVO (IfCs011ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs011ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs011ComBodyResVO extends BaseVO {
	private List<IfCs011ComBodyCsResVO> csList;
	
	public IfCs011ComBodyResVO() {
		super();
	}

	public List<IfCs011ComBodyCsResVO> getCsList() {
		return csList;
	}

	public void setCsList(List<IfCs011ComBodyCsResVO> csList) {
		this.csList = csList;
	}

}