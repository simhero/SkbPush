package com.skt.ssp.gw.service;

import com.skt.ssp.gw.vo.AuthVO;


/**
 * Auth Service Interface (AuthService)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: AuthService.java,v 1.0 2011/08/25 00:00:00 ChoKyuJin Express $
 */
public interface AuthService {
	public AuthVO selectAuthInfo(AuthVO authVO);
	public void insertAuthInfo(AuthVO authVO) throws Exception;
	public void deleteAuthInfo(AuthVO authVO) throws Exception;
	public void updateAuthInfo(AuthVO authVO) throws Exception;
}