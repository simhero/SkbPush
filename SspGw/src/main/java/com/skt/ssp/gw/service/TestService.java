package com.skt.ssp.gw.service;

import com.skt.ssp.gw.vo.test.IfTe001MobReqVO;
import com.skt.ssp.gw.vo.test.IfTe001MobResVO;

/**
 * Test Service Interface (TestService)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: TestService.java,v 1.1 2011/09/03 00:00:00 SimByungChul Express $
 */
public interface TestService {
	public void jmsTest();
	public IfTe001MobResVO requestTest001(IfTe001MobReqVO ifTe001MobReqVO);
}