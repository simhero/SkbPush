package com.skt.ssp.gw.vo.goods;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo005MobResVO (IfGo005MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo005MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo005MobResVO extends BaseVO {
	private IfGo005MobDataResVO response;

	public IfGo005MobResVO() {
		super();
	}

	public IfGo005MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfGo005MobDataResVO response) {
		this.response = response;
	}



}