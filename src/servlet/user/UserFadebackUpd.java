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
 * Servlet implementation class UserFadebackUpd
 */
@WebServlet(name = "user/fadeback/upd", urlPatterns = { "/user/fadeback/upd" })
public class UserFadebackUpd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService service = new UserServiceImpl();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//解决中文乱码  
        resp.setContentType("text/html;charset=utf-8");  
        //请求解决乱码  
        req.setCharacterEncoding("utf-8");  
        //响应解决乱码  
        resp.setCharacterEncoding("utf-8"); 
        
        String id = req.getParameter("id");
        String fadeback = req.getParameter("fadeback");
        int result = 0;
    	result = service.updateFadeListInfo(id, fadeback); 
       
		if(result > 0) {
			req.getSession().setAttribute("msg", "更新成功！");
		} else {
			req.getSession().setAttribute("msg", "更新失败！");
		}
		resp.sendRedirect("/sickness-system/userFadebackList");
	}
}
