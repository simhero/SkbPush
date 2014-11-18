package com.skt.ssp.ih.web.controller;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skt.ssp.ih.parse.ImageConvertDbpMsgReader;
import com.skt.ssp.ih.service.CommonService;
import com.skt.ssp.ih.service.ImageConvProcService;
import com.skt.ssp.ih.vo.imageConvert.IfIh001DataReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh001DataResVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002DataReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002DataResVO;
import com.skt.ssp.ih.web.validator.ImageConvertValidator;

/**
 * ImageConvertController (ImageConvertController)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: ImageConvertController.java,v 1.0 2011/10/31 00:00:00 ChoKyuJin Express $
 */
@Controller
@RequestMapping("/mobileInterface")
public class ImageConvertController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private ImageConvProcService imageConvProcService;
	@Autowired
	private ImageConvertValidator imageConvertValidator;
	@Autowired
	private ImageConvertDbpMsgReader imageConvertDbpMsgReader;
	
	@RequestMapping(value = "/IF-IH-001", method=RequestMethod.POST)
	public void requestImageConvert001(@RequestBody String xmlStr, HttpServletRequest req, HttpServletResponse res) {
		PrintWriter out = null;
		
		try {
//			logger.debug("IH-001 ST");
			long st = new Date().getTime();
			res.setCharacterEncoding("UTF-8");
			out = res.getWriter();
			
			/** 1. Check Remote Address */
			if(!commonService.isAllowAccess(req.getRemoteAddr())) {
				out.write(commonService.returnStringIfIh001(commonService.setIfIh001ResponseVO("IH01907")));
				return;
			}
			
			/** 2. REQUEST XML Parsing */
			IfIh001DataReqVO reqVO = imageConvertDbpMsgReader.getIh001DbpReqMessage(xmlStr);
			if(reqVO == null) {
				out.write(commonService.returnStringIfIh001(commonService.setIfIh001ResponseVO("IH01906")));
				return;
			}
				
			/** 3. REQUEST Validate			*/
			IfIh001DataResVO imageConvertResVO = imageConvertValidator.validateIfIh001(reqVO);
			if(imageConvertResVO != null) {
				out.write(commonService.returnStringIfIh001(imageConvertResVO));
				return;
			}
			
			/** 4. 이미지 저장 & 디비이력 추가	*/
			imageConvertResVO = imageConvProcService.requestIh001(reqVO);
			out.write(commonService.returnStringIfIh001(imageConvertResVO));
			
			long en = new Date().getTime();
			logger.debug("IH-001 TIME="+((en - st) / 1000));
//			logger.debug("IH-001 EN\n");
			
		} catch (Exception e) {
			logger.error(e);
			out.write(commonService.returnStringIfIh001(commonService.setIfIh001ResponseErrorVO("IH01999", e.getMessage())));
		} finally {
			if(out != null) {
				out.flush();
				out.close();
			}
		}
		
	}
	
	@RequestMapping(value = "/IF-IH-002", method=RequestMethod.POST)
	public void requestImageConvert002(@RequestBody String xmlStr, HttpServletRequest req, HttpServletResponse res) {
		PrintWriter out = null;
		String trId = StringUtils.substring(xmlStr, xmlStr.indexOf("<transactionId>"), xmlStr.indexOf("</transactionId>")).replace("<transactionId>", "");
		String adCd = StringUtils.substring(xmlStr, xmlStr.indexOf("<adminCode>"), xmlStr.indexOf("</adminCode>")).replace("<adminCode>", "");
		try {
			logger.debug("IH-002 ST");
			
			res.setCharacterEncoding("UTF-8");
			out = res.getWriter();
			
			/** 1. Check Remote Address */
			if(!commonService.isAllowAccess(req.getRemoteAddr())) {
				IfIh002DataResVO imageConvertResVO = commonService.setIfIh002ResponseVO("IH01907");
				imageConvertResVO.getBody().setTransactionId(trId);
				imageConvertResVO.getBody().setAdminCode(adCd);
				out.write(commonService.returnStringIfIh002(imageConvertResVO));
				return;
			}
			
			/** 2. REQUEST XML Parsing */
			IfIh002DataReqVO reqVO = imageConvertDbpMsgReader.getIh002DbpReqMessage(xmlStr);
			if(reqVO == null) {
				IfIh002DataResVO imageConvertResVO = commonService.setIfIh002ResponseVO("IH01906");
				imageConvertResVO.getBody().setTransactionId(trId);
				imageConvertResVO.getBody().setAdminCode(adCd);
				out.write(commonService.returnStringIfIh002(imageConvertResVO));
				return;
			}
				
			/** 3. REQUEST Validate			*/
			IfIh002DataResVO imageConvertResVO = imageConvertValidator.validateIfIh002(reqVO);
			if(imageConvertResVO != null) {
				imageConvertResVO.getBody().setTransactionId(trId);
				imageConvertResVO.getBody().setAdminCode(adCd);
				out.write(commonService.returnStringIfIh002(imageConvertResVO));
				return;
			}
			if(reqVO.getBody().getSizeList() != null)
				logger.debug("IH-002 SIZE LIST = "+reqVO.getBody().getSizeList().size());
			if(reqVO.getBody().getFileList() != null)
				logger.debug("IH-002 FILE LIST = "+reqVO.getBody().getFileList().size());
			
			/** 4. 이미지 저장 & 디비이력 추가	*/
			imageConvertResVO = imageConvProcService.requestIh002(reqVO);
			imageConvertResVO.getBody().setTransactionId(trId);
			imageConvertResVO.getBody().setAdminCode(adCd);
			out.write(commonService.returnStringIfIh002(imageConvertResVO));
			
			logger.debug("IH-002 EN\n");
			
		} catch (Exception e) {
			logger.error(e);
			IfIh002DataResVO imageConvertResVO = commonService.setIfIh002ResponseErrorVO("IH01999", e.getMessage());
			imageConvertResVO.getBody().setTransactionId(trId);
			imageConvertResVO.getBody().setAdminCode(adCd);
			out.write(commonService.returnStringIfIh002(imageConvertResVO));
		} finally {
			if(out != null) {
				out.flush();
				out.close();
			}
		}
		
	}
	
}