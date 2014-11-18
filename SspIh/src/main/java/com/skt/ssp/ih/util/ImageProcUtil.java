package com.skt.ssp.ih.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * ImageProcUtil
 *
 * @author Young-Joo, Kim
 * @author <a href="mailto:youngjookim@in-sprit.com">Young-Joo, Kim</a>
 * @version $Id: ImageProcUtil.java,v 1.0 2011/10/14 00:00:00 Young-Joo, Kim Express $
 */
@Component
public class ImageProcUtil {
	protected final Log logger = LogFactory.getLog(getClass());

	//ImageMagick convert tool 위치
	private String convertTool;
	//이미지 사이즈 조정시 실행 옵션
	private static final String commandStr1 = "-resize";
	private static final String commandStr2 = "-quality";
	
	public ImageProcUtil() {
//		convertTool = "C:\\Program Files\\ImageMagick-6.2.8-Q16\\convert.exe";
	}
	
	public ImageProcUtil(String convertTool) {
		this.convertTool = convertTool;
	}
	
	public ImageProcUtil(String convertTool, String srcFileParentPath, String destFileParentPath) {
		this.convertTool = convertTool;
	}
	
	public String getConvertTool() {
		return convertTool;
	}

	public void setConvertTool(String convertTool) {
		this.convertTool = convertTool;
	}
	
	// 복수의 썸네일 이미지 생성
	public int makeThumbnails(int count, String[] srcImg, String[] destImg, String[] imgSize){

		logger.debug("[START] public int makeThumbnails(int count, String[] srcImg, String[] destImg, String[] imgSize)");

		int status = 0; // 0 : success
		
		for(int i=0; i<count; i++)
		{
			status += makeThumbnail(srcImg[i], destImg[i], imgSize[i]);
		}
		
		logger.debug("[END] public int makeThumbnails(int count, String[] srcImg, String[] destImg, String[] imgSize)\n");
		
		return status;
	}
	
	//1개의 썸네일 이미지 생성
	public int makeThumbnail(String srcImg, String destImg, String imgSize){

		logger.debug("[START] public int makeThumbnail(String srcImg, String destImg, String imgSize)");
		logger.debug(" srcImg = " + srcImg);
		logger.debug(" destImg = " + destImg);
		logger.debug(" imgSize = " + imgSize);
		
		int status = 0;

		String[] cmd = new String[7];
		cmd[0] = convertTool;
		cmd[1] = commandStr1;
		cmd[2] = imgSize;
		cmd[3] = commandStr2;
		cmd[4] = "100";
		cmd[5] = srcImg;
		cmd[6] = destImg;
		
		boolean isExist = false;
		
		FileProcUtil fileUtil = new FileProcUtil();
		isExist = fileUtil.isExistFile(srcImg);
		
		if(isExist)
		{
			try
			{
				Process proc = Runtime.getRuntime().exec(cmd);
				status = proc.waitFor();
			}
			catch (Exception ex)
			{
				logger.debug("[ERROR] : ");
				logger.debug(ex.toString());
			} 
		}
		else
		{
			logger.debug("[존재하지 않는 파일] " + srcImg);
			status = 1;
		}

		logger.debug("[END] public int makeThumbnail(String srcImg, String destImg, String imgSize)\n");
		return status;
	}
}
