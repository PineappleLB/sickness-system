package servlet.user;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.impl.UserServiceImpl;

/**
 * @author 作者 pineapple 
 * @E-mail: 2443755705@qq.com
 * @version 创建时间：2018年6月25日 下午4:39:09
 * @description 用户登录请求
 */
@WebServlet("/userLogin")
public class UserLoginServlet extends HttpServlet {
	
	UserService service = new UserServiceImpl();

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
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Map<String, Object> user = service.selectUserByName(username);
		if(user != null && user.get("password") != null && user.get("password").equals(password)) {
			resp.sendRedirect("/home.jsp");
		} else {
			req.getSession().setAttribute("msg", "用户名或密码错误！");
			resp.sendRedirect("/login.jsp");
		}
	}
	
	

}
