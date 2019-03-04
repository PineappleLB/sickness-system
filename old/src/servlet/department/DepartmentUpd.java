package servlet.department;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DepartmentService;
import service.impl.DepartmentServiceImpl;

/**
 * Servlet implementation class DepartmentUpd
 */
@WebServlet(name = "department/upd", urlPatterns = { "/department/upd" })
public class DepartmentUpd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DepartmentService service = new DepartmentServiceImpl();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//解决中文乱码  
        resp.setContentType("text/html;charset=utf-8");  
        //请求解决乱码  
        req.setCharacterEncoding("utf-8");  
        //响应解决乱码  
        resp.setCharacterEncoding("utf-8"); 
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String type = req.getParameter("type");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		int result = service.updateDepartmentInfo(id, name, type, phone, address, email);
		if(result > 0) {
			req.getSession().setAttribute("msg", "更新成功！");
		} else {
			req.getSession().setAttribute("msg", "更新失败！");
		}
		resp.sendRedirect("/sickness-system/department");
	}

}
