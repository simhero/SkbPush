package com.skt.ssp.gw.service.impl;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.jms.JMSException;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skt.ssp.gw.adapter.DbpMsgSender;
import com.skt.ssp.gw.common.QueueSend;
import com.skt.ssp.gw.parse.CsDbpMsgMaker;
import com.skt.ssp.gw.parse.CsDbpMsgReader;
import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.service.CsService;
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
 * Cs Service Impl(CsServiceImpl)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: CsServiceImpl.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin  Express $
 */
@Service("csService")
public class CsServiceImpl implements CsService {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CompositeConfiguration config;
	@Autowired
	private CommonService commonService;
	@Autowired
	private DbpMsgSender dbpMsgSender;
	@Autowired
	private CsDbpMsgMaker csDbpMsgMaker;
	@Autowired
	private CsDbpMsgReader csDbpMsgReader;
	private QueueSend qs = null;

	public CsServiceImpl() {
	}

	@PostConstruct
	public void init() throws Exception {
		qs = commonService.getQueueInstance(config.getString("SAMPLE_QUEUE"));
	}

	@PreDestroy
	public void destroy() throws Exception {
		if(qs != null) qs.close();
	}

	@Override
	public void jmsCs() {
		try {
			sendQueue("QUEUE TEST");
		} catch (JMSException jmsEx) {
			qs = null;
			if (logger.isErrorEnabled()) {
				logger.error("jmsCs()\r\n" + jmsEx);
			}
		} catch (Exception e) {
			if (qs == null)
				qs = commonService.getQueueInstance(config.getString("SAMPLE_QUEUE"));
			if (logger.isErrorEnabled()) {
				logger.error("jmsCs()\r\n" + e);
			}
		}
	}
	
	public String send(String interfaceId, String dbpReqMessage) {
		return dbpMsgSender.send(interfaceId, StringUtils.stripToEmpty(dbpReqMessage));
	}

	private void sendQueue(String msg) throws Exception {
		HashMap<String,Object> queueData = new HashMap<String,Object>();
		logger.info("sendQueue(String msg) msg="+msg);
		queueData.put("MSG", msg);
		qs.send(queueData);
	}

	@Override
	public IfCs001MobResVO requestCs001(IfCs001MobReqVO ifCs001MobReqVO) {
		return getCs001DbpResMessage(send(ifCs001MobReqVO.getRequest().getHeader().getComInterfaceId(), getCs001DbpReqMessage(ifCs001MobReqVO)));
	}

	private String getCs001DbpReqMessage(IfCs001MobReqVO ifCs001MobReqVO) {
		return csDbpMsgMaker.getCs001DbpReqMessage(ifCs001MobReqVO);
	}

	private IfCs001MobResVO getCs001DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return csDbpMsgReader.getCs001DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfCs002MobResVO requestCs002(IfCs002MobReqVO ifCs002MobReqVO) {
		return getCs002DbpResMessage(send(ifCs002MobReqVO.getRequest().getHeader().getComInterfaceId(), getCs002DbpReqMessage(ifCs002MobReqVO)));
	}

	private String getCs002DbpReqMessage(IfCs002MobReqVO ifCs002MobReqVO) {
		return csDbpMsgMaker.getCs002DbpReqMessage(ifCs002MobReqVO);
	}

	private IfCs002MobResVO getCs002DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return csDbpMsgReader.getCs002DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfCs003MobResVO requestCs003(IfCs003MobReqVO ifCs003MobReqVO) {
		return getCs003DbpResMessage(send(ifCs003MobReqVO.getRequest().getHeader().getComInterfaceId(), getCs003DbpReqMessage(ifCs003MobReqVO)));
	}

	private String getCs003DbpReqMessage(IfCs003MobReqVO ifCs003MobReqVO) {
		return csDbpMsgMaker.getCs003DbpReqMessage(ifCs003MobReqVO);
	}

	private IfCs003MobResVO getCs003DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return csDbpMsgReader.getCs003DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfCs004MobResVO requestCs004(IfCs004MobReqVO ifCs004MobReqVO) {
		return getCs004DbpResMessage(send(ifCs004MobReqVO.getRequest().getHeader().getComInterfaceId(), getCs004DbpReqMessage(ifCs004MobReqVO)));
	}

	private String getCs004DbpReqMessage(IfCs004MobReqVO ifCs004MobReqVO) {
		return csDbpMsgMaker.getCs004DbpReqMessage(ifCs004MobReqVO);
	}

	private IfCs004MobResVO getCs004DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return csDbpMsgReader.getCs004DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfCs005MobResVO requestCs005(IfCs005MobReqVO ifCs005MobReqVO) {
		return getCs005DbpResMessage(send(ifCs005MobReqVO.getRequest().getHeader().getComInterfaceId(), getCs005DbpReqMessage(ifCs005MobReqVO)));
	}

	private String getCs005DbpReqMessage(IfCs005MobReqVO ifCs005MobReqVO) {
		return csDbpMsgMaker.getCs005DbpReqMessage(ifCs005MobReqVO);
	}

	private IfCs005MobResVO getCs005DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return csDbpMsgReader.getCs005DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfCs006MobResVO requestCs006(IfCs006MobReqVO ifCs006MobReqVO) {
		return getCs006DbpResMessage(send(ifCs006MobReqVO.getRequest().getHeader().getComInterfaceId(), getCs006DbpReqMessage(ifCs006MobReqVO)));
	}

	private String getCs006DbpReqMessage(IfCs006MobReqVO ifCs006MobReqVO) {
		return csDbpMsgMaker.getCs006DbpReqMessage(ifCs006MobReqVO);
	}

