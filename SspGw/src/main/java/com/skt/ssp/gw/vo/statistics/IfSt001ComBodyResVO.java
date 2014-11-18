package com.skt.ssp.gw.vo.statistics;

import java.util.List;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfSt001ComBodyResVO (IfSt001ComBodyResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSt001ComBodyResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSt001ComBodyResVO extends BaseVO {
	private String statisticsCnt	= "";
	private IfSt001ComBodySummaryResVO summary;
	private List<IfSt001ComBodyStatisticsResVO> statisticsList;

	public IfSt001ComBodyResVO() {
		super();
	}

	public String getStatisticsCnt() {
		return statisticsCnt;
	}

	public IfSt001ComBodySummaryResVO getSummary() {
		return summary;
	}

	public List<IfSt001ComBodyStatisticsResVO> getStatisticsList() {
		return statisticsList;
	}

	public void setStatisticsCnt(String statisticsCnt) {
		this.statisticsCnt = statisticsCnt;
	}

	public void setSummary(IfSt001ComBodySummaryResVO summary) {
		this.summary = summary;
	}

	public void setStatisticsList(List<IfSt001ComBodyStatisticsResVO> statisticsList) {
		this.statisticsList = statisticsList;
	}

}