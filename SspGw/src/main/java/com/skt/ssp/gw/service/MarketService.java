package com.skt.ssp.gw.service;

import com.skt.ssp.gw.vo.test.IfTe001MobReqVO;
import com.skt.ssp.gw.vo.test.IfTe001MobResVO;

/**
 * Market Service Interface (MarketService)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: MarketService.java,v 1.1 2011/09/03 00:00:00 SimByungChul Express $
 */
public interface MarketService {
	public void jmsMarket();
	public IfTe001MobResVO requestMarket001(IfTe001MobReqVO ifTe001MobReqVO);
}