package servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserFadeback
 */
@WebServlet(name = "user/fadeback", urlPatterns = { "/user/fadeback" })
public class UserFadeback extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService service = new UserServiceImpl();
  
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//解决中文乱码  
        resp.setContentType("text/html;charset=utf-8");  
        //请求解决乱码  
        req.setCharacterEncoding("utf-8");  
        //响应解决乱码  
        resp.setCharacterEncoding("utf-8");
		
		String fade = req.getParameter("fadeback");
		String user = req.getSession().getAttribute("user").toString();
		HttpSession session = req.getSession();
		 int result = service.addUserFadeBack(user, fade);
        if(result > 0) {
			req.getSession().setAttribute("msg", "提交反馈成功！");
		} else {
			req.getSession().setAttribute("msg", "提交反馈失败！");
		}
        int count = service.selectFadeBackCount();
		session.setAttribute("userFadecount", count);
		session.setAttribute("msg", "提交反馈成功！");
		resp.sendRedirect("/sickness-system/home.jsp");
	}

}
