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
 * Servlet implementation class UserFadebackDel
 */
@WebServlet(name = "user/fadeback/del", urlPatterns = { "/user/fadeback/del" })
public class UserFadebackDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService service = new UserServiceImpl();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 解决中文乱码
		resp.setContentType("text/html;charset=utf-8");
		// 请求解决乱码
		req.setCharacterEncoding("utf-8");
		// 响应解决乱码
		resp.setCharacterEncoding("utf-8");
		int result = 0;
		try {
			String name = req.getParameter("ids");
			String[] names = name.split(",");
			result = service.deleteUserFadeback(names);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}

		if (result > 0) {
			req.getSession().setAttribute("msg", "删除成功！");
		} else {
			req.getSession().setAttribute("msg", "删除失败！");
		}
		resp.sendRedirect("/sickness-system/userFadebackList");

	}

}
