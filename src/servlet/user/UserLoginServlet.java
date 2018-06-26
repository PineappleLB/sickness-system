package servlet.user;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.AdminService;
import service.UserService;
import service.impl.AdminServiceImpl;
import service.impl.UserServiceImpl;

/**
 * @author 作者 pineapple 
 * @E-mail: 2443755705@qq.com
 * @version 创建时间：2018年6月25日 下午4:39:09
 * @description 用户登录请求
 */
@WebServlet("/userLogin")
public class UserLoginServlet extends HttpServlet {
	
	UserService uservice = new UserServiceImpl();
	
	AdminService aservice = new AdminServiceImpl();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String loginType = req.getParameter("login_type");
		if(loginType.equals("user")) {
			userLogin(req, resp);
		}else if(loginType.equals("admin")) {
			adminLogin(req, resp);
		}
	}

	private void adminLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		Map<String, Object> user = aservice.selectAdminByName(username);
		if(user != null && user.get("password") != null && user.get("password").equals(password)) {
			session.setAttribute("role", "admin");
			resp.sendRedirect("/sickness-system/home.jsp");
		} else {
			session.setAttribute("msg", "用户名或密码错误！");
			resp.sendRedirect("/sickness-system/login.jsp");
		}
	}

	private void userLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		Map<String, Object> user = uservice.selectUserByName(username);
		if(user != null && user.get("password") != null && user.get("password").equals(password)) {
			session.setAttribute("role", "user");
			resp.sendRedirect("/sickness-system/home.jsp");
		} else {
			session.setAttribute("msg", "用户名或密码错误！");
			resp.sendRedirect("/sickness-system/login.jsp");
		}
		
	}
	
	

}
