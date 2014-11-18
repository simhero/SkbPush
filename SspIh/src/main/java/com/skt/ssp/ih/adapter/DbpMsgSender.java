package com.skt.ssp.ih.adapter;

import java.io.ByteArrayInputStream;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.ih.service.CommonService;

/**
 * DbpMsgSender (DbpMsgSender)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: DbpMsgSender.java,v1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Component
public class DbpMsgSender {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public DbpMsgSender() {
	}

	public String send(String interfaceId, String msg) {
		HttpClient client = new HttpClient();
		client.getHostConfiguration().setHost( commonService.getDbpIp(), commonService.getDbpPort(), config.getString("DBP.DBPREQ_PROTOCOL"));
		client.getHttpConnectionManager().getParams().setConnectionTimeout(config.getInt("DBP.DBPREQ_TIMEOUT"));
		client.getHttpConnectionManager().getParams().setSoTimeout(config.getInt("DBP.DBPREQ_TIMEOUT"));
		String contentType = config.getString("DBP.DBPREQ_CONTENT_TYPE");
		PostMethod post = null;
		String dbpResData = "";
		try {
			String methodStr = commonService.getDbpReqEndPoint(interfaceId);
			post = new PostMethod( methodStr );
			post.setRequestHeader("Content-Type", contentType);
			post.setRequestBody( new ByteArrayInputStream(msg.getBytes()) );
			if (logger.isInfoEnabled()) {
				logger.info( "#########  DBP Before Sent #########"  );
				logger.info( "getHostUrl = " + client.getHostConfiguration().getHostURL() );
				logger.info( "getPath = " + methodStr );
				logger.info( "getRequestHeader = " + post.getRequestHeaders() );
				logger.info( "msg = " + msg );
			}
			int httpRes = client.executeMethod(post);
			if (logger.isInfoEnabled()) {
				logger.info( "#########  DBP After Sent ##########"  );
				logger.info( "#########  DBP Before Receive ######"  );
			}
			if (httpRes == HttpStatus.SC_OK) {
				dbpResData = new String(post.getResponseBody(), "UTF-8");
				logger.info( "dbpResData = " + dbpResData );
			} else {
				logger.info( "httpRes = " + httpRes );
			}
			if (logger.isInfoEnabled()) {
				logger.info( "#########  DBP After Receive #######"  );
			}
		} catch (Exception ex) {
			logger.info( "Exception = " + ex );
			ex.printStackTrace();
		} finally {
			if(post != null) post.releaseConnection();
		}
		return dbpResData;
	}

}