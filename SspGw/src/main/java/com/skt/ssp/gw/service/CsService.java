package com.skt.ssp.gw.service;

import com.skt.ssp.gw.vo.cs.IfCs001MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs001MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs002MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs002MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs003MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs003MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs004MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs004MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs005MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs005MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs006MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs006MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs007MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs007MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs008MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs008MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs009MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs009MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs010MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs010MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs011MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs011MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs012MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs012MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs013MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs013MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs014MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs014MobResVO;
import com.skt.ssp.gw.vo.cs.IfCs015MobReqVO;
import com.skt.ssp.gw.vo.cs.IfCs015MobResVO;


/**
 * Cs Service Interface (CsService)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: CsService.java,v 1.1 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public interface CsService {
	public void jmsCs();
	public IfCs001MobResVO requestCs001(IfCs001MobReqVO ifCs001MobReqVO);
	public IfCs002MobResVO requestCs002(IfCs002MobReqVO ifCs002MobReqVO);
	public IfCs003MobResVO requestCs003(IfCs003MobReqVO ifCs003MobReqVO);
	public IfCs004MobResVO requestCs004(IfCs004MobReqVO ifCs004MobReqVO);
	public IfCs005MobResVO requestCs005(IfCs005MobReqVO ifCs005MobReqVO);
	public IfCs006MobResVO requestCs006(IfCs006MobReqVO ifCs006MobReqVO);
	public IfCs007MobResVO requestCs007(IfCs007MobReqVO ifCs007MobReqVO);
	public IfCs008MobResVO requestCs008(IfCs008MobReqVO ifCs008MobReqVO);
	public IfCs009MobResVO requestCs009(IfCs009MobReqVO ifCs009MobReqVO);
	public IfCs010MobResVO requestCs010(IfCs010MobReqVO ifCs010MobReqVO);
	public IfCs011MobResVO requestCs011(IfCs011MobReqVO ifCs011MobReqVO);
	public IfCs012MobResVO requestCs012(IfCs012MobReqVO ifCs012MobReqVO);
	public IfCs013MobResVO requestCs013(IfCs013MobReqVO ifCs013MobReqVO);
	public IfCs014MobResVO requestCs014(IfCs014MobReqVO ifCs014MobReqVO);
	public IfCs015MobResVO requestCs015(IfCs015MobReqVO ifCs015MobReqVO);
	
}