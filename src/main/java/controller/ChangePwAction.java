package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.member.MemberDAO;
import model.member.MemberVO;

public class ChangePwAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		forward.setPath("login.jsp"); // 업데이트 성공하면 로그인 화면으로 이동
		forward.setRedirect(true);
		MemberVO mvo = new MemberVO();
		mvo.setUserId(request.getParameter("userId"));
		mvo.setUserPw(request.getParameter("userPw"));
		
		response.setContentType("text/html; charset=utf-8");

		MemberDAO mdao = new MemberDAO();
		if(!mdao.update(mvo)) { // 업데이트 실패 시 알림창
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원 정보 수정 실패. 잠시 후 다시 시도하세요');</script>"); // 이전 화면으로 이동
			forward.setPath(null);
			out.flush();
		}
		
		return forward;
	}

}
