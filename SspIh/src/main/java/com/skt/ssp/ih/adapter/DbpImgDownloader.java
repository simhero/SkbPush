package com.skt.ssp.ih.adapter;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;


/**
 * DbpImgDownloader (DbpImgDownloader)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: DbpImgDownloader.java,v1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Component
public class DbpImgDownloader {
	protected final Log logger = LogFactory.getLog(getClass());

	public DbpImgDownloader() { }

	public boolean download(String url, String saveFile) {
		logger.debug("DOWNLOAD ST TIME="+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
		HttpClient client = null;
		GetMethod method = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		boolean retVal = true;
		try {
			client = new HttpClient();
			method = new GetMethod(url);
			method.setFollowRedirects(true);
			// Execute the GET method
			int statusCode = client.executeMethod(method);
			if (statusCode == 404 || statusCode == 500) {
				retVal = false;
			} else if (statusCode == 200) {
				logger.debug("Reading file="+saveFile);
				bis = new BufferedInputStream(method.getResponseBodyAsStream());
				fos = new FileOutputStream(saveFile);

				byte[] bytes = new byte[8192];
				int count = bis.read(bytes);

				while (count != -1 && count <= 8192) {
					fos.write(bytes, 0, count);
					count = bis.read(bytes);
					Thread.sleep(50);
				}

				if (count != -1) {
					fos.write(bytes, 0, count);
				}

				logger.debug("Done");
				
				retVal = true;
			}
		} catch (Exception e) {
			logger.error(e);
			retVal = false;
		} finally {
			try {
				if (fos != null) fos.close();
				if (bis != null) bis.close();
				if (method != null) method.releaseConnection();
			} catch (IOException e) {
				logger.error(e);
			}
		}
		logger.debug("DOWNLOAD EN TIME="+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date())+"\n");
		return retVal;
	}

}