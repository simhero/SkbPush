package com.skt.ssp.gw.common;

import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * QueueReceive(QueueReceive)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: QueueReceive.java,v 1.0 2011/08/13 00:00:00 SimByungChul Express $
 */
public class QueueReceive {
	private QueueConnectionFactory qconFactory = null;
	private QueueSession qsession = null;
	private QueueConnection qcon = null;
	private Queue queue = null;
	private QueueReceiver qreceiver = null;

	public void init(String contextFacotryName, String url, String factoryName, String queueName, MessageListener messageListener) throws JMSException, NamingException {
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, contextFacotryName);
		env.put(Context.PROVIDER_URL, url);
		InitialContext ctx = new InitialContext(env);
		qconFactory = (QueueConnectionFactory) ctx.lookup(factoryName);
		qcon = qconFactory.createQueueConnection();
		qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		queue = (Queue) ctx.lookup(queueName);
		qreceiver = qsession.createReceiver(queue);
		qreceiver.setMessageListener(messageListener);
		qcon.start();
	}

	public void close()throws JMSException {
		qreceiver.close();
		qsession.close();
		qcon.close();
	}

	public static void main(String[] args) throws Exception {
	}
}