package com.skt.ssp.gw.vo.goods;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * IfGo010ComBodyIdxConverter (IfGo010ComBodyIdxConverter)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfGo010ComBodyIdxConverter.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfGo010ComBodyIdxConverter implements Converter {
	public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
		IfGo010ComBodyIdxReqVO vo = (IfGo010ComBodyIdxReqVO) value;
		writer.setValue(vo.getIdx());
	}

	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		IfGo010ComBodyIdxReqVO vo = new IfGo010ComBodyIdxReqVO();
		vo.setIdx(reader.getValue());
		return vo;
	}

	@SuppressWarnings("rawtypes")
	public boolean canConvert(Class clazz) {
		return clazz.equals(IfGo010ComBodyIdxReqVO.class);
	}
}
