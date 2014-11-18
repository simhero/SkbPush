package com.skt.ssp.gw.vo;

import java.util.Date;

/**
 * MessageReq VO (MessageReqVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: MessageReqVO.java,v 1.0 2011/04/01 00:00:00 SimByungChul Express $
 */
public class MessageReqVO extends BaseVO {
	private String messageReqId;
	private String senderId;
	private String senderShortcode;
	private String boxType;
	private String inflowPath;
	private String header;
	private String message;
	private String signature;
	private String regServer;
	private String sendYn;
	private String reserveYn;
	private String reserveSendDate;
	private String reserveMessageStatus;
	private Date registerDate;
	private String registerId;
	private Date updateDate;
	private String updateId;

	public MessageReqVO() {
		super();
	}

	public String getMessageReqId() {
		return messageReqId;
	}

	public String getSenderId() {
		return senderId;
	}

	public String getSenderShortcode() {
		return senderShortcode;
	}

	public String getBoxType() {
		return boxType;
	}

	public String getInflowPath() {
		return inflowPath;
	}

	public String getHeader() {
		return header;
	}

	public String getMessage() {
		return message;
	}

	public String getSignature() {
		return signature;
	}

	public String getRegServer() {
		return regServer;
	}

	public String getSendYn() {
		return sendYn;
	}

	public String getReserveYn() {
		return reserveYn;
	}

	public String getReserveSendDate() {
		return reserveSendDate;
	}

	public String getReserveMessageStatus() {
		return reserveMessageStatus;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public String getRegisterId() {
		return registerId;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setMessageReqId(String messageReqId) {
		this.messageReqId = messageReqId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public void setSenderShortcode(String senderShortcode) {
		this.senderShortcode = senderShortcode;
	}

	public void setBoxType(String boxType) {
		this.boxType = boxType;
	}

	public void setInflowPath(String inflowPath) {
		this.inflowPath = inflowPath;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public void setRegServer(String regServer) {
		this.regServer = regServer;
	}

	public void setSendYn(String sendYn) {
		this.sendYn = sendYn;
	}

	public void setReserveYn(String reserveYn) {
		this.reserveYn = reserveYn;
	}

	public void setReserveSendDate(String reserveSendDate) {
		this.reserveSendDate = reserveSendDate;
	}

	public void setReserveMessageStatus(String reserveMessageStatus) {
		this.reserveMessageStatus = reserveMessageStatus;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

}