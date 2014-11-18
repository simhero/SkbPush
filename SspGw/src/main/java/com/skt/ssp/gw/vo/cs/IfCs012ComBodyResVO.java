package com.skt.ssp.gw.vo.cs;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCs012ComBodyResVO (IfCs012ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCs012ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCs012ComBodyResVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String faqCnt		= "";
	private List<IfCs012ComBodyFaqResVO> faqList;

	public IfCs012ComBodyResVO() {
		super();
	}

	public String getAdminCode() {
		return adminCode;
	}

	public String getUserId() {
		return userId;
	}

	public String getFaqCnt() {
		return faqCnt;
	}

	public List<IfCs012ComBodyFaqResVO> getFaqList() {
		return faqList;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setFaqCnt(String faqCnt) {
		this.faqCnt = faqCnt;
	}

	public void setFaqList(List<IfCs012ComBodyFaqResVO> faqList) {
		this.faqList = faqList;
	}

}