package com.skt.ssp.gw.vo.statistics;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * IfSt002ComBodyUidConverter (IfSt002ComBodyUidConverter)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSt002ComBodyUidConverter.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSt002ComBodyUidConverter implements Converter {
	public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
		IfSt002ComBodyUidReqVO vo = (IfSt002ComBodyUidReqVO) value;
		writer.setValue(vo.getUid());
	}

	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		IfSt002ComBodyUidReqVO vo = new IfSt002ComBodyUidReqVO();
		vo.setUid(reader.getValue());
		return vo;
	}

	@SuppressWarnings("rawtypes")
	public boolean canConvert(Class clazz) {
		return clazz.equals(IfSt002ComBodyUidReqVO.class);
	}
}
