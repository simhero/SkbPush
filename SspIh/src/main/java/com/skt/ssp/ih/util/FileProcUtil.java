package com.skt.ssp.ih.util;

/**
 * FileProcUtil
 *
 * @author Young-Joo, Kim
 * @author <a href="mailto:youngjookim@in-sprit.com">Young-Joo, Kim</a>
 * @version $Id: FileProcUtil,v 1.0 2011/10/14 00:00:00 Young-Joo, Kim Express $
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * FileProcUtil
 *
 * @author Young-Joo, Kim
 * @author <a href="mailto:youngjookim@in-sprit.com">Young-Joo, Kim</a>
 * @version $Id: FileProcUtil.java,v 1.0 2011/10/14 00:00:00 Young-Joo, Kim Express $
 */
@Component
public class FileProcUtil {
	protected final Log logger = LogFactory.getLog(getClass());

	private static final int EXIST_FOLDER = 1;
	private static final int SUCCESS_CREATE_FOLDER = 2;
	private static final int FAIL_CREATE_FOLDER = 3;
	
	public FileProcUtil() {}

	public boolean isExistFile(String fileName)
	{
		logger.debug("[START] public boolean isExistFile(String fileName)");

		boolean returnVal = false;
		
		File f = new File(fileName);

		if (f.isFile()) {
			logger.debug("존재하는 파일 : " + fileName);
			returnVal = true;
		} else {
			logger.debug("존재하지 않는 파일 : " + fileName);
			returnVal = false;
		}
		
		logger.debug("[END] public boolean isExistFile(String fileName)\n");
		return returnVal;
	}
	
	public String getNotExistFileName(String fileName)
	{
		logger.debug("[START] public String getNotExistFileName(String fileName)");
		logger.debug("fileName = " + fileName);

		String uniqueFileName = fileName;
		String strExtension = getExtension(fileName);
		
		if(isExistFile(fileName))
		{
			int i=1;
			int period = uniqueFileName.indexOf('.');
			uniqueFileName = uniqueFileName.substring(0, period) + "_" + i + "." + strExtension;
			
			while(true) {
				if(isExistFile(uniqueFileName))
				{
					i++;
					uniqueFileName = uniqueFileName.substring(0, period) + "_" + i + "." + strExtension;
				}
				else
					break;
			}
		}
		
		logger.debug("uniqueFileName = " + uniqueFileName);
		logger.debug("[END] public String getNotExistFileName(String fileName)\n");

		return uniqueFileName;
	}
	
	public String getExtension(String fileName)
	{
		logger.debug("[START] public String getExtension(String fileName)");
		logger.debug("fileName = " + fileName);

		String strExtension = "";
		int period = fileName.lastIndexOf(".");
		if(period == -1) strExtension = "";
		else strExtension = fileName.substring(period+1);

		logger.debug("strExtension = " + strExtension);
		logger.debug("[END] public String getExtension(String fileName)\n");
		return strExtension;
	}
	
	public String getFileSize(String fileName) {
		logger.debug("[START] public String getFileSize(String fileName)");
		long size = 0;
		File d = new File(fileName);
		if (d.exists()) {
			size = d.length();
			logger.debug("FILE SIZE = "+size);
		} else {
			logger.debug("FILE NOT FOUND");
		}
		logger.debug("[END] public String getFileSize(String fileName)\n");
		return String.valueOf(size);
	}
	
	public String getFileName(String url) {
		logger.debug("[START] public String getFileName(String url)");
		String fileName = "";
		int period = url.lastIndexOf("/");
		if(period == -1) fileName = "";
		else fileName = url.substring(period+1);
		logger.debug("[END] public String getFileName(String url)\n");
		return fileName;
	}
	
	public String getNextFileName(String file, String cnt) {
		logger.debug("[START] public String getNextFileName(String file, String cnt)");
		String fileName = "";
		int period = file.lastIndexOf(".");
		if(period == -1) fileName = file + "_" + cnt;
		else fileName = file.substring(0, period) + "_" + cnt + file.substring(period);
		logger.debug("[END] public String getNextFileName(String file, String cnt)\n");
		return fileName;
	}

