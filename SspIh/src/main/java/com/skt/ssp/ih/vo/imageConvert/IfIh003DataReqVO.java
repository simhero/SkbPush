package com.skt.ssp.ih.vo.imageConvert;

import com.skt.ssp.ih.vo.BaseVO;

/**
 * IfIh003DataReqVO (IfIh003DataReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfIh003DataReqVO.java,v 1.0 2011/10/31 00:00:00 ChoKyuJin Express $
 */
public class IfIh003DataReqVO extends BaseVO {
	private IfIh003BodyReqVO body;
	
	public IfIh003DataReqVO() {
		super();
	}

	public IfIh003BodyReqVO getBody() {
		return body;
	}

	public void setBody(IfIh003BodyReqVO body) {
		this.body = body;
	}

}