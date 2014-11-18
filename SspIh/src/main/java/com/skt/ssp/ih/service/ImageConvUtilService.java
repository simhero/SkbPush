package com.skt.ssp.ih.service;

import java.util.List;

import com.skt.ssp.ih.vo.imageConvert.IfIh001BodyFileResVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh001BodyUrlResVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002DataReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002DataResVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh003BodyFileReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh003BodyUrlReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIhConvInfoDbVO;
import com.skt.ssp.ih.vo.imageConvert.IfIhConvReqInfoDbVO;

/**
 * ImageConvUtilService Interface (ImageConvUtilService)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: ImageConvUtilService.java,v 1.1 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public interface ImageConvUtilService {
	public IfIh002DataResVO addReqIh002Db(IfIh002DataReqVO reqVO);
	public void addImageConvertInfo(IfIhConvInfoDbVO ifIhDbVO);
	public void addImageConvertReqInfo(IfIhConvReqInfoDbVO ifIhDbVO);
	public void updateImageConvertReqInfo(IfIhConvReqInfoDbVO ifIhDbVO);
	public void updateImageConvertInfo(IfIhConvInfoDbVO ifIhDbVO);
	public List<String> selectReqConvIds();
	public List<IfIhConvReqInfoDbVO> selectImgConvReqInfos(String reqConvId);
	public String getDownTempImgPath(String path);
	public String getDownTempImgPath(String subPath, String path);
	public String getDownTempImgPath(String subPath, String cnt, String path);
	public String getImgPath(String imgFile, String adminCode, String reqDevCd, String path);
	public String getImgPath2(String imgFile, String adminCode, String reqDevCd, String path);
	public String getTempImgPath(String imgPath);
	public String getConvImgPath(String adminCode, String reqDevCd, String fileType);
	public boolean imageConvert(String imgPath, String covFilePath, String imgSize);
	public IfIh001BodyFileResVO createIfIh001ResFileVO(String keyVal);
	public IfIh001BodyUrlResVO createIfIh001ResUrlVO(String reqDevCd);
	public IfIh003BodyFileReqVO createIfIh003ReqFileVO(String keyVal);
	public IfIh003BodyUrlReqVO createIfIh003ReqUrlVO(String reqDevCd);
	public IfIhConvInfoDbVO getDbVO(String adminCode, String userId,
			String transactionId, String keyVal, String img, String confIng,
			String convImg, String imgUrl, String osType, String reqSysCd,
			String resultCode, String convReqDt);
}
