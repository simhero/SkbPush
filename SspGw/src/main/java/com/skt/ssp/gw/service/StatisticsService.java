package com.skt.ssp.gw.service;

import com.skt.ssp.gw.vo.statistics.IfSt001MobReqVO;
import com.skt.ssp.gw.vo.statistics.IfSt001MobResVO;
import com.skt.ssp.gw.vo.statistics.IfSt002MobReqVO;
import com.skt.ssp.gw.vo.statistics.IfSt002MobResVO;

/**
 * Statistics Service Interface (StatisticsService)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: StatisticsService.java,v 1.1 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public interface StatisticsService {
	public void jmsStatistics();
	public IfSt001MobResVO requestStatistics001(IfSt001MobReqVO ifSt001MobReqVO);
	public IfSt002MobResVO requestStatistics002(IfSt002MobReqVO ifSt002MobReqVO);
}