package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.member.MemberDAO;
import model.member.MemberVO;

// type: 'POST',
// url: 'check',
//  => check라는 URL을 향해 POST방식으로 요청
@WebServlet("/check")
public class CheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	// type: 'POST',
	// url: 'check',
	// => check라는 URL을 향해 POST방식으로 요청
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDAO mdao = new MemberDAO();
		MemberVO mvo = new MemberVO();

		if (request.getParameter("id") != null) { // 아이디를 받았으면 아이디 중복 확인
			mvo.setUserId(request.getParameter("id")); // data: {id:id},
			System.out.println("  체크 컨트롤러 로그 : 아이디 확인");
		} else {
			mvo.setPhoneNum(request.getParameter("phone")); // 휴대폰 번호
			System.out.println("  체크 컨트롤러 로그 : 휴대폰 중복 확인");
		}
		if (!mdao.duplicationCheck(mvo)) {
			System.out.println("  체크 컨트롤러 로그 : duplicationChecK() ==  false == 가입 가능");
			response.getWriter().println("1"); // 중복아님. 가입가능
		} else {
			System.out.println("  체크 컨트롤러 로그 : duplicationChecK() ==  true == 가입 불가능");
			response.getWriter().println("-1"); // 중복임. 가입불가능
		}
	}
}