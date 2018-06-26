package servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserRegist
 */
@WebServlet(name = "regist", urlPatterns = { "/regist" })
public class UserRegist extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService service = new UserServiceImpl();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("accout");
		String password = req.getParameter("password");
		String sex = req.getParameter("sex");
		String age = req.getParameter("age");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String home_addr = req.getParameter("home_addr");
		String work_addr = req.getParameter("work_addr");
		int result = service.userRegist(name, password, sex, age, email, phone, home_addr, work_addr);
		if(result > 0) {
			req.getSession().setAttribute("msg", "注册成功！");
		} else {
			req.getSession().setAttribute("msg", "注册失败！");
		}
		resp.sendRedirect("/sickness-system/login.jsp");
		
	}

}
