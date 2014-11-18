package com.skt.ssp.gw.service;

import com.skt.ssp.gw.vo.settlement.IfSe001MobReqVO;
import com.skt.ssp.gw.vo.settlement.IfSe001MobResVO;
import com.skt.ssp.gw.vo.settlement.IfSe002MobReqVO;
import com.skt.ssp.gw.vo.settlement.IfSe002MobResVO;

/**
 * Settlement Service Interface (SettlementService)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: SettlementService.java,v 1.1 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public interface SettlementService {
	public void jmsSettlement();
	public IfSe001MobResVO requestSettlement001(IfSe001MobReqVO ifSe001MobReqVO);
	public IfSe002MobResVO requestSettlement002(IfSe002MobReqVO ifSe002MobReqVO);
}