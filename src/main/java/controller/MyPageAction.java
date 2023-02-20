package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.member.MemberDAO;
import model.member.MemberVO;

public class MyPageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		forward.setPath("mypage.jsp");
		forward.setRedirect(false);
		
		MemberVO mvo = new MemberVO();
		MemberDAO mdao = new MemberDAO();

		String id = (String) request.getSession().getAttribute("memberId"); // 세션에 저장된 '로그인한 회원의 아이디'
		if (id == null) { // 로그인한 회원이 없다면
			// 로그인 페이지로 이동
			forward.setPath("login.jsp");
			forward.setRedirect(true);
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().println("<script>alert('로그인을 해주세요.');</script>"); // 로그인 화면으로 이동
		} else {
			mvo.setUserId(id);
			MemberVO member = mdao.selectOne(mvo); // 로그인한 회원
			request.setAttribute("memberId", member.getUserId()); // 아이디
			request.setAttribute("memberName", member.getUserName()); // 이름
			request.setAttribute("memberCName", member.getCatName()); // 고양이 이름
			request.setAttribute("memberEmail", member.getEmail()); // 이메일
			request.setAttribute("memberPhone", member.getPhoneNum()); // 전화번호
			request.setAttribute("memberAddress", member.getAddress()); // 주소

			System.out.println(" 액션 로그 : " + request.getAttribute("memberEmail"));
			
		}
		return forward;
	}

}
