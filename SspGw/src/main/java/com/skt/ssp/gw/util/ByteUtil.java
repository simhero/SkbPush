package com.skt.ssp.gw.util;

import org.jboss.netty.buffer.ChannelBuffer;

/**
 * Byte Util (ByteUtil)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: ByteUtil.java,v 1.0 2011/09/03 00:00:00 SimByungChul Express $
 */
public class ByteUtil {

    public static final byte[] shortToByte(short s) {
		byte[] dest = new byte[2];
		dest[1] = (byte) (s & 0xff);
		dest[0] = (byte) ((s >> 8) & 0xff);
		return dest;
	}

	public static final short byteToShort(byte[] buffer) {
		return byteToShort(buffer, 0);
	}

	public static final short byteToShort(byte[] buffer, int offset) {
		return (short) (((buffer[offset] & 0xff) << 8) | (buffer[offset + 1] & 0xff));
	}

	public static byte[] intToByte(int value) {
		byte[] b = new byte[4];
		for (int i = 0; i < 4; i++) {
			int offset = (b.length - 1 - i) * 8;
			b[i] = (byte) ((value >>> offset) & 0xFF);
		}
		return b;
	}

	public static int byteToInt(byte[] data) {
		int i;
		int result = 0;
		int sizeOfInt = Integer.SIZE / 8;
		int buf = 0;
		for (i = 0; i < sizeOfInt; i++) {
			buf = data[i] & 0xFF;
			result = result | (buf << ((sizeOfInt - i - 1) * 8));
			buf = 0;
		}
		return result;
	}

	public static String getStringFromChannelBuffer(ChannelBuffer cb, int length) {
		byte[] returnStr = new byte[length];
		cb.readBytes(returnStr);
		return new String(returnStr).trim();
	}

	public static String getFlexibleStringFromChannelBuffer(ChannelBuffer cb, int length) {
		byte[] returnStr = new byte[length];
		for (int i = 0; i < returnStr.length; i++) {
			returnStr[i] = cb.readByte();
			if ( returnStr[i] == (byte)0x00) {
				return new String(returnStr).trim();
			}
		}
		return new String(returnStr).trim();
	}
}