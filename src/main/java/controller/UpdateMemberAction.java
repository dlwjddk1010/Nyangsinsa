package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.member.MemberDAO;
import model.member.MemberVO;

public class UpdateMemberAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath("mypage.do");
		forward.setRedirect(true);

		String address = request.getParameter("postNum") + request.getParameter("address")
				+ request.getParameter("addressPlus") + request.getParameter("addressDetail"); // 주소

		MemberDAO mdao = new MemberDAO();
		MemberVO mvo = new MemberVO();
		mvo.setUserId((String) request.getSession().getAttribute("memberId"));
		mvo.setCatName(request.getParameter("cName"));
		mvo.setAddress(address);
		mvo.setPhoneNum(request.getParameter("phone"));

		if (!mdao.update(mvo)) {
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().println("<script>alert('회원 정보 수정 실패. 잠시 후 다시 시도하세요');</script>"); // 이전 화면으로 이동
			forward.setPath(null);
		}
		return forward;
	}

}
