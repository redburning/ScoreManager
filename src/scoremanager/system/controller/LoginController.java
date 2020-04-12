package scoremanager.system.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import scoremanager.system.entity.base.UserEntity;
import scoremanager.system.manager.ClientManager;
import scoremanager.system.service.SystemService;
import scoremanager.system.util.AjaxJson;
import scoremanager.system.util.ContextHolderUtils;
import scoremanager.system.util.SystemConstant;
import scoremanager.system.vo.Client;

@Controller
@RequestMapping("/loginController")
public class LoginController {

	@Autowired
	private SystemService systemService;
	
	/**
	 * 登录页
	 * @param request
	 * @return
	 */
	@RequestMapping(params="login")
	public ModelAndView login(HttpServletRequest request) {
		return new ModelAndView("system/login");
	}
	
	/**
	 * 首页
	 * @param request
	 * @return
	 */
	@RequestMapping(params="home")
	public ModelAndView home(HttpServletRequest request) {
		return new ModelAndView("system/home");
	}
	
	@RequestMapping(params="logout")
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = ContextHolderUtils.getSession();
		ClientManager.getInstance().removeClient(session.getId());
		session.invalidate();
		ModelAndView modelAndView = new ModelAndView(new RedirectView("loginController.do?login"));
		return modelAndView;
	}
	
	@RequestMapping(params="doLogin")
	public ModelAndView doLogin(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("system/main");
		HttpSession session = ContextHolderUtils.getSession();
		Client client = ClientManager.getInstance().getClient(session.getId());
		request.setAttribute("username", client.getUser().getUsername());
		return modelAndView;
	}
	
	@RequestMapping(params="doCheck")
	@ResponseBody
	public AjaxJson doCheck(HttpServletRequest request, String username, String password, String captcha) {
		AjaxJson res = new AjaxJson();
		HttpSession session = ContextHolderUtils.getSession();
		
		if (!captcha.equalsIgnoreCase(String.valueOf(session.getAttribute(SystemConstant.KEY_CAPTCHA)))) {
			res.setSuccess(false);
			res.setMsg("验证码错误");
		} else {
			UserEntity user = new UserEntity();
			user.setUsername(username);
			user.setPassword(password);
			user = this.systemService.getUserByNameAndPassword(user);
			if (user == null) {
				res.setSuccess(false);
				res.setMsg("用户名或密码错误");
			} else {
				Client client = new Client();
				client.setLogindatetime(new Date());
				client.setUser(user);
				ClientManager.getInstance().addClient(session.getId(), client);
				if (user.getStatus() == UserEntity.STATUS_FORBIDDEN) {
					res.setSuccess(false);
					res.setMsg("该用户被禁用, 请联系管理员.");
				} else {
					res.setSuccess(true);
					res.setMsg("登录成功");
				}
			}
		}
		return res;
	}
	
}
