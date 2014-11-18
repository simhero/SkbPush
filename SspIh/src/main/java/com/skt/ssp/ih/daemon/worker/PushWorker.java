package com.skt.ssp.ih.daemon.worker;

import java.util.Date;
import java.util.HashMap;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.skt.ssp.ih.daemon.manager.PushManager;
import com.skt.ssp.ih.service.CommonService;
import com.skt.ssp.ih.service.PushService;

/**
 * Push Worker (PushWorker)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: PushWorker.java,v 1.0 2011/10/04 00:00:00 SimByungChul Express $
 */
public class PushWorker extends Thread implements MessageListener{
	protected final Log logger = LogFactory.getLog("PUSH_TRA");
	private PushManager pushManager = null;
	private int pushWorkerNum = 0;
	private PushService pushService = null;
	private CommonService commonService = null;
	private CompositeConfiguration config = null;
	private ObjectMessage omsg = null;

	public PushWorker(PushManager pushManager, int pushWorkerNum) {
		this.pushManager = pushManager;
		this.pushWorkerNum = pushWorkerNum;
		pushService = this.pushManager.getPushService();
		commonService = pushService.getCommonService();
		config = pushService.getConfiguration();
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
			HashMap<String,String> msgHash;
			if (message instanceof ObjectMessage) {
				omsg = (ObjectMessage)message;
				msgHash = (HashMap<String,String>)omsg.getObject();
				processWorker(msgHash);
			}
			logger.info("PushWorker onMessage END");
		} catch (Exception e) {
			logger.info("PushWorker onMessage(Message message)="+e);
		} finally {
		}

	}

	public void processWorker(HashMap<String,String> msgHash) {
	}


}