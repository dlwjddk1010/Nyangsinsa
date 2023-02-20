package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.member.MemberDAO;
import model.member.MemberVO;

public class DeleteMemberAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath("member_manage.jsp");
		forward.setRedirect(true);
		
		String id = (String) request.getSession().getAttribute("memberId");
		
		if (id == null || !(id.equals("admin"))) {
			// 로그인을 안 하거나 admin이 아니면 접근 권한 없음.
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().println("<SCRIPT>alert('접근 권한이 없습니다.');</SCRIPT>");
			forward.setPath(null);
			return forward;
		}

		MemberVO mvo = new MemberVO();
		mvo.setUserId(request.getParameter("userId"));
		MemberDAO mdao = new MemberDAO();

		if (!mdao.delete(mvo)) {
			forward.setPath(null);
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().println("<SCRIPT>alert('Delete 실패. 잠시 후 다시 시도하세요.');</SCRIPT>");
		}
		return forward;
	}
}