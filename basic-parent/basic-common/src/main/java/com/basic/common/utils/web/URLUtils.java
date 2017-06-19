package com.basic.common.utils.web;

import java.util.HashMap;
import java.util.Map;

/**
 * URL工具类
 * 
 * @author Avan - 2013-04-19
 */
public class URLUtils {

	/**
	 * 通过url获取主机地址,包括端口号<br>
	 * http://localhost/* -> localhost <br>
	 * http://127.0.0.1:8080/* -> 127.0.0.1:8080 <br>
	 * http://www.test.com:8080/* -> www.test.com:8080 <br>
	 * 
	 * @param url url地址
	 * @return 主机地址
	 */
	public static String getHostAddr(String url) {
		int flagPos = url.indexOf("://");
		if (flagPos == -1) {
			return null;
		}
		url = url.substring(flagPos + 3);
		int virgulePos = url.indexOf('/');
		return virgulePos == -1 ? url : url.substring(0, virgulePos);
	}

	/**
	 * 通过url获取主机名<br>
	 * http://localhost/* -> localhost <br>
	 * http://127.0.0.1:8080/* -> 127.0.0.1 <br>
	 * http://www.test.com:8080/* -> www.test.com <br>
	 * 
	 * @param url url地址
	 * @return 主机名
	 */
	public static String getHostName(String url) {
		String hostAddr = getHostAddr(url);
		int colonPos = hostAddr.indexOf(':');
		return colonPos == -1 ? hostAddr : hostAddr.substring(0, colonPos);
	}

	/**
	 * 通过url获取主机端口号<br>
	 * http://localhost/* -> <br>
	 * http://127.0.0.1:8080/* -> 8080 <br>
	 * http://www.test.com:8080/* -> 8080 <br>
	 * 
	 * @param url url地址
	 * @return 端口号
	 */
	public static String getHostPort(String url) {
		String hostAddr = getHostAddr(url);
		int colonPos = hostAddr.indexOf(':');
		return colonPos == -1 ? "" : hostAddr.substring(colonPos + 1);
	}

	/**
	 * 判断url的主机名是否是IP地址<br>
	 * http://localhost/* -> false <br>
	 * http://127.0.0.1:8080/* -> true <br>
	 * http://www.test.com:8080/* -> false <br>
	 * 
	 * @param url url地址
	 * @return IP地址
	 */
	public static boolean isIp(String url) {
		try {
			String hostName = getHostName(url);
			Integer.valueOf(hostName.substring(hostName.lastIndexOf('.') + 1));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 通过url获取域名<br>
	 * http://localhost/* -> localhost <br>
	 * http://127.0.0.1:8080/* -> 127.0.0.1 <br>
	 * http://www.test.com:8080/* -> .test.com <br>
	 * 
	 * @param url url地址
	 * @return 域名
	 */
	public static String getDomain(String url) {
		String hostName = getHostName(url);
		if (isIp(url)) {
			return hostName;
		} else {
			int dotPos = hostName.indexOf('.');
			return dotPos == -1 ? hostName : hostName.substring(dotPos, hostName.length());
		}
	}

	/**
	 * 判断是否是系统外部地址
	 * 
	 * @param url url地址
	 * @return 是:true 否:false
	 */
	public static boolean isExternalUrl(String url) {
		return url.startsWith("http://") || url.startsWith("https://") || url.startsWith("ftp://") || url.equals("about:blank");
	}

	/**
	 * 通过url获取请求地址，不包括参数<br>
	 * http://localhost/index.html?id=1 -> http://localhost/index.html <br>
	 * 
	 * @param url url地址
	 * @return 请求地址
	 */
	public static String getRequestUrl(String url) {
		String _url = null;
		if (url.contains("?")) {
			_url = url.substring(0, url.indexOf('?'));
		}
		return _url;
	}

	/**
	 * 通过url获取请求参数<br>
	 * http://localhost/index.html?id=1 -> id - 1 <br>
	 * 
	 * @param url url地址
	 * @return 请求地址
	 */
	public static Map<String, String> getRequestParam(String url) {
		Map<String, String> map = null;
		if (url.contains("?")) {
			map = new HashMap<String, String>();
			String _url = url.substring(url.indexOf('?') + 1);
			String[] params = _url.split("&");
			for (String param : params) {
				String values[] = param.split("=");
				if (values.length > 1) {
					map.put(values[0], values[1]);
				}
			}
		}
		return map;
	}
}
