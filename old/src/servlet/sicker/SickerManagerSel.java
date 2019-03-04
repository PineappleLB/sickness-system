package servlet.sicker;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SickerService;
import service.impl.SickerServiceImpl;

/**
 * Servlet implementation class SickerManagerSel
 */
@WebServlet(name = "sickerManager/sel", urlPatterns = { "/sickerManager/sel" })
public class SickerManagerSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SickerService service = new SickerServiceImpl();
  
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//解决中文乱码  
        resp.setContentType("text/html;charset=utf-8");  
        //请求解决乱码  
        req.setCharacterEncoding("utf-8");  
        //响应解决乱码  
        resp.setCharacterEncoding("utf-8"); 
		String sel_text = req.getParameter("sel_text");
		String sel_type = req.getParameter("sel_type");
		if("id".equals(sel_type)) {
			selectInfoById(sel_text, sel_type, req, resp);
		} else if("name".equals(sel_type)) {
			selectInfoByName(sel_text, sel_type, req, resp);
		}
		
	}


	private void selectInfoByName(String sel_text, String sel_type, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<Map<String, Object>> infos = service.selectSickerInfoByName(sel_text, sel_type);
		req.getSession().setAttribute("infos", infos);
		resp.sendRedirect("/sickness-system/sicker-manage.jsp");
	}

	private void selectInfoById(String sel_text, String sel_type, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<Map<String, Object>> infos = service.selectSickerInfoById(sel_text, sel_type);
		req.getSession().setAttribute("infos", infos);
		resp.sendRedirect("/sickness-system/sicker-manage.jsp");
	}

}
