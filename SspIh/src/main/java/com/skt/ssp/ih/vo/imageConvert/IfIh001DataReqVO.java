package com.skt.ssp.ih.vo.imageConvert;

import com.skt.ssp.ih.vo.BaseVO;

/**
 * IfIh001DataReqVO (IfIh001DataReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfIh001DataReqVO.java,v 1.0 2011/10/31 00:00:00 ChoKyuJin Express $
 */
public class IfIh001DataReqVO extends BaseVO {
	private IfIh001BodyReqVO body;

	public IfIh001DataReqVO() {
		super();
	}

	public IfIh001BodyReqVO getBody() {
		return body;
	}

	public void setBody(IfIh001BodyReqVO body) {
		this.body = body;
	}

}