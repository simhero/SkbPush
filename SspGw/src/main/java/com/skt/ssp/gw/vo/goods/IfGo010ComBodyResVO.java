package com.skt.ssp.gw.vo.goods;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo010ComBodyResVO (IfGo010ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo010ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo010ComBodyResVO extends BaseVO {
	private List<IfGo010ComBodyIdxResVO> idxList;
	
	public IfGo010ComBodyResVO() {
		super();
	}

	public List<IfGo010ComBodyIdxResVO> getIdxList() {
		return idxList;
	}

	public void setIdxList(List<IfGo010ComBodyIdxResVO> idxList) {
		this.idxList = idxList;
	}

}