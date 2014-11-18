package com.skt.ssp.ih.common;

import org.springframework.mail.javamail.JavaMailSender;

/**
 * Abstract MessageSender(AbstractMessageSender)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: AbstractMessageSender.java,v 1.0 2011/10/11 00:00:00 SimByungChul Express $
 */
public abstract class AbstractMessageSender {
	protected String to;
	protected String from;
	protected String subject;
	protected String text;
	protected JavaMailSender sender;

	public void setFrom(String from) {
		this.from = from;
	}

	public void setSender(JavaMailSender sender) {
		this.sender = sender;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setText(String text) {
		this.text = text;
	}
}
