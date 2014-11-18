package com.skt.ssp.gw.vo.config;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfCf002ComBodyReqVO (IfCf002ComBodyReqVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfCf002ComBodyReqVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfCf002ComBodyReqVO extends BaseVO {
	private String adminCode			= "";
	private String userId				= "";
	private String alarmYn				= "";
	private String newOrderAlarmYn		= "";
	private String cancelOrderAlarmYn	= "";
	private String returnOrderAlarmYn	= "";
	private String exchangeOrderAlarmYn	= "";
	private String goodsProcAlarmYn		= "";
	private String csAlarmYn			= "";
	private String safetyQtyYn			= "";
	private String urgencyYn			= "";
	private String alarmStartPeriod		= "";
	private String alarmEndPeriod		= "";
	private String alarmInterval		= "";

	public IfCf002ComBodyReqVO() {
		super();
	}

	public String getAdminCode() {
		return adminCode;
	}

	public String getUserId() {
		return userId;
	}

	public String getAlarmYn() {
		return alarmYn;
	}

	public String getNewOrderAlarmYn() {
		return newOrderAlarmYn;
	}

	public String getCancelOrderAlarmYn() {
		return cancelOrderAlarmYn;
	}

	public String getReturnOrderAlarmYn() {
		return returnOrderAlarmYn;
	}

	public String getExchangeOrderAlarmYn() {
		return exchangeOrderAlarmYn;
	}

	public String getGoodsProcAlarmYn() {
		return goodsProcAlarmYn;
	}

	public String getCsAlarmYn() {
		return csAlarmYn;
	}

	public String getSafetyQtyYn() {
		return safetyQtyYn;
	}

	public String getUrgencyYn() {
		return urgencyYn;
	}

	public String getAlarmStartPeriod() {
		return alarmStartPeriod;
	}

	public String getAlarmEndPeriod() {
		return alarmEndPeriod;
	}

	public String getAlarmInterval() {
		return alarmInterval;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setAlarmYn(String alarmYn) {
		this.alarmYn = alarmYn;
	}

	public void setNewOrderAlarmYn(String newOrderAlarmYn) {
		this.newOrderAlarmYn = newOrderAlarmYn;
	}

	public void setCancelOrderAlarmYn(String cancelOrderAlarmYn) {
		this.cancelOrderAlarmYn = cancelOrderAlarmYn;
	}

	public void setReturnOrderAlarmYn(String returnOrderAlarmYn) {
		this.returnOrderAlarmYn = returnOrderAlarmYn;
	}

	public void setExchangeOrderAlarmYn(String exchangeOrderAlarmYn) {
		this.exchangeOrderAlarmYn = exchangeOrderAlarmYn;
	}

	public void setGoodsProcAlarmYn(String goodsProcAlarmYn) {
		this.goodsProcAlarmYn = goodsProcAlarmYn;
	}

	public void setCsAlarmYn(String csAlarmYn) {
		this.csAlarmYn = csAlarmYn;
	}

	public void setSafetyQtyYn(String safetyQtyYn) {
		this.safetyQtyYn = safetyQtyYn;
	}

	public void setUrgencyYn(String urgencyYn) {
		this.urgencyYn = urgencyYn;
	}

	public void setAlarmStartPeriod(String alarmStartPeriod) {
		this.alarmStartPeriod = alarmStartPeriod;
	}

	public void setAlarmEndPeriod(String alarmEndPeriod) {
		this.alarmEndPeriod = alarmEndPeriod;
	}

	public void setAlarmInterval(String alarmInterval) {
		this.alarmInterval = alarmInterval;
	}

}