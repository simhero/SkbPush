package com.skt.ssp.ih.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;

import com.skt.ssp.ih.common.ExceptionMailSender;

/**
 * ExceptionNotification Aspect  (ExceptionNotificationAspect)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: ExceptionNotificationAspect.java,v 1.0 2011/10/10 00:00:00 SimByungChul Express $
 */
public class ExceptionNotificationAspect {
	protected final Log logger = LogFactory.getLog(getClass());
	private ExceptionMailSender mailSender;

	public ExceptionNotificationAspect() {
	}

	public void setMailSender(ExceptionMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void exceptionNotiAdvice(DataAccessException Ex) {
		if (logger.isDebugEnabled()) {
			logger.info("com.skt.ssp.ih.aspect.ExceptionNotificationAspect.DataAccessException() ");
			logger.info("Ex= "+ Ex.getMessage());
			logger.info("Caught : " + Ex.getClass().getName());
		}
		mailSender.sendMessage(Ex);
		if (logger.isDebugEnabled()) {
			logger.info("com.skt.ssp.ih.aspect.ExceptionNotificationAspect.DataAccessException() ");
		}
	}
}

