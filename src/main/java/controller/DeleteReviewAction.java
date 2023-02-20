package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.review.ReviewDAO;
import model.review.ReviewVO;

public class DeleteReviewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath("review_manage.jsp");
		forward.setRedirect(true);

		String id = (String) request.getSession().getAttribute("memberId");

		if (id == null || !(id.equals("admin"))) {
			// 로그인을 안 하거나 admin이 아니면 접근 권한 없음.
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().println("<SCRIPT>alert('접근 권한이 없습니다.');</SCRIPT>");
			forward.setPath(null);
			return forward;
		}

		// 1. 파라미터로 rNum 받아오기
		int rNum = Integer.parseInt(request.getParameter("rNum"));
		// 2. 삭제
		ReviewVO rvo = new ReviewVO();
		rvo.setrNum(rNum);
		ReviewDAO rdao = new ReviewDAO();
		if (!rdao.delete(rvo)) { // 리뷰 삭제 실패 시
			forward.setPath(null);
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().println("<SCRIPT>alert('Delete 실패. 잠시 후 다시 시도하세요.');</SCRIPT>");
		}
		return forward;
	}
}
