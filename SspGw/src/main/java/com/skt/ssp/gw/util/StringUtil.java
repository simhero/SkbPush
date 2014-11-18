package com.skt.ssp.gw.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * String Util (StringUtil)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: StringUtil.java,v 1.0 2011/09/03 00:00:00 SimByungChul    Express $
 */
public class StringUtil {

	public StringUtil() {
	}

	public static String stackTraceToString(Throwable ex) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		PrintStream p = new PrintStream(b);
		ex.printStackTrace(p);
		p.close();
		String stackTrace = b.toString();
		try {
			b.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return convertHtmlBr(stackTrace);
	}

	public static String convertHtmlBr(String comment) {
		if (comment == null)
			return "";
		int length = comment.length();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			String tmp = comment.substring(i, i + 1);
			if ("\r".compareTo(tmp) == 0) {
				tmp = comment.substring(++i, i + 1);
				if ("\n".compareTo(tmp) == 0)
					buffer.append("<br>\r");
				else
					buffer.append("\r");
			}
			buffer.append(tmp);
		}
		return buffer.toString();
	}

	public static String engToKor(String str) {
		String returnString = str;
		try {
			returnString = new String(str.getBytes("8859_1"), "EUC_KR");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return returnString;
	}

	public static String getCRLF() {
		return "\r\n";
	}

	public static String hideMdn(String mdn) {
		String returnString = mdn;
		try {
			returnString = mdn.substring(0, (mdn.lastIndexOf('-') + 1)) + "xxxx";
		} catch (Exception e) {
		}
		return returnString;
	}

	public static String nullValue(String str, String nullStr) {
		if (str == null || str.trim().length() == 0)
			return nullStr;
		else
			return str;
	}

	public static String trimString(String str) {
		String strTmp;
		if (str == null || str.equals(""))
			strTmp = "";
		else
			strTmp = str.trim();

		return strTmp;
	}

	public static String lpad(String str, int length, String fillUpStr) {
		StringBuffer resultStr = new StringBuffer();
		for (int i = 0; i < length - str.length(); i++) {
			resultStr.append(fillUpStr);
		}
		resultStr.append(str);
		return resultStr.toString();
	}

	public static String rpad(String str, int length, String fillUpStr) {
		StringBuffer resultStr = new StringBuffer();
		resultStr.append(str);
		for (int i = 0; i < length - str.length(); i++) {
			resultStr.append(fillUpStr);
		}
		return resultStr.toString();
	}

	public static int stringToInteger(String str, int defaultInt) {
		int returnInt = 0;
		try {
			returnInt = Integer.parseInt(str);
		} catch (Exception e) {
			returnInt = defaultInt;
		}
		return returnInt;
	}

	public static String dateFormatString(String str) {
		if (str == null || str.trim().length() != 8)
			return str;
		else
			return (str.substring(2, 4) + "." + str.substring(4, 6) + "." + str.substring(6, 8));
	}

	public static String timeFormatString(String str) {
		if (str == null || str.trim().length() != 4)
			return str;
		else
			return (str.substring(0, 2) + ":" + str.substring(2, 4));
	}

	public static int strToInt(String s) {
		int result;
		Integer i;
		result = 0;
		try {
			i = new Integer(s);
			result = i.intValue();
		} catch (NumberFormatException e) {
			System.out.println("BAD PARAMETER VALUE: ");
		}

		return result;
	}

	public static byte[] addNullToString(String srcStr, int addLength) {
//		byte[] destBytes = new byte[addLength];
//		if (srcStr == null) {
//			for(int i=0; i<addLength; i++) {
//				destBytes[i] = (byte)0x00;
//			}
//			return destBytes;
//		}
		int srcStrLength = srcStr.length();
		byte[] srcBytes = srcStr.getBytes();
		byte[] destBytes = new byte[addLength];
		if (srcStrLength >= addLength) return srcStr.getBytes();
		for(int i=0; i<addLength; i++) {
			if(i < srcBytes.length) {
				destBytes[i] = srcBytes[i];
			} else {
				destBytes[i] = (byte)0x00;
			}
		}
		return destBytes;
	}

    public static String addNumType(String src, int srcIdx, int totalIdx) {
        for(int i=0; i<totalIdx - srcIdx; i++) {
            src =  "0" + src;
        }
        return src;
    }

	public static String cutStringByBytes(String str, int length ) {
//		if (str == null) return "";
		byte[] bytes = str.getBytes();
		int byteLen = bytes.length;
		int counter = 0;
		if ( length >= byteLen ) return str;
		for ( int i = length - 1; i >= 0; i-- ){
			if (((int)bytes[i] & 0x80) != 0 ) counter++;
		}
		return new String(bytes, 0, length - ( counter % 2 ));
	}

	public static byte[] addNullAndCutStringByBytes(String str, int maxLength ) {
		int strLength = str.getBytes().length;
		if ( maxLength == strLength ) {
			return str.getBytes();
		} else if ( maxLength > strLength ) {
			return addNullToBytes(str.getBytes());
		} else {
			return cutStringByBytes(str, maxLength).getBytes();
		}
	}

    public static byte[] addNullToBytes(byte[] srcBytes) {
		byte[] destBytes = new byte[srcBytes.length+1];
		for(int i=0; i<destBytes.length; i++) {
			if(i < srcBytes.length) {
				destBytes[i] = srcBytes[i];
			} else {
				destBytes[i] = (byte)0x00;
			}
		}
		return destBytes;
    }

//    public static byte[] addNullToBytes(byte[] array1) {
//    	byte[] joinedArray = new byte[array1.length + 1];
//    	System.arraycopy(array1, 0, joinedArray, 0, array1.length);
//    	System.arraycopy((byte)0x00, 0, joinedArray, array1.length, 1);
//    	return joinedArray;
//    }

}
