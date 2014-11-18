package com.skt.ssp.ih.simulator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * SimulIhServlet (SimulIhServlet)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: SimulIhServlet.java,v 1.0 2011/10/11 00:00:00 SimByungChul Express $
 */
public class SimulIhServlet extends HttpServlet {
	protected final Log logger = LogFactory.getLog(getClass());

	public void init(ServletConfig servletConfig) throws ServletException {
		super.init(servletConfig);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
	    res.setContentType("text/html");
	    PrintWriter out = res.getWriter();
	    String rtnXmlData = (new StringBuffer()
		.append("<?xml version=\"1.0\" encoding=\"euc-kr\" ?>\r\n")
		.append("<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n")
		.append("<env:Header>\r\n")
		.append("<mm7:TransactionID xmlns:mm7=\"http://www.3gpp.org/ftp/Specs/archive/23_series/23.140/schema/REL-5-MM7-1-0\" env:mustUnderstand=\"1\">I_r28992897</mm7:TransactionID>\r\n")
		.append("</env:Header>\r\n")
		.append("<env:Body>\r\n")
		.append("<mm7:DeliverRsp xmlns:mm7=\"http://www.3gpp.org/ftp/Specs/archive/23_series/23.140/schema/REL-5-MM7-1-0\">\r\n")
		.append("<MM7Version>5.3.0</MM7Version>\r\n")
		.append("<ServiceCode>0</ServiceCode>\r\n")
		.append("<Status>\r\n")
		.append("<StatusCode>1000</StatusCode>\r\n")
		.append("<StatusText>Delivered</StatusText>\r\n")
		.append("<Detail></Detail>\r\n")
		.append("</Status>\r\n")
		.append("</mm7:DeliverRsp>\r\n")
		.append("</env:Body>\r\n")
		.append("</env:Envelope>\r\n").toString());
	    out.println(rtnXmlData);
	}

}