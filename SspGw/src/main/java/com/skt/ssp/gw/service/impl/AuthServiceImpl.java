package com.skt.ssp.gw.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skt.ssp.gw.dao.AuthDAO;
import com.skt.ssp.gw.service.AuthService;
import com.skt.ssp.gw.vo.AuthVO;

/**
 * Auth Service Impl(AuthServiceImpl)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: AuthServiceImpl.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin  Express $
 */
@Service("authService")
public class AuthServiceImpl implements AuthService {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private AuthDAO authDAO;
	
	public AuthServiceImpl() { }

	@PostConstruct
	public void init() throws Exception { }

	@PreDestroy
	public void destroy() throws Exception { }
	
	@Override
	public AuthVO selectAuthInfo(AuthVO authVO) {
		return authDAO.selectAuthInfo(authVO);
	}
	
	@Override
	public void insertAuthInfo(AuthVO authVO) throws Exception {
		authDAO.insertAuthInfo(authVO);
	}
	
	@Override
	public void updateAuthInfo(AuthVO authVO) throws Exception {
		authDAO.insertAuthInfo(authVO);
	}
	
	@Override
	public void deleteAuthInfo(AuthVO authVO) throws Exception {
		authDAO.deleteAuthInfo(authVO);
	}
	
}