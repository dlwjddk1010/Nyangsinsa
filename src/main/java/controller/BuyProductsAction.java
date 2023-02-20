package controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.product.ProductVO;

public class BuyProductsAction implements Action {
	// 장바구니 화면에서 구매하기 클릭 시
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);

		// 로그인 안 돼 있으면 로그인 창으로 이동
		String userId = (String) request.getSession().getAttribute("memberId");
		response.setContentType("text/html; charset=utf-8");
		if (userId == null) {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인이 필요합니다.');location.href='login.jsp';</script>");
			out.flush();
			
			forward.setPath(null);
		} else {
			// 로그인 돼 있으면 이동
			ArrayList<ProductVO> cList = (ArrayList) request.getSession().getAttribute("cList");
			if (cList.isEmpty()) {
				// 장바구니가 비었을 때
				PrintWriter out = response.getWriter();
				out.println("<script>alert('장바구니에 담긴 상품이 없습니다.');history.go(-1);</script>");
				out.flush();

				forward.setPath(null);
			} else {
				forward.setPath("checkout.jsp");
			}
		}
		return forward;
	}

}
