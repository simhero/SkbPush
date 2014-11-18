package com.skt.ssp.gw.daemon;

import java.util.Date;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skt.ssp.gw.daemon.manager.PushManager;
import com.skt.ssp.gw.daemon.worker.ShutdownWorker;
import com.skt.ssp.gw.service.PushService;

/**
 * Push Daemon Server (PushDaemon)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: PushDaemon.java,v 1.0 2011/09/04 00:00:00 SimByungChul Express $
 */
public class PushDaemon {
	protected final Log logger = LogFactory.getLog("PUSH_DAEMON_TRA");
	private static PushDaemon instance = null;
	private CompositeConfiguration config = null;
	private ApplicationContext context;
	private static PushService pushService = null;

	public PushDaemon() {
		if (logger.isInfoEnabled()) {
			logger.info("######### Initializing Push Daemon  #######################");
		}
		try {
			initialize();
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("######### PushDaemon() Exception : " + e);
			}
		}
	}

	private static PushDaemon getInstance() {
		if (instance == null) instance = new PushDaemon();
		return instance;
	}

	public static void main(String[] args) {
		PushDaemon.getInstance();
	}

	private void initialize() throws Exception {
		try {
			if (logger.isInfoEnabled()) {
				logger.info("######### Start PUSH Daemon #################################");
			}
			String[] paths = { "applicationContext.xml" };
			context = new ClassPathXmlApplicationContext(paths);
			pushService = (PushService) context.getBean("pushService");
			config = pushService.getConfiguration();
			Runtime.getRuntime().addShutdownHook(createShutdownWorker(config, "PUSH DAEMON"));
			startDaemon();
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("######### initialize() Exception : " + e);
			}
		}
	}

	private void startDaemon() {
		try {
			int currDate = Integer.parseInt(DateFormatUtils.format(new Date(), "yyyyMMdd"));
			int currTime = Integer.parseInt(DateFormatUtils.format(new Date(), "HHmmss"));
			if (config.getString("DAEMON.PUSH.ALIVE_FLAG").equals("Y") && config.getInt("DAEMON.PUSH.START_DATE") <= currDate
					&& config.getInt("DAEMON.PUSH.END_DATE") >= currDate && config.getInt("DAEMON.PUSH.START_TIME") <= currTime
					&& config.getInt("DAEMON.PUSH.END_TIME") >= currTime) {
				logger.info("DAEMON.PUSH.END_DATE=" + config.getInt("DAEMON.PUSH.END_DATE"));
				PushManager pushManager = new PushManager(pushService);
				pushManager.start();
				Thread.sleep(config.getInt("DAEMON.PUSH.DAEMON_SLEEP_TIME"));
			}
			Thread.sleep(config.getInt("DAEMON.FINISH_SLEEP_TIME"));
			for(int i=0; i< 100; i++) {
				Thread.sleep(1000000000);
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("######### PushDaemon Exception : " + e);
			}
			try {
				Thread.sleep(config.getInt("DAEMON.FINISH_SLEEP_TIME"));
			} catch (Exception ex) {

			}
		}
	}

	private ShutdownWorker createShutdownWorker(CompositeConfiguration config, String daemonName) {
		return ShutdownWorker.create(config, daemonName);
	}

}