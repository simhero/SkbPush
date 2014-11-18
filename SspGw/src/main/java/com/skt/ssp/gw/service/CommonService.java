package com.skt.ssp.gw.service;

import javax.jms.MessageListener;

import org.apache.commons.configuration.CompositeConfiguration;

import com.skt.ssp.gw.common.QueueReceive;
import com.skt.ssp.gw.common.QueueSend;
import com.skt.ssp.gw.vo.IfErrMobResVO;
import com.skt.ssp.gw.vo.IfHeaderDbpReqVO;
import com.skt.ssp.gw.vo.IfHeaderDbpResVO;
import com.skt.ssp.gw.vo.IfHeaderMobReqVO;
import com.skt.ssp.gw.vo.IfHeaderMobResVO;

/**
 * Common Service Interface (CommonService)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: CommonService.java,v 1.0 2011/08/25 00:00:00 SimByungChul Express $
 */
public interface CommonService {
	public CompositeConfiguration getConfiguration();
	public String getServerId();
	public String getServerId(String hostName);
	public String getServerSourceIp();
	public String getServerSourceIp(String hostName);
	public String getServerMode();
	public String getHostName();
	public String getHostAddress();
	public QueueSend getQueueInstance(String queueName);
	public void initQueueReceiveInstance(String queueName, MessageListener messageListener);
	public QueueReceive initAndGetQueueReceiveInstance(String queueName, MessageListener messageListener);
	public boolean isMdn(String mdn);
	public String getDbpReqEndPoint(String interfaceId);
	public String getDbpReqEndPoint(String interfaceId, String hostName);
	public String getMobErrorResponseMsg(String errorCode, String errorMsg);
	public IfErrMobResVO getMobErrorResponseMsg(IfHeaderMobReqVO ifHeaderMobReqVO, String errorCode);
	public IfErrMobResVO getMobErrorResponseMsg(IfHeaderMobReqVO ifHeaderMobReqVO, String errorCode, String errorMsg);
	public IfErrMobResVO validateMobHeaderReq(IfHeaderMobReqVO ifHeaderMobReqVO);
	public IfErrMobResVO validateMobHeaderRes(IfHeaderMobReqVO ifHeaderMobReqVO, IfHeaderMobResVO ifHeaderMobResVO);
	public String getResultMsgOfMobileRes(String errorCode);
	public String getDbpIp();
	public String getDbpIp(String hostName);
	public int getDbpPort();
	public int getDbpPort(String hostName);
	public IfHeaderDbpReqVO setDbpReqHeader(IfHeaderMobReqVO ifHeaderMobReqVO);
	public IfHeaderMobResVO setMobResHeader(IfHeaderDbpResVO ifHeaderDbpResVO);
	public boolean isEmptyOrMaxLengthOver(String val, int maxLeng, String opt);
	public IfErrMobResVO chkAuthInfo(IfHeaderMobReqVO ifHeaderMobReqVO, String adminCode, String userId);
	public String getAuthReqTime(String reqAuthKey);
	public String getLastConnectTime(String reqAuthKey);
	public String getMobilePageCount(String reqDevCd, String resolution);
	public String DSEncode(String strIn);
	public String DSDecode(String strIn);
	public String getGwDateType();
	public String getReqAuthKey(String reqAuthKey);
	public void addResAuthTime(IfHeaderMobReqVO ifHeaderMobReqVO, IfHeaderMobResVO IfHeaderMobResVO);
	public IfErrMobResVO chkDemoInterface(IfHeaderMobReqVO ifHeaderMobReqVO, String adminCode, String userId);
}