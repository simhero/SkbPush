package com.skt.ssp.gw.service;

import org.apache.commons.configuration.CompositeConfiguration;

import com.skt.ssp.gw.adapter.ApnsMsgSender;
import com.skt.ssp.gw.adapter.C2dmMsgSender;
import com.skt.ssp.gw.parse.PushDbpMsgReader;
import com.skt.ssp.gw.vo.push.IfPu001MobReqVO;
import com.skt.ssp.gw.vo.push.IfPu001MobResVO;
import com.skt.ssp.gw.vo.push.IfPu002MobReqVO;
import com.skt.ssp.gw.vo.push.IfPu002MobResVO;
import com.skt.ssp.gw.vo.push.IfPu004MobReqVO;
import com.skt.ssp.gw.vo.push.IfPu004MobResVO;

/**
 * Push Service (PushService)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: PushService.java,v 1.0 2011/09/04 00:00:00 ChoKyuJin Express $
 */
public interface PushService {
	public CompositeConfiguration getConfiguration();
	public CommonService getCommonService();
	public void jmsPush();
	public IfPu001MobResVO requestPush001(IfPu001MobReqVO ifPu001MobReqVO);
	public IfPu002MobResVO requestPush002(IfPu002MobReqVO ifPu002MobReqVO);
	public String requestPush003(String bodyStr) throws Exception;
	public String getPush003ErrorResponseMsg(String errMsg);
	public IfPu004MobResVO requestPush004(IfPu004MobReqVO ifPu004MobReqVO);
	public ApnsMsgSender getApnsMsgSender();
	public C2dmMsgSender getC2dmMsgSender();
	public PushDbpMsgReader getPushDbpMsgReader();
}