	public boolean isExistDirectory(String fileName)
	{
		logger.debug("[START] public boolean isExistDirectory(String fileName)");

		boolean returnVal = false;
		
		File d = new File(fileName);

		if (d.isDirectory()) {
			logger.debug("존재하는 디렉토리 : " + fileName);
			returnVal = true;
		} else {
			logger.debug("존재하지 않는 디렉토리 : " + fileName);
			returnVal = false;
		}
		
		logger.debug("[END] public boolean isExistDirectory(String fileName)\n");
		return returnVal;
	}
	
	public boolean deleteFile(String fileName)
	{
		logger.debug("[START] public boolean deleteFile(String fileName)");

		boolean returnVal = true;
		File f = new File(fileName);
		returnVal = f.delete();
		
		logger.debug("[END] public boolean deleteFile(String fileName)\n");
		return returnVal;
	}
	
	public boolean copyFile(String inFileName, String outFileName)
	{
		logger.debug("[START] public boolean copyFile(String inFileName, String outFileName)");
		logger.debug("inFileName = " + inFileName);
		logger.debug("outFileName = " + outFileName);

		boolean returnVal = true;

		try {
			FileInputStream fis = new FileInputStream(inFileName);
			FileOutputStream fos = new FileOutputStream(outFileName);
			
			int data = 0;
			while((data=fis.read())!=-1)
			{
				fos.write(data);
			}
			
			fis.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			logger.error(e);
			returnVal = false;
		} catch (IOException e) {
			logger.error(e);
			returnVal = false;
		}
		
		logger.debug("[END] public boolean copyFile(String inFileName, String outFileName)\n");
		return returnVal;
	}
	
	public boolean moveFile(String inFileName, String outFileName)
	{
		logger.debug("[START] public boolean moveFile(String inFileName, String outFileName)");
		logger.debug("inFileName = " + inFileName);
		logger.debug("outFileName = " + outFileName);

		boolean returnVal = true;

		try {
			FileInputStream fis = new FileInputStream(inFileName);
			FileOutputStream fos = new FileOutputStream(outFileName);
			
			int data = 0;
			while((data=fis.read())!=-1)
			{
				fos.write(data);
			}
			
			fis.close();
			fos.close();
			
			deleteFile(inFileName);
			
		} catch (FileNotFoundException e) {
			logger.error(e);
			returnVal = false;
		} catch (IOException e) {
			logger.error(e);
			returnVal = false;
		}
		
		logger.debug("[END] public boolean moveFile(String inFileName, String outFileName)\n");
		return returnVal;
	}

	public List<File> getDirFileList(String dirPath)
	{
		logger.debug("[START] public List<File> getDirFileList(String dirPath)");
		logger.debug("dirPath = " + dirPath);

		List<File> dirFileList = null;
		
		File dir = new File(dirPath);
		
		if(dir.exists())
		{
			File[] files = dir.listFiles();
			
			dirFileList = Arrays.asList(files);
		}
		
		logger.debug("[END] public List<File> getDirFileList(String dirPath)\n");
		return dirFileList;
	}
	
	public int makeDirectory(String dirPath)
	{
		logger.debug("[START] public int makeDirectory(String dirPath)");
		logger.debug("dirPath = " + dirPath);
		
		int returnVal = EXIST_FOLDER;
		
		if(isExistDirectory(dirPath)){
			returnVal = EXIST_FOLDER;
		}
		else
		{
			File f = new File(dirPath);
		    if (f.mkdirs())
		    {
				returnVal = SUCCESS_CREATE_FOLDER;
				logger.debug("[디렉토리 생성] " + dirPath);
		    }
		    else
		    {
				returnVal = FAIL_CREATE_FOLDER;
				logger.debug("[디렉토리 생성 실패] " + dirPath);
		    }
		}
		
		logger.debug("[END] public int makeDirectory(String dirPath)\n");
		
		return returnVal;
	}
}
