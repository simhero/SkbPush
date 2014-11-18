package com.skt.ssp.gw.web.controller;


import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * AppUploadController (AppUploadController)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: AppUploadController.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Controller
public class AppUploadController {
	protected final Log logger = LogFactory.getLog(getClass());
	
	@RequestMapping("/appUpload.do")
	public @ResponseBody String appUpload(@RequestParam("appFile") MultipartFile appFile) {
		String retStr = "";
		
		try {
			
			logger.debug("FileName="+appFile.getOriginalFilename());
			logger.debug("FIleSize="+appFile.getSize());
			
			String dir = "/home/ssp/download/";
			logger.debug("SaveFile="+dir+appFile.getOriginalFilename());
			File saveFile = new File(dir+appFile.getOriginalFilename());
			if(saveFile.isFile()) {
				saveFile.delete();
			}
			appFile.transferTo(saveFile);
			
			retStr = "{\"result\":\"10\",\"url\":\"http://1.234.6.184:8080/sspGw/download/"+appFile.getOriginalFilename()+"\"}";
			
		} catch (Exception e) {
			logger.debug(e);
			retStr = "{\"result\":\"20\"}";
		}
		
		return retStr;
	}
}