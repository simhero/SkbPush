package com.skt.ssp.ih.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skt.ssp.ih.adapter.DbpImgDownloader;
import com.skt.ssp.ih.adapter.DbpMsgSender;
import com.skt.ssp.ih.parse.ImageConvertDbpMsgReader;
import com.skt.ssp.ih.service.CommonService;
import com.skt.ssp.ih.service.ImageConvProcService;
import com.skt.ssp.ih.service.ImageConvUtilService;
import com.skt.ssp.ih.util.FileProcUtil;
import com.skt.ssp.ih.vo.imageConvert.IfIh001BodyFileReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh001BodyFileResVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh001BodyReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh001BodyResVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh001BodySizeReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh001BodyUrlResVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh001DataReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh001DataResVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002BodyFileReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002BodyReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002BodySizeReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002DataReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002DataResVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh003BodyFileReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh003BodyReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh003BodyUrlReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh003DataReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh003DataResVO;
import com.skt.ssp.ih.vo.imageConvert.IfIhConvInfoDbVO;
import com.skt.ssp.ih.vo.imageConvert.IfIhConvReqInfoDbVO;

/**
 * ImageConvProcServiceImpl (ImageConvProcServiceImpl)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: ImageConvProcServiceImpl.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin  Express $
 */
@Service("imageConvProcService")
public class ImageConvProcServiceImpl implements ImageConvProcService {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CompositeConfiguration config;
	@Autowired
	private CommonService commonService;
	@Autowired
	private FileProcUtil fileProcUtil;
	@Autowired
	private DbpImgDownloader dbpImgDownloader;
	@Autowired
	private ImageConvUtilService imageConvUtilService;
//	@Autowired
//	private IhTaskExecutor ihTaskExecutor;
	@Autowired
	private DbpMsgSender dbpMsgSender;
	@Autowired
	private ImageConvertDbpMsgReader imageConvertDbpMsgReader;
	
	private static int svcDirNo = 1;
	private static int svcDirThreadNo = 1;
	private static int svcDirDaemonNo = 1;
	
	public ImageConvProcServiceImpl() { }

	@PostConstruct
	public void init() throws Exception { }

	@PreDestroy
	public void destroy() throws Exception { }
	
	@Override
	public CompositeConfiguration getConfiguration() {
		return config;
	}

	@Override
	public CommonService getCommonService() {
		return commonService;
	}
	
	@Override
	public ImageConvUtilService getImageConvUtilService() {
		return imageConvUtilService;
	}
	
	/**
	 * web 에서 사용
	 */
	@Override
	public IfIh001DataResVO requestIh001(IfIh001DataReqVO reqVO) throws Exception {
		IfIh001BodyReqVO body = reqVO.getBody();
		
		/** 1. size가 0인 경우 디폴드 한개 만들어 줌 */
		if(body.getSizeList() == null || body.getSizeList().size() == 0) {
			body.setSizeList(new ArrayList<IfIh001BodySizeReqVO>());
			body.getSizeList().add(new IfIh001BodySizeReqVO());
		}
		
		/** 2. RESPONSE VO */
		IfIh001DataResVO resDataVO = commonService.setIfIh001ResponseVO("SUCCESS");
		
		/** 3. RESPONSE BODY VO */
		IfIh001BodyResVO resBodyVO = resDataVO.getBody();
		resBodyVO.setFileList(new ArrayList<IfIh001BodyFileResVO>());
		
		/** 4. FILE 갯수만큼 로직 실행 */
		for(int i = 0; i < body.getFileList().size(); i++) {
			/** RESPONSE file VO */
			IfIh001BodyFileResVO resFileVO = addIfIh001ImgFile(body, body.getFileList().get(i));
			resBodyVO.getFileList().add(resFileVO);
			
			Thread.sleep(10);
		}
		return resDataVO;
	}
	
	private IfIh001BodyFileResVO addIfIh001ImgFile(IfIh001BodyReqVO body, IfIh001BodyFileReqVO fileVO) throws Exception {
		/** 1. RESPONSE file VO */
		IfIh001BodyFileResVO resFileVO = imageConvUtilService.createIfIh001ResFileVO(fileVO.getKeyVal());
		
		/** 2. 원본 이미지 다운로드 & SIZE 갯수만큼 저장 로직 실행	*/
		if(svcDirNo == 20) svcDirNo = 1;
		String imgFile = imageConvUtilService.getDownTempImgPath("WEB", String.valueOf(svcDirNo++), fileVO.getImgUrl());
		boolean isDownload = dbpImgDownloader.download(fileVO.getImgUrl(), imgFile);
		for(int j = 0; j < body.getSizeList().size(); j++) {
			if(isDownload) {
				/** 3. 파일 다운로드 성공, 이미지 변환 & 디비 이력추가 */
				IfIh001BodyUrlResVO resUrlVO = addIhIf001SizeFile(body, fileVO, body.getSizeList().get(j), imgFile);
				resFileVO.getUrlList().add(resUrlVO);
			} else {
				/** 3. 파일 다운로드 실패, 디비 이력추가 */
				IfIh001BodyUrlResVO resUrlVO = setIfIh001DownloadError(body, fileVO, body.getSizeList().get(j));
				resFileVO.getUrlList().add(resUrlVO);
			}
			
			Thread.sleep(10);
		}
		
		/** 임시파일 제거 */
		fileProcUtil.deleteFile(imgFile);
		return resFileVO;
	}
	
	private IfIh001BodyUrlResVO addIhIf001SizeFile(IfIh001BodyReqVO body, IfIh001BodyFileReqVO fileVO, IfIh001BodySizeReqVO sizeVO, String imgFile) throws Exception {

		/** RESPONSE URL VO */
		IfIh001BodyUrlResVO resUrlVO = imageConvUtilService.createIfIh001ResUrlVO(sizeVO.getReqDevCd());
		
		/** 1. 원본 이미지 저장	*/
		String imgPath = imageConvUtilService.getImgPath(imgFile, body.getAdminCode(), sizeVO.getReqDevCd(), fileVO.getImgUrl());
		String imgFileUrl = "";
		String covFilePath = "";
		if("".equals(imgPath)) {
			commonService.setErrorResUrlCode(resUrlVO, "IH01902");
		} else {
			/** 2. 임시 파일 생성				*/
			String tempFile = imageConvUtilService.getTempImgPath(imgPath);
			
			/** 3. 이미지 변환	 & 저장			*/
			covFilePath = imageConvUtilService.getConvImgPath(body.getAdminCode(), sizeVO.getReqDevCd(), fileProcUtil.getExtension(tempFile));
			if(!imageConvUtilService.imageConvert(tempFile, covFilePath, sizeVO.getImgSize())) {
				commonService.setErrorResUrlCode(resUrlVO, "IH01903");
			} else {
				/** IMG WEB URL */
				imgFileUrl = commonService.getImgUrl() + body.getAdminCode() + "/" + commonService.getDeviceStr(sizeVO.getReqDevCd()) + "/" + fileProcUtil.getFileName(covFilePath);
			}
		}
		
		Thread.sleep((int)(1000*config.getFloat("FILE_SIZE_READ_SLEEP_SEC")));
		
		/** 4. 디비 이력 추가				*/
		IfIhConvInfoDbVO ifIh001DbVO = 
			imageConvUtilService.getDbVO(body.getAdminCode(), body.getUserId(), "", fileVO.getKeyVal(), fileVO.getImgUrl(), imgPath, covFilePath, 
					imgFileUrl, sizeVO.getReqDevCd(), body.getConvReqSysCd(), resUrlVO.getResultCode(), body.getConvReqDt());
		try {
			imageConvUtilService.addImageConvertInfo(ifIh001DbVO);
		} catch (Exception e) {
			commonService.setErrorResUrlCode(resUrlVO, "IH01905");
			logger.error(e);
		}
		
		resUrlVO.setImgUrl(imgFileUrl);
		
		return resUrlVO;
	}
	
