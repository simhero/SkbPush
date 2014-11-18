package com.skt.ssp.ih.web.validator;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.ih.service.CommonService;
import com.skt.ssp.ih.vo.imageConvert.IfIh001BodyFileReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh001BodyReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh001BodySizeReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh001DataReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh001DataResVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002BodyFileReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002BodyReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002BodySizeReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002DataReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002DataResVO;

/**
 * ImageConvertValidator (ImageConvertValidator)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: ImageConvertValidator.java,v 1.0 2011/10/31 00:00:00 ChoKyuJin Express $
 */
@Component
public class ImageConvertValidator {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public ImageConvertValidator() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}
	
	public IfIh001DataResVO validateIfIh001(IfIh001DataReqVO imageConvertReqVO) {
		IfIh001BodyReqVO bodyVO = imageConvertReqVO.getBody();
		if(commonService.isEmptyOrMaxLengthOver(bodyVO.getAdminCode(), 50, "M")) return commonService.setIfIh001ResponseVO("IH01001");
		if(commonService.isEmptyOrMaxLengthOver(bodyVO.getUserId(), 50, "O")) return commonService.setIfIh001ResponseVO("IH01002");
		if(commonService.isEmptyOrMaxLengthOver(bodyVO.getConvReqSysCd(), 3, "M")) return commonService.setIfIh001ResponseVO("IH01003");
		if(commonService.isEmptyOrMaxLengthOver(bodyVO.getConvReqDt(), 20, "M")) return commonService.setIfIh001ResponseVO("IH01004");
		if(bodyVO.getSizeList() != null && bodyVO.getSizeList().size() > 0) {
			for(IfIh001BodySizeReqVO sizeVO : bodyVO.getSizeList()) {
				if(commonService.isEmptyOrMaxLengthOver(sizeVO.getReqDevCd(), 3, "O")) return commonService.setIfIh001ResponseVO("IH01005");
				if(commonService.isEmptyOrMaxLengthOver(sizeVO.getImgSize(), 50, "O")) return commonService.setIfIh001ResponseVO("IH01006");
			}
		}
		if(bodyVO.getFileList() == null || bodyVO.getFileList().size() == 0) return commonService.setIfIh001ResponseVO("IH01007");
		for(IfIh001BodyFileReqVO fileVO : bodyVO.getFileList()) {
			if(commonService.isEmptyOrMaxLengthOver(fileVO.getKeyVal(), 50, "M")) return commonService.setIfIh001ResponseVO("IH01007");
			if(commonService.isEmptyOrMaxLengthOver(fileVO.getImgUrl(), 256, "M")) return commonService.setIfIh001ResponseVO("IH01008");
		}
		return null;
	}
	
	public IfIh002DataResVO validateIfIh002(IfIh002DataReqVO imageConvertReqVO) {
		IfIh002BodyReqVO bodyVO = imageConvertReqVO.getBody();
		if(commonService.isEmptyOrMaxLengthOver(bodyVO.getTransactionId(), 15, "M")) return commonService.setIfIh002ResponseVO("IH02001");
		if(commonService.isEmptyOrMaxLengthOver(bodyVO.getAdminCode(), 50, "M")) return commonService.setIfIh002ResponseVO("IH02002");
		if(commonService.isEmptyOrMaxLengthOver(bodyVO.getConvReqSysCd(), 3, "M")) return commonService.setIfIh002ResponseVO("IH02003");
		if(commonService.isEmptyOrMaxLengthOver(bodyVO.getConvReqDt(), 20, "M")) return commonService.setIfIh002ResponseVO("IH02004");
		if(bodyVO.getSizeList() != null && bodyVO.getSizeList().size() > 0) {
			for(IfIh002BodySizeReqVO sizeVO : bodyVO.getSizeList()) {
				if(commonService.isEmptyOrMaxLengthOver(sizeVO.getReqDevCd(), 3, "O")) return commonService.setIfIh002ResponseVO("IH02005");
				if(commonService.isEmptyOrMaxLengthOver(sizeVO.getImgSize(), 50, "O")) return commonService.setIfIh002ResponseVO("IH02006");
			}
		}
		if(bodyVO.getFileList() == null || bodyVO.getFileList().size() == 0) return commonService.setIfIh002ResponseVO("IH02007");
		for(IfIh002BodyFileReqVO fileVO : bodyVO.getFileList()) {
			if(commonService.isEmptyOrMaxLengthOver(fileVO.getKeyVal(), 50, "M")) return commonService.setIfIh002ResponseVO("IH02007");
			if(commonService.isEmptyOrMaxLengthOver(fileVO.getImgUrl(), 256, "M")) return commonService.setIfIh002ResponseVO("IH02008");
		}
		return null;
	}

}