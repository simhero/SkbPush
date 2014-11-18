package com.skt.ssp.gw.service;

import java.util.List;
import java.util.Map;

/**
 * Create Table Service Interface (CreateTableService)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: CreateTableService.java,v 1.1 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public interface CreateTableService {
	@SuppressWarnings("rawtypes")
	public List selectTest(Map map);
	@SuppressWarnings("rawtypes")
	public void insertTest(Map map) throws Exception;
}
