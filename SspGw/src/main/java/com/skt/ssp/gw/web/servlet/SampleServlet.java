package com.skt.ssp.gw.web.servlet;

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
 * SampleServlet (SampleServlet)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: SampleServlet.java,v 1.0 2011/08/31 00:00:00 SimByungChul Express $
 */
public class SampleServlet extends HttpServlet {
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
	    String testData = "";
	    out.println(testData);
	}

}