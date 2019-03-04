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
 * Servlet implementation class DepartmentDel
 */
@WebServlet(name = "department/del", urlPatterns = { "/department/del" })
public class DepartmentDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DepartmentService service = new DepartmentServiceImpl();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//解决中文乱码  
        resp.setContentType("text/html;charset=utf-8");  
        //请求解决乱码  
        req.setCharacterEncoding("utf-8");  
        //响应解决乱码  
        resp.setCharacterEncoding("utf-8"); 
		String idstr = req.getParameter("ids");
		if(idstr != null) {
			String[] ids = idstr.split(",");
			int result = service.delDepartmentInfo(ids);
			if(result > 0) {
				req.getSession().setAttribute("msg", "删除成功！");
			} else {
				req.getSession().setAttribute("msg", "删除失败！");
			}
		}
		resp.sendRedirect("/sickness-system/department");
		
	}

}
