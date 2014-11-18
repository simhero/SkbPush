package com.skt.ssp.gw.dao;

import java.util.List;
import java.util.Map;

public interface CreateTableDAO {
	@SuppressWarnings("rawtypes")
	public List selectTest(Map map);
	@SuppressWarnings("rawtypes")
	public void insertTest(Map map) throws Exception;
	public void createTable() throws Exception;
}
