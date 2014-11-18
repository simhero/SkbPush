package com.skt.ssp.gw.vo.statistics;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfSt002ComBodyResVO (IfSt002ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSt002ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSt002ComBodyResVO extends BaseVO {
	private String statisticsCnt = "";
	private List<IfSt002ComBodyStatisticsResVO> statisticsList;
	private IfSt002ComBodySummaryResVO summary;
	
	public IfSt002ComBodyResVO() {
		super();
	}

	public String getStatisticsCnt() {
		return statisticsCnt;
	}

	public List<IfSt002ComBodyStatisticsResVO> getStatisticsList() {
		return statisticsList;
	}

	public IfSt002ComBodySummaryResVO getSummary() {
		return summary;
	}

	public void setStatisticsCnt(String statisticsCnt) {
		this.statisticsCnt = statisticsCnt;
	}

	public void setStatisticsList(List<IfSt002ComBodyStatisticsResVO> statisticsList) {
		this.statisticsList = statisticsList;
	}

	public void setSummary(IfSt002ComBodySummaryResVO summary) {
		this.summary = summary;
	}

}