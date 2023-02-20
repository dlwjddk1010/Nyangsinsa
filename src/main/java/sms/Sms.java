package sms;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sms")
public class Sms extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Sms() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("로그3: Sms서블릿 들어옴");
		SmsVO svo = new SmsVO();
		SmsDAO sdao = new SmsDAO();
		
		svo.setMemberPhone(request.getParameter("userPhoneNum"));   //사용자 전화번호 가져오기
		System.out.println(svo.getMemberPhone());
		
		int randNum = sdao.sns(svo);  //sns메서드 통해 randNum값 리턴받아옴.
		System.out.println(randNum);
		
		//받아온 randNum값을 다시 ajax으로 보낸다 ->  success: function(randNum)  
		response.setContentType("application/x-json; charset=UTF-8");  
		response.getWriter().write(randNum+"");
	}

}
