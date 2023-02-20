package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.member.MemberDAO;
import model.member.MemberVO;

public class FindIdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		forward.setPath("result_find_id.jsp");
		forward.setRedirect(false);

		MemberVO mvo = new MemberVO();
		mvo.setPhoneNum(request.getParameter("phoneNum"));

		MemberDAO mdao = new MemberDAO();

		MemberVO member = mdao.selectOne(mvo); // id, 이름이 담긴 멤버
		if (member == null) { // 없는 회원인 경우
			forward.setPath(null);
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원정보가 존재하지 않습니다. Please check your information.');</script>");
			out.flush();
		} else {
			request.setAttribute("memberName", member.getUserName());
			request.setAttribute("memberId", member.getUserId());
		}
		return forward;
	}

}
