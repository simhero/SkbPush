package com.skt.ssp.gw.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.skt.ssp.gw.dao.AuthDAO;
import com.skt.ssp.gw.vo.AuthVO;

/**
 * Auth DAO Implement (AuthDAOImpl)
 *
 * @author <a href="mailto:simhero@in-sprit.com">ChoKyuJin</a>
 * @version $Id: AuthDAOImpl.java,v 1.1 2011/09/03 00:00:00 ChoKyuJin Express $
 */
@Repository("authDAO")
public class AuthDAOImpl extends SqlMapClientDaoSupport implements AuthDAO {
	protected final Log logger = LogFactory.getLog(getClass());

	public AuthDAOImpl() {
	}

	@Autowired
	public void Init(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
	}
	
	@Override
	public AuthVO selectAuthInfo(AuthVO authVO) {
		return (AuthVO) getSqlMapClientTemplate().queryForObject("Auth.select", authVO);
	}
	
	@Override
	public void insertAuthInfo(AuthVO authVO) throws Exception {
		getSqlMapClient().insert("Auth.insert", authVO);
	}
	
	@Override
	public void deleteAuthInfo(AuthVO authVO) throws Exception {
		getSqlMapClient().delete("Auth.delete", authVO);
	}

}