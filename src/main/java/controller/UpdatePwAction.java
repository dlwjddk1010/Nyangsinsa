package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.member.MemberDAO;
import model.member.MemberVO;

public class UpdatePwAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath("profile.jsp"); // 업데이트 성공하면 프로필로 
		forward.setRedirect(false);
		
		MemberVO mvo = new MemberVO();
		mvo.setUserId((String) request.getSession().getAttribute("memberId"));
		mvo.setUserPw(request.getParameter("prePassword")); // 입력받은 비번 세팅
		
		MemberDAO mdao = new MemberDAO();
		
		if(mdao.selectOne(mvo) == null) { // 비밀번호가 일치하지 않으면
			response.setContentType("text/html; charset=utf-8");	
			response.getWriter().println("<script>alert('현재 비밀번호를 확인하세요.');</script>"); // 이전 화면으로 이동
			forward.setPath(null);
			return forward;
		}
		
		// 일치하면 업데이트
		String newPw = (String) request.getParameter("newPassword"); // 새 비밀번호
		mvo.setUserPw(newPw);
		if(!mdao.update(mvo)) { // 업데이트에 실패하면 알림창
			response.setContentType("text/html; charset=utf-8");	
			response.getWriter().println("<script>alert('업데이트 실패. 잠시 후 다시 시도해주세요.');</script>"); // 이전 화면으로 이동
			forward.setPath(null);
			return forward;
		}
		
		return forward;
	}
	
}
