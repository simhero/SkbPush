package com.skt.ssp.gw.vo.goods;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * IfGo001ComBodyUidConverter (IfGo001ComBodyUidConverter)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo001ComBodyUidConverter.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo001ComBodyUidConverter implements Converter {
	public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
		IfGo001ComBodyUidReqVO vo = (IfGo001ComBodyUidReqVO) value;
		writer.setValue(vo.getUid());
	}

	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		IfGo001ComBodyUidReqVO vo = new IfGo001ComBodyUidReqVO();
		vo.setUid(reader.getValue());
		return vo;
	}

	@SuppressWarnings("rawtypes")
	public boolean canConvert(Class clazz) {
		return clazz.equals(IfGo001ComBodyUidReqVO.class);
	}
}
