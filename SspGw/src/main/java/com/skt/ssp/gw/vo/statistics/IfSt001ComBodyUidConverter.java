package com.skt.ssp.gw.vo.statistics;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * IfSt001ComBodyUidConverter (IfSt001ComBodyUidConverter)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfSt001ComBodyUidConverter.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfSt001ComBodyUidConverter implements Converter {
	public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
		IfSt001ComBodyUidReqVO vo = (IfSt001ComBodyUidReqVO) value;
		writer.setValue(vo.getUid());
	}

	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		IfSt001ComBodyUidReqVO vo = new IfSt001ComBodyUidReqVO();
		vo.setUid(reader.getValue());
		return vo;
	}

	@SuppressWarnings("rawtypes")
	public boolean canConvert(Class clazz) {
		return clazz.equals(IfSt001ComBodyUidReqVO.class);
	}
}
