package com.skt.ssp.gw.vo.push;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfPu004ComBodyResVO (IfPu004ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfPu004ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfPu004ComBodyResVO extends BaseVO {
	private List<IfPu004ComBodyPushInfoResVO> pushInfoList;
	
	public IfPu004ComBodyResVO() {
		super();
	}

	public List<IfPu004ComBodyPushInfoResVO> getPushInfoList() {
		return pushInfoList;
	}

	public void setPushInfoList(List<IfPu004ComBodyPushInfoResVO> pushInfoList) {
		this.pushInfoList = pushInfoList;
	}

}