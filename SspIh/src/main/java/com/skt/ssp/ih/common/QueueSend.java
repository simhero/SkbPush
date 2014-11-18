package com.skt.ssp.ih.common;

import java.io.Serializable;
import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/** This example shows how to establish a connection
 * and send messages to the JMS queue. The classes in this
 * package operate on the same JMS queue. Run the classes together to
 * witness messages being sent and received, and to browse the queue
 * for messages. The class is used to send messages to the queue.
 *
 * @author Copyright (c) 1999-2006 by BEA Systems, Inc. All Rights Reserved.
 */
public class QueueSend {
	private QueueConnectionFactory qconFactory;
	private QueueConnection qcon;
	private QueueSession qsession;
	private QueueSender qsender;
	private Queue queue;
	private TextMessage msg;
	private ObjectMessage omsg;

	/**
	 * Creates all the necessary objects for sending
	 * messages to a JMS queue.
	 *
	 * @param ctx JNDI initial context
	 * @param queueName name of queue
	 * @exception NamingException if operation cannot be performed
	 * @exception JMSException if JMS fails to initialize due to internal error
	 */
	public void init(String contextFacotryName, String url, String factoryName, String queueName) throws NamingException, JMSException {
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, contextFacotryName);
		env.put(Context.PROVIDER_URL, url);
		Context ctx = new InitialContext(env);
		qconFactory = (QueueConnectionFactory) ctx.lookup(factoryName);
		qcon = qconFactory.createQueueConnection();
		qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		queue = (Queue) ctx.lookup(queueName);
		qsender = qsession.createSender(queue);
		msg = qsession.createTextMessage();
		omsg = qsession.createObjectMessage();
		qcon.start();
	}

	/**
	 * Sends a message to a JMS queue.
	 *
	 * @param messagemessage to be sent
	 * @exception JMSException if JMS fails to send message due to internal error
	 */
	public synchronized void send(String message) throws JMSException {
		msg.setText(message);
		qsender.send(msg);
	}

	/**
	 * Sends a message to a JMS queue.
	 *
	 * @param messagemessage to be sent
	 * @exception JMSException if JMS fails to send message due to internal error
	 */
	public synchronized void send(Object message) throws Exception {
		omsg.setObject((Serializable) message);
		qsender.send(omsg);
	}

	/**
	 * Closes JMS objects.
	 * @exception JMSException if JMS fails to close objects due to internal error
	 */
	public void close() throws JMSException {
		qsender.close();
		qsession.close();
		qcon.close();
	}

	 /** main() method.
	*
	* @param args WebLogic Server URL
	* @exception Exception if operation fails
	*/
	public static void main(String[] args) throws Exception {
	}
}
