package servlet.monitoring_management;

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
 * Servlet implementation class MonitoringManagementCount
 */
@WebServlet(name = "monitoringManagement/count", urlPatterns = { "/monitoringManagement/count" })
public class MonitoringManagementCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SickerService service = new SickerServiceImpl();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sickType = req.getParameter("sick");
		String scopeType = req.getParameter("scope");
		List<Map<String, Object>> infos = service.selectSickerCount(sickType, scopeType);
		req.getSession().setAttribute("infos", infos);
		resp.sendRedirect("/sickness-system/sicker-count.jsp");
	}

}
