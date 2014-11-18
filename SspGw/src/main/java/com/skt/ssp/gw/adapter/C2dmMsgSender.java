package com.skt.ssp.gw.adapter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;

/**
 * C2dmMsgSender (C2dmMsgSender)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: C2dmMsgSender.java,v1.0 2011/10/15 00:00:00 ChoKyuJin Express $
 */
@Component
public class C2dmMsgSender {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public C2dmMsgSender() {
	}
	
	public String authC2dm() {
		HttpClient client = new HttpClient();
		client.getHostConfiguration().setHost(config.getString("DAEMON.C2DM.AUTH_URL"), config.getInt("DAEMON.C2DM.AUTH_PORT"), config.getString("DAEMON.C2DM.AUTH_PROTOCOL"));
		client.getHttpConnectionManager().getParams().setConnectionTimeout(1000 * 10);
		client.getHttpConnectionManager().getParams().setSoTimeout(1000 * 10);
		PostMethod post = null;
		String authToken = "";
		try {
			StringBuffer postDataBuilder = new StringBuffer();
			postDataBuilder.append("accountType=" + config.getString("DAEMON.C2DM.ACCOUNT_TYPE"));
			postDataBuilder.append("&Email=" + config.getString("DAEMON.C2DM.AUTH_ID"));
			postDataBuilder.append("&Passwd=" + config.getString("DAEMON.C2DM.AUTH_PW"));
			postDataBuilder.append("&service=" + config.getString("DAEMON.C2DM.SERVICE"));
			postDataBuilder.append("&source=" + config.getString("DAEMON.C2DM.SOURCE"));
			byte[] postData = postDataBuilder.toString().getBytes("UTF8");
			
			post = new PostMethod(config.getString("DAEMON.C2DM.AUTH_METHOD"));
			post.setRequestHeader("Content-Type", config.getString("DAEMON.C2DM.AUTH_CONTENT_TYPE"));
			post.setRequestHeader("Content-Length", Integer.toString(postData.length));
			post.setRequestBody(new ByteArrayInputStream(postData));
			if (logger.isInfoEnabled()) {
				logger.info("#########  C2DM Auth Before Sent #########");
				logger.debug("getHostUrl = " + client.getHostConfiguration().getHostURL());
				logger.debug("getPath = " + post.getPath());
				logger.info("getRequestHeader = " + post.getRequestHeaders());
			}
			int httpRes = client.executeMethod(post);
			if (logger.isInfoEnabled()) {
				logger.info("#########  C2DM Auth After Sent ##########");
				logger.info("#########  C2DM Auth Before Receive ######");
			}
			if (httpRes == HttpStatus.SC_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(post.getResponseBodyAsStream()));
				String sidLine = br.readLine();
				String lsidLine = br.readLine();
				String authLine = br.readLine();
				logger.info("sidLine = " + sidLine);
				logger.info("lsidLine = " + lsidLine);
				logger.info("authLine = " + authLine);
				authToken = authLine.substring(5, authLine.length());
				logger.info("authToken = " + authToken);
			} else {
				logger.info("httpRes = " + httpRes);
			}
			if (logger.isInfoEnabled()) {
				logger.info("#########  C2DM Auth After Receive #######");
			}
		} catch (Exception ex) {
			logger.info("Exception = " + ex);
			ex.printStackTrace();
		} finally {
			post.releaseConnection();
		}
		
		return authToken;
	}

	public void sendC2dm(String deviceToken, String alertMessage, String authToken) {
		HttpClient client = new HttpClient();
		client.getHostConfiguration().setHost(config.getString("DAEMON.C2DM.SEND_URL"), config.getInt("DAEMON.C2DM.SEND_PORT"), config.getString("DAEMON.C2DM.SEND_PROTOCOL"));
		client.getHttpConnectionManager().getParams().setConnectionTimeout(1000 * 10);
		client.getHttpConnectionManager().getParams().setSoTimeout(1000 * 10);
		PostMethod post = null;
		String c2dmData = "";
		try {
			StringBuffer postDataBuilder = new StringBuffer();
			postDataBuilder.append("registration_id=" + deviceToken);
			postDataBuilder.append("&collapse_key=" + config.getString("DAEMON.C2DM.COLLAPSE_KEY").hashCode());
			postDataBuilder.append("&delay_while_idle=" + config.getString("DAEMON.C2DM.DELAY_WHILE_IDLE"));
			postDataBuilder.append("&data.msg=" + URLEncoder.encode(alertMessage, "UTF-8"));
			byte[] postData = postDataBuilder.toString().getBytes("UTF8");
			
			post = new PostMethod(config.getString("DAEMON.C2DM.SEND_METHOD"));
			post.setRequestHeader("Content-Type", config.getString("DAEMON.C2DM.SEND_CONTENT_TYPE"));
			post.setRequestHeader("Content-Length", Integer.toString(postData.length));
			post.setRequestHeader("Authorization", "GoogleLogin auth=" + authToken);
			post.setRequestBody(new ByteArrayInputStream(postData));
			if (logger.isInfoEnabled()) {
				logger.info("#########  C2DM Send Before Sent #########");
				logger.debug("getHostUrl = " + client.getHostConfiguration().getHostURL());
				logger.debug("getPath = " + post.getPath());
				logger.info("getRequestHeader = " + post.getRequestHeaders());
				logger.info("msg = " + alertMessage);
			}
			int httpRes = client.executeMethod(post);
			if (logger.isInfoEnabled()) {
				logger.info("#########  C2DM Send After Sent ##########");
				logger.info("#########  C2DM Send Before Receive ######");
			}
			if (httpRes == HttpStatus.SC_OK) {
				c2dmData = new String(post.getResponseBody(), "UTF-8");
				logger.info("c2dmData = " + c2dmData);
			} else {
				logger.info("httpRes = " + httpRes);
			}
			if (logger.isInfoEnabled()) {
				logger.info("#########  C2DM Send After Receive #######");
			}
		} catch (Exception ex) {
			logger.info("Exception = " + ex);
			ex.printStackTrace();
		} finally {
			post.releaseConnection();
		}
	}

}