package scoremanager.system.interceptor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import scoremanager.system.manager.ClientManager;
import scoremanager.system.util.ContextHolderUtils;
import scoremanager.system.util.ResourceUtil;
import scoremanager.system.vo.Client;

public class AuthInterceptor implements HandlerInterceptor {

	private List<String> excludeUrls;
	
	public List<String> getExcludeUrls() {
		return excludeUrls;
	}
	
	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}
	
	
	/**
	 * 在controller后拦截
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView)
			throws Exception {
	}

	/**
	 * 在controller前拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		String requestPath = ResourceUtil.getRequestPath(request);
		HttpSession session = ContextHolderUtils.getSession();
		Client client = ClientManager.getInstance().getClient(session.getId());
		if (excludeUrls.contains(requestPath)) {
			return true;
		} else {
			if (client != null && client.getUser() != null) {
				return true;
			} else {
				forward(request, response);
				return false;
			}
		}
	}

	/**
	 * 转发
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "forword")
	public ModelAndView forword(HttpServletRequest request) {
		return new ModelAndView(new RedirectView("loginController.do?login"));
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("pages/common/timeout.jsp").forward(request, response);
	}
	
}
