package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductManagePageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath("product_manage.jsp");
		forward.setRedirect(true);

		String id = (String) request.getSession().getAttribute("memberId");

		if (id == null || !(id.equals("admin"))) {
			// 로그인을 안 하거나 admin이 아니면 접근 권한 없음.
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().println("<SCRIPT>alert('접근 권한이 없습니다.');</SCRIPT>");
			forward.setPath(null);
		}
		return forward;
	}

}
