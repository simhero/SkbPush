package com.skt.ssp.gw.daemon.worker;

import java.util.HashMap;
import java.util.List;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.skt.ssp.gw.adapter.ApnsMsgSender;
import com.skt.ssp.gw.adapter.C2dmMsgSender;
import com.skt.ssp.gw.daemon.manager.PushManager;
import com.skt.ssp.gw.parse.PushDbpMsgReader;
import com.skt.ssp.gw.service.CommonService;
import com.skt.ssp.gw.service.PushService;
import com.skt.ssp.gw.vo.push.IfPu003ComBodyPushIDReqVO;
import com.skt.ssp.gw.vo.push.IfPu003ComBodyReqVO;
import com.skt.ssp.gw.vo.push.IfPu003ComBodyTransferGroupReqVO;
import com.skt.ssp.gw.vo.push.IfPu003DbpDataReqVO;

/**
 * Push Worker (PushWorker)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: PushWorker.java,v 1.0 2011/09/04 00:00:00 SimByungChul Express $
 */
public class PushWorker extends Thread implements MessageListener{
	protected final Log logger = LogFactory.getLog("PUSH_TRA");
	private PushManager pushManager = null;
	private int pushWorkerNum = 0;
	private PushService pushService = null;
	private CommonService commonService = null;
	private CompositeConfiguration config = null;
	private ApnsMsgSender apnsMsgSender = null;
	private C2dmMsgSender c2dmMsgSender = null;
	private PushDbpMsgReader pushDbpMsgReader = null;
	private ObjectMessage omsg = null;


	public PushWorker(PushManager pushManager, int pushWorkerNum) {
		this.pushManager = pushManager;
		this.pushWorkerNum = pushWorkerNum;
		pushService = this.pushManager.getPushService();
		commonService = pushService.getCommonService();
		config = pushService.getConfiguration();
		apnsMsgSender = pushService.getApnsMsgSender();
		c2dmMsgSender = pushService.getC2dmMsgSender();
		pushDbpMsgReader = pushService.getPushDbpMsgReader();
	}

	public void run() {
		logger.info("PushWorker run() START");
		commonService.initQueueReceiveInstance(config.getString("PUSH_QUEUE"), this);
		logger.info("PushWorker run() END");
	}

	public void onMessage(Message message) {
		logger.info("pushWorkerNum="+pushWorkerNum);
		logger.info("PushWorker onMessage START");
		try {
			while(config.getString("DAEMON.PUSH.PUSH_QUEUE_FLAG").equals("FALSE")) {
				logger.info("[PUSH] Queue Sleep !!!");
				Thread.sleep(config.getInt("DAEMON.PUSH.PUSH_QUEUE_SLEEP_TIME"));
			}
			HashMap<String,String> pushHash;
			if (message instanceof ObjectMessage) {
				omsg = (ObjectMessage)message;
				pushHash = (HashMap<String,String>)omsg.getObject();
				processWorker(pushHash);
			}
			logger.info("PushWorker onMessage END");
		} catch (Exception e) {
			logger.info("PushWorker onMessage(Message message)="+e);
		} finally {
		}

	}

	public void processWorker(HashMap<String,String> pushHashMap) {
		logger.info("pushHashMap="+pushHashMap);
		IfPu003ComBodyReqVO ifPu003ComBodyReqVO = getPu003DbpReqMessage(pushHashMap.get("MSG")).getBody();
		List<IfPu003ComBodyPushIDReqVO> pushIDList = ifPu003ComBodyReqVO.getPushIdList();
		List<IfPu003ComBodyTransferGroupReqVO> transferGroupList = ifPu003ComBodyReqVO.getTransferGroupList();
		String authToken = "";
		// google c2dm 인증 && 인증키 받아옴
		if(pushIDList.size() > 0) { authToken = c2dmMsgSender.authC2dm(); }
		// 메세지 리스트 반복
		for( IfPu003ComBodyTransferGroupReqVO transferGroup : transferGroupList) {
			String pushMsg = transferGroup.getPushMsg();
			// PushId 리스트 반복
			for ( IfPu003ComBodyPushIDReqVO ifPu003ComBodyPushIDReqVO : pushIDList ) {
				String reqDevCd = StringUtils.stripToEmpty(ifPu003ComBodyPushIDReqVO.getReqDevCd());
				String pushId = ifPu003ComBodyPushIDReqVO.getPushId();
				// Push 전송
				if (reqDevCd.equals(config.getString("DAEMON.PUSH.IPHONE_DEVICE"))) {
					sendApns("iPhone", pushId, pushMsg);
				} else if (reqDevCd.equals(config.getString("DAEMON.PUSH.ANDROID_DEVICE"))) {
					sendC2dm(pushId, pushMsg, authToken);
				}
			}
		}
	}

	private IfPu003DbpDataReqVO getPu003DbpReqMessage(String msg) {
		return pushDbpMsgReader.getPu003DbpReqMessage(msg);
	}

	private void sendApns(String deviceKind, String deviceToken, String pushMsg) {
		apnsMsgSender.sendApns(deviceKind, deviceToken, pushMsg);
	}

	private void sendC2dm(String deviceToken, String pushMsg, String authToken) {
		c2dmMsgSender.sendC2dm(deviceToken, pushMsg, authToken);
	}





}