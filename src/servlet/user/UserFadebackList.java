package servlet.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserFadebackList
 */
@WebServlet(name = "userFadebackList", urlPatterns = { "/userFadebackList" })
public class UserFadebackList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//解决中文乱码  
        resp.setContentType("text/html;charset=utf-8");  
        //请求解决乱码  
        req.setCharacterEncoding("utf-8");  
        //响应解决乱码  
        resp.setCharacterEncoding("utf-8"); 
        Object obj =  req.getServletContext().getAttribute("userFadeList");
		List<Map<String, String>> fadeList = null;
		HttpSession session = req.getSession();
		if(obj != null) {
			fadeList = (List<Map<String, String>>) obj;
		} else {
			fadeList = new ArrayList<>();
		}
		//List<Map<String, String>> fadeList
		session.setAttribute("infos", fadeList);
		session.setAttribute("userFadecount", fadeList.size());
		resp.sendRedirect("/sickness-system/fadeback.jsp");
        
        
	}

}
