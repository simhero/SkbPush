package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo006ComBodyGroupResVO (IfGo006ComBodyGroupResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo006ComBodyGroupResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo006ComBodyGroupResVO extends BaseVO {
	private String groupCode	= "";
	private String groupName	= "";
	
	public IfGo006ComBodyGroupResVO() {
		super();
	}

	public String getGroupCode() {
		return groupCode;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}