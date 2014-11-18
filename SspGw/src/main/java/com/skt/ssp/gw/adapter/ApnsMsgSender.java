package com.skt.ssp.gw.adapter;

import org.apache.commons.configuration.CompositeConfiguration;
import javapns.back.PushNotificationManager;
import javapns.back.SSLConnectionHelper;
import javapns.data.Device;
import javapns.data.PayLoad;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.ssp.gw.service.CommonService;

/**
 * ApnsMsgSender (ApnsMsgSender)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: ApnsMsgSender.java,v1.0 2011/10/15 00:00:00 SimByungChul Express $
 */
@Component
public class ApnsMsgSender {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CommonService commonService;
	@Autowired
	private CompositeConfiguration config;

	public ApnsMsgSender() {
	}

	public void sendApns(String deviceKind, String deviceToken, String alertMessage){
		logger.info( "deviceKind " + deviceKind);
		logger.info( "deviceToken " + deviceToken);
		logger.info( "alertMessage " + alertMessage);
		logger.info( "runmode " + config.getString("DAEMON.APNS.RUN_MODE"));
		logger.info( "testHost " + config.getString("DAEMON.APNS.APNS_TEST_HOST"));
		logger.info( "testPath " + config.getString("DAEMON.APNS.CERTIFICATE_TEST_PATH"));
		logger.info( "realHost " + config.getString("DAEMON.APNS.APNS_REAL_HOST"));
		logger.info( "realPath " + config.getString("DAEMON.APNS.CERTIFICATE_REAL_PATH"));
		logger.info( "port " + config.getString("DAEMON.APNS.APNS_PORT"));
		logger.info( "password " + config.getString("DAEMON.APNS.CERTIFICATE_PASSWORD"));
		String runMode = config.getString("DAEMON.APNS.RUN_MODE");
		int badgeCount = config.getInt("DAEMON.APNS.BADGE_COUNT");
		String apnsHost = "";
		String certificatePath = "";

		PushNotificationManager pushManager = PushNotificationManager.getInstance();
		try {
			PayLoad payLoad = new PayLoad();
			payLoad.addAlert(alertMessage);
			payLoad.addBadge(badgeCount);

			pushManager.addDevice(deviceKind, deviceToken);

			if (runMode.equals("TEST")) {
				apnsHost = config.getString("DAEMON.APNS.APNS_TEST_HOST");
				certificatePath = config.getString("DAEMON.APNS.CERTIFICATE_TEST_PATH");
			} else if (runMode.equals("REAL")) {
				apnsHost = config.getString("DAEMON.APNS.APNS_REAL_HOST");
				certificatePath = config.getString("DAEMON.APNS.CERTIFICATE_REAL_PATH");
			}
			logger.info( "apnsHost " + apnsHost);
			logger.info( "certificatePath " + certificatePath);
			logger.info( "port " + config.getInt("DAEMON.APNS.APNS_PORT"));
			logger.info( "password " + config.getString("DAEMON.APNS.CERTIFICATE_PASSWORD"));
			logger.info( "deviceKind " + deviceKind);
			pushManager.initializeConnection(apnsHost, config.getInt("DAEMON.APNS.APNS_PORT"), certificatePath, config.getString("DAEMON.APNS.CERTIFICATE_PASSWORD"), SSLConnectionHelper.KEYSTORE_TYPE_PKCS12);

			Device client = pushManager.getDevice(deviceKind);
			pushManager.sendNotification(client, payLoad);
			pushManager.stopConnection();

		} catch (Exception ex) {
			logger.info( "Exception = " + ex );
			ex.printStackTrace();
		} finally {
			try {
				pushManager.removeDevice(deviceKind);
			} catch (Exception e) {
				logger.info( "Exception = " + e );
				e.printStackTrace();
			}
		}
	}

}