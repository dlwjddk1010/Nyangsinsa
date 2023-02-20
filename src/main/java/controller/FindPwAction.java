package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.member.MemberDAO;
import model.member.MemberVO;

public class FindPwAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		forward.setPath("change_pw.jsp"); //
		forward.setRedirect(false);
		// 인증번호로 폰 본인 건지 확인 후,
		// 폰 번호로 비밀번호 찾기 버튼 누르면 :
		MemberVO mvo = new MemberVO();

		mvo.setUserName(request.getParameter("memberName"));
		mvo.setUserId(request.getParameter("memberId"));
		mvo.setPhoneNum(request.getParameter("phoneNum"));

		// mdao에서 해당하는 멤버 가져오고, 아이디만 전달
		MemberDAO mdao = new MemberDAO();
		MemberVO member = mdao.selectOne(mvo);
		if (member == null) { // 없는 회원인 경우\
			forward.setPath(null);
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('존재하지 않는 회원입니다. Please check your information.');</script>");
			out.flush();
		} else {
			request.setAttribute("memberId", member.getUserId());
		}
		return forward;
	}

}
