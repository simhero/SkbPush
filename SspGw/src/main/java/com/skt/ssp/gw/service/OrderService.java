package com.skt.ssp.gw.service;

import com.skt.ssp.gw.vo.order.IfOr001MobReqVO;
import com.skt.ssp.gw.vo.order.IfOr001MobResVO;
import com.skt.ssp.gw.vo.order.IfOr002MobReqVO;
import com.skt.ssp.gw.vo.order.IfOr002MobResVO;
import com.skt.ssp.gw.vo.order.IfOr003MobReqVO;
import com.skt.ssp.gw.vo.order.IfOr003MobResVO;

/**
 * Order Service Interface (OrderService)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: OrderService.java,v1.1 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public interface OrderService {
	public void jmsOrder();
	public IfOr001MobResVO requestOrder001(IfOr001MobReqVO ifOr001MobReqVO);
	public IfOr002MobResVO requestOrder002(IfOr002MobReqVO ifOr002MobReqVO);
	public IfOr003MobResVO requestOrder003(IfOr003MobReqVO ifOr003MobReqVO);
}