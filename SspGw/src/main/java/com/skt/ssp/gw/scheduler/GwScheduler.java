package com.skt.ssp.gw.scheduler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.configuration.CompositeConfiguration;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * GwScheduler (GwScheduler)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: GwScheduler.java,v 1.0 2011/04/14 00:00:00 SimByungChul Express $
 */
public class GwScheduler extends QuartzJobBean {
	protected final Log logger = LogFactory.getLog(getClass());

	private CompositeConfiguration config = null;

	public void setConfiguration(CompositeConfiguration config) {
		this.config = config;
	}

	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		if (logger.isInfoEnabled()) {
			logger.info("InfoScheduler START");
			logger.info("InfoScheduler END");
		}
	}
}

