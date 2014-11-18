package com.skt.ssp.gw.exception;

/**
 * Wow Gw Exception (GwException)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: GwException.java,v 1.0 2011/08/11 00:00:00 SimByungChul Express $
 */
public class GwException extends Exception {
	private static final long serialVersionUID = 1L;

	public GwException() {
		super();
	}

	public GwException(String message, Throwable cause) {
		super(message, cause);
	}

	public GwException(String message) {
		super(message);
	}

	public GwException(Throwable cause) {
		super(cause);
	}
}
