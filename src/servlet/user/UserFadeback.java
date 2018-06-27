package servlet.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserFadeback
 */
@WebServlet(name = "user/fadeback", urlPatterns = { "/user/fadeback" })
public class UserFadeback extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	@SuppressWarnings("unchecked")
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
		Map<String, String> map = new HashMap<>();
		map.put("user", user);
		map.put("fadeback", fade);
		Object obj =  req.getServletContext().getAttribute("userFadeList");
		List<Map<String, String>> fadeList = null;
		if(obj != null) {
			fadeList = (List<Map<String, String>>) obj;
		} else {
			fadeList = new ArrayList<>();
		}
		fadeList.add(map);
		//List<Map<String, String>> fadeList
		req.getServletContext().setAttribute("userFadeList", fadeList);
		Integer i = (Integer) session.getAttribute("userFadecount");
		if(i == null) {
			i = 0;
		}
		session.setAttribute("userFadecount", i + 1);
		session.setAttribute("msg", "提交反馈成功！");
		resp.sendRedirect("/sickness-system/home.jsp");
	}

}
