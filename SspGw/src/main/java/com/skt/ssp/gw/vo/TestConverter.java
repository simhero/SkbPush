package com.skt.ssp.gw.vo;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class TestConverter implements Converter {
	public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
		AuthVO vo = (AuthVO) value;
		writer.setValue(vo.getAdminId());
	}

	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		AuthVO vo = new AuthVO();
		vo.setAdminId(reader.getValue());
		return vo;
	}

	@SuppressWarnings("rawtypes")
	public boolean canConvert(Class clazz) {
		return clazz.equals(AuthVO.class);
	}
}