	private IfIh001BodyUrlResVO setIfIh001DownloadError(IfIh001BodyReqVO body, IfIh001BodyFileReqVO fileVO, IfIh001BodySizeReqVO sizeVO) {
		IfIh001BodyUrlResVO resUrlVO = new IfIh001BodyUrlResVO();
		resUrlVO.setReqDevCd(sizeVO.getReqDevCd());
		commonService.setErrorResUrlCode(resUrlVO, "IH01901");
		/** 4. 디비 이력 추가				*/
		IfIhConvInfoDbVO ifIh001DbVO = 
			imageConvUtilService.getDbVO(body.getAdminCode(), body.getUserId(), "", fileVO.getKeyVal(), fileVO.getImgUrl(), "", "", 
					"", sizeVO.getReqDevCd(), body.getConvReqSysCd(), resUrlVO.getResultCode(), body.getConvReqDt());
		try {
			imageConvUtilService.addImageConvertInfo(ifIh001DbVO);
		} catch (Exception e) {
			logger.error(e);
			commonService.setErrorResUrlCode(resUrlVO, "IH01905");
		}
		return resUrlVO;
	}
	
	/*
	@Override
	public IfIh002DataResVO requestIh002(IfIh002DataReqVO reqVO) throws Exception {
		// Queue
		ihTaskExecutor.procStart(reqVO);
		return commonService.setIfIh002ResponseVO("SUCCESS");
	}
	*/
	
	/**
	 * web 에서 사용
	 */
	@Override
	public IfIh002DataResVO requestIh002(IfIh002DataReqVO reqVO) throws Exception {
		// Daemon
		return imageConvUtilService.addReqIh002Db(reqVO);
	}
	
	/**
	 * web thread 에서 사용
	 */
	@Override
	public IfIh003DataReqVO requestIh002ThreadProc(IfIh002DataReqVO reqVO) {
		IfIh002BodyReqVO body = reqVO.getBody();
		
		/** 1. size가 0인 경우 디폴드 한개 만들어 줌 */
		if(body.getSizeList() == null || body.getSizeList().size() == 0) {
			body.setSizeList(new ArrayList<IfIh002BodySizeReqVO>());
			body.getSizeList().add(new IfIh002BodySizeReqVO());
		}
		
		/** 2. RESPONSE VO */
		IfIh003DataReqVO reqDataVO = commonService.setIfIh003RequestVO("SUCCESS");
		
		/** 3. RESPONSE BODY VO */
		IfIh003BodyReqVO reqBodyVO = reqDataVO.getBody();
		reqBodyVO.setFileList(new ArrayList<IfIh003BodyFileReqVO>());
		
		/** 4. FILE 갯수만큼 로직 실행 */
		for(int i = 0; i < body.getFileList().size(); i++) {
			/** RESPONSE file VO */
			IfIh003BodyFileReqVO resFileVO = addIfIh002ImgFile(body, body.getFileList().get(i));
			reqBodyVO.getFileList().add(resFileVO);
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				logger.error(e);
			}
		}
		return reqDataVO;
	}
	
	private IfIh003BodyFileReqVO addIfIh002ImgFile(IfIh002BodyReqVO body, IfIh002BodyFileReqVO fileVO) {
		/** 1. RESPONSE file VO */
		IfIh003BodyFileReqVO reqFileVO = imageConvUtilService.createIfIh003ReqFileVO(fileVO.getKeyVal());
		try {
			/** 2. 원본 이미지 다운로드 & SIZE 갯수만큼 저장 로직 실행	*/
			if(svcDirThreadNo == 20) svcDirThreadNo = 1;
			String imgFile = imageConvUtilService.getDownTempImgPath("THREAD", String.valueOf(svcDirThreadNo++), fileVO.getImgUrl());
			boolean isDownload = dbpImgDownloader.download(fileVO.getImgUrl(), imgFile);;
			for(int j = 0; j < body.getSizeList().size(); j++) {
				if(isDownload) {
					/** 3. 파일 다운로드 성공, 이미지 변환 & 디비 이력추가 */
					IfIh003BodyUrlReqVO resUrlVO = addIfIh002SizeFile(body, fileVO, body.getSizeList().get(j), imgFile);
					reqFileVO.getUrlList().add(resUrlVO);
				} else {
					/** 3. 파일 다운로드 실패, 디비 이력추가 */
					IfIh003BodyUrlReqVO resUrlVO = setIfIh002DownloadError(body, fileVO, body.getSizeList().get(j));
					reqFileVO.getUrlList().add(resUrlVO);
				}
				
				Thread.sleep(50);
			}
			
			/** 임시파일 제거 */
			fileProcUtil.deleteFile(imgFile);
		} catch (Exception e) {
			logger.error(e);
			for(int j = reqFileVO.getUrlList().size(); j < body.getSizeList().size(); j++) {
				/** 3. 파일 다운로드 실패, 디비 이력추가 */
				IfIh003BodyUrlReqVO resUrlVO = setIfIh002SystemError(body, fileVO, body.getSizeList().get(j));
				reqFileVO.getUrlList().add(resUrlVO);
			}
		}
		return reqFileVO;
	}
	
	private IfIh003BodyUrlReqVO addIfIh002SizeFile(IfIh002BodyReqVO body, IfIh002BodyFileReqVO fileVO, IfIh002BodySizeReqVO sizeVO, String imgFile) {
		/** RESPONSE URL VO */
		IfIh003BodyUrlReqVO reqUrlVO = imageConvUtilService.createIfIh003ReqUrlVO(sizeVO.getReqDevCd());
		try {
			/** 1. 원본 이미지 저장	*/
			String imgPath = imageConvUtilService.getImgPath(imgFile, body.getAdminCode(), sizeVO.getReqDevCd(), fileVO.getImgUrl());
			String imgFileUrl = "";
			String covFilePath = "";
			if("".equals(imgPath)) {
				commonService.setErrorResUrlCode(reqUrlVO, "IH03902");
			} else {
				/** 2. 임시 파일 생성				*/
				String tempFile = imageConvUtilService.getTempImgPath(imgPath);
				
				/** 3. 이미지 변환	 & 저장			*/
				covFilePath = imageConvUtilService.getConvImgPath(body.getAdminCode(), sizeVO.getReqDevCd(), fileProcUtil.getExtension(tempFile));
				if(!imageConvUtilService.imageConvert(tempFile, covFilePath, sizeVO.getImgSize())) {
					commonService.setErrorResUrlCode(reqUrlVO, "IH03903");
				} else {
					/** IMG WEB URL */
					imgFileUrl = commonService.getImgUrl() + body.getAdminCode() + "/" + commonService.getDeviceStr(sizeVO.getReqDevCd()) + "/" + fileProcUtil.getFileName(covFilePath);
				}
			}
			
			Thread.sleep((int)(1000*config.getFloat("FILE_SIZE_READ_SLEEP_SEC")));
			
			/** 4. 디비 이력 추가				*/
			IfIhConvInfoDbVO ifIh002DbVO = 
				imageConvUtilService.getDbVO(body.getAdminCode(), "", body.getTransactionId(), fileVO.getKeyVal(), fileVO.getImgUrl(), imgPath, covFilePath, 
						imgFileUrl, sizeVO.getReqDevCd(), body.getConvReqSysCd(), reqUrlVO.getResultCode(), body.getConvReqDt());
			try {
				imageConvUtilService.addImageConvertInfo(ifIh002DbVO);
			} catch (Exception e) {
				commonService.setErrorResUrlCode(reqUrlVO, "IH03905");
				logger.error(e);
			}
			
			reqUrlVO.setImgUrl(imgFileUrl);
		} catch (Exception e) {
			logger.error(e);
			commonService.setErrorResUrlCode(reqUrlVO, "IH03999");
		}
		return reqUrlVO;
	}
	
	private IfIh003BodyUrlReqVO setIfIh002DownloadError(IfIh002BodyReqVO body, IfIh002BodyFileReqVO fileVO, IfIh002BodySizeReqVO sizeVO) {
		IfIh003BodyUrlReqVO reqUrlVO = new IfIh003BodyUrlReqVO();
		reqUrlVO.setReqDevCd(sizeVO.getReqDevCd());
		commonService.setErrorResUrlCode(reqUrlVO, "IH03901");
		/** 4. 디비 이력 추가				*/
		IfIhConvInfoDbVO ifIh002DbVO = 
			imageConvUtilService.getDbVO(body.getAdminCode(), "", body.getTransactionId(), fileVO.getKeyVal(), fileVO.getImgUrl(), "", "", 
					"", sizeVO.getReqDevCd(), body.getConvReqSysCd(), reqUrlVO.getResultCode(), body.getConvReqDt());
		try {
			imageConvUtilService.addImageConvertInfo(ifIh002DbVO);
		} catch (Exception e) {
			logger.error(e);
			commonService.setErrorResUrlCode(reqUrlVO, "IH03905");
		}
		return reqUrlVO;
	}
	
	private IfIh003BodyUrlReqVO setIfIh002SystemError(IfIh002BodyReqVO body, IfIh002BodyFileReqVO fileVO, IfIh002BodySizeReqVO sizeVO) {
		IfIh003BodyUrlReqVO reqUrlVO = new IfIh003BodyUrlReqVO();
		reqUrlVO.setReqDevCd(sizeVO.getReqDevCd());
		commonService.setErrorResUrlCode(reqUrlVO, "IH03999");
		/** 4. 디비 이력 추가				*/
		IfIhConvInfoDbVO ifIh002DbVO = 
			imageConvUtilService.getDbVO(body.getAdminCode(), "", body.getTransactionId(), fileVO.getKeyVal(), fileVO.getImgUrl(), "", "", 
					"", sizeVO.getReqDevCd(), body.getConvReqSysCd(), reqUrlVO.getResultCode(), body.getConvReqDt());
		try {
			imageConvUtilService.addImageConvertInfo(ifIh002DbVO);
		} catch (Exception e) {
			logger.error(e);
			commonService.setErrorResUrlCode(reqUrlVO, "IH03905");
		}
		return reqUrlVO;
	}
	
	/**
	 * daemon 에서 사용
	 */
	@Override
	public String requestIh002DaemonProc(String reqConvId) throws Exception {
		// 1. DB Query
		List<IfIhConvReqInfoDbVO> convList = imageConvUtilService.selectImgConvReqInfos(reqConvId);
		logger.info("ImgConvWorker convList size="+convList.size());
		// 2. 이미지 변환
		IfIh003DataReqVO reqDataVO = this.convertImg(convList);
		
		// 3. DBP 호출
		return sendMsg(reqDataVO);
	}

	private IfIh003DataReqVO convertImg(List<IfIhConvReqInfoDbVO> convList) throws Exception {
		IfIh003DataReqVO reqDataVO = commonService.setIfIh003RequestVO("SUCCESS");

		for(int i = 0; i < convList.size(); i ++) {
			IfIhConvReqInfoDbVO reqVO = convList.get(i);

			reqDataVO.getBody().setTransactionId(reqVO.getTransactionId());
			reqDataVO.getBody().setAdminCode(reqVO.getAdminCode());
			
			IfIh003BodyFileReqVO reqFileVO = imageConvUtilService.createIfIh003ReqFileVO(reqVO.getKeyVal());
			reqFileVO.setKeyVal(reqVO.getKeyVal());
			IfIh003BodyUrlReqVO reqUrlVO = imageConvUtilService.createIfIh003ReqUrlVO(reqVO.getOsVerCd());
			
			IfIhConvInfoDbVO dbVO = new IfIhConvInfoDbVO();
			dbVO.setConvId(StringUtils.stripToEmpty(commonService.getConvId()));
			dbVO.setAdminCode(reqVO.getAdminCode());
			dbVO.setTransactionId(reqVO.getTransactionId());
			dbVO.setKeyVal(reqVO.getKeyVal());
			dbVO.setConvOrigFileNm(reqVO.getConvOrigFileNm());
			dbVO.setOsVerCd(reqVO.getOsVerCd());
			dbVO.setConvReqSysCd(reqVO.getConvReqSysCd());
			dbVO.setConvReqDt(reqVO.getConvReqDt());
			
			// 원본 이미지 다운로드
			if(svcDirDaemonNo == (config.getInt("DAEMON.IH_CONV.PROC_THREAD_CNT") * 2)) svcDirDaemonNo = 1;
			String imgFile = imageConvUtilService.getDownTempImgPath("BATCH", String.valueOf(svcDirDaemonNo++), reqVO.getConvOrigFileNm());
			boolean isDownload = dbpImgDownloader.download(reqVO.getConvOrigFileNm(), imgFile);
			if(isDownload) {
				// 원본 이미지 저장
				dbVO.setConfIngFileNm(imageConvUtilService.getImgPath(imgFile, reqVO.getAdminCode(), reqVO.getOsVerCd(), reqVO.getConvOrigFileNm()));
				if("".equals(dbVO.getConfIngFileNm())) {
					commonService.setErrorResUrlCode(reqUrlVO, "IH03902");
				} else {
					/** 2. 임시 파일 생성				*/
					String tempFile = imageConvUtilService.getTempImgPath(dbVO.getConfIngFileNm());
					
					/** 3. 이미지 변환	 & 저장			*/
					dbVO.setConvEndFileNm(imageConvUtilService.getConvImgPath(reqVO.getAdminCode(), reqVO.getOsVerCd(), fileProcUtil.getExtension(tempFile)));
					if(!imageConvUtilService.imageConvert(tempFile, dbVO.getConvEndFileNm(), reqVO.getImageResolution())) {
						commonService.setErrorResUrlCode(reqUrlVO, "IH03903");
					} else {
						/** 움직이는 그림 분할 저장 되는 문제로 인한 코드 추가 */
						if(!fileProcUtil.isExistFile(dbVO.getConvEndFileNm())) {
							String convEndFile = "";
							if("".equals(fileProcUtil.getExtension(dbVO.getConvEndFileNm()))) {
								convEndFile = dbVO.getConvEndFileNm() + "-0";
							} else {
								convEndFile = StringUtils.substring(dbVO.getConvEndFileNm(), 0, dbVO.getConvEndFileNm().lastIndexOf(".")) 
												+ "-0." + fileProcUtil.getExtension(dbVO.getConvEndFileNm());
							}
							dbVO.setConvEndFileNm(convEndFile);
						}
						/** IMG WEB URL */
						dbVO.setImageServiceUrl(commonService.getImgUrl() + reqVO.getAdminCode() + "/" + commonService.getDeviceStr(reqVO.getOsVerCd()) + "/" + fileProcUtil.getFileName(dbVO.getConvEndFileNm()));
					}
				}
				
				Thread.sleep((int)(1000*config.getFloat("FILE_SIZE_READ_SLEEP_SEC")));
				
				dbVO.setConvReqFileTypeCd(StringUtils.stripToEmpty(fileProcUtil.getExtension(dbVO.getConfIngFileNm())));
				dbVO.setConvEndFileTypeCd(StringUtils.stripToEmpty(fileProcUtil.getExtension(dbVO.getConvEndFileNm())));
				dbVO.setConvEndFileSize(StringUtils.stripToEmpty(fileProcUtil.getFileSize(dbVO.getConvEndFileNm())));
				dbVO.setConvResultCd(reqUrlVO.getResultCode());
				dbVO.setConvEndDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
				
				try {
					/** 4. 디비 이력 추가				*/
					imageConvUtilService.addImageConvertInfo(dbVO);
					reqVO.setConvResultCd("SUCCESS");
					imageConvUtilService.updateImageConvertReqInfo(reqVO);
				} catch (Exception e) {
					commonService.setErrorResUrlCode(reqUrlVO, "IH03905");
					logger.error(e);
				}
				
				reqUrlVO.setImgUrl(dbVO.getImageServiceUrl());
				
			} else {
				
				reqUrlVO.setReqDevCd(reqVO.getOsVerCd());
				commonService.setErrorResUrlCode(reqUrlVO, "IH03901");
				dbVO.setConvResultCd(reqUrlVO.getResultCode());
				dbVO.setConvEndDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
				
				try {
					/** 4. 디비 이력 추가				*/
					imageConvUtilService.addImageConvertInfo(dbVO);
					reqVO.setConvResultCd("IH03901");
					imageConvUtilService.updateImageConvertReqInfo(reqVO);
				} catch (Exception e) {
					commonService.setErrorResUrlCode(reqUrlVO, "IH03905");
					logger.error(e);
				}
			}
			
			fileProcUtil.deleteFile(imgFile);
			reqFileVO.getUrlList().add(reqUrlVO);
			reqDataVO.getBody().getFileList().add(reqFileVO);
			reqDataVO.getBody().setConvReqDt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			
			Thread.sleep(10);
		}
		
		return reqDataVO;
	}
	
	private String sendMsg(IfIh003DataReqVO reqDataVO) throws Exception {
		String resXml = dbpMsgSender.send("IF-IH-003", commonService.requestStringIfIh003(reqDataVO));
		IfIh003DataResVO resVO = imageConvertDbpMsgReader.getIh003DbpResMessage(resXml);
		if(resVO == null || !"SUCCESS".equals(resVO.getBody().getResultCode())) throw new Exception();
		return resVO.getBody().getResultCode();
	}
}