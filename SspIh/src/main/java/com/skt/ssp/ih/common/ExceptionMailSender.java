package com.skt.ssp.ih.common;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.skt.ssp.ih.util.StringUtil;

/**
 * Exception MailSender (ExceptionMailSender)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: ExceptionMailSender.java,v 1.0 2011/10/15 00:00:00 SimByungChul Express $
 */
public class ExceptionMailSender extends AbstractMessageSender {
	protected final Log logger = LogFactory.getLog(getClass());
	private MessageSourceAccessor msAccessor = null;

	public void setMessageSourceAccessor(MessageSourceAccessor msAccessor) {
		this.msAccessor = msAccessor;
	}

	public void sendMessage(Throwable e) {
		try {
			MimeMessage msg = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg);

			helper.setTo(to);
			helper.setFrom(from);
			helper.setSubject("SSP IH Error Message");

			StringBuffer sb = new StringBuffer();
			sb.append("<html><head></head><body>");
			sb.append("<h1>");
			sb.append(e.getMessage());
			sb.append("</h1><br/>");
			sb.append(StringUtil.stackTraceToString(e));
			sb.append("</body></html>");

			helper.setText(sb.toString());

//			sender.send(msg);

			String[] mailUserList= StringUtils.splitPreserveAllTokens(msAccessor.getMessage("userMmailList"), ";");
			for(String mailuser : mailUserList) {
				helper.setTo(mailuser);
				sender.send(msg);
			}

		}
		catch (MessagingException me) {
			if (logger.isErrorEnabled()) {
				logger.error(msAccessor.getMessage("email.not.send"), me);
				logger.error(msAccessor.getMessage("original.error.message"), e);
				me.printStackTrace();
			}
		}
		catch (Exception ex) {
			if (logger.isErrorEnabled()) {
				logger.error(msAccessor.getMessage("email.not.send"), ex);
				logger.error(msAccessor.getMessage("original.error.message"), e);
				ex.printStackTrace();
			}
		}
	}
}
