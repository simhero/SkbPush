package com.skt.ssp.ih.dao;

import java.util.List;

import com.skt.ssp.ih.vo.imageConvert.IfIhConvInfoDbVO;
import com.skt.ssp.ih.vo.imageConvert.IfIhConvReqInfoDbVO;

/**
 * ImageConvert DAO Interface (ImageConvertDAO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: ImageConvertDAO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public interface ImageConvertDAO {
	public void addImageConvertInfo(IfIhConvInfoDbVO ifIhDbVO);
	public void updateImageConvertInfo(IfIhConvInfoDbVO ifIhDbVO);
	public void addImageConvertReqInfo(IfIhConvReqInfoDbVO ifIhDbVO);
	public void updateImageConvertReqInfo(IfIhConvReqInfoDbVO ifIhDbVO);
	public List<String> selectReqConvIds();
	public List<IfIhConvReqInfoDbVO> selectImgConvReqInfos(String reqConvId);
}