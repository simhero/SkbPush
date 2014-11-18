package com.skt.ssp.ih.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.skt.ssp.ih.dao.ImageConvertDAO;
import com.skt.ssp.ih.service.CommonService;
import com.skt.ssp.ih.vo.imageConvert.IfIhConvInfoDbVO;
import com.skt.ssp.ih.vo.imageConvert.IfIhConvReqInfoDbVO;

/**
 * ImageConvert DAO Implement (ImageConvertDAOImpl)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: ImageConvertDAOImpl.java,v 1.1 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Repository("imageConvertDAO")
public class ImageConvertDAOImpl extends SqlMapClientDaoSupport implements ImageConvertDAO {
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private CommonService commonService;

	public ImageConvertDAOImpl() { }

	@Autowired
	public void Init(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
	}
	
	@Override
	public void addImageConvertInfo(IfIhConvInfoDbVO ifIhDbVO) {
		ifIhDbVO.setInsertDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		this.getSqlMapClientTemplate().insert("ImageConvert.addImgInfo", ifIhDbVO);
	}
	
	@Override
	public void updateImageConvertInfo(IfIhConvInfoDbVO ifIhDbVO) {
		ifIhDbVO.setUpdateDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		this.getSqlMapClientTemplate().update("ImageConvert.updateImgInfo", ifIhDbVO);
	}
	
	@Override
	public void addImageConvertReqInfo(IfIhConvReqInfoDbVO ifIhDbVO) {
		ifIhDbVO.setInsertDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		this.getSqlMapClientTemplate().insert("ImageConvert.addImgReqInfo", ifIhDbVO);
	}
	
	@Override
	public void updateImageConvertReqInfo(IfIhConvReqInfoDbVO ifIhDbVO) {
		ifIhDbVO.setUpdateDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		this.getSqlMapClientTemplate().update("ImageConvert.updateImgReqInfo", ifIhDbVO);
	}
	
	@Override
	public List<String> selectReqConvIds() {
		Map<String,String> map = new HashMap<String,String>();
		map.put("convCode", commonService.getConversionCode());
		map.put("rowCnt", commonService.getProcThreadCnt());
		return this.getSqlMapClientTemplate().queryForList("ImageConvert.selectReqConvId", map);
	}
	
	@Override
	public List<IfIhConvReqInfoDbVO> selectImgConvReqInfos(String reqConvId) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("reqConvId", reqConvId);
		map.put("convCode", commonService.getConversionCode());
		map.put("rowCnt", commonService.getProcThreadRow());
		return this.getSqlMapClientTemplate().queryForList("ImageConvert.selectImgConvReqInfo", map);
	}

}