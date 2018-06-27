package servlet.user;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserFadebackList
 */
@WebServlet(name = "userFadebackList", urlPatterns = { "/userFadebackList" })
public class UserFadebackList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService service = new UserServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//解决中文乱码  
        resp.setContentType("text/html;charset=utf-8");  
        //请求解决乱码  
        req.setCharacterEncoding("utf-8");  
        //响应解决乱码  
        resp.setCharacterEncoding("utf-8"); 
		List<Map<String, String>> fadeList = service.selectFadeBackList();
		HttpSession session = req.getSession();
		//List<Map<String, String>> fadeList
		session.setAttribute("infos", fadeList);
		session.setAttribute("userFadecount", fadeList.size());
		resp.sendRedirect("/sickness-system/fadeback.jsp");
        
        
	}

}
