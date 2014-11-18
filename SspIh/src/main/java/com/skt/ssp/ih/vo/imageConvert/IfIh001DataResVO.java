package com.skt.ssp.ih.vo.imageConvert;

import com.skt.ssp.ih.vo.BaseVO;

/**
 * IfIh001DataResVO (IfIh001DataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfIh001DataResVO.java,v 1.0 2011/10/31 00:00:00 ChoKyuJin Express $
 */
public class IfIh001DataResVO extends BaseVO {
	private IfIh001BodyResVO body;
	
	public IfIh001DataResVO() {
		super();
	}

	public IfIh001BodyResVO getBody() {
		return body;
	}

	public void setBody(IfIh001BodyResVO body) {
		this.body = body;
	}

}