package com.skt.ssp.ih.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;

/**
 * Logging Aspect (LoggingAspect)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: LoggingAspect.java,v 1.0 2011/10/10 00:00:00 SimByungChul Express $
 */
public class LoggingAspect {
	protected final Log logger = LogFactory.getLog(getClass());

	public void logMethodEntry(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		String name = joinPoint.getSignature().toLongString();
		StringBuffer sb = new StringBuffer(name + " called with: [");
		for (int i = 0; i < args.length; i++) {
			Object o = args[i];
			sb.append(o);
			sb.append((i == args.length - 1) ? "]" : ", ");
		}
		if (logger.isDebugEnabled()) {
			logger.info(sb);
		}
	}

	public void logMethodExit(StaticPart staticPart, Object result) {
		String name = staticPart.getSignature().toLongString();
		if (logger.isDebugEnabled()) {
			logger.info(name + " returning: [" + result + "]");
		}
	}
}
