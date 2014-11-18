package com.skt.ssp.gw.vo;

import java.util.Date;

/**
 * Message VO (MessageVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: MessageVO.java,v 1.0 2011/04/01 00:00:00 SimByungChul Express $
 */
public class MessageVO extends BaseVO {
	private String messageId;
	private String messageReqId;
	private String receiverMsisdn;
	private int messageOrder;
	private String winMessageId;
	private String sendSequenceNo;
	private String sendDate;
	private String sendCode;
	private String respDate;
	private String respCodeIn;
	private String respCode;
	private String receiptDate;
	private String receiptCodeIn;
	private String receiptCode;
	private String message;
	private String dispatchServer;
	private Date registerDate;
	private String registerId;
	private Date updateDate;
	private String updateId;

	public MessageVO() {
		super();
	}

	public String getMessageId() {
		return messageId;
	}

	public String getMessageReqId() {
		return messageReqId;
	}

	public String getReceiverMsisdn() {
		return receiverMsisdn;
	}

	public int getMessageOrder() {
		return messageOrder;
	}

	public String getWinMessageId() {
		return winMessageId;
	}

	public String getSendSequenceNo() {
		return sendSequenceNo;
	}

	public String getSendDate() {
		return sendDate;
	}

	public String getSendCode() {
		return sendCode;
	}

	public String getRespDate() {
		return respDate;
	}

	public String getRespCodeIn() {
		return respCodeIn;
	}

	public String getRespCode() {
		return respCode;
	}

	public String getReceiptDate() {
		return receiptDate;
	}

	public String getReceiptCodeIn() {
		return receiptCodeIn;
	}

	public String getReceiptCode() {
		return receiptCode;
	}

	public String getMessage() {
		return message;
	}

	public String getDispatchServer() {
		return dispatchServer;
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

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public void setMessageReqId(String messageReqId) {
		this.messageReqId = messageReqId;
	}

	public void setReceiverMsisdn(String receiverMsisdn) {
		this.receiverMsisdn = receiverMsisdn;
	}

	public void setMessageOrder(int messageOrder) {
		this.messageOrder = messageOrder;
	}

	public void setWinMessageId(String winMessageId) {
		this.winMessageId = winMessageId;
	}

	public void setSendSequenceNo(String sendSequenceNo) {
		this.sendSequenceNo = sendSequenceNo;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public void setSendCode(String sendCode) {
		this.sendCode = sendCode;
	}

	public void setRespDate(String respDate) {
		this.respDate = respDate;
	}

	public void setRespCodeIn(String respCodeIn) {
		this.respCodeIn = respCodeIn;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public void setReceiptDate(String receiptDate) {
		this.receiptDate = receiptDate;
	}

	public void setReceiptCodeIn(String receiptCodeIn) {
		this.receiptCodeIn = receiptCodeIn;
	}

	public void setReceiptCode(String receiptCode) {
		this.receiptCode = receiptCode;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setDispatchServer(String dispatchServer) {
		this.dispatchServer = dispatchServer;
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