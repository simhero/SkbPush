package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs005MobReqVO (IfCs005MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs005MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs005MobReqVO extends BaseVO {
	private IfCs005MobDataReqVO request;

	public IfCs005MobReqVO() {
		super();
	}

	public IfCs005MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfCs005MobDataReqVO request) {
		this.request = request;
	}

}