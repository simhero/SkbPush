package com.skt.ssp.gw.vo.goods;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo002ComBodyResVO (IfGo002ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo002ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo002ComBodyResVO extends BaseVO {
	private String adminCode		= "";
	private String userId			= "";
	private String gJcode			= "";
	private String gModel			= "";
	private String gMfname			= "";
	private String gBrandName		= "";
	private String gOrigin			= "";
	private String img				= "";
	private String gQty				= "";
	private List<IfGo002ComBodyGoodsResVO> goodsList;
	
	public IfGo002ComBodyResVO() {
		super();
		this.adminCode		= "";
		this.userId			= "";
		this.gJcode			= "";
		this.gModel			= "";
		this.gMfname		= "";
		this.gBrandName		= "";
		this.gOrigin		= "";
		this.img			= "";
		this.gQty			= "";
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

	public String getgModel() {
		return gModel;
	}

	public String getgMfname() {
		return gMfname;
	}

	public String getgBrandName() {
		return gBrandName;
	}

	public String getgOrigin() {
		return gOrigin;
	}

	public String getImg() {
		return img;
	}

	public String getgQty() {
		return gQty;
	}

	public List<IfGo002ComBodyGoodsResVO> getGoodsList() {
		return goodsList;
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

	public void setgModel(String gModel) {
		this.gModel = gModel;
	}

	public void setgMfname(String gMfname) {
		this.gMfname = gMfname;
	}

	public void setgBrandName(String gBrandName) {
		this.gBrandName = gBrandName;
	}

	public void setgOrigin(String gOrigin) {
		this.gOrigin = gOrigin;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void setgQty(String gQty) {
		this.gQty = gQty;
	}

	public void setGoodsList(List<IfGo002ComBodyGoodsResVO> goodsList) {
		this.goodsList = goodsList;
	}
	
}