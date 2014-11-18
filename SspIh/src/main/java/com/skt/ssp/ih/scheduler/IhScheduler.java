package com.skt.ssp.ih.scheduler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.configuration.CompositeConfiguration;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * IhScheduler (IhScheduler)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IhScheduler.java,v 1.0 2011/10/14 00:00:00 SimByungChul Express $
 */
public class IhScheduler extends QuartzJobBean {
	protected final Log logger = LogFactory.getLog(getClass());

	private CompositeConfiguration config = null;

	public void setConfiguration(CompositeConfiguration config) {
		this.config = config;
	}

	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		if (logger.isInfoEnabled()) {
//			logger.info("IhScheduler START");
//			logger.info("IhScheduler END");
		}
	}
}

