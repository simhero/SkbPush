package com.skt.ssp.ih.service;

import javax.jms.MessageListener;

import org.apache.commons.configuration.CompositeConfiguration;

import com.skt.ssp.ih.common.QueueReceive;
import com.skt.ssp.ih.common.QueueSend;
import com.skt.ssp.ih.vo.imageConvert.IfIh001BodyUrlResVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh001DataResVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002DataResVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh003BodyUrlReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh003DataReqVO;

/**
 * Common Service Interface (CommonService)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: CommonService.java,v 1.0 2011/10/11 00:00:00 ChoKyuJin Express $
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
	public String getDeviceStr(String type);
	public String getDeviceImgSize(String type);
	public String getFileSeqId(int cnt);
	public String getFileId();
	public String getConversionCode();
	public String getProcThreadCnt();
	public String getProcThreadRow();
	public String getConvertTool();
	public String getSrcDir();
	public String getTempDir();
	public String getDescDir();
	public String getImgUrl();
	public int getDbpPort();
	public String getDbpIp();
	public String getDbpReqEndPoint(String interfaceId);
	public boolean isEmptyOrMaxLengthOver(String val, int maxLeng, String opt);
	public String getConvId();
	public boolean isAllowAccess(String remoteIp);
	public void setErrorResUrlCode(IfIh001BodyUrlResVO resUrlVO, String errorCode);
	public IfIh001DataResVO setIfIh001ResponseVO(String errcode);
	public IfIh001DataResVO setIfIh001ResponseErrorVO(String errcode, String msg);
	public String returnStringIfIh001(IfIh001DataResVO imageConvertResVO);
	public void setErrorResUrlCode(IfIh003BodyUrlReqVO resUrlVO, String errorCode);
	public IfIh002DataResVO setIfIh002ResponseVO(String errcode);
	public IfIh002DataResVO setIfIh002ResponseErrorVO(String errcode, String msg);
	public String returnStringIfIh002(IfIh002DataResVO imageConvertResVO);
	public IfIh003DataReqVO setIfIh003RequestVO(String errcode);
	public String requestStringIfIh003(IfIh003DataReqVO imageConvertResVO);
	public String getGwDateType();
}