package com.skt.ssp.gw.vo.order;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfOr003ComBodyOrderReqVO (IfOr003ComBodyOrderReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfOr003ComBodyOrderReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfOr003ComBodyOrderReqVO extends BaseVO {
	private String mainCode		= "";
	private String uid			= "";
	private String jumunNo		= "";
	private String cmd			= "";
	private String oState		= "";
	private String tagcom		= "";
	private String songjangNo	= "";

	public IfOr003ComBodyOrderReqVO() {
		super();
	}

	public String getMainCode() {
		return mainCode;
	}

	public String getUid() {
		return uid;
	}

	public String getJumunNo() {
		return jumunNo;
	}

	public String getCmd() {
		return cmd;
	}

	public String getoState() {
		return oState;
	}

	public String getTagcom() {
		return tagcom;
	}

	public String getSongjangNo() {
		return songjangNo;
	}

	public void setMainCode(String mainCode) {
		this.mainCode = mainCode;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setJumunNo(String jumunNo) {
		this.jumunNo = jumunNo;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public void setoState(String oState) {
		this.oState = oState;
	}

	public void setTagcom(String tagcom) {
		this.tagcom = tagcom;
	}

	public void setSongjangNo(String songjangNo) {
		this.songjangNo = songjangNo;
	}

}