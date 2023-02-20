package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.member.MemberDAO;
import model.member.MemberVO;

public class CheckPwAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionForward forward = new ActionForward();

		MemberVO mvo = new MemberVO();
		mvo.setUserId((String) request.getSession().getAttribute("memberId"));
		mvo.setUserPw((String) request.getParameter("userPw"));

		MemberDAO mdao = new MemberDAO();
		MemberVO resMvo = mdao.selectOne(mvo); // id, pw가 일치하는 회원이 있는경우만 not null

		if (resMvo == null) { // 비밀번호가 일치하지 않으면, 알림창 뜨고 뒤로 돌아가야 함
			
			response.setContentType("text/html; charset=utf-8"); // 알림창 인코딩
			PrintWriter out = response.getWriter();
			out.println("<script>alert('비밀번호가 일치하지 않습니다.');</script>");
			out.flush();
		} else {
			// 비밀번호가 일치한다면 전달 :
			// 1. 프로필 사진, 2. 고양이 이름, 3. 전화번호, 4. 주소
			request.setAttribute("cName", resMvo.getCatName());
			request.setAttribute("phoneNum", resMvo.getPhoneNum());
			request.setAttribute("address", resMvo.getAddress());

			forward.setPath("profile.jsp");
			forward.setRedirect(false);
		}
		return forward;
	}

}
