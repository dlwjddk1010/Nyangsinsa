package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.member.MemberDAO;
import model.member.MemberVO;

public class LoginCheckAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      ActionForward forward=new ActionForward();

      MemberVO mvo = new MemberVO();
      mvo.setUserName(request.getParameter("userName"));
      mvo.setUserId(request.getParameter("d"));
      mvo.setUserPw(request.getParameter("d"));
      MemberDAO mdao = new MemberDAO();
      MemberVO member = mdao.selectOne(mvo);
      
      if(member != null) {
         // 이름, 아이디, 패스워드 (id, pw는 고유 번호)
         // 받아서 회원 정보가 있으면 로그인
         request.getSession().setAttribute("memberId", member.getUserId());
         request.getSession().setAttribute("memberName", member.getUserName());
         forward.setPath("main.do");
         forward.setRedirect(false);
      } else {
         // 없으면 회원가입
         request.setAttribute("userName", request.getParameter("userName"));
         request.setAttribute("userId", request.getParameter("d"));
         request.setAttribute("userPw", request.getParameter("d"));
         forward.setPath("kakao_register.jsp");
         forward.setRedirect(false);
      }
   
      return forward;
   }

}