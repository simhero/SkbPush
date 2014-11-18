package com.skt.ssp.gw.exception;

import org.springframework.core.ErrorCoded;

/**
 * Menu Search Exception (MenuNotFoundException)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: MenuNotFoundException.java,v 1.0 2011/08/31 00:00:00 SimByungChul Express $
 */
public class MenuNotFoundException extends Exception implements ErrorCoded {

	public MenuNotFoundException() {
		super();
	}

	public MenuNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public MenuNotFoundException(String message) {
		super(message);
	}

	public MenuNotFoundException(Throwable cause) {
		super(cause);
	}

	public String getErrorCode() {
		return "menu.notfound.exception";
	}
}