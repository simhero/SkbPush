package com.skt.ssp.gw.vo.goods;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo006ComBodyResVO (IfGo006ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo006ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo006ComBodyResVO extends BaseVO {
	private String groupCnt	= "";
	private List<IfGo006ComBodyGroupResVO> groupList;

	public IfGo006ComBodyResVO() {
		super();
	}

	public String getGroupCnt() {
		return groupCnt;
	}

	public List<IfGo006ComBodyGroupResVO> getGroupList() {
		return groupList;
	}

	public void setGroupCnt(String groupCnt) {
		this.groupCnt = groupCnt;
	}

	public void setGroupList(List<IfGo006ComBodyGroupResVO> groupList) {
		this.groupList = groupList;
	}

}