package com.skt.ssp.gw.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.skt.ssp.gw.dao.CustomerDAO;

/**
 * Customer DAO Implement (CustomerDAOImpl)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: CustomerDAOImpl.java,v 1.1 2011/09/03 00:00:00 SimByungChul Express $
 */
@Repository("customerDAO")
public class CustomerDAOImpl extends SqlMapClientDaoSupport implements CustomerDAO {
	protected final Log logger = LogFactory.getLog(getClass());

	public CustomerDAOImpl() {
	}

	@Autowired
	public void Init(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
	}

}