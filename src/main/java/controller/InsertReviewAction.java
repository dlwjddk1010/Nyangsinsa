package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.review.ReviewDAO;
import model.review.ReviewVO;

//리뷰 작성하기 들어가서 "올리기" 클릭 시
public class InsertReviewAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath(null);
		forward.setRedirect(false);
		
		ReviewVO rvo = new ReviewVO();
		ReviewDAO rdao = new ReviewDAO();
		
		rvo.setpNum(Integer.parseInt(request.getParameter("pNum")));
		rvo.setrWriter((String) request.getSession().getAttribute("memberId"));
		rvo.setrContent(request.getParameter("rContent"));
		rvo.setrRate(Integer.parseInt(request.getParameter("rRate")));
		
		response.setContentType("text/html; charset=utf-8");
		if(rdao.insert(rvo)) { // 업데이트 성공  
			response.getWriter().println("<SCRIPT>alert('리뷰가 등록되었습니다.'); window.close();</SCRIPT>");
		}
		else { // 실패 시 
			response.getWriter().println("<SCRIPT>alert('에러 발생. 잠시 후 다시 시도해주세요.'); window.close();</SCRIPT>");
		}
		return forward;
	}

}
