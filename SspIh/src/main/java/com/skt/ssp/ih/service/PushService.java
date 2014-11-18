package com.skt.ssp.ih.service;

import org.apache.commons.configuration.CompositeConfiguration;

/**
 * Push Service (PushService)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: PushService.java,v 1.0 2011/10/04 00:00:00 SimByungChul Express $
 */
public interface PushService {
	public CompositeConfiguration getConfiguration();
	public CommonService getCommonService();
}