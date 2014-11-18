package com.skt.ssp.gw.vo.order;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * IfOr001ComBodyUidConverter (IfOr001ComBodyUidConverter)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfOr001ComBodyUidConverter.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfOr001ComBodyUidConverter implements Converter {
	public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
		IfOr001ComBodyUidReqVO vo = (IfOr001ComBodyUidReqVO) value;
		writer.setValue(vo.getUid());
	}

	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		IfOr001ComBodyUidReqVO vo = new IfOr001ComBodyUidReqVO();
		vo.setUid(reader.getValue());
		return vo;
	}

	@SuppressWarnings("rawtypes")
	public boolean canConvert(Class clazz) {
		return clazz.equals(IfOr001ComBodyUidReqVO.class);
	}
}
