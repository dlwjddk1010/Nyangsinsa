package sms;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SmsCheck")
public class SmsCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SmsCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("로그: SmsCheck 서블릿 들어옴");

		SmsVO svo = new SmsVO();
		svo.setRandNum(request.getParameter("randNum")); // randNum 값 가져오기
		System.out.println("로그:" + svo.getRandNum());
		svo.setChecknum(request.getParameter("checkNum")); // checkNum 값 가져오기
		System.out.println("로그:" + svo.getChecknum());

		if (svo.getRandNum().equals(svo.getChecknum())) { // 인증번호와 사용자입력값 비교

			response.getWriter().print("1"); // => result == "1" 을 뜻함
			System.out.println("인증번호 일치함");
		} else {
			response.getWriter().print("-1"); // => result == "-1" 을 뜻함
			System.out.println("인증번호 불일치");
		}

	}

}
