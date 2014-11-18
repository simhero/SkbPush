package com.skt.ssp.gw.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skt.ssp.gw.dao.CreateTableDAO;
import com.skt.ssp.gw.service.CreateTableService;

/**
 * Create Table Service Impl(CreateTableServiceImpl)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: CreateTableServiceImpl.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin  Express $
 */
@Service("createTableService")
public class CreateTableServiceImpl implements CreateTableService {

	@Autowired
	private CreateTableDAO createTableDAO;
	
	public CreateTableServiceImpl() {}
	
	@PostConstruct
	public void init() throws Exception {
		createTableDAO.createTable();
	}
	
	@PreDestroy
	public void destroy() throws Exception {
		
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List selectTest(Map map) {
		return createTableDAO.selectTest(map);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void insertTest(Map map) throws Exception {
		createTableDAO.insertTest(map);
	}
}
