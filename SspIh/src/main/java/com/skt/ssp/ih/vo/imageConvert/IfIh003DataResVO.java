package com.skt.ssp.ih.vo.imageConvert;

import com.skt.ssp.ih.vo.BaseVO;

/**
 * IfIh003DataResVO (IfIh003DataResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfIh003DataResVO.java,v 1.0 2011/10/31 00:00:00 ChoKyuJin Express $
 */
public class IfIh003DataResVO extends BaseVO {
	private IfIh003BodyResVO body;
	
	public IfIh003DataResVO() {
		super();
	}

	public IfIh003BodyResVO getBody() {
		return body;
	}

	public void setBody(IfIh003BodyResVO body) {
		this.body = body;
	}

}