package scoremanager.system;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import scoremanager.system.util.CaptchaUtil;
import scoremanager.system.util.SystemConstant;

public class CaptchaServlet extends HttpServlet {

	private static final long serialVersionUID = -530776989959762759L;

	private static final Logger logger = Logger.getLogger(HttpServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("image/jpeg");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expire", 0);
		try {
			HttpSession session = request.getSession();
			CaptchaUtil tool = new CaptchaUtil();
			StringBuffer code = new StringBuffer();
			BufferedImage image = tool.genRandomCodeImage(code);
			session.removeAttribute(SystemConstant.KEY_CAPTCHA);
			session.setAttribute(SystemConstant.KEY_CAPTCHA, code.toString());
			logger.info("captcha generated");
			ImageIO.write(image, "JPEG", response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}
	
}