	private IfCs006MobResVO getCs006DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return csDbpMsgReader.getCs006DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfCs007MobResVO requestCs007(IfCs007MobReqVO ifCs007MobReqVO) {
		return getCs007DbpResMessage(send(ifCs007MobReqVO.getRequest().getHeader().getComInterfaceId(), getCs007DbpReqMessage(ifCs007MobReqVO)));
	}

	private String getCs007DbpReqMessage(IfCs007MobReqVO ifCs007MobReqVO) {
		return csDbpMsgMaker.getCs007DbpReqMessage(ifCs007MobReqVO);
	}

	private IfCs007MobResVO getCs007DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return csDbpMsgReader.getCs007DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfCs008MobResVO requestCs008(IfCs008MobReqVO ifCs008MobReqVO) {
		return getCs008DbpResMessage(send(ifCs008MobReqVO.getRequest().getHeader().getComInterfaceId(), getCs008DbpReqMessage(ifCs008MobReqVO)));
	}

	private String getCs008DbpReqMessage(IfCs008MobReqVO ifCs008MobReqVO) {
		return csDbpMsgMaker.getCs008DbpReqMessage(ifCs008MobReqVO);
	}

	private IfCs008MobResVO getCs008DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return csDbpMsgReader.getCs008DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfCs009MobResVO requestCs009(IfCs009MobReqVO ifCs009MobReqVO) {
		return getCs009DbpResMessage(send(ifCs009MobReqVO.getRequest().getHeader().getComInterfaceId(), getCs009DbpReqMessage(ifCs009MobReqVO)));
	}

	private String getCs009DbpReqMessage(IfCs009MobReqVO ifCs009MobReqVO) {
		return csDbpMsgMaker.getCs009DbpReqMessage(ifCs009MobReqVO);
	}

	private IfCs009MobResVO getCs009DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return csDbpMsgReader.getCs009DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfCs010MobResVO requestCs010(IfCs010MobReqVO ifCs010MobReqVO) {
		return getCs010DbpResMessage(send(ifCs010MobReqVO.getRequest().getHeader().getComInterfaceId(), getCs010DbpReqMessage(ifCs010MobReqVO)));
	}

	private String getCs010DbpReqMessage(IfCs010MobReqVO ifCs010MobReqVO) {
		return csDbpMsgMaker.getCs010DbpReqMessage(ifCs010MobReqVO);
	}

	private IfCs010MobResVO getCs010DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return csDbpMsgReader.getCs010DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfCs011MobResVO requestCs011(IfCs011MobReqVO ifCs011MobReqVO) {
		return getCs011DbpResMessage(send(ifCs011MobReqVO.getRequest().getHeader().getComInterfaceId(), getCs011DbpReqMessage(ifCs011MobReqVO)));
	}

	private String getCs011DbpReqMessage(IfCs011MobReqVO ifCs011MobReqVO) {
		return csDbpMsgMaker.getCs011DbpReqMessage(ifCs011MobReqVO);
	}

	private IfCs011MobResVO getCs011DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return csDbpMsgReader.getCs011DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfCs012MobResVO requestCs012(IfCs012MobReqVO ifCs012MobReqVO) {
		return getCs012DbpResMessage(send(ifCs012MobReqVO.getRequest().getHeader().getComInterfaceId(), getCs012DbpReqMessage(ifCs012MobReqVO)));
	}

	private String getCs012DbpReqMessage(IfCs012MobReqVO ifCs012MobReqVO) {
		return csDbpMsgMaker.getCs012DbpReqMessage(ifCs012MobReqVO);
	}

	private IfCs012MobResVO getCs012DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return csDbpMsgReader.getCs012DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfCs013MobResVO requestCs013(IfCs013MobReqVO ifCs013MobReqVO) {
		return getCs013DbpResMessage(send(ifCs013MobReqVO.getRequest().getHeader().getComInterfaceId(), getCs013DbpReqMessage(ifCs013MobReqVO)));
	}

	private String getCs013DbpReqMessage(IfCs013MobReqVO ifCs013MobReqVO) {
		return csDbpMsgMaker.getCs013DbpReqMessage(ifCs013MobReqVO);
	}

	private IfCs013MobResVO getCs013DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return csDbpMsgReader.getCs013DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfCs014MobResVO requestCs014(IfCs014MobReqVO ifCs014MobReqVO) {
		return getCs014DbpResMessage(send(ifCs014MobReqVO.getRequest().getHeader().getComInterfaceId(), getCs014DbpReqMessage(ifCs014MobReqVO)));
	}

	private String getCs014DbpReqMessage(IfCs014MobReqVO ifCs014MobReqVO) {
		return csDbpMsgMaker.getCs014DbpReqMessage(ifCs014MobReqVO);
	}

	private IfCs014MobResVO getCs014DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return csDbpMsgReader.getCs014DbpResMessage(dbpResMessage);
	}
	
	@Override
	public IfCs015MobResVO requestCs015(IfCs015MobReqVO ifCs015MobReqVO) {
		return getCs015DbpResMessage(send(ifCs015MobReqVO.getRequest().getHeader().getComInterfaceId(), getCs015DbpReqMessage(ifCs015MobReqVO)));
	}

	private String getCs015DbpReqMessage(IfCs015MobReqVO ifCs015MobReqVO) {
		return csDbpMsgMaker.getCs015DbpReqMessage(ifCs015MobReqVO);
	}

	private IfCs015MobResVO getCs015DbpResMessage(String dbpResMessage) {
		if (StringUtils.stripToEmpty(dbpResMessage).length() == 0) return null;
		return csDbpMsgReader.getCs015DbpResMessage(dbpResMessage);
	}
	
}