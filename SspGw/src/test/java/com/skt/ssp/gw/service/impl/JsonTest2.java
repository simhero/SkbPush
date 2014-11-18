package com.skt.ssp.gw.service.impl;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import junit.framework.TestCase;

/**
 * JsonTest2 VO (JsonTest2)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: JsonTest2.java,v 1.0 2011/09/02 00:00:00 SimByungChul Express $
 */
public class JsonTest2 {
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

	public void atestInitSendInfo() {
		for (int i = 0; i < 1; i++) {
		HttpClient client = new HttpClient();
		client.getHttpConnectionManager().getParams().setConnectionTimeout(1000);
		PostMethod post = null;
		try {
//			String jsonData = "{\"device\":{\"deviceid\":\"" + "123456" + "\",\"mac\":\"\",\"modelname\":\"\"},\"head\":{\"clientid\":\"\",\"serviceid\":\"" + "ABCDEF" + "\"}}";
//			String jsonData = "{\"request\":{\"deviceId\":\"" + "123456" + "\",\"id\":\" " + "aaaaaaaaaaaaaaa" + "  \",\"version\":\"  " + "bbbbbbbbbbbbbbb" + "  \"}}";
//			String jsonData = "{\"request\":{\"header\",\"body\"}}";
			String jsonData = "{\"request\":{\"header\":{\"comAuthKey\":\"\",\"comInterfaceId\":\"IF_CU_001\",\"comVersion\":\"1.0\",\"comTrId\":\"UUID10101010101010101010101010\",\"comReqDevCd\":\"AND\",\"cc\":\"82\",\"phone_num\":\"1012345678\",\"model\":\"SHW-M110S\",\"manufacturer\":\"samsung\"},\"body\":{\"out\":\"testout\",\"orderList\":[{\"orderId\":\"order1\"},{\"orderId\":\"order2\"},{\"orderId\":\"order3\"}]}}}";
			post = new PostMethod("http://1.234.6.184:8080/sspGw/mobileGw/mobileInterface/IFTE001");
			post.setRequestHeader("Content-Type", "application/json");
			post.setRequestHeader("User-Agent", "iPhone; 640x480; SSP-SVC/1.0");
			post.setRequestHeader("Connection", "Close");
			post.setRequestBody(new ByteArrayInputStream(jsonData.getBytes()));
			System.out.println("time ="+sdf.format(new java.util.Date( )));
			long time1 = System.currentTimeMillis ();
			int result = client.executeMethod(post);
			long time2 = System.currentTimeMillis ();
			System.out.println("time2="+sdf.format(new java.util.Date( )));
			System.out.println ( "progress time=" +( time2 - time1 ) / 1000.0 );
			System.out.println("result : "+result);
			System.out.println("Response Value: ");
			System.out.println(post.getResponseBodyAsString());
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			post.releaseConnection();
		}
		}
	}

	public static void main(String[] args) {
		new JsonTest2().atestInitSendInfo();
	}
}


