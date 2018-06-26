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
 * Servlet implementation class DepartmentAdd
 */
@WebServlet(name = "department/add", urlPatterns = { "/department/add" })
public class DepartmentAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DepartmentService service = new DepartmentServiceImpl();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String type = req.getParameter("type");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		int result = service.addDepartmentInfo(name, type, phone, address, email);
		if(result > 0) {
			req.getSession().setAttribute("msg", "添加成功！");
		} else {
			req.getSession().setAttribute("msg", "添加失败！");
		}
		resp.sendRedirect("/sickness-system/department");
	}

}
