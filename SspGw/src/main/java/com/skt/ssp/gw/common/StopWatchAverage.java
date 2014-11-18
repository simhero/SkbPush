package com.skt.ssp.gw.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * StopWatchAverage (StopWatchAverage)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: StopWatchAverage,v 1.0 2011/04/13 00:00:00 SimByungChul Express $
 */
public class StopWatchAverage {
	protected final Log logger = LogFactory.getLog(getClass());
	private long startTime;
	private long elapsedTime = 0;
	private double totalElapsedTime;
	private long runCount = 0;
	private String currentName;
	private boolean threadFlag = false;

	public StopWatchAverage() {
		currentName = "WOW SAMPLE STOP WATCH";
		startTime = System.currentTimeMillis();
	}

	public StopWatchAverage(boolean threadFlag) {
		changeMessage("", true, true);
	}

	public StopWatchAverage(String message) {
		changeMessage(message, false, true);
	}

	public StopWatchAverage(String message, boolean threadFlag) {
		changeMessage(message, threadFlag, true);
	}

	public void reset() {
		startTime = System.currentTimeMillis();
		elapsedTime = 0;
		totalElapsedTime = 0;
		runCount = 0;
	}

	public void start() {
		startTime = System.currentTimeMillis();
		elapsedTime = 0;
	}

	public void stop() {
		elapsedTime = System.currentTimeMillis() - startTime;
		totalElapsedTime += elapsedTime;
		runCount++;
	}

	public void changeMessage(String message, boolean threadFlag, boolean resetFlag) {
		String threadName = "";
		this.setThreadFlag(threadFlag);
		if (threadFlag) {
			threadName = " ThreadName=" + Thread.currentThread().getName();
		}
		currentName = "[" + message + threadName + "] ";
		if (resetFlag) {
			reset();
		}
	}

	public double getElapsedMS() {
		if (elapsedTime == 0)
			stop();
		return elapsedTime;
	}

	public double getElapsedNano() {
		if (elapsedTime == 0)
			stop();
		return elapsedTime;
	}

	public String toString() {
		if (elapsedTime == 0)
			stop();
		double elapsedAverage = totalElapsedTime / runCount;
		return currentName + "Run Count : " + runCount + ", Total : " + totalElapsedTime + " ms, Average : " + elapsedAverage + " ms";
	}

	public void setThreadFlag(boolean threadFlag) {
		this.threadFlag = threadFlag;
	}

	public boolean getThreadFlag() {
		return threadFlag;
	}
}

