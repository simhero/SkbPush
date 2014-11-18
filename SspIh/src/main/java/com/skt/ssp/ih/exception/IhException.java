package com.skt.ssp.ih.exception;

/**
 * Wow Ih Exception (IhException)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IhException.java,v 1.0 2011/10/11 00:00:00 SimByungChul Express $
 */
public class IhException extends Exception {
	private static final long serialVersionUID = 1L;

	public IhException() {
		super();
	}

	public IhException(String message, Throwable cause) {
		super(message, cause);
	}

	public IhException(String message) {
		super(message);
	}

	public IhException(Throwable cause) {
		super(cause);
	}
}
