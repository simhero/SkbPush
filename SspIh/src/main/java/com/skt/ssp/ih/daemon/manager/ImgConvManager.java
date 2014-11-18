package com.skt.ssp.ih.daemon.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.skt.ssp.ih.daemon.worker.ImgConvWorker;
import com.skt.ssp.ih.service.ImageConvProcService;
import com.skt.ssp.ih.service.ImageConvUtilService;

/**
 * ImgConvManager (ImgConvManager)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: ImgConvManager.java,v 1.0 2011/10/04 00:00:00 ChoKyuJin Express $
 */
public class ImgConvManager extends Thread {
	protected final Log logger = LogFactory.getLog(this.getClass());
	private ImageConvProcService imageConvProcService = null;
	private ImageConvUtilService imageConvUtilService = null;
	private CompositeConfiguration config = null;
	private ArrayList<Thread> threads = null;
	
	private ImgConvManager() {
		super();
		this.threads = new ArrayList<Thread>();
	}

	public ImgConvManager(ImageConvProcService imageConvProcService) {
		this();
		this.imageConvProcService = imageConvProcService;
		this.imageConvUtilService = imageConvProcService.getImageConvUtilService();
		this.config = imageConvProcService.getConfiguration();
	}

	public void run() {
		while(true) {
//			logger.info("ImgConvManager run() START");
			// 무한루프 작업중인 스레드가 0개인 경우 startWorker 실행
			if(threads.size() == 0) {
				startWorker();
			} else {
				int cnt = 0;
				for(int i = 0; i < threads.size(); i++){
					Thread thread = threads.get(i);
					if(thread != null && thread.isAlive()) {
						cnt++;
					}
				}
				if(cnt == 0) {
					threads.clear();
					startWorker();
				}
			}
			try {
				Thread.sleep(config.getLong("DAEMON.IH_CONV.SLEEP_TIME")*1000);
			} catch (InterruptedException e) {
				logger.error(e);
			}
//			logger.info("ImgConvManager run() END");
		}
	}

	public void startWorker() {
		logger.info("startWorker()");
		
		// 1. 디비 쿼리
		List<String> reqConvIds = imageConvUtilService.selectReqConvIds();
		logger.info("ImgConvManager reqConvIds size="+reqConvIds.size());
		
		// 2. 가져온 갯수 만큼 스레드로 돌림
		for(int i = 0; i < reqConvIds.size(); i++){
			ImgConvWorker imgConvWorker = new ImgConvWorker(this, reqConvIds.get(i));
			imgConvWorker.start();
			threads.add(imgConvWorker);
		}
	}

	public ImageConvProcService getImageConvProcService() {
		return imageConvProcService;
	}

}
