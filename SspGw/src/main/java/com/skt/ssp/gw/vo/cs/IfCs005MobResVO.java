package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs005MobResVO (IfCs005MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs005MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs005MobResVO extends BaseVO {
	private IfCs005MobDataResVO response;

	public IfCs005MobResVO() {
		super();
	}

	public IfCs005MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCs005MobDataResVO response) {
		this.response = response;
	}



}