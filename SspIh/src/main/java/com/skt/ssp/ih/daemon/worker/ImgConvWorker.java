package com.skt.ssp.ih.daemon.worker;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.skt.ssp.ih.daemon.manager.ImgConvManager;
import com.skt.ssp.ih.service.ImageConvProcService;

/**
 * Image Conversion Worker (ImgConvWorker)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: ImgConvWorker.java,v 1.0 2011/10/04 00:00:00 ChoKyuJin Express $
 */
public class ImgConvWorker extends Thread {
	protected final Log logger = LogFactory.getLog(this.getClass());
	private ImgConvManager imgConvManager = null;
	private ImageConvProcService imageConvProcService = null;
	private String reqConvId;
	

	public ImgConvWorker(ImgConvManager imgConvManager, String reqConvId) {
		this.imgConvManager = imgConvManager;
		this.reqConvId = reqConvId;
		this.imageConvProcService = this.imgConvManager.getImageConvProcService();
	}

	public void run() {
		logger.info("ImgConvWorker run() START");
		long stTime = new Date().getTime();
		try {
			processWorker();
		} catch (Exception e) {
			logger.error(e);
		}
		long enTime = new Date().getTime();
		logger.info("ImgConvWorker Proc Time= "+(enTime-stTime));
		logger.info("ImgConvWorker run() END");
	}

	public void processWorker() throws Exception {
		String result = imageConvProcService.requestIh002DaemonProc(reqConvId);
		logger.debug("ImgConvWorker processWorker() "+result);
	}
	
	

}