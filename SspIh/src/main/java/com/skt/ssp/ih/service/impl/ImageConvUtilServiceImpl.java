package com.skt.ssp.ih.service.impl;

import java.io.File;
import java.io.FileFilter;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skt.ssp.ih.dao.ImageConvertDAO;
import com.skt.ssp.ih.service.CommonService;
import com.skt.ssp.ih.service.ImageConvUtilService;
import com.skt.ssp.ih.util.FileProcUtil;
import com.skt.ssp.ih.util.ImageProcUtil;
import com.skt.ssp.ih.vo.imageConvert.IfIh001BodyFileResVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh001BodyUrlResVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002BodyFileReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002BodyReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002BodySizeReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002DataReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002DataResVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh003BodyFileReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh003BodyUrlReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIhConvInfoDbVO;
import com.skt.ssp.ih.vo.imageConvert.IfIhConvReqInfoDbVO;

/**
 * ImageConvUtilServiceImpl (ImageConvUtilServiceImpl)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: ImageConvUtilServiceImpl.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin  Express $
 */
@Service("imageConvUtilService")
public class ImageConvUtilServiceImpl implements ImageConvUtilService {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private ImageProcUtil imageProcUtil;
	@Autowired
	private FileProcUtil fileProcUtil;
	@Autowired
	private ImageConvertDAO imageConvertDAO;
	
	public ImageConvUtilServiceImpl() { }

	@PostConstruct
	public void init() throws Exception {
		imageProcUtil.setConvertTool(commonService.getConvertTool());
		if(fileProcUtil.makeDirectory(commonService.getSrcDir())==3)	{ logger.debug("[디렉토리 생성 실패] " + commonService.getSrcDir()); return; }
		if(fileProcUtil.makeDirectory(commonService.getTempDir())==3)	{ logger.debug("[디렉토리 생성 실패] " + commonService.getTempDir()); return; }
		if(fileProcUtil.makeDirectory(commonService.getDescDir())==3)	{ logger.debug("[디렉토리 생성 실패] " + commonService.getDescDir()); return; }
	}

	@PreDestroy
	public void destroy() throws Exception { }
	
	@Override
	public IfIh002DataResVO addReqIh002Db(IfIh002DataReqVO reqVO) {
		IfIh002BodyReqVO body = reqVO.getBody();
		/** 1. size가 0인 경우 디폴드 한개 만들어 줌 */
		if(body.getSizeList() == null || body.getSizeList().size() == 0) {
			body.setSizeList(new ArrayList<IfIh002BodySizeReqVO>());
			body.getSizeList().add(new IfIh002BodySizeReqVO());
		}
		int cnt = 0;
		String reqConvId = commonService.getConvId();
		/** 2. DB INSERT */
		for(int i = 0; i < body.getFileList().size(); i++) {
			IfIh002BodyFileReqVO fileVO = body.getFileList().get(i);
			for(int j = 0; j < body.getSizeList().size(); j++) {
				IfIh002BodySizeReqVO sizeVO = body.getSizeList().get(j);
				IfIhConvReqInfoDbVO dbVO = new IfIhConvReqInfoDbVO();
				dbVO.setReqConvId(reqConvId);
				dbVO.setConvFileSeq(commonService.getFileSeqId(++cnt));
				dbVO.setTransactionId(body.getTransactionId());
				dbVO.setAdminCode(body.getAdminCode());
				dbVO.setOsVerCd(sizeVO.getReqDevCd());
				dbVO.setConvReqSysCd(body.getConvReqSysCd());
				dbVO.setConvOrigFileNm(fileVO.getImgUrl());
				dbVO.setImageResolution(sizeVO.getImgSize());
				dbVO.setKeyVal(fileVO.getKeyVal());
				dbVO.setConvReqDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(body.getConvReqDt(), new ParsePosition(0))));
				dbVO.setConvEndDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
				dbVO.setConvResultCd(commonService.getConversionCode());
				addImageConvertReqInfo(dbVO);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return commonService.setIfIh002ResponseVO("SUCCESS");
	}
	
	@Override
	public void addImageConvertInfo(IfIhConvInfoDbVO ifIhDbVO) {
		imageConvertDAO.addImageConvertInfo(ifIhDbVO);
	}
	
	@Override
	public void updateImageConvertInfo(IfIhConvInfoDbVO ifIhDbVO) {
		imageConvertDAO.updateImageConvertInfo(ifIhDbVO);
	}
	
	@Override
	public void addImageConvertReqInfo(IfIhConvReqInfoDbVO ifIhDbVO) {
		imageConvertDAO.addImageConvertReqInfo(ifIhDbVO);
	}
	
	@Override
	public void updateImageConvertReqInfo(IfIhConvReqInfoDbVO ifIhDbVO) {
		imageConvertDAO.updateImageConvertReqInfo(ifIhDbVO);
	}
	
	@Override
	public List<String> selectReqConvIds() {
		return imageConvertDAO.selectReqConvIds();
	}
	
	@Override
	public List<IfIhConvReqInfoDbVO> selectImgConvReqInfos(String reqConvId) {
		return imageConvertDAO.selectImgConvReqInfos(reqConvId);
	}
	
	@Override
	public String getDownTempImgPath(String path) {
		return getDownTempImgPath("", path);
	}
	
	@Override
	public String getDownTempImgPath(String subPath, String path) {
		return getDownTempImgPath(subPath, "", path);
	}
	
	@Override
	public String getDownTempImgPath(String subPath, String no, String path) {
		String imgPath = "";
		try {
			logger.debug("getDownTempImgPath ST");
			if("".equals(StringUtils.stripToEmpty(subPath))) imgPath = commonService.getTempDir(); 
			else imgPath = commonService.getTempDir() + subPath + "/";
			if(!"".equals(no)) imgPath = imgPath + no + "/";
			if(!fileProcUtil.isExistDirectory(imgPath)) fileProcUtil.makeDirectory(imgPath);
			String fileName = fileProcUtil.getFileName(path);
			if(!fileProcUtil.isExistFile(imgPath + fileName)) {
				File f = new File(imgPath + fileName);
				f.createNewFile();
			}
			imgPath = imgPath + fileName;
			logger.debug("imgPath="+imgPath);
			logger.debug("getDownTempImgPath EN\n");
		} catch (Exception e) {
			logger.error(e);
		}
		return imgPath;
	}
	
	@Override
	public String getImgPath(String imgFile, String adminCode, String reqDevCd, String path) {
		String imgPath = "";
		try {
			logger.debug("getImgPath ST");
			imgPath = commonService.getSrcDir() + adminCode + "/" + commonService.getDeviceStr(reqDevCd) + "/";
			if(!fileProcUtil.isExistDirectory(imgPath)) fileProcUtil.makeDirectory(imgPath);
			String fileName = fileProcUtil.getFileName(path);
			if(fileProcUtil.isExistFile(imgPath + fileName)) {
				int i = 0;
				while(true) {
					fileName = fileProcUtil.getNextFileName(fileProcUtil.getFileName(path), String.valueOf(i));
					if(!fileProcUtil.isExistFile(imgPath + fileName)) {
						File f = new File(imgPath + fileName);
						f.createNewFile();
						break;
					}
					i++;
					Thread.sleep(1);
				}
			}
			imgPath += fileName;
			if(!fileProcUtil.copyFile(imgFile, imgPath)) {
				imgPath = "";
			}
			logger.debug("imgPath="+imgPath);
			logger.debug("getImgPath EN\n");
		} catch (Exception e) {
			logger.error(e);
		}
		return imgPath;
	}
	
	@Override
	public String getImgPath2(String imgFile, String adminCode, String reqDevCd, String path) {
		String imgPath = "";
		try {
			logger.debug("getImgPath2 ST");
			imgPath = commonService.getSrcDir() + adminCode + "/" + commonService.getDeviceStr(reqDevCd) + "/";
			if(!fileProcUtil.isExistDirectory(imgPath)) fileProcUtil.makeDirectory(imgPath);
			String fileName = fileProcUtil.getFileName(path);
			final String nm = StringUtils.substring(fileName, 0, fileName.lastIndexOf("."));
			File f = new File(imgPath);
			File[] flist = f.listFiles(new FileFilter() {
				@Override
				public boolean accept(File pathname) {
					if(pathname.isFile()) {
						return pathname.getName().startsWith(nm);
					}
					return false;
				}
			});
			if(flist.length > 0) {
				fileName = fileProcUtil.getNextFileName(fileProcUtil.getFileName(path), String.valueOf(flist.length));
			}
			imgPath += fileName;
			if(!fileProcUtil.copyFile(imgFile, imgPath)) {
				imgPath = "";
			}
			logger.debug("imgPath="+imgPath);
			logger.debug("getImgPath2 EN\n");
		} catch (Exception e) {
			logger.error(e);
		}
		return imgPath;
	}
	
	@Override
	public String getTempImgPath(String imgPath) {
		logger.debug("getTempImgPath ST");
		String fileType = fileProcUtil.getExtension(imgPath);
		String tempFile = commonService.getTempDir() + commonService.getFileId();
		if(!"".equals(fileType)) tempFile += "." + fileType;
		fileProcUtil.copyFile(imgPath, tempFile);
		logger.debug("tempFile="+tempFile);
		logger.debug("getTempImgPath EN\n");
		return tempFile;
	}
	
	@Override
	public String getConvImgPath(String adminCode, String reqDevCd, String fileType) {
		logger.debug("getConvImgPath ST");
		String covFilePath = commonService.getDescDir() + adminCode + "/" + commonService.getDeviceStr(reqDevCd) + "/";
		if(!fileProcUtil.isExistDirectory(covFilePath)) fileProcUtil.makeDirectory(covFilePath);
		if("".equals(fileType)) covFilePath += commonService.getFileId();
		else covFilePath += commonService.getFileId() + "." + fileType;
		logger.debug("covFilePath="+covFilePath);
		logger.debug("getConvImgPath EN\n");
		return covFilePath;
	}
	
	@Override
	public boolean imageConvert(String imgPath, String covFilePath, String imgSize) {
		logger.debug("imageConvert ST");
		boolean retVal = true;
		int ret = imageProcUtil.makeThumbnail(imgPath, covFilePath, commonService.getDeviceImgSize(imgSize));
		fileProcUtil.deleteFile(imgPath);
		if(ret == 1) retVal = false;
		logger.debug("imageConvert EN\n");
		return retVal;
	}
	
	@Override
	public IfIh001BodyFileResVO createIfIh001ResFileVO(String keyVal) {
		IfIh001BodyFileResVO resFileVO = new IfIh001BodyFileResVO();
		resFileVO.setKeyVal(keyVal);
		resFileVO.setUrlList(new ArrayList<IfIh001BodyUrlResVO>());
		return resFileVO;
	}
	
	@Override
	public IfIh001BodyUrlResVO createIfIh001ResUrlVO(String reqDevCd){
		IfIh001BodyUrlResVO resUrlVO = new IfIh001BodyUrlResVO();
		resUrlVO.setReqDevCd(reqDevCd);
		resUrlVO.setResultCode("SUCCESS");
		resUrlVO.setResultMsg("SUCCESS");
		return resUrlVO;
	}
	
	@Override
	public IfIh003BodyFileReqVO createIfIh003ReqFileVO(String keyVal) {
		IfIh003BodyFileReqVO resFileVO = new IfIh003BodyFileReqVO();
		resFileVO.setKeyVal(keyVal);
		resFileVO.setUrlList(new ArrayList<IfIh003BodyUrlReqVO>());
		return resFileVO;
	}
	
	@Override
	public IfIh003BodyUrlReqVO createIfIh003ReqUrlVO(String reqDevCd){
		IfIh003BodyUrlReqVO resUrlVO = new IfIh003BodyUrlReqVO();
		resUrlVO.setReqDevCd(reqDevCd);
		resUrlVO.setResultCode("SUCCESS");
		resUrlVO.setResultMsg("SUCCESS");
		return resUrlVO;
	}
	
	@Override
	public IfIhConvInfoDbVO getDbVO(String adminCode, String userId,
			String transactionId, String keyVal, String img, String confIng,
			String convImg, String imgUrl, String osType, String reqSysCd,
			String resultCode, String convReqDt) {
		IfIhConvInfoDbVO ifIh001DbVO = new IfIhConvInfoDbVO();
		ifIh001DbVO.setConvId(StringUtils.stripToEmpty(commonService.getConvId()));
		ifIh001DbVO.setAdminCode(StringUtils.stripToEmpty(adminCode));
		ifIh001DbVO.setUserId(StringUtils.stripToEmpty(userId));
		ifIh001DbVO.setTransactionId(transactionId);
		ifIh001DbVO.setKeyVal(keyVal);
		ifIh001DbVO.setOsVerCd(StringUtils.stripToEmpty(osType));
		ifIh001DbVO.setConvReqSysCd(StringUtils.stripToEmpty(reqSysCd));
		ifIh001DbVO.setConvOrigFileNm(StringUtils.stripToEmpty(img));
		ifIh001DbVO.setConfIngFileNm(StringUtils.stripToEmpty(confIng));
		ifIh001DbVO.setConvEndFileNm(StringUtils.stripToEmpty(convImg));
		ifIh001DbVO.setConvReqFileTypeCd(StringUtils.stripToEmpty(fileProcUtil.getExtension(confIng)));
		ifIh001DbVO.setConvEndFileTypeCd(StringUtils.stripToEmpty(fileProcUtil.getExtension(convImg)));
		ifIh001DbVO.setConvEndFileSize(StringUtils.stripToEmpty(fileProcUtil.getFileSize(convImg)));
		ifIh001DbVO.setImageServiceUrl(StringUtils.stripToEmpty(imgUrl));
		ifIh001DbVO.setConvReqDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(convReqDt, new ParsePosition(0))));
		ifIh001DbVO.setConvEndDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		ifIh001DbVO.setConvResultCd(StringUtils.stripToEmpty(resultCode));
		ifIh001DbVO.setInsertId(StringUtils.stripToEmpty(userId));
		logger.debug("ifIh001DbVO="+ifIh001DbVO);
		return ifIh001DbVO;
	}
	
}