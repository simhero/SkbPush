package com.skt.ssp.gw.vo.push;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * IfPu002ComBodyUidConverter (IfPu002ComBodyUidConverter)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfPu002ComBodyUidConverter.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfPu002ComBodyUidConverter implements Converter {
	public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
		IfPu002ComBodyUidReqVO vo = (IfPu002ComBodyUidReqVO) value;
		writer.setValue(vo.getUid());
	}

	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		IfPu002ComBodyUidReqVO vo = new IfPu002ComBodyUidReqVO();
		vo.setUid(reader.getValue());
		return vo;
	}

	@SuppressWarnings("rawtypes")
	public boolean canConvert(Class clazz) {
		return clazz.equals(IfPu002ComBodyUidReqVO.class);
	}
}
