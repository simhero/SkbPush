package com.skt.ssp.gw.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.skt.ssp.gw.dao.CreateTableDAO;

@Repository("createTableDAO")
public class CreateTableDAOImpl extends SqlMapClientDaoSupport implements CreateTableDAO {

	public CreateTableDAOImpl() {}
	
	@Autowired
	public void Init(SqlMapClient sqlMapClient) throws Exception {
		setSqlMapClient(sqlMapClient);
	}
	
	@Override
	public void createTable() throws Exception {
		getSqlMapClient().insert("CreateTable.tableCreate");
		getSqlMapClient().insert("CreateTable.sequenceCreate");
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List selectTest(Map map) {
		return getSqlMapClientTemplate().queryForList("CreateTable.select");
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void insertTest(Map map) throws Exception {
		getSqlMapClient().insert("CreateTable.insert", map);
	}
	
}
