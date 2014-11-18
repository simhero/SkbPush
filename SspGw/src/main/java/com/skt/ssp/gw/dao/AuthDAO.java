package com.skt.ssp.gw.dao;

import com.skt.ssp.gw.vo.AuthVO;

/**
 * Auth DAO Interface (AuthDAO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: AuthDAO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public interface AuthDAO {
	public AuthVO selectAuthInfo(AuthVO authVO);
	public void insertAuthInfo(AuthVO authVO) throws Exception;
	public void deleteAuthInfo(AuthVO authVO) throws Exception;
}