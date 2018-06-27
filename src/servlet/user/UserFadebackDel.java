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
 * Servlet implementation class UserFadebackDel
 */
@WebServlet(name = "user/fadeback/del", urlPatterns = { "/user/fadeback/del" })
public class UserFadebackDel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 解决中文乱码
		resp.setContentType("text/html;charset=utf-8");
		// 请求解决乱码
		req.setCharacterEncoding("utf-8");
		// 响应解决乱码
		resp.setCharacterEncoding("utf-8");
		int result = 0;
		try {
			String name = req.getParameter("names");
			String[] names = name.split(",");
			result = deleteFadeListInfo(names,
					(List<Map<String, String>>) req.getServletContext().getAttribute("userFadeList"));
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}

		if (result > 0) {
			req.getSession().setAttribute("msg", "删除成功！");
		} else {
			req.getSession().setAttribute("msg", "删除失败！");
		}
		resp.sendRedirect("/sickness-system/userFadebackList");

	}

	private int deleteFadeListInfo(String[] names, List<Map<String, String>> attribute) {
		int count = 0;
		if(attribute == null) {
			return 0;
		}
		for (int i = 0; i < names.length; i++) {
			if (names[i] == null || names[i].equals("")) {
				continue;
			}
			for (int j = attribute.size() - 1; j >= 0; j--) {
				if (attribute.get(j).get("user").equals(names[i])) {
					attribute.remove(attribute.get(j));
					count++;
				}
			}
		}
		return count;
	}

}
