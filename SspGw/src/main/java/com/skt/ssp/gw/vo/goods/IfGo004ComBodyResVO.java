package com.skt.ssp.gw.vo.goods;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo004ComBodyResVO (IfGo004ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo004ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo004ComBodyResVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String gJcode		= "";
	private String mainCode		= "";
	private String uid			= "";
	private String gB2bcode		= "";
	private String goodsLogCnt	= "";
	private List<IfGo004ComBodyGoodsResVO> goodsLogList;

	public IfGo004ComBodyResVO() {
		super();
		this.adminCode		= "";
		this.userId			= "";
		this.gJcode			= "";
		this.mainCode		= "";
		this.uid			= "";
		this.gB2bcode		= "";
		this.goodsLogCnt	= "";
	}

	public String getAdminCode() {
		return adminCode;
	}

	public String getUserId() {
		return userId;
	}

	public String getgJcode() {
		return gJcode;
	}

	public String getMainCode() {
		return mainCode;
	}

	public String getUid() {
		return uid;
	}

	public String getgB2bcode() {
		return gB2bcode;
	}

	public String getGoodsLogCnt() {
		return goodsLogCnt;
	}

	public List<IfGo004ComBodyGoodsResVO> getGoodsLogList() {
		return goodsLogList;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setgJcode(String gJcode) {
		this.gJcode = gJcode;
	}

	public void setMainCode(String mainCode) {
		this.mainCode = mainCode;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setgB2bcode(String gB2bcode) {
		this.gB2bcode = gB2bcode;
	}

	public void setGoodsLogCnt(String goodsLogCnt) {
		this.goodsLogCnt = goodsLogCnt;
	}

	public void setGoodsLogList(List<IfGo004ComBodyGoodsResVO> goodsLogList) {
		this.goodsLogList = goodsLogList;
	}

}