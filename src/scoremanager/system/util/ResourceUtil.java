package scoremanager.system.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取资源工具类
 * @author redburning
 *
 */
public class ResourceUtil {

	public static String getRequestPath(HttpServletRequest request) {
		String requestPath = request.getRequestURI() + "?" + request.getQueryString();
		// 去掉其他参数
		if (requestPath.indexOf("&") > -1) {
			requestPath = requestPath.substring(0, requestPath.indexOf("&"));
		}
		// 去掉项目路径
		requestPath = requestPath.substring(request.getContextPath().length() + 1);
		return requestPath;
	}
	
}
