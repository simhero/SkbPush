package com.skt.ssp.gw.web.controller;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skt.ssp.gw.service.CreateTableService;
import com.skt.ssp.gw.vo.AuthVO;
import com.thoughtworks.xstream.XStream;

/**
 * MMDBTestController (MMDBTestController)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: MMDBTestController.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Controller
public class MMDBTestController {

	Logger logger = Logger.getLogger(getClass());
	
	static int no = 0;
	
	@Autowired
	private CreateTableService createTableService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/test.do")
	public void test(
			HttpServletRequest req,
			HttpServletResponse resp) throws Exception {

		PrintWriter pw = null;
		
		try {
			
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("application/xml;utf-8");
			
			logger.debug("*** HEADER ***");
			Enumeration e = req.getHeaderNames();
			while(e.hasMoreElements()) {
				String header = (String)e.nextElement();
				logger.debug(header + " / " + req.getHeader(header));
			}
			
			logger.debug("\n");
			
			pw = resp.getWriter();
			
			ServletInputStream is = req.getInputStream();
			
			StringBuffer sb = new StringBuffer();
			
			byte[] b = new byte[1024];
			
			while( is.read(b) > -1 ) {
				sb.append(new String(b, "UTF-8"));
			}
			
			logger.debug("REQ BODY STR	: " + sb.toString() + "\n");
			/*
			JSONObject jsonStr = null;
			String streetName = "";
			String city = "";
			try {
				
				jsonStr = JSONObject.fromObject(sb.toString());
				streetName = jsonStr.getString("PAGE_START");
				city = jsonStr.getString("PAGE_END");
				
				logger.debug("PAGE_START		: " + streetName);
				logger.debug("PAGE_END			: " + city + "\n");
				
			} catch (Exception e1) {
				
				logger.error(e1);
				pw.println("{\"RESULT_CD\":\"20\"}");
				return;
			}
			*/
			Map map = new HashMap();
			
			List list = createTableService.selectTest(map);
			
//			Map<String, Object> result = new HashMap<String, Object>();
//			result.put("RESULT_CD", "10");
//			result.put("ITEM", list);
//			
//			JSONObject pRslt = JSONObject.fromObject(result); 
//			
//			pw.println(pRslt);
			
			pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			pw.println("<info>");
			pw.println("<count>"+list.size()+"</count>");
			
			XStream xstream = new XStream();
			xstream.alias("authUser", AuthVO.class);
			xstream.toXML(list, pw);
			
			pw.println("</info>");
			
		} finally {
			
			try {
				
				if(pw != null) { pw.flush(); pw.close(); }
				
			} catch (Exception e) {
			
				logger.error(e);
				
			}
			
		}
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/test12.do")
	public void test12(
			HttpServletRequest req,
			HttpServletResponse resp) throws Exception {

		PrintWriter pw = null;
		
		try {
			
			resp.setCharacterEncoding("UTF-8");
		
			pw = resp.getWriter();
			
			ServletInputStream is = req.getInputStream();
			
			StringBuffer sb = new StringBuffer();
			
			byte[] b = new byte[1024];
			
			while( is.read(b) > -1 ) {
				sb.append(new String(b, "UTF-8"));
			}
			
			logger.debug("REQ BODY STR	: " + sb.toString() + "\n");
			/*
			JSONObject jsonStr = null;
			String streetName = "";
			String city = "";
			try {
				
				jsonStr = JSONObject.fromObject(sb.toString());
				streetName = jsonStr.getString("STREET_NAME");
				city = jsonStr.getString("CITY");
				
				logger.debug("streetName	: " + streetName);
				logger.debug("city			: " + city + "\n");
				
			} catch (Exception e) {
				
				logger.error(e);
				pw.println("{\"RESULT_CD\":\"20\"}");
				return;
			}
						
			Map map = new HashMap();
			map.put("streetName", streetName);
			map.put("city", city);
			*/
			Map map = new HashMap();
			map.put("USER_ID", "USER_ID_"+(no++));
			map.put("ADMIN_ID", "CURRENT_TIMESTAMP");
			map.put("LOGIN_ID", "LOGIN_ID");
			map.put("AUTH_KEY", "AUTH_KEY");
			map.put("AUTH_HEADER", "AUTH_HEADER");
			map.put("AUTH_BODY", "AUTH_BODY");
			map.put("PUSH_NOTI_ID", "PUSH_NOTI_ID");
			map.put("REGISTER_ID", "REGISTER_ID");
			map.put("UPDATE_ID", "UPDATE_ID");
			
			createTableService.insertTest(map);
			
			pw.println("{\"RESULT_CD\":\"10\"}");
		
		} catch (Exception e) {
			
			logger.error(e);
			throw new ServletException(e);
			
		} finally {
			
			try {
				
				if(pw != null) { pw.flush(); pw.close(); }
				
			} catch (Exception e) {
			
				logger.error(e);
				
			}
			
		}
		
	}
	
}
