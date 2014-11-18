package com.skt.ssp.ih.vo.imageConvert;

import com.skt.ssp.ih.vo.BaseVO;

/**
 * IfIh002DataResVO (IfIh002DataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfIh002DataResVO.java,v 1.0 2011/10/31 00:00:00 ChoKyuJin Express $
 */
public class IfIh002DataResVO extends BaseVO {
	private IfIh002BodyResVO body;
	
	public IfIh002DataResVO() {
		super();
	}

	public IfIh002BodyResVO getBody() {
		return body;
	}

	public void setBody(IfIh002BodyResVO body) {
		this.body = body;
	}

}