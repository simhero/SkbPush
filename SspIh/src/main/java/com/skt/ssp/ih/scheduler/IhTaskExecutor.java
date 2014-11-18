package com.skt.ssp.ih.scheduler;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;

import com.skt.ssp.ih.adapter.DbpMsgSender;
import com.skt.ssp.ih.parse.ImageConvertDbpMsgReader;
import com.skt.ssp.ih.service.CommonService;
import com.skt.ssp.ih.service.ImageConvProcService;
import com.skt.ssp.ih.vo.imageConvert.IfIh002DataReqVO;
import com.skt.ssp.ih.vo.imageConvert.IfIh003DataReqVO;

/**
 * IhTaskExecutor (IhTaskExecutor)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IhTaskExecutor.java,v 1.0 2011/10/14 00:00:00 ChoKyuJin Express $
 */
public class IhTaskExecutor {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private DbpMsgSender dbpMsgSender;
	@Autowired
	private ImageConvProcService imageConvProcService;
	@Autowired
	private ImageConvertDbpMsgReader imageConvertDbpMsgReader;
	
	private TaskExecutor taskExecutor;
	
	public IhTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}
	
	public void procStart(IfIh002DataReqVO reqVO) {
		taskExecutor.execute(new ImageFileConvertTask(reqVO));
	}
	
	private static int threadNo = 1;
	
	private class ImageFileConvertTask implements Runnable {

		private IfIh002DataReqVO reqVO;
		private String threadName = "";

		public ImageFileConvertTask(IfIh002DataReqVO reqVO) {
			this.reqVO = reqVO;
		}

		public void run() {
			try {
				if(threadNo == 100000) threadNo = 1;
				threadName = String.valueOf(threadNo++);
				long st = new Date().getTime();
//				logger.debug(threadName + " : IMAGE CONVERT THREAD ST");
				
				/** 1. 이미지 컨버팅 처리 */
				IfIh003DataReqVO ifIh003ReqVO = imageConvProcService.requestIh002ThreadProc(reqVO);
				ifIh003ReqVO.getBody().setTransactionId(reqVO.getBody().getTransactionId());
				ifIh003ReqVO.getBody().setAdminCode(reqVO.getBody().getAdminCode());
				ifIh003ReqVO.getBody().setConvReqDt(commonService.getGwDateType());
				long en = new Date().getTime();
				logger.debug(threadName + " : TIME="+((en - st) / 1000));
				
				/** 2. DBP 호출 */
				String resXml = dbpMsgSender.send("IF-IH-003", commonService.requestStringIfIh003(ifIh003ReqVO));
				/*IfIh003DataResVO resVO = */imageConvertDbpMsgReader.getIh003DbpResMessage(resXml);
//				logger.debug(threadName + " : IfIh003DataResVO="+resVO);
			} catch (Exception e) {
				logger.error(e);
			}
		}
		
	}
}
