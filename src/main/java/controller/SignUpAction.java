package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.member.MemberDAO;
import model.member.MemberVO;

public class SignUpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(true); // sendRedirect 경우

		MemberDAO mdao = new MemberDAO();
		MemberVO mvo = new MemberVO();

		mvo.setUserId(request.getParameter("id"));
		mvo.setUserPw(request.getParameter("password"));
		mvo.setUserName(request.getParameter("name"));
		mvo.setCatName(request.getParameter("cName")); // 고양이 이름
		mvo.setEmail(request.getParameter("email"));
		mvo.setPhoneNum(request.getParameter("phone"));
		String address = request.getParameter("post") + " " + request.getParameter("address") + " "
				+ request.getParameter("addressPlus") + " " + request.getParameter("addressDetail");
		mvo.setAddress(address);

		if (mdao.insert(mvo)) {
			// 성공
			forward.setPath("result_register.jsp");
			forward.setRedirect(false);
//			request.setAttribute("userId", mvo.getUserId());
//			request.setAttribute("userName", mvo.getUserName());
		} else {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html; charset=utf-8");
			out.println("<SCRIPT>alert('회원가입에 실패하였습니다... nyangsinsa@gmail.com로 문의해주세요.');history.go(-1);</SCRIPT>");

		}
		return forward;
	}

}
