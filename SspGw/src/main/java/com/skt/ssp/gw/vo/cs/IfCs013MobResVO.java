package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs013MobResVO (IfCs013MobResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs013MobResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs013MobResVO extends BaseVO {
	private IfCs013MobDataResVO response;

	public IfCs013MobResVO() {
		super();
	}

	public IfCs013MobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfCs013MobDataResVO response) {
		this.response = response;
	}



}