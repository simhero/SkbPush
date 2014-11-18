package com.skt.ssp.ih.daemon.manager;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.skt.ssp.ih.daemon.worker.PushWorker;
import com.skt.ssp.ih.service.PushService;

/**
 * PushManager (PushManager)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: PushManager,v 1.0 2011/10/04 00:00:00 SimByungChul Express $
 */
public class PushManager extends Thread {
	protected final Log logger = LogFactory.getLog("PUSH_DAEMON_TRA");
	private PushService pushService = null;
	private CompositeConfiguration config = null;

	public PushManager(PushService pushService) {
		this.pushService = pushService;
		config = pushService.getConfiguration();
	}

	public void run() {
		logger.info("PushManager run() START");
		startWorker();
		logger.info("PushManager run() END");
	}

	public void startWorker() {
		for (int i = 0; i < config.getInt("DAEMON.PUSH.PUSH_WORKER_COUNT"); i++) {
			PushWorker pushWorker = new PushWorker(this,i);
			pushWorker.start();
		}
	}

	public PushService getPushService() {
		return pushService;
	}

}
