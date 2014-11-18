package com.skt.ssp.gw.service;

import com.skt.ssp.gw.vo.intro.IfIn001MobReqVO;
import com.skt.ssp.gw.vo.intro.IfIn001MobResVO;
import com.skt.ssp.gw.vo.intro.IfIn002MobReqVO;
import com.skt.ssp.gw.vo.intro.IfIn002MobResVO;

/**
 * Intro Service Interface (IntroService)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IntroService.java,v 1.1 2011/09/03 00:00:00 SimByungChul Express $
 */
public interface IntroService {
	public void jmsTest();
	public IfIn001MobResVO requestIntro001(IfIn001MobReqVO ifIn001MobReqVO);
	public IfIn002MobResVO requestIntro002(IfIn002MobReqVO ifIn002MobReqVO);
}