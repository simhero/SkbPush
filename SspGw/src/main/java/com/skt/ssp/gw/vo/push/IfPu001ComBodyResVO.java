package com.skt.ssp.gw.vo.push;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfPu001ComBodyResVO (IfPu001ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfPu001ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfPu001ComBodyResVO extends BaseVO {
	private String pushCnt	= "";
	private List<IfPu001ComBodyPushMsgResVO> pushMsgList;

	public IfPu001ComBodyResVO() {
		super();
	}

	public String getPushCnt() {
		return pushCnt;
	}

	public List<IfPu001ComBodyPushMsgResVO> getPushMsgList() {
		return pushMsgList;
	}

	public void setPushCnt(String pushCnt) {
		this.pushCnt = pushCnt;
	}

	public void setPushMsgList(List<IfPu001ComBodyPushMsgResVO> pushMsgList) {
		this.pushMsgList = pushMsgList;
	}

}