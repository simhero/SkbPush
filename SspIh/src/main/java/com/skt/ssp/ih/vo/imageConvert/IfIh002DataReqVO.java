package com.skt.ssp.ih.vo.imageConvert;

import com.skt.ssp.ih.vo.BaseVO;

/**
 * IfIh002DataReqVO (IfIh002DataReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfIh002DataReqVO.java,v 1.0 2011/10/31 00:00:00 ChoKyuJin Express $
 */
public class IfIh002DataReqVO extends BaseVO {
	private IfIh002BodyReqVO body;

	public IfIh002DataReqVO() {
		super();
	}

	public IfIh002BodyReqVO getBody() {
		return body;
	}

	public void setBody(IfIh002BodyReqVO body) {
		this.body = body;
	}

}