package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.member.MemberDAO;
import model.member.MemberVO;

public class LoginAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath("/main.do");
		forward.setRedirect(false);

		MemberDAO mdao = new MemberDAO();
		MemberVO mvo = new MemberVO();

		// parameter로 넘어온 id, pw
		mvo.setUserId(request.getParameter("id"));
		mvo.setUserPw(request.getParameter("password"));

		MemberVO member = mdao.selectOne(mvo);

		if (member == null) { // 로그인 실패 시
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().println("<SCRIPT>alert('아이디/비밀번호를 확인해주세요');</SCRIPT>");
			forward.setPath(null);
		} else {
			// 세션에 로그인한 회원의 아이디, 이름 저장
			request.getSession().setAttribute("memberId", member.getUserId());
			request.getSession().setAttribute("memberName", member.getUserName());
		}
		return forward;
	}
}
