package com.skt.ssp.gw.vo.push;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfPu002MobReqVO (IfPu002MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfPu002MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfPu002MobReqVO extends BaseVO {
	private IfPu002MobDataReqVO request;

	public IfPu002MobReqVO() {
		super();
	}

	public IfPu002MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfPu002MobDataReqVO request) {
		this.request = request;
	}

}