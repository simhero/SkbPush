package com.skt.ssp.ih.parse;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.ih.vo.imageConvert.IfIh001BodyFileReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh001BodySizeReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh001DataReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002BodyFileReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002BodySizeReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh002DataReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh003DataResVO;
import com.thoughtworks.xstream.XStream;

/**
 * ImageConvertDbpMsgReader (ImageConvertDbpMsgReader)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: ImageConvertDbpMsgReader.java,v1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Component
public class ImageConvertDbpMsgReader {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CompositeConfiguration config;

	public ImageConvertDbpMsgReader() {
	}

	public CompositeConfiguration getConfiguration() {
		return config;
	}
	
	public IfIh001DataReqVO getIh001DbpReqMessage(String xml) {
		logger.debug("getIh001DbpReqMessage XML="+xml);
		IfIh001DataReqVO vo = null;
		try {
			XStream xstream = new XStream();
			xstream.alias("Request", IfIh001DataReqVO.class);
			xstream.alias("sizes", IfIh001BodySizeReqVO.class);
			xstream.alias("files", IfIh001BodyFileReqVO.class);
			vo = (IfIh001DataReqVO)xstream.fromXML(xml);
		} catch (Exception e) {
			logger.error(e);
		}
		logger.debug("IfIh001DataReqVO="+vo);
		return vo;
	}
	
	public IfIh002DataReqVO getIh002DbpReqMessage(String xml) {
		logger.debug("getIh002DbpReqMessage XML="+xml);
		IfIh002DataReqVO vo = null;
		try {
			XStream xstream = new XStream();
			xstream.alias("Request", IfIh002DataReqVO.class);
			xstream.alias("sizes", IfIh002BodySizeReqVO.class);
			xstream.alias("files", IfIh002BodyFileReqVO.class);
			vo = (IfIh002DataReqVO)xstream.fromXML(xml);
		} catch (Exception e) {
			logger.error(e);
		}
		logger.debug("IfIh002DataReqVO="+vo);
		return vo;
	}
	
	public IfIh003DataResVO getIh003DbpResMessage(String xml) {
		logger.debug("getIh003DbpResMessage XML="+xml);
		IfIh003DataResVO vo = null;
		try {
			XStream xstream = new XStream();
			xstream.alias("Response", IfIh003DataResVO.class);
			vo = (IfIh003DataResVO)xstream.fromXML(xml);
		} catch (Exception e) {
			logger.error(e);
		}
		logger.debug("IfIh003DataResVO="+vo);
		return vo;
	}

}