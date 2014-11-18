package com.skt.ssp.gw.daemon.worker;

import java.util.List;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ShutdownWorker (ShutdownWorker)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: ShutdownWorker.java,v1.0 2011/09/04 00:00:00 SimByungChul Express $
 */
public class ShutdownWorker extends Thread {
	protected final Log logger = LogFactory.getLog(getClass());
	private CompositeConfiguration config = null;

	private ShutdownWorker(CompositeConfiguration config, String daemonName) {
		this.config = config;
	}

	public void run() {
		try {
			if (logger.isInfoEnabled()) {
				logger.info("######### Start ShutdownWorker #############################");
			}
			shutdownJob();
			if (logger.isInfoEnabled()) {
				logger.info("######### End ShutdownWorker ###############################");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void shutdownJob() {
		try {
			List manager = config.getList("MANAGER_MDN");
/*			List<String> manager = config.getList("MANAGER_MDN");
			for (String mdn : manager) {
				if (logger.isInfoEnabled()) {
					logger.info("######### manager= " + mdn );
				}
			}*/
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public static ShutdownWorker create(CompositeConfiguration config, String daemonName) {
		return new ShutdownWorker(config, daemonName);
	}
}