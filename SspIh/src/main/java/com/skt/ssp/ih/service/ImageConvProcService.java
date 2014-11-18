package com.skt.ssp.ih.service;

import org.apache.commons.configuration.CompositeConfiguration;

import com.skt.ssp.ih.vo.imageConvert.IfIh001DataReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh001DataResVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002DataReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002DataResVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh003DataReqVO;

/**
 * ImageConvProcService Interface (ImageConvProcService)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: ImageConvProcService.java,v 1.1 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public interface ImageConvProcService {
	public CompositeConfiguration getConfiguration();
	public CommonService getCommonService();
	public ImageConvUtilService getImageConvUtilService();
	public IfIh001DataResVO requestIh001(IfIh001DataReqVO reqVO) throws Exception;
	public IfIh002DataResVO requestIh002(IfIh002DataReqVO reqVO) throws Exception;
	public IfIh003DataReqVO requestIh002ThreadProc(IfIh002DataReqVO reqVO);
	public String requestIh002DaemonProc(String reqConvId)throws Exception;
}
