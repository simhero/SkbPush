package com.skt.ssp.gw.vo;


/**
 * IfErrMobRes VO (IfErrMobResVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: IfErrMobResVO.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class IfErrMobResVO extends BaseVO {
	private IfErrMobDataResVO response;

	public IfErrMobResVO() {
		super();
	}

	public IfErrMobDataResVO getResponse() {
		return response;
	}

	public void setResponse(IfErrMobDataResVO response) {
		this.response = response;
	}



}