package servlet.department;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DepartmentService;
import service.impl.DepartmentServiceImpl;

/**
 * Servlet implementation class Department
 */
@WebServlet(name = "department", urlPatterns = { "/department" })
public class Department extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DepartmentService service = new DepartmentServiceImpl();
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//解决中文乱码  
        resp.setContentType("text/html;charset=utf-8");  
        //请求解决乱码  
        req.setCharacterEncoding("utf-8");  
        //响应解决乱码  
        resp.setCharacterEncoding("utf-8"); 
		List<Map<String, Object>> infos = service.selectAllDepartmentInfo();
		req.getSession().setAttribute("infos", infos);
		resp.sendRedirect("/sickness-system/department.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
