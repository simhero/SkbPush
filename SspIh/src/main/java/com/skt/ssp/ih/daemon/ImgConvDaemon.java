package com.skt.ssp.ih.daemon;

import java.util.Date;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skt.ssp.ih.daemon.manager.ImgConvManager;
import com.skt.ssp.ih.daemon.worker.ShutdownWorker;
import com.skt.ssp.ih.service.ImageConvProcService;

/**
 * Image Conversion Daemon Server (ImgConvDaemon)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: ImgConvDaemon.java,v 1.0 2011/10/04 00:00:00 ChoKyuJin Express $
 */
public class ImgConvDaemon {
	protected final Log logger = LogFactory.getLog("IH_TRA");
	private static ImgConvDaemon instance = null;
	private CompositeConfiguration config = null;
	private ApplicationContext context;
	private static ImageConvProcService imageConvProcService = null;

	public ImgConvDaemon() {
		if (logger.isInfoEnabled()) {
			logger.info("######### Initializing Push Daemon  #######################");
		}
		try {
			initialize();
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("######### ImgConvDaemon() Exception : " + e);
			}
		}
	}

	private static ImgConvDaemon getInstance() {
		if (instance == null) instance = new ImgConvDaemon();
		return instance;
	}

	public static void main(String[] args) {
		ImgConvDaemon.getInstance();
	}

	private void initialize() throws Exception {
		try {
			if (logger.isInfoEnabled()) {
				logger.info("######### Start Image Conversion Daemon #################################");
			}
			String[] paths = { "applicationContext.xml" };
			context = new ClassPathXmlApplicationContext(paths);
			imageConvProcService = (ImageConvProcService) context.getBean("imageConvProcService");
			config = imageConvProcService.getConfiguration();
			Runtime.getRuntime().addShutdownHook(createShutdownWorker(config, "IMG CONV DAEMON"));
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
				ImgConvManager imgConvManager = new ImgConvManager(imageConvProcService);
				imgConvManager.start();
				Thread.sleep(config.getInt("DAEMON.PUSH.DAEMON_SLEEP_TIME"));
			}
			Thread.sleep(config.getInt("DAEMON.FINISH_SLEEP_TIME"));
			for(int i=0; i< 100; i++) {
				Thread.sleep(1000000000);
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("######### ImageConversionException : " + e);
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