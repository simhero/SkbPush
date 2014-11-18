package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo005MobReqVO (IfGo005MobReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo005MobReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo005MobReqVO extends BaseVO {
	private IfGo005MobDataReqVO request;

	public IfGo005MobReqVO() {
		super();
	}

	public IfGo005MobDataReqVO getRequest() {
		return request;
	}

	public void setRequest(IfGo005MobDataReqVO request) {
		this.request = request;
	}

}