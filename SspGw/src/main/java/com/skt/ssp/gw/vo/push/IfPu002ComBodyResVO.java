package com.skt.ssp.gw.vo.push;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfPu002ComBodyResVO (IfPu002ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfPu002ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfPu002ComBodyResVO extends BaseVO {
	private String pushCnt	= "";
	private List<IfPu002ComBodyPushMsgResVO> pushMsgList;

	public IfPu002ComBodyResVO() {
		super();
	}

	public String getPushCnt() {
		return pushCnt;
	}

	public List<IfPu002ComBodyPushMsgResVO> getPushMsgList() {
		return pushMsgList;
	}

	public void setPushCnt(String pushCnt) {
		this.pushCnt = pushCnt;
	}

	public void setPushMsgList(List<IfPu002ComBodyPushMsgResVO> pushMsgList) {
		this.pushMsgList = pushMsgList;
	}

}