package com.skt.ssp.gw.vo.cs;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs012ComBodyFaqResVO (IfCs012ComBodyFaqResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs012ComBodyFaqResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs012ComBodyFaqResVO extends BaseVO {
	private String faqNo		= "";
	private String faqTitle		= "";
	private String faqContents	= "";
	private String faqDate		= "";

	public IfCs012ComBodyFaqResVO() {
		super();
	}

	public String getFaqNo() {
		return faqNo;
	}

	public String getFaqTitle() {
		return faqTitle;
	}

	public String getFaqContents() {
		return faqContents;
	}

	public String getFaqDate() {
		return faqDate;
	}

	public void setFaqNo(String faqNo) {
		this.faqNo = faqNo;
	}

	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}

	public void setFaqContents(String faqContents) {
		this.faqContents = faqContents;
	}

	public void setFaqDate(String faqDate) {
		this.faqDate = faqDate;
	}

}