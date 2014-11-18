package com.skt.ssp.gw.vo.intro;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfIn001ComBodyKeyWordRes VO (IfIn001ComBodyKeyWordResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfIn001ComBodyKeyWordResVO.java,v1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfIn001ComBodyKeyWordResVO extends BaseVO {
	private String keyNo = "";
	private String keyWord = "";
	private String hitCnt = "";

	public IfIn001ComBodyKeyWordResVO() {
		super();
		this.keyNo = "";
		this.keyWord = "";
		this.hitCnt = "";
	}

	public String getKeyNo() {
		return keyNo;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public String getHitCnt() {
		return hitCnt;
	}

	public void setKeyNo(String keyNo) {
		this.keyNo = keyNo;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public void setHitCnt(String hitCnt) {
		this.hitCnt = hitCnt;
	}

}
