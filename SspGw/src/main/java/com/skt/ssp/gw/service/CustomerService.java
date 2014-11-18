package com.skt.ssp.gw.service;

import com.skt.ssp.gw.vo.customer.IfCu001MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu001MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu002MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu002MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu003MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu003MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu004MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu004MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu005MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu005MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu006MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu006MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu007MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu007MobResVO;
import com.skt.ssp.gw.vo.customer.IfCu008MobReqVO;
import com.skt.ssp.gw.vo.customer.IfCu008MobResVO;

/**
 * Customer Service Interface (CustomerService)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: CustomerService.java,v 1.1 2011/09/03 00:00:00 SimByungChul Express $
 */
public interface CustomerService {
	public void jmsCustomer();
	public IfCu001MobResVO requestCustomer001(IfCu001MobReqVO ifCu001MobReqVO) throws Exception;
	public IfCu002MobResVO requestCustomer002(IfCu002MobReqVO ifCu002MobReqVO);
	public IfCu003MobResVO requestCustomer003(IfCu003MobReqVO ifCu003MobReqVO);
	public IfCu004MobResVO requestCustomer004(IfCu004MobReqVO ifGo005MobReqVO);
	public IfCu005MobResVO requestCustomer005(IfCu005MobReqVO ifCu005MobReqVO);
	public IfCu006MobResVO requestCustomer006(IfCu006MobReqVO ifCu006MobReqVO);
	public IfCu007MobResVO requestCustomer007(IfCu007MobReqVO ifCu007MobReqVO);
	public IfCu008MobResVO requestCustomer008(IfCu008MobReqVO ifCu008MobReqVO) throws Exception;
}
