package com.skt.ssp.gw.vo.intro;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfIn001ComBodyRes VO (IfIn001ComBodyResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfIn001ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfIn001ComBodyResVO extends BaseVO {
	private String keywordDate		= "";
	private String storeURL			= "";
	private String comAppVersion	= "";
	private String comAppUpdate		= "";
		
	private List<IfIn001ComBodyMarketResVO> marketList;

	public IfIn001ComBodyResVO() {
		super();
	}

	public String getKeywordDate() {
		return keywordDate;
	}

	public String getStoreURL() {
		return storeURL;
	}

	public String getComAppVersion() {
		return comAppVersion;
	}

	public String getComAppUpdate() {
		return comAppUpdate;
	}

	public List<IfIn001ComBodyMarketResVO> getMarketList() {
		return marketList;
	}

	public void setKeywordDate(String keywordDate) {
		this.keywordDate = keywordDate;
	}

	public void setStoreURL(String storeURL) {
		this.storeURL = storeURL;
	}

	public void setComAppVersion(String comAppVersion) {
		this.comAppVersion = comAppVersion;
	}

	public void setComAppUpdate(String comAppUpdate) {
		this.comAppUpdate = comAppUpdate;
	}

	public void setMarketList(List<IfIn001ComBodyMarketResVO> marketList) {
		this.marketList = marketList;
	}

}
