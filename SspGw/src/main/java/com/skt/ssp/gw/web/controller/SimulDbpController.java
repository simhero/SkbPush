package com.skt.ssp.gw.web.controller;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skt.ssp.gw.service.CommonService;

/**
 * SimulDbpController (SimulDbpController)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: SimulDbpController.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Controller
public class SimulDbpController {
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private CommonService commonService;
	
	@RequestMapping(value="/simulDbp", method=RequestMethod.POST)
	public void requestTest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		res.setContentType("application/xml; charset=utf8");
		res.setCharacterEncoding("UTF-8");
		
		PrintWriter pw = null;
		
		try {
			
			pw = res.getWriter();
			
			BufferedReader in = new BufferedReader(req.getReader());
			
			StringBuffer sb = new StringBuffer();
			
			String str = "";
			
			while((str = in.readLine()) != null) {
				
				sb.append(str);
				
			}
			
			String body = sb.toString().trim();
			
			logger.debug("REQ_XML : " + body);
			
			String comInterfaceId = body.substring(body.indexOf("<interfaceId>") + 13, body.indexOf("</interfaceId>"));
			
			String userId = "";
			if( body.indexOf("<userId>") > -1 ) {
				userId = body.substring(body.indexOf("<userId>") + 8, body.indexOf("</userId>"));
			}
			
			logger.debug("REQ_INTERFACE_ID : " + comInterfaceId);
			logger.debug("REQ_USER_ID : " + userId);
			
			String dbpResMessage = resStr(userId, comInterfaceId);
			
			logger.debug("RES_XML : " + dbpResMessage);
			
			pw.println(dbpResMessage);
			
		} catch (Exception e) {
			
			throw e;
			
		} finally {
			
			if(pw != null) { pw.flush(); pw.close(); }
//			if(os != null) { os.flush(); os.close(); }
			
		}
		
	}
	
	public String resStr(String userId, String comInterfaceId) throws Exception {
		
		String dbpResMessage = "";
		String authKey = "";
		if(StringUtils.stripToEmpty(userId).length() > 0) {
			authKey = commonService.DSEncode("designfd|"+userId+"|"+new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
		}
		
		logger.debug("AUTH_KEY : " + authKey);
		
		if( "IF-TE-001".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<out>test001</out>" +
							"<orderList>" +
							"<order>" +
							"<orderId>1111</orderId>" +
							"</order>" +
							"<order>" +
							"<orderId>2222</orderId>" +
							"</order>" +
							"</orderList>" +
							"</body>" +
							"</response>";
		
		} else if( "IF-IN-001".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<keywordDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</keywordDate>" +
							"<marketList>" +
								"<markets>" +
									"<mainCode>AUC</mainCode>" +
									"<mainName>AUCTION</mainName>" +
									"<keyWordList>" +
										"<keyWords>" +
											"<keyNo>1</keyNo>" +
											"<keyWord>GGOGGO</keyWord>" +
											"<hitCnt>11</hitCnt>" +
										"</keyWords>" +
										"<keyWords>" +
											"<keyNo>2</keyNo>" +
											"<keyWord>SET</keyWord>" +
											"<hitCnt>11</hitCnt>" +
										"</keyWords>" +
									"</keyWordList>" +
								"</markets>" +
								"<markets>" +
									"<mainCode>GMK</mainCode>" +
									"<mainName>G-MARKET</mainName>" +
									"<keyWordList>" +
										"<keyWords>" +
											"<keyNo>1</keyNo>" +
											"<keyWord>GGOGGO</keyWord>" +
											"<hitCnt>11</hitCnt>" +
										"</keyWords>" +
										"<keyWords>" +
											"<keyNo>2</keyNo>" +
											"<keyWord>SET</keyWord>" +
											"<hitCnt>11</hitCnt>" +
										"</keyWords>" +
									"</keyWordList>" +
								"</markets>" +
							"</marketList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-IN-002".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"</Response>";
			
		} else if( "IF-CU-001".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<adminCode>designfd</adminCode>" +
							"<userId>" + userId + "</userId>" +
							"<comAppVersion></comAppVersion>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-CU-002".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<adminCode>designfd</adminCode>" +
							"<userId>" + userId + "</userId>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-CU-003".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<adminCode>designfd</adminCode>" +
							"<userId>" + userId + "</userId>" +
							"<comName>COMPANY</comName>" +
							"<userName><![CDATA[LEE]]></userName>" +
							"<userPhone><![CDATA[010-6353-2043]]></userPhone>" +
							"<userEmail><![CDATA[test@gmail.com]]></userEmail>" +
							"<userLevel>1</userLevel>" +
							"<userMasters>N</userMasters>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-CU-004".equals( comInterfaceId ) ) {
			
				dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<adminCode>designfd</adminCode>" +
							"<userId>" + userId + "</userId>" +
							"<marketList>" +
								"<markets>" +
									"<mainCode>SKE</mainCode>" +
									"<mainName><![CDATA[11번가]]></mainName>" +
									"<uid>SKE10203142</uid>" +
									"<stts>01</stts>" +
								"</markets>" +
								"<markets>" +
									"<mainCode>GMK</mainCode>" +
									"<mainName><![CDATA[지마켓]]></mainName>" +
									"<uid>GMK12283122</uid>" +
									"<stts>01</stts>" +
								"</markets>" +
							"</marketList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-CU-005".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<adminCode>designfd</adminCode>" +
							"<userId>" + userId + "</userId>" +
							"<oCnt>2</oCnt>" +
							"<oAmt>3</oAmt>" +
							"<sAmt>3</sAmt>" +
							"<gSaleCnt>2</gSaleCnt>" +
							"<gSaleReadyCnt>7</gSaleReadyCnt>" +
							"<gStopCnt>2</gStopCnt>" +
							"<gStopReadyCnt>6</gStopReadyCnt>" +
							"<oPaidCnt>6</oPaidCnt>" +
							"<oNewCnt>2</oNewCnt>" +
							"<oShipCnt>8</oShipCnt>" +
							"<oDeliCnt>10</oDeliCnt>" +
							"<oCanCnt>2</oCanCnt>" +
							"<oCanedCnt>21</oCanedCnt>" +
							"<oRetCnt>1</oRetCnt>" +
							"<oRetedCnt>2</oRetedCnt>" +
							"<oExcCnt>9</oExcCnt>" +
							"<oExcedCnt>6</oExcedCnt>" +
							"<csNewCnt>3</csNewCnt>" +
							"<csEmeCnt>4</csEmeCnt>" +
							"</body>" +
							"</Response>";
			
			
		} else if( "IF-CU-006".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<adminCode>designfd</adminCode>" +
							"<userId>" + userId + "</userId>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-CU-007".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<adminCode>designfd</adminCode>" +
							"<userId>" + userId + "</userId>" +
							"<oCnt>2</oCnt>" +
							"<oAmt>3</oAmt>" +
							"<sAmt>3</sAmt>" +
							"<gSaleCnt>2</gSaleCnt>" +
							"<gSaleReadyCnt>7</gSaleReadyCnt>" +
							"<gStopCnt>2</gStopCnt>" +
							"<gStopReadyCnt>6</gStopReadyCnt>" +
							"<oPaidCnt>6</oPaidCnt>" +
							"<oNewCnt>2</oNewCnt>" +
							"<oShipCnt>8</oShipCnt>" +
							"<oDeliCnt>10</oDeliCnt>" +
							"<oCanCnt>2</oCanCnt>" +
							"<oCanedCnt>21</oCanedCnt>" +
							"<oRetCnt>1</oRetCnt>" +
							"<oRetedCnt>2</oRetedCnt>" +
							"<oExcCnt>9</oExcCnt>" +
							"<oExcedCnt>6</oExcedCnt>" +
							"<csNewCnt>3</csNewCnt>" +
							"<csEmeCnt>4</csEmeCnt>" +
							"<marketList>" +
								"<markets>" +
									"<mainCode>SKE</mainCode>" +
									"<mainName><![CDATA[11번가]]></mainName>" +
									"<uid>SKE10203142</uid>" +
									"<stts>01</stts>" +
								"</markets>" +
								"<markets>" +
									"<mainCode>GMK</mainCode>" +
									"<mainName><![CDATA[지마켓]]></mainName>" +
									"<uid>GMK12283122</uid>" +
									"<stts>01</stts>" +
								"</markets>" +
							"</marketList>" +
							"</body>" +
							"</Response>";
		} else if( "IF-CU-008".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<adminCode>designfd</adminCode>" +
							"<userId>" + userId + "</userId>" +
							"<oCnt>2</oCnt>" +
							"<oAmt>3</oAmt>" +
							"<sAmt>3</sAmt>" +
							"<gSaleCnt>2</gSaleCnt>" +
							"<gSaleReadyCnt>7</gSaleReadyCnt>" +
							"<gStopCnt>2</gStopCnt>" +
							"<gStopReadyCnt>6</gStopReadyCnt>" +
							"<oPaidCnt>6</oPaidCnt>" +
							"<oNewCnt>2</oNewCnt>" +
							"<oShipCnt>8</oShipCnt>" +
							"<oDeliCnt>10</oDeliCnt>" +
							"<oCanCnt>2</oCanCnt>" +
							"<oCanedCnt>21</oCanedCnt>" +
							"<oRetCnt>1</oRetCnt>" +
							"<oRetedCnt>2</oRetedCnt>" +
							"<oExcCnt>9</oExcCnt>" +
							"<oExcedCnt>6</oExcedCnt>" +
							"<csNewCnt>3</csNewCnt>" +
							"<csEmeCnt>4</csEmeCnt>" +
							"<marketList>" +
								"<markets>" +
									"<mainCode>SKE</mainCode>" +
									"<mainName><![CDATA[11번가]]></mainName>" +
									"<uid>SKE10203142</uid>" +
									"<stts>01</stts>" +
								"</markets>" +
								"<markets>" +
									"<mainCode>GMK</mainCode>" +
									"<mainName><![CDATA[지마켓]]></mainName>" +
									"<uid>GMK12283122</uid>" +
									"<stts>01</stts>" +
								"</markets>" +
							"</marketList>" +
							"</body>" +
							"</Response>";
		
		} else if( "IF-GO-001".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<adminCode>designfd</adminCode>" +
							"<userId>" + userId + "</userId>" +
							"<goodsCnt>3</goodsCnt>" +
							"<goodsList>" +
								"<goods>" +
									"<mainCode>SKE</mainCode>" +
									"<mainName><![CDATA[11번가]]></mainName>" +
									"<mImgUrl>102</mImgUrl>" +
									"<uid>SKE10203142</uid>" +
									"<gJcode>12153131</gJcode>" +
									"<gName><![CDATA[TEST 상품]]></gName>" +
									"<gModel><![CDATA[TEST 모델]]></gModel>" +
									"<gMfname><![CDATA[TEST 제조사]]></gMfname>" +
									"<gBrandName><![CDATA[TEST 브랜드]]></gBrandName>" +
									"<gOrigin><![CDATA[TEST 원산지]]></gOrigin>" +
									"<img>http://www.test.com/test.jpg</img>" +
									"<gB2bcode>10203142</gB2bcode>" +
									"<useWpriceYn>N</useWpriceYn>" +
									"<gWprice>101</gWprice>" +
									"<gPrice>34000</gPrice>" +
									"<gRprice>34000</gRprice>" +
									"<gPqty>300</gPqty>" +
									"<safetyQty>300</safetyQty>" +
									"<sDate>2011-01-01 01:01:30</sDate>" +
									"<eDate>2011-12-31 23:59:59</eDate>" +
									"<gCategoryName><![CDATA[기타]]></gCategoryName>" +
									"<stts>01</stts>" +
								"</goods>" +
								"<goods>" +
									"<mainCode>GMK</mainCode>" +
									"<mainName><![CDATA[지마켓]]></mainName>" +
									"<mImgUrl>http://www.test.com/test2.jpg</mImgUrl>" +
									"<uid>GMK10203142</uid>" +
									"<gJcode>12153133</gJcode>" +
									"<gName><![CDATA[TEST 상품2]]></gName>" +
									"<gModel><![CDATA[TEST 모델2]]></gModel>" +
									"<gMfname><![CDATA[TEST 제조사2]]></gMfname>" +
									"<gBrandName><![CDATA[TEST 브랜드2]]></gBrandName>" +
									"<gOrigin><![CDATA[TEST 원산지2]]></gOrigin>" +
									"<img>http://www.test.com/test2.jpg</img>" +
									"<gB2bcode>10203143</gB2bcode>" +
									"<useWpriceYn>N</useWpriceYn>" +
									"<gWprice>101</gWprice>" +
									"<gPrice>34000</gPrice>" +
									"<gRprice>34000</gRprice>" +
									"<gPqty>300</gPqty>" +
									"<safetyQty>300</safetyQty>" +
									"<sDate>2011-01-01 01:01:30</sDate>" +
									"<eDate>2011-12-31 23:59:59</eDate>" +
									"<gCategoryName><![CDATA[기타]]></gCategoryName>" +
									"<stts>01</stts>" +
								"</goods>" +
							"</goodsList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-GO-002".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<adminCode>designfd</adminCode>" +
							"<userId>" + userId + "</userId>" +
							"<gJcode>12153131</gJcode>" +
							"<gModel>TEST MODEL</gModel>" +
							"<gMfname>TEST MF</gMfname>" +
							"<gBrandName>TEST Brand</gBrandName>" +
							"<gOrigin>TEST Origin</gOrigin>" +
							"<img>http://www.test.com/test.jpg</img>" +
							"<gQty>2000</gQty>" +
							"<goodsList>" +
								"<goods>" +
									"<mainCode>GMK</mainCode>" +
									"<mainName>G-Market</mainName>" +
									"<mImgUrl>http://www.test.com/test2.jpg</mImgUrl>" +
									"<uid>GMK10203142</uid>" +
									"<gB2bcode>10203143</gB2bcode>" +
									"<gName>TEST GOODS2</gName>" +
									"<useWpriceYn>N</useWpriceYn>" +
									"<gWprice>101</gWprice>" +
									"<gPrice>34000</gPrice>" +
									"<gRprice>34000</gRprice>" +
									"<gPqty>300</gPqty>" +
									"<safetyQty>300</safetyQty>" +
									"<sDate>2011-01-01 01:01:30</sDate>" +
									"<eDate>2011-12-31 23:59:59</eDate>" +
									"<gCategoryName>TEST</gCategoryName>" +
									"<gAccQty>1000</gAccQty>" +
									"<useMyPriceYn>N</useMyPriceYn>" +
									"<upDate>20110101010130</upDate>" +
									"<stts>01</stts>" +
								"</goods>" +
							"</goodsList>" +
							"</body>" +
							"</Response>";
							
		} else if( "IF-GO-003".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<goodsList>" +
								"<goods>" +
									"<gJcode>200002</gJcode>" +
									"<mainCode>AUC</mainCode>" +
									"<uid>zzata</uid>" +
									"<stts>03</stts>" +
									"<rsltCode>S</rsltCode>" +
									"<rsltMsg>SUCCESS</rsltMsg>" +
								"</goods>" +
							"</goodsList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-GO-004".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<adminCode>designfd</adminCode>" +
							"<userId>" + userId + "</userId>" +
							"<gJcode>12153131</gJcode>" +
							"<mainCode>AUC</mainCode>" +
							"<uid>SKE10203142</uid>" +
							"<gB2bcode>10203142</gB2bcode>" +
							"<goodsLogCnt>2</goodsLogCnt>" +
							"<goodsLogList>" +
								"<goodsLogs>" +
									"<regDate>2011-09-06 11:14:30</regDate>" +
									"<exeDate>2011-09-06 11:14:30</exeDate>" +
									"<jobKind>101</jobKind>" +
									"<result>1010</result>" +
									"<gPrice>5000</gPrice>" +
									"<regUser>YJKIM</regUser>" +
								"</goodsLogs>" +
								"<goodsLogs>" +
									"<regDate>2011-09-11 11:14:30</regDate>" +
									"<exeDate>2011-09-11 11:14:30</exeDate>" +
									"<jobKind>101</jobKind>" +
									"<result>1010</result>" +
									"<gPrice>5000</gPrice>" +
									"<regUser>YJKIM</regUser>" +
								"</goodsLogs>" +
							"</goodsLogList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-GO-005".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
//							"<adminCode>designfd</adminCode>" +
//							"<userId>" + userId + "</userId>" +
							"<groupCode>310</groupCode>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-GO-0051".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
//							"<adminCode>designfd</adminCode>" +
//							"<userId>" + userId + "</userId>" +
							"<groupCode>310</groupCode>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-GO-006".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
//							"<adminCode>designfd</adminCode>" +
//							"<userId>" + userId + "</userId>" +
							"<groupCnt>2</groupCnt>" +
							"<groupList>" +
								"<groups>" +
									"<groupCode>310</groupCode>" +
									"<groupName>그룹1</groupName>" +
								"</groups>" +
								"<groups>" +
									"<groupCode>311</groupCode>" +
									"<groupName>그룹2</groupName>" +
								"</groups>" +
							"</groupList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-GO-007".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
//							"<adminCode>designfd</adminCode>" +
//							"<userId>" + userId + "</userId>" +
							"<priceCnt>2</priceCnt>" +
							"<groupName>그룹1</groupName>" +
							"<priceList>" +
								"<prices>" +
									"<groupCode>310</groupCode>" +
									"<groupName>그룹1</groupName>" +
									"<gJcode>CT2002561</gJcode>" +
									"<gB2bcode></gB2bcode>" +
									"<gName>나이키 프렌치 테리 팬츠 (AS FRENCH TERRY PANT 411560-050)나이키 프렌치 테리 팬츠 (AS FRENCH TERRY PANT 411560-050)</gName>" +
									"<gPrice>1500</gPrice>" +
								"</prices>" +
								"<prices>" +
									"<groupCode>310</groupCode>" +
									"<groupName>그룹1</groupName>" +
									"<gJcode>CT2002562</gJcode>" +
									"<gB2bcode></gB2bcode>" +
									"<gName>나이키 프렌치 테리 팬츠 (AS FRENCH TERRY PANT 411560-050)\n나이키 프렌치 테리 팬츠 (AS FRENCH TERRY PANT 411560-050)</gName>" +
									"<gPrice>1000</gPrice>" +
								"</prices>" +
							"</priceList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-GO-008".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
//							"<body>" +
//							"<adminCode>designfd</adminCode>" +
//							"<userId>" + userId + "</userId>" +
//							"</body>" +
							"</Response>";
			
		} else if( "IF-GO-009".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
//							"<adminCode>designfd</adminCode>" +
//							"<userId>" + userId + "</userId>" +
							"<groupCode>001</groupCode>" +
							"<groupName>그룹1</groupName>" +
							"<gJcode>CT2002577@1</gJcode>" +
							"<gB2bcode></gB2bcode>" +
							"<gName>(인기상품) MM100S M2F 명품 막스마라  정품</gName>" +
							"<gPrice>270000</gPrice>" +
							"<keyWord>(인기상품) MM100S M2F 명품 막스마라  정품</keyWord>" +
							"<keyWordRegDate>2011-09-12 12:30:00</keyWordRegDate>" +
							"<priceCnt>4</priceCnt>" +
							"<priceList>" +
								"<prices>" +
									"<idx>1</idx>" +
									"<pIdx>PX21212121</pIdx>" +
									"<inType>naver</inType>" +
									"<lastBuildDate>2011-09-13 13:30:00</lastBuildDate>" +
									"<title>명품 막스마라  정품</title>" +
									"<linkUrl></linkUrl>" +
									"<imgUrl></imgUrl>" +
									"<mainCode>AUC</mainCode>" +
									"<mainName>옥션</mainName>" +
									"<mImgUrl></mImgUrl>" +
									"<uid>zzata</uid>" +
									"<lprice>500</lprice>" +
									"<hprice>2500</hprice>" +
									"<mallType>1</mallType>" +
									"<mallName>오픈테스트마켓</mallName>" +
									"<productId>518649</productId>" +
									"<productType>1</productType>" +
									"<beaType>0</beaType>" +
									"<beaAmt>0</beaAmt>" +
									"<inDate>2011-09-10 12:30:00</inDate>" +
								"</prices>" +
								"<prices>" +
									"<idx>2</idx>" +
									"<pIdx>PX21212121</pIdx>" +
									"<inType>naver</inType>" +
									"<lastBuildDate>2011-09-13 13:30:00</lastBuildDate>" +
									"<title>명품 막스마라  정품</title>" +
									"<linkUrl></linkUrl>" +
									"<imgUrl></imgUrl>" +
									"<mainCode>SKE</mainCode>" +
									"<mainName>11번가</mainName>" +
									"<mImgUrl></mImgUrl>" +
									"<uid>zzata</uid>" +
									"<lprice>500</lprice>" +
									"<hprice>2500</hprice>" +
									"<mallType>1</mallType>" +
									"<mallName>오픈테스트마켓</mallName>" +
									"<productId>518649</productId>" +
									"<productType>1</productType>" +
									"<beaType>0</beaType>" +
									"<beaAmt>0</beaAmt>" +
									"<inDate>2011-09-10 12:30:00</inDate>" +
								"</prices>" +
								"<prices>" +
									"<idx>3</idx>" +
									"<pIdx>PX21212121</pIdx>" +
									"<inType>naver</inType>" +
									"<lastBuildDate>2011-09-13 13:30:00</lastBuildDate>" +
									"<title>명품 막스마라  정품</title>" +
									"<linkUrl></linkUrl>" +
									"<imgUrl></imgUrl>" +
									"<mainCode>AUC</mainCode>" +
									"<mainName>옥션</mainName>" +
									"<mImgUrl></mImgUrl>" +
									"<uid>zzata</uid>" +
									"<lprice>500</lprice>" +
									"<hprice>2500</hprice>" +
									"<mallType>1</mallType>" +
									"<mallName>오픈테스트마켓</mallName>" +
									"<productId>518649</productId>" +
									"<productType>1</productType>" +
									"<beaType>0</beaType>" +
									"<beaAmt>0</beaAmt>" +
									"<inDate>2011-09-10 12:30:00</inDate>" +
								"</prices>" +
								"<prices>" +
									"<idx>4</idx>" +
									"<pIdx>PX21212121</pIdx>" +
									"<inType>naver</inType>" +
									"<lastBuildDate>2011-09-13 13:30:00</lastBuildDate>" +
									"<title>명품 막스마라  정품</title>" +
									"<linkUrl></linkUrl>" +
									"<imgUrl></imgUrl>" +
									"<mainCode>SKE</mainCode>" +
									"<mainName>11번가</mainName>" +
									"<mImgUrl></mImgUrl>" +
									"<uid>zzata</uid>" +
									"<lprice>500</lprice>" +
									"<hprice>2500</hprice>" +
									"<mallType>1</mallType>" +
									"<mallName>오픈테스트마켓</mallName>" +
									"<productId>518649</productId>" +
									"<productType>1</productType>" +
									"<beaType>0</beaType>" +
									"<beaAmt>0</beaAmt>" +
									"<inDate>2011-09-10 12:30:00</inDate>" +
								"</prices>" +
							"</priceList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-GO-010".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
//							"<body>" +
//							"<adminCode>designfd</adminCode>" +
//							"<userId>" + userId + "</userId>" +
//							"</body>" +
							"</Response>";
			
		} else if( "IF-GO-011".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
//							"<adminCode>designfd</adminCode>" +
//							"<userId>" + userId + "</userId>" +
							"<groupCode>310</groupCode>" +
							"<groupName>그룹1</groupName>" +
							"<gJcode>CT2002561</gJcode>" +
							"<gB2bcode></gB2bcode>" +
							"<gName>꼬꼬면</gName>" +
							"<gPrice>1500</gPrice>" +
							"<keyWord>꼬꼬</keyWord>" +
							"<priceList>" +
								"<prices>" +
									"<sgPrice>1500</sgPrice>" +
									"<sgQty>20</sgQty>" +
								"</prices>" +
								"<prices>" +
									"<sgPrice>1700</sgPrice>" +
									"<sgQty>30</sgQty>" +
								"</prices>" +
								"<prices>" +
									"<sgPrice>1900</sgPrice>" +
									"<sgQty>20</sgQty>" +
								"</prices>" +
								"<prices>" +
									"<sgPrice>1300</sgPrice>" +
									"<sgQty>50</sgQty>" +
								"</prices>" +
								"<prices>" +
									"<sgPrice>1200</sgPrice>" +
									"<sgQty>60</sgQty>" +
								"</prices>" +
								"<prices>" +
									"<sgPrice>1600</sgPrice>" +
									"<sgQty>30</sgQty>" +
								"</prices>" +
								"<prices>" +
									"<sgPrice>1800</sgPrice>" +
									"<sgQty>10</sgQty>" +
								"</prices>" +
							"</priceList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-GO-012".equals( comInterfaceId ) ) {

			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
//							"<adminCode>designfd</adminCode>" +
//							"<userId>" + userId + "</userId>" +
							"<totalCnt>4</totalCnt>" +
							"<myPriceList>" +
								"<myPrices>" +
									"<gubun>001</gubun>" +
									"<groupCode>310</groupCode>" +
									"<groupName>그룹1</groupName>" +
									"<gB2bcode></gB2bcode>" +
									"<gName></gName>" +
									"<gPrice></gPrice>" +
								"</myPrices>" +
								"<myPrices>" +
									"<gubun>001</gubun>" +
									"<groupCode>311</groupCode>" +
									"<groupName>그룹2</groupName>" +
									"<gJcode>CT2002562</gJcode>" +
									"<gB2bcode></gB2bcode>" +
									"<gName></gName>" +
									"<gPrice></gPrice>" +
								"</myPrices>" +
								"<myPrices>" +
									"<gubun>002</gubun>" +
									"<groupCode></groupCode>" +
									"<groupName></groupName>" +
									"<gJcode>CT2002561</gJcode>" +
									"<gB2bcode></gB2bcode>" +
									"<gName>나이키 프렌치 테리 팬츠 (AS FRENCH TERRY PANT 411560-050)나이키 프렌치 테리 팬츠 (AS FRENCH TERRY PANT 411560-050)</gName>" +
									"<gPrice>1500</gPrice>" +
								"</myPrices>" +
								"<myPrices>" +
									"<gubun>002</gubun>" +
									"<groupCode></groupCode>" +
									"<groupName></groupName>" +
									"<gJcode>CT2002562</gJcode>" +
									"<gB2bcode></gB2bcode>" +
									"<gName>나이키 프렌치 테리 팬츠 (AS FRENCH TERRY PANT 411560-050)\n나이키 프렌치 테리 팬츠 (AS FRENCH TERRY PANT 411560-050)</gName>" +
									"<gPrice>1000</gPrice>" +
								"</myPrices>" +
							"</myPriceList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-OR-001".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<adminCode>designfd</adminCode>" +
							"<userId>" + userId + "</userId>" +
							"<orderCnt>2</orderCnt>" +
							"<orderList>" +
								"<orders>" +
									"<mainCode>AUC</mainCode>" +
									"<mainName>옥션</mainName>" +
									"<mImgUrl>20</mImgUrl>" +
									"<uid>zzata</uid>" +
									"<jumunNo>651619</jumunNo>" +
									"<jumunDate>2011-09-25 16:24:30</jumunDate>" +
									"<oName>심병철</oName>" +
									"<oHp>010-1111-2222</oHp>" +
									"<gName>꼬꼬면</gName>" +
									"<oAmt>12000</oAmt>" +
									"<oState>00</oState>" +
								"</orders>" +
								"<orders>" +
									"<mainCode>AUC</mainCode>" +
									"<mainName>옥션</mainName>" +
									"<mImgUrl></mImgUrl>" +
									"<uid>zzata</uid>" +
									"<jumunNo>651609</jumunNo>" +
									"<jumunDate>2011-09-23 16:24:30</jumunDate>" +
									"<oName>김강호</oName>" +
									"<oHp>010-2222-3333</oHp>" +
									"<gName>삼양라면</gName>" +
									"<oAmt>34000</oAmt>" +
									"<oState>04</oState>" +
								"</orders>" +
							"</orderList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-OR-002".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<adminCode>designfd</adminCode>" +
							"<userId>" + userId + "</userId>" +
							"<mainCode>AUC</mainCode>" +
							"<mainName>옥션</mainName>" +
							"<mImgUrl></mImgUrl>" +
							"<uid>zzata</uid>" +
							"<jumunNo>651609</jumunNo>" +
							"<jumunDate>2011-09-23 16:24:30</jumunDate>" +
							"<oName>김강호</oName>" +
							"<oTel>02-123-2222</oTel>" +
							"<oHp>010-2222-3333</oHp>" +
							"<oAmt>34000</oAmt>" +
							"<kAmt>34000</kAmt>" +
							"<oState>04</oState>" +
							"<csMsg></csMsg>" +
							"<goodsList>" +
								"<goods>" +
									"<gB2bcode></gB2bcode>" +
									"<gName>삼양라면</gName>" +
									"<gStand></gStand>" +
									"<gQty>20</gQty>" +
									"<gPrice>1700</gPrice>" +
									"<gGubun>00</gGubun>" +
									"<gDeliveryCode>DEVCD102030</gDeliveryCode>" +
								"</goods>" +
								"<goods>" +
									"<gB2bcode></gB2bcode>" +
									"<gName>삼양라면111</gName>" +
									"<gStand></gStand>" +
									"<gQty>20</gQty>" +
									"<gPrice>1700</gPrice>" +
									"<gGubun>00</gGubun>" +
									"<gDeliveryCode>DEVCD102030</gDeliveryCode>" +
								"</goods>" +
								"<goods>" +
									"<gB2bcode></gB2bcode>" +
									"<gName>삼양라면222</gName>" +
									"<gStand></gStand>" +
									"<gQty>20</gQty>" +
									"<gPrice>1700</gPrice>" +
									"<gGubun>00</gGubun>" +
									"<gDeliveryCode>DEVCD102030</gDeliveryCode>" +
								"</goods>" +
							"</goodsList>" +
							"<beaList>" +
								"<beas>" +
									"<gDeliveryCode>DEVCD102030</gDeliveryCode>" +
									"<sName>김강호</sName>" +
									"<sTel>02-123-2222</sTel>" +
									"<sHp>010-2222-3333</sHp>" +
									"<receiveType></receiveType>" +
									"<tagcom>DIR</tagcom>" +
									"<songjangNo>651984894516</songjangNo>" +
								"</beas>" +
								"<beas>" +
									"<gDeliveryCode>DEVCD102030</gDeliveryCode>" +
									"<sName>김강호111</sName>" +
									"<sTel>02-234-3333</sTel>" +
									"<sHp>010-5555-1111</sHp>" +
									"<receiveType></receiveType>" +
									"<tagcom>DIR</tagcom>" +
									"<songjangNo>651984894516</songjangNo>" +
								"</beas>" +
								"<beas>" +
									"<gDeliveryCode>DEVCD102030</gDeliveryCode>" +
									"<sName>김강호222</sName>" +
									"<sTel>02-345-4444</sTel>" +
									"<sHp>010-3333-4444</sHp>" +
									"<receiveType></receiveType>" +
									"<tagcom>DIR</tagcom>" +
									"<songjangNo>651984894516</songjangNo>" +
								"</beas>" +
							"</beaList>" +
							"<jengSan>" +
								"<jsDate>2011-09-25 16:24:30</jsDate>" +
								"<jsPamt>34000</jsPamt>" +
								"<jsSamt>3400</jsSamt>" +
								"<jsJamt>30000</jsJamt>" +
							"</jengSan>" +
							"<claimInfoList>" +
								"<claimInfo>" +
									"<claimStatus>16</claimStatus>" +
									"<claimCount>10</claimCount>" +
									"<claimPrice>17000</claimPrice>" +
									"<claimRegDate>2011-09-25 16:24:30</claimRegDate>" +
									"<claimRegUser>김강호111</claimRegUser>" +
									"<claimDesc>테스트입니다.111</claimDesc>" +
									"<claimSolveDate>2011-09-25 16:24:30</claimSolveDate>" +
									"<claimSolveUser>어드민</claimSolveUser>" +
									"<claimCancelReason></claimCancelReason>" +
								"</claimInfo>" +
								"<claimInfo>" +
									"<claimStatus>16</claimStatus>" +
									"<claimCount>10</claimCount>" +
									"<claimPrice>17000</claimPrice>" +
									"<claimRegDate>2011-09-25 16:24:30</claimRegDate>" +
									"<claimRegUser>김강호222</claimRegUser>" +
									"<claimDesc>테스트입니다.222</claimDesc>" +
									"<claimSolveDate>2011-09-25 16:24:30</claimSolveDate>" +
									"<claimSolveUser>어드민</claimSolveUser>" +
									"<claimCancelReason></claimCancelReason>" +
								"</claimInfo>" +
								"<claimInfo>" +
									"<claimStatus>16</claimStatus>" +
									"<claimCount>10</claimCount>" +
									"<claimPrice>17000</claimPrice>" +
									"<claimRegDate>2011-09-25 16:24:30</claimRegDate>" +
									"<claimRegUser>김강호333</claimRegUser>" +
									"<claimDesc>테스트입니다.333</claimDesc>" +
									"<claimSolveDate>2011-09-25 16:24:30</claimSolveDate>" +
									"<claimSolveUser>어드민</claimSolveUser>" +
									"<claimCancelReason></claimCancelReason>" +
								"</claimInfo>" +
							"</claimInfoList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-OR-003".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
//							"<adminCode>designfd</adminCode>" +
//							"<userId>" + userId + "</userId>" +
							"<orderList>" +
								"<orders>" +
									"<jumunNo>949489518</jumunNo>" +
									"<oState>01</oState>" +
									"<rsltCode>S</rsltCode>" +
									"<rsltMsg>SUCCSESS</rsltMsg>" +
								"</orders>" +
								"<orders>" +
									"<jumunNo>895189494</jumunNo>" +
									"<oState>01</oState>" +
									"<rsltCode>S</rsltCode>" +
									"<rsltMsg>SUCCSESS</rsltMsg>" +
								"</orders>" +
							"</orderList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-SE-001".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<adminCode>designfd</adminCode>" +
							"<userId>" + userId + "</userId>" +
							"<settleCnt>2</settleCnt>" +
							"<settleList>" +
								"<settles>" +
									"<mainCode>AUC</mainCode>" +
									"<mainName>옥션</mainName>" +
									"<mImgUrl></mImgUrl>" +
									"<uid>zzata</uid>" +
									"<jumunNo>6161515</jumunNo>" +
									"<jsDate>2011-09-25 16:24:30</jsDate>" +
									"<jsPamt>20000</jsPamt>" +
									"<jsSamt>10000</jsSamt>" +
									"<jsJamt>10000</jsJamt>" +
								"</settles>" +
								"<settles>" +
									"<mainCode>SKE</mainCode>" +
									"<mainName>11번가</mainName>" +
									"<mImgUrl></mImgUrl>" +
									"<uid>zzata</uid>" +
									"<jumunNo>6161892</jumunNo>" +
									"<jsDate>2011-09-25 16:24:30</jsDate>" +
									"<jsPamt>90000</jsPamt>" +
									"<jsSamt>30000</jsSamt>" +
									"<jsJamt>30000</jsJamt>" +
								"</settles>" +
							"</settleList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-SE-002".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<adminCode>designfd</adminCode>" +
							"<userId>" + userId + "</userId>" +
							"<mainCode>SKE</mainCode>" +
							"<mainName>11번가</mainName>" +
							"<mImgUrl></mImgUrl>" +
							"<uid>zzata</uid>" +
							"<jumunNo>6161892</jumunNo>" +
							"<jsDate>2011-09-25 16:24:30</jsDate>" +
							"<jsPamt>90000</jsPamt>" +
							"<jsSamt>30000</jsSamt>" +
							"<jsJamt>30000</jsJamt>" +
							"<settleList>" +
								"<settles>" +
									"<gB2bcode>1651591</gB2bcode>" +
									"<gName>꼬꼬면</gName>" +
									"<gQty>1</gQty>" +
									"<gPrice>23000</gPrice>" +
									"<sPrice>1000</sPrice>" +
									"<jPrice>10000</jPrice>" +
									"<gGubun>00</gGubun>" +
								"</settles>" +
							"</settleList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-CS-001".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<adminCode>designfd</adminCode>" +
							"<userId>" + userId + "</userId>" +
							"<csCnt>2</csCnt>" +
							"<csList>" +
								"<css>" +
									"<mainCode>AUC</mainCode>" +
									"<mainName>옥션</mainName>" +
									"<mImgUrl></mImgUrl>" +
									"<uid>zzata</uid>" +
									"<csNo>9848949</csNo>" +
									"<csDate>2011-09-28 14:21:00</csDate>" +
									"<gB2bcode></gB2bcode>" +
									"<jumunNo>65984984</jumunNo>" +
									"<csState>01</csState>" +
									"<csUser>designfd</csUser>" +
									"<qName>디자인</qName>" +
									"<csContact>email</csContact>" +
									"<csKind>01</csKind>" +
									"<qSubject>상품 문의드립니다.</qSubject>" +
								"</css>" +
								"<css>" +
									"<mainCode>AUC</mainCode>" +
									"<mainName>옥션</mainName>" +
									"<mImgUrl></mImgUrl>" +
									"<uid>zzata</uid>" +
									"<csNo>9848976</csNo>" +
									"<csDate>2011-09-28 14:23:00</csDate>" +
									"<gB2bcode></gB2bcode>" +
									"<jumunNo>84984659</jumunNo>" +
									"<csState>01</csState>" +
									"<csUser>c</csUser>" +
									"<qName>c</qName>" +
									"<csContact>email</csContact>" +
									"<csKind>03</csKind>" +
									"<qSubject>배송 문의드립니다.</qSubject>" +
								"</css>" +
							"</csList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-CS-002".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<adminCode>designfd</adminCode>" +
							"<userId>" + userId + "</userId>" +
							"<mainCode>SKE</mainCode>" +
							"<mainName>11번가</mainName>" +
							"<mImgUrl></mImgUrl>" +
							"<uid>zzata</uid>" +
							"<csNo>9848976</csNo>" +
							"<csDate>2011-09-28 14:23:00</csDate>" +
							"<csState>01</csState>" +
							"<qUser>designfd</qUser>" +
							"<qName>designfd</qName>" +
							"<csKind>01</csKind>" +
							"<jumunNo>65984984</jumunNo>" +
							"<gB2bcode></gB2bcode>" +
							"<gName>꼬꼬면</gName>" +
							"<qSubject>상품 문의드립니다.</qSubject>" +
							"<qContents>어떻게 끓여먹어야 맛있는건가요?</qContents>" +
							"<aSubject></aSubject>" +
							"<aContents></aContents>" +
							"<aDate></aDate>" +
							"<tDate></tDate>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-CS-003".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"</Response>";
			
		} else if( "IF-CS-004".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<adminCode>designfd</adminCode>" +
							"<userId>" + userId + "</userId>" +
							"<csCnt>1</csCnt>" +
							"<csList>" +
								"<css>" +
									"<mainCode>SKE</mainCode>" +
									"<mainName>11번가</mainName>" +
									"<mImgUrl></mImgUrl>" +
									"<uid>zzata</uid>" +
									"<pushCategory>01</pushCategory>" +
									"<csNo>19519519</csNo>" +
									"<csDate>2011-09-28 14:34:00</csDate>" +
									"<csState>01</csState>" +
									"<csNew>Y</csNew>" +
									"<qUser>designfd</qUser>" +
									"<qName>심병철</qName>" +
									"<csKind>03</csKind>" +
									"<jumunNo></jumunNo>" +
									"<gJcode></gJcode>" +
									"<gB2bcode></gB2bcode>" +
									"<qSubject>방금 주문했는데 배송은 언제 되나요?</qSubject>" +
								"</css>" +
							"</csList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-CS-005".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<adminCode>designfd</adminCode>" +
							"<userId>" + userId + "</userId>" +
							"<mainCode>SKE</mainCode>" +
							"<mainName>11번가</mainName>" +
							"<mImgUrl></mImgUrl>" +
							"<uid>zzata</uid>" +
							"<csNo>19519519</csNo>" +
							"<csDate>2011-09-28 14:34:00</csDate>" +
							"<csState>01</csState>" +
							"<qName>심병철</qName>" +
							"<csKind>03</csKind>" +
							"<jumunNo>519615</jumunNo>" +
							"<gJcode>zzata</gJcode>" +
							"<gB2bcode></gB2bcode>" +
							"<gName>꼬꼬면</gName>" +
							"<qSubject>방금 주문했는데 배송은 언제 되나요?</qSubject>" +
							"<qContents>방금 주문했는데 배송은 언제 되나요?</qContents>" +
							"<aSubject></aSubject>" +
							"<aContents></aContents>" +
							"<aDate></aDate>" +
							"<tDate></tDate>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-CS-006".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<csCnt>1</csCnt>" +
							"<csList>" +
								"<css>" +
									"<csNo>519489</csNo>" +
									"<aSubject>RE: 방금 주문했는데 배송은 언제 되나요?</aSubject>" +
									"<aContents>오전에 출고 하였으니 내일 안으로 받으실수 있습니다.</aContents>" +
								"</css>" +
							"</csList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-CS-007".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"</Response>";
			
		} else if( "IF-CS-008".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<csCnt>1</csCnt>" +
							"<csList>" +
								"<css>" +
									"<csNo>519489</csNo>" +
									"<aSubject>RE: 방금 주문했는데 배송은 언제 되나요?</aSubject>" +
									"<aContents>오전에 출고 하였으니 내일 안으로 받으실수 있습니다.</aContents>" +
								"</css>" +
							"</csList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-CS-009".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<csCnt>1</csCnt>" +
							"<csList>" +
								"<css>" +
									"<csNo>519489</csNo>" +
									"<qSubject>방금 주문했는데 배송은 언제 되나요?</qSubject>" +
									"<csDate>2011-09-28 14:44:00</csDate>" +
									"<csState>01</csState>" +
								"</css>" +
							"</csList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-CS-010".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<qSubject>방금 주문했는데 배송은 언제 되나요?</qSubject>" +
							"<qContents>방금 주문했는데 배송은 언제 되나요?</qContents>" +
							"<csDate>2011-09-28 14:44:00</csDate>" +
							"<aSubject>RE: 방금 주문했는데 배송은 언제 되나요?</aSubject>" +
							"<aContents>오전에 출고 하였으니 내일 안으로 받으실수 있습니다.</aContents>" +
							"<aDate>2011-09-28 15:00:00</aDate>" +
							"<csState>01</csState>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-CS-011".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<csList>" +
								"<css>" +
									"<csNo></csNo>" +
									"<rsltCode>S</rsltCode>" +
									"<rsltMsg>SUCCSESS</rsltMsg>" +
								"</css>" +
								"<css>" +
									"<csNo></csNo>" +
									"<rsltCode>S</rsltCode>" +
									"<rsltMsg>SUCCSESS</rsltMsg>" +
								"</css>" +
							"</csList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-CS-012".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<adminCode>designfd</adminCode>" +
							"<userId>" + userId + "</userId>" +
							"<faqCnt>1</faqCnt>" +
							"<faqList>" +
								"<faqs>" +
									"<faqNo>111222333</faqNo>" +
									"<faqTitle>자주발생하는 FAQ</faqTitle>" +
									"<faqContents>테스트입니다.</faqContents>" +
									"<faqDate>2011-09-28 14:48:00</faqDate>" +
								"</faqs>" +
							"</faqList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-CS-013".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"</Response>";
			
		} else if( "IF-CS-014".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"</Response>";
			
		} else if( "IF-CS-015".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"</Response>";
			
		} else if( "IF-ST-001".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<statisticsCnt>10</statisticsCnt>" +
							"<summary>" +
								"<salePrice>100000</salePrice>" +
								"<saleQty>200</saleQty>" +
								"<calculatePrice>10000</calculatePrice>" +
								"<calculateQty>20</calculateQty>" +
								"<cancelPrice>10000</cancelPrice>" +
								"<cancelQty>20</cancelQty>" +
								"<exchangePrice>10000</exchangePrice>" +
								"<exchangeQty>20</exchangeQty>" +
								"<takebackPrice>10000</takebackPrice>" +
								"<takebackQty>20</takebackQty>" +
							"</summary>" +
							"<statisticsList>";
							for(int i = 0; i < 10; i++) {
								dbpResMessage += 
									"<statistics>" +
										"<categoryName>2011-10-" + StringUtils.leftPad((i+1) + "", 2, "0") + "</categoryName>" +
										"<salePrice>10000</salePrice>" +
										"<saleQty>20</saleQty>" +
										"<calculatePrice>1000</calculatePrice>" +
										"<calculateQty>2</calculateQty>" +
										"<cancelPrice>1000</cancelPrice>" +
										"<cancelQty>2</cancelQty>" +
										"<exchangePrice>1000</exchangePrice>" +
										"<exchangeQty>2</exchangeQty>" +
										"<takebackPrice>1000</takebackPrice>" +
										"<takebackQty>2</takebackQty>" +
										"<dataList>" +
											"<datas>" +
												"<mainCode>AUC</mainCode>" +
												"<mainName>옥션</mainName>" +
												"<mImgUrl></mImgUrl>" +
												"<uid>zzata</uid>" +
												"<salePrice>5000</salePrice>" +
												"<saleQty>10</saleQty>" +
												"<calculatePrice>500</calculatePrice>" +
												"<calculateQty>1</calculateQty>" +
												"<cancelPrice>500</cancelPrice>" +
												"<cancelQty>1</cancelQty>" +
												"<exchangePrice>500</exchangePrice>" +
												"<exchangeQty>1</exchangeQty>" +
												"<takebackPrice>500</takebackPrice>" +
												"<takebackQty>1</takebackQty>" +
											"</datas>" +
											"<datas>" +
												"<mainCode>SKE</mainCode>" +
												"<mainName>11번가</mainName>" +
												"<mImgUrl></mImgUrl>" +
												"<uid>zzata</uid>" +
												"<salePrice>5000</salePrice>" +
												"<saleQty>10</saleQty>" +
												"<calculatePrice>500</calculatePrice>" +
												"<calculateQty>1</calculateQty>" +
												"<cancelPrice>500</cancelPrice>" +
												"<cancelQty>1</cancelQty>" +
												"<exchangePrice>500</exchangePrice>" +
												"<exchangeQty>1</exchangeQty>" +
												"<takebackPrice>500</takebackPrice>" +
												"<takebackQty>1</takebackQty>" +
											"</datas>" +
										"</dataList>" + 
									"</statistics>";
									
								Thread.sleep(100);
							}
							dbpResMessage += "</statisticsList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-ST-002".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<statisticsCnt>2</statisticsCnt>" +
							"<summary>" +
								"<visitorCnt>40</visitorCnt>" +
								"<orderCnt>40</orderCnt>" +
								"<goodsCnt>40</goodsCnt>" +
								"<salePrice>4000</salePrice>" +
								"<conversionFactor></conversionFactor>" +
							"</summary>" +
							"<statisticsList>" +
								"<statistics>" +
									"<categoryName>AUC</categoryName>" +
									"<visitorCnt>20</visitorCnt>" +
									"<orderCnt>20</orderCnt>" +
									"<goodsCnt>20</goodsCnt>" +
									"<salePrice>2000</salePrice>" +
									"<conversionFactor></conversionFactor>" +
									"<dataList>" +
										"<datas>" +
											"<mainCode>AUC</mainCode>" +
											"<mainName>옥션</mainName>" +
											"<mImgUrl></mImgUrl>" +
											"<uid>zzata</uid>" +
											"<visitorCnt>10</visitorCnt>" +
											"<orderCnt>10</orderCnt>" +
											"<goodsCnt>10</goodsCnt>" +
											"<salePrice>1000</salePrice>" +
											"<conversionFactor></conversionFactor>" +
										"</datas>" +
										"<datas>" +
											"<mainCode>AUC</mainCode>" +
											"<mainName>옥션</mainName>" +
											"<mImgUrl></mImgUrl>" +
											"<uid>zzata</uid>" +
											"<visitorCnt>10</visitorCnt>" +
											"<orderCnt>10</orderCnt>" +
											"<goodsCnt>10</goodsCnt>" +
											"<salePrice>1000</salePrice>" +
											"<conversionFactor></conversionFactor>" +
										"</datas>" +
									"</dataList>" +
								"</statistics>" +
								"<statistics>" +
									"<categoryName>SKE</categoryName>" +
									"<visitorCnt>20</visitorCnt>" +
									"<orderCnt>20</orderCnt>" +
									"<goodsCnt>20</goodsCnt>" +
									"<salePrice>2000</salePrice>" +
									"<conversionFactor></conversionFactor>" +
									"<dataList>" +
										"<datas>" +
											"<mainCode>SKE</mainCode>" +
											"<mainName>11번가</mainName>" +
											"<mImgUrl></mImgUrl>" +
											"<uid>zzata</uid>" +
											"<visitorCnt>10</visitorCnt>" +
											"<orderCnt>10</orderCnt>" +
											"<goodsCnt>10</goodsCnt>" +
											"<salePrice>1000</salePrice>" +
											"<conversionFactor></conversionFactor>" +
										"</datas>" +
										"<datas>" +
											"<mainCode>AUC</mainCode>" +
											"<mainName>옥션</mainName>" +
											"<mImgUrl></mImgUrl>" +
											"<uid>zzata</uid>" +
											"<visitorCnt>10</visitorCnt>" +
											"<orderCnt>10</orderCnt>" +
											"<goodsCnt>10</goodsCnt>" +
											"<salePrice>1000</salePrice>" +
											"<conversionFactor></conversionFactor>" +
										"</datas>" +
									"</dataList>" +
								"</statistics>" +
							"</statisticsList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-PU-001".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<pushCnt>1</pushCnt>" +
							"<pushMsgList>" +
								"<pushMsgs>" +
									"<transferGroupIdx>001</transferGroupIdx>" +
									"<csNew>Y</csNew>" +
									"<pushMsg>TEST MESSAGE</pushMsg>" +
									"<procDate>2011-10-10 12:59:20</procDate>" +
								"</pushMsgs>" +
							"</pushMsgList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-PU-002".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<pushCnt>6</pushCnt>" +
							"<pushMsgList>" +
								"<pushMsgs>" +
									"<idx>1</idx>" +
									"<transferGroupIdx>001</transferGroupIdx>" +
									"<mainCode>SKE</mainCode>" +
									"<mainName>11번가</mainName>" +
									"<mImgUrl>http://1.234.6.176/img/Android/ico_market_11st.png</mImgUrl>" +
									"<uid>zzata10</uid>" +
									"<pushCategory>11</pushCategory>" +
									"<title></title>" +
									"<procDate>2010-01-25 18:33:35</procDate>" +
									"<csNo></csNo>" +
									"<userId>TEST USER</userId>" +
									"<userName>양형석</userName>" +
									"<jumunNo>201001250126086</jumunNo>" +
									"<gJcode></gJcode>" +
									"<gName>듀퐁폰전용가죽케이스 / U510S U510LE / 어린왕자폰 / 듀퐁폰가죽케이스 / 듀퐁폰케이스 / 듀퐁폰실리콘케이스</gName>" +
									"<stts>07</stts>" +
								"</pushMsgs>" +
								"<pushMsgs>" +
									"<idx>2</idx>" +
									"<transferGroupIdx>001</transferGroupIdx>" +
									"<mainCode>SKE</mainCode>" +
									"<mainName>11번가</mainName>" +
									"<mImgUrl>http://1.234.6.176/img/Android/ico_market_11st.png</mImgUrl>" +
									"<uid>zzata10</uid>" +
									"<pushCategory>12</pushCategory>" +
									"<title></title>" +
									"<procDate>2010-01-27 09:12:39</procDate>" +
									"<csNo></csNo>" +
									"<userId>TEST USER</userId>" +
									"<userName>김현태</userName>" +
									"<jumunNo>201001270367127</jumunNo>" +
									"<gJcode></gJcode>" +
									"<gName>옴니아2케이스 / M710 M715 M7350 / 옴니아2가죽케이스 / 옴니아2 케이스 / 옴니아2실리콘케이스</gName>" +
									"<stts>03</stts>" +
								"</pushMsgs>" +
								"<pushMsgs>" +
									"<idx>3</idx>" +
									"<transferGroupIdx>001</transferGroupIdx>" +
									"<mainCode>SKE</mainCode>" +
									"<mainName>11번가</mainName>" +
									"<mImgUrl>http://1.234.6.176/img/Android/ico_market_11st.png</mImgUrl>" +
									"<uid>zzata10</uid>" +
									"<pushCategory>13</pushCategory>" +
									"<title></title>" +
									"<procDate>2010-01-27 11:15:56</procDate>" +
									"<csNo></csNo>" +
									"<userId>TEST USER</userId>" +
									"<userName>장지선</userName>" +
									"<jumunNo>201001270383388</jumunNo>" +
									"<gJcode></gJcode>" +
									"<gName>듀퐁폰전용가죽케이스 / U510S U510LE / 어린왕자폰 / 듀퐁폰가죽케이스 / 듀퐁폰케이스 / 듀퐁폰실리콘케이스</gName>" +
									"<stts>03</stts>" +
								"</pushMsgs>" +
								"<pushMsgs>" +
									"<idx>4</idx>" +
									"<transferGroupIdx>001</transferGroupIdx>" +
									"<mainCode>SKE</mainCode>" +
									"<mainName>11번가</mainName>" +
									"<mImgUrl>http://1.234.6.176/img/Android/ico_market_11st.png</mImgUrl>" +
									"<uid>zzata10</uid>" +
									"<pushCategory>13</pushCategory>" +
									"<title></title>" +
									"<procDate>2010-01-27 11:15:56</procDate>" +
									"<csNo></csNo>" +
									"<userId>TEST USER</userId>" +
									"<userName>김대훈</userName>" +
									"<jumunNo>201001270435131</jumunNo>" +
									"<gJcode></gJcode>" +
									"<gName>연아의햅틱케이스/W770 7700 7750 미니햅틱 연아의햅틱케이스 연아의햅틱가죽케이스 햅틱미니</gName>" +
									"<stts>01</stts>" +
								"</pushMsgs>" +
								"<pushMsgs>" +
									"<idx>5</idx>" +
									"<transferGroupIdx>001</transferGroupIdx>" +
									"<mainCode>AUC</mainCode>" +
									"<mainName>옥션</mainName>" +
									"<mImgUrl>http://1.234.6.176/img/Android/ico_market_auction.png</mImgUrl>" +
									"<uid>zzata</uid>" +
									"<pushCategory>30</pushCategory>" +
									"<title>이 제품 남자가 쓸수도 있나요?</title>" +
									"<procDate>2008-09-24</procDate>" +
									"<csNo>CS201109070017</csNo>" +
									"<userId>moglee13</userId>" +
									"<userName>moglee13</userName>" +
									"<jumunNo></jumunNo>" +
									"<gJcode></gJcode>" +
									"<gName></gName>" +
									"<stts>02</stts>" +
								"</pushMsgs>" +
								"<pushMsgs>" +
									"<idx>6</idx>" +
									"<transferGroupIdx>001</transferGroupIdx>" +
									"<mainCode>AUC</mainCode>" +
									"<mainName>옥션</mainName>" +
									"<mImgUrl>http://1.234.6.176/img/Android/ico_market_auction.png</mImgUrl>" +
									"<uid>zzata</uid>" +
									"<pushCategory>30</pushCategory>" +
									"<title>도대체 언제 보냅니까?</title>" +
									"<procDate>2008-09-25</procDate>" +
									"<csNo>CS201109070023</csNo>" +
									"<userId>milena4914</userId>" +
									"<userName>milena4914</userName>" +
									"<jumunNo></jumunNo>" +
									"<gJcode></gJcode>" +
									"<gName></gName>" +
									"<stts>01</stts>" +
								"</pushMsgs>" +
							"</pushMsgList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-PU-004".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<pushInfoList>" +
							"<pushInfos>" +
								"<transferGroupIdx>10</transferGroupIdx>" +
								"<idx>10</idx>" +
								"<rsltCode>S</rsltCode>" +
								"<rsltMsg>SUCCESS</rsltMsg>" +
							"</pushInfos>" +
							"<pushInfos>" +
								"<transferGroupIdx>11</transferGroupIdx>" +
								"<idx>11</idx>" +
								"<rsltCode>S</rsltCode>" +
								"<rsltMsg>SUCCESS</rsltMsg>" +
							"</pushInfos>" +
							"</pushInfoList>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-CF-001".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"<body>" +
							"<alarmYn>Y</alarmYn>" +
							"<newOrderAlarmYn>Y</newOrderAlarmYn>" +
							"<cancelOrderAlarmYn>Y</cancelOrderAlarmYn>" +
							"<returnOrderAlarmYn>Y</returnOrderAlarmYn>" +
							"<exchangeOrderAlarmYn>Y</exchangeOrderAlarmYn>" +
							"<goodsProcAlarmYn>Y</goodsProcAlarmYn>" +
							"<csAlarmYn>Y</csAlarmYn>" +
							"<safetyQtyYn>Y</safetyQtyYn>" +
							"<alarmStartPeriod>08:30</alarmStartPeriod>" +
							"<alarmEndPeriod>23:00</alarmEndPeriod>" +
							"<alarmInterval>01</alarmInterval>" +
							"<useGlobalWpriceYn>Y</useGlobalWpriceYn>" +
							"<lastAppVersion>v1.0.0</lastAppVersion>" +
							"</body>" +
							"</Response>";
			
		} else if( "IF-CF-002".equals( comInterfaceId ) ) {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"</Response>";
			
		} else {
			
			dbpResMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<Response>" +
							"<header>" +
							"<authKey><![CDATA[" + authKey + "]]></authKey>" +
							"<interfaceId>" + comInterfaceId + "</interfaceId>" +
							"<resultCode>SUCCESS</resultCode>" +
							"<resultMsg>SUCCESS</resultMsg>" +
							"<responseDate>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())+"</responseDate>" +
							"</header>" +
							"</Response>";
			
		}
		
		return dbpResMessage;
		
	}
	
}
