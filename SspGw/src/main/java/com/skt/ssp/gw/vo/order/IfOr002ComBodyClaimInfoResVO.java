package com.skt.ssp.gw.vo.order;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfOr002ComBodyClaimInfoResVO (IfOr002ComBodyClaimInfoResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfOr002ComBodyClaimInfoResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfOr002ComBodyClaimInfoResVO extends BaseVO {
	private String claimStatus			= "";
	private String claimCount			= "";
	private String claimPrice			= "";
	private String claimRegDate			= "";
	private String claimRegUser			= "";
	private String claimDesc			= "";
	private String claimSolveDate		= "";
	private String claimSolveUser		= "";
	private String claimCancelReason	= "";
	
	public IfOr002ComBodyClaimInfoResVO() {
		super();
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public String getClaimCount() {
		return claimCount;
	}

	public String getClaimPrice() {
		return claimPrice;
	}

	public String getClaimRegDate() {
		return claimRegDate;
	}

	public String getClaimRegUser() {
		return claimRegUser;
	}

	public String getClaimDesc() {
		return claimDesc;
	}

	public String getClaimSolveDate() {
		return claimSolveDate;
	}

	public String getClaimSolveUser() {
		return claimSolveUser;
	}

	public String getClaimCancelReason() {
		return claimCancelReason;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public void setClaimCount(String claimCount) {
		this.claimCount = claimCount;
	}

	public void setClaimPrice(String claimPrice) {
		this.claimPrice = claimPrice;
	}

	public void setClaimRegDate(String claimRegDate) {
		this.claimRegDate = claimRegDate;
	}

	public void setClaimRegUser(String claimRegUser) {
		this.claimRegUser = claimRegUser;
	}

	public void setClaimDesc(String claimDesc) {
		this.claimDesc = claimDesc;
	}

	public void setClaimSolveDate(String claimSolveDate) {
		this.claimSolveDate = claimSolveDate;
	}

	public void setClaimSolveUser(String claimSolveUser) {
		this.claimSolveUser = claimSolveUser;
	}

	public void setClaimCancelReason(String claimCancelReason) {
		this.claimCancelReason = claimCancelReason;
	}

}