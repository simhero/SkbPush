package com.skt.ssp.gw.vo.push;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfPu001MobReqVO (IfPu001MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfPu001MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfPu001MobReqVO extends BaseVO {
	private IfPu001MobDataReqVO request;

	public IfPu001MobReqVO() {
		super();
	}

	public IfPu001MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfPu001MobDataReqVO request) {
		this.request = request;
	}

}