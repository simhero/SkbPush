package com.skt.ssp.gw.vo.goods;

import java.util.ArrayList;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfGo010ComBodyReqVO (IfGo010ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo010ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo010ComBodyReqVO extends BaseVO {
	private String adminCode	= "";
	private String userId		= "";
	private String gJcode		= "";
	private String mainCode		= "";
	private String gB2bcode		= "";
	private ArrayList<IfGo010ComBodyIdxReqVO> idxList;
	
	public IfGo010ComBodyReqVO() {
		super();
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

	public String getgB2bcode() {
		return gB2bcode;
	}

	public ArrayList<IfGo010ComBodyIdxReqVO> getIdxList() {
		return idxList;
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

	public void setgB2bcode(String gB2bcode) {
		this.gB2bcode = gB2bcode;
	}

	public void setIdxList(ArrayList<IfGo010ComBodyIdxReqVO> idxList) {
		this.idxList = idxList;
	}

}