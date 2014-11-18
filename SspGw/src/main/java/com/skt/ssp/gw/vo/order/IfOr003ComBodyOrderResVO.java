package com.skt.ssp.gw.vo.order;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfOr003ComBodyOrderResVO (IfOr003ComBodyOrderResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfOr003ComBodyOrderResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfOr003ComBodyOrderResVO extends BaseVO {
	private String jumunNo	= "";
	private String oState	= "";
	private String rsltCode	= "";
	private String rsltMsg	= "";

	public IfOr003ComBodyOrderResVO() {
		super();
	}

	public String getJumunNo() {
		return jumunNo;
	}

	public String getoState() {
		return oState;
	}

	public String getRsltCode() {
		return rsltCode;
	}

	public String getRsltMsg() {
		return rsltMsg;
	}

	public void setJumunNo(String jumunNo) {
		this.jumunNo = jumunNo;
	}

	public void setoState(String oState) {
		this.oState = oState;
	}

	public void setRsltCode(String rsltCode) {
		this.rsltCode = rsltCode;
	}

	public void setRsltMsg(String rsltMsg) {
		this.rsltMsg = rsltMsg;
	}

}