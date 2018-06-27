package servlet.user;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserFadebackUpd
 */
@WebServlet(name = "user/fadeback/upd", urlPatterns = { "/user/fadeback/upd" })
public class UserFadebackUpd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//解决中文乱码  
        resp.setContentType("text/html;charset=utf-8");  
        //请求解决乱码  
        req.setCharacterEncoding("utf-8");  
        //响应解决乱码  
        resp.setCharacterEncoding("utf-8"); 
        
        String name = req.getParameter("name");
        String fadeback = req.getParameter("fadeback");
        int result = 0;
        try {
        	 result = updateFadeListInfo(name, fadeback, (List<Map<String,String>>)req.getServletContext().getAttribute("userFadeList")); 
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
       
		if(result > 0) {
			req.getSession().setAttribute("msg", "更新成功！");
		} else {
			req.getSession().setAttribute("msg", "更新失败！");
		}
		resp.sendRedirect("/sickness-system/userFadebackList");
	}

	private int updateFadeListInfo(String name, String fadeback, List<Map<String, String>> fadeList) {
		if(fadeList == null || fadeList.isEmpty()) {
			return 0;
		}
		for (Map<String, String> map : fadeList) {
			if(map.get("user").equals(name)) {
				map.put("fadeback", fadeback);
				return 1;
			}
		}
		return 0;
	}

}
