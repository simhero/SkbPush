package com.skt.ssp.gw.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.skt.ssp.gw.dao.SettlementDAO;

/**
 * Settlement DAO Implement (SettlementDAOImpl)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: SettlementDAOImpl.java,v 1.1 2011/09/03 00:00:00 SimByungChul Express $
 */
@Repository("settlementDAO")
public class SettlementDAOImpl extends SqlMapClientDaoSupport implements SettlementDAO {
	protected final Log logger = LogFactory.getLog(getClass());

	public SettlementDAOImpl() {
	}

	@Autowired
	public void Init(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
	}

}