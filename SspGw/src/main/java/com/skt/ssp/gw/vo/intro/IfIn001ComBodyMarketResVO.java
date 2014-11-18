package com.skt.ssp.gw.vo.intro;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfIn001ComBodyMarketResVO VO (IfIn001ComBodyMarketResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfIn001ComBodyMarketResVO.java,v1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfIn001ComBodyMarketResVO extends BaseVO {
	private String mainCode = "";
	private String mainName = "";
	private List<IfIn001ComBodyKeyWordResVO> keyWordList;

	public IfIn001ComBodyMarketResVO() {
		super();
		this.mainCode = "";
		this.mainName = "";
	}

	public String getMainCode() {
		return mainCode;
	}

	public String getMainName() {
		return mainName;
	}

	public List<IfIn001ComBodyKeyWordResVO> getKeyWordList() {
		return keyWordList;
	}

	public void setMainCode(String mainCode) {
		this.mainCode = mainCode;
	}

	public void setMainName(String mainName) {
		this.mainName = mainName;
	}

	public void setKeyWordList(List<IfIn001ComBodyKeyWordResVO> keyWordList) {
		this.keyWordList = keyWordList;
	}

}
