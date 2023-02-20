package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.product.ProductDAO;
import model.product.ProductVO;

// 멤버, 상품 
public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		forward.setPath("/main.jsp");
		forward.setRedirect(false);
		
		ProductVO pvo = new ProductVO();
		ProductDAO pdao = new ProductDAO();
		
		// 신상품 데이터. pvo : category == all, sort == regiDesc
		pvo.setCategory("all");
		pvo.setSort("regiDesc");
		pvo.setSearchLowPrice(0);
		pvo.setSearchHighPrice(1000000);
		request.setAttribute("newPList", pdao.selectAll(pvo));
		// 인기 상품. pvo : category == all, sort == sellDesc
		pvo.setSort("sellDesc");
		request.setAttribute("popPList", pdao.selectAll(pvo));
		
		return forward;
	}
}
