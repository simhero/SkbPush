package com.skt.ssp.gw.service;

import com.skt.ssp.gw.vo.config.IfCf001MobReqVO;
import com.skt.ssp.gw.vo.config.IfCf001MobResVO;
import com.skt.ssp.gw.vo.config.IfCf002MobReqVO;
import com.skt.ssp.gw.vo.config.IfCf002MobResVO;
import com.skt.ssp.gw.vo.config.IfCf003MobReqVO;
import com.skt.ssp.gw.vo.config.IfCf003MobResVO;
import com.skt.ssp.gw.vo.config.IfCf004MobReqVO;
import com.skt.ssp.gw.vo.config.IfCf004MobResVO;

/**
 * Config Service Interface (ConfigService)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: ConfigService.java,v 1.1 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public interface ConfigService {
	public void jmsPush();
	public IfCf001MobResVO requestConfig001(IfCf001MobReqVO ifCf001MobReqVO);
	public IfCf002MobResVO requestConfig002(IfCf002MobReqVO ifCf002MobReqVO);
	public IfCf003MobResVO requestConfig003(IfCf003MobReqVO ifCf003MobReqVO);
	public IfCf004MobResVO requestConfig004(IfCf004MobReqVO ifCf004MobReqVO);
}
