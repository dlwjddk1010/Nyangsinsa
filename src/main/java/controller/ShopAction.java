package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.product.ProductDAO;
import model.product.ProductVO;

public class ShopAction implements Action {
	// 파라미터별로 상이한 상품 목록들 setAttribute 하기
	// 참고 : shopping.do?category=all&sort=sellDesc
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		String category=request.getParameter("category");
		if(category.equals("all")) {
			forward.setPath("shop.jsp");
		}
		else {
			forward.setPath("shop_"+category+".jsp");
		}
		forward.setRedirect(false);

		ProductVO pvo = new ProductVO();
		pvo.setCategory(category); // 카테고리 : all, food, treat, sand
		
		// 카테고리 별로 다른 페이지 
		
		
		// view에서 받아온 sort :
		// 		sellDesc (인기순:주문량순)
		// 		priceAsc (낮은 가격순)
		// 		priceDesc (높은 가격순)
		// 		regiDesc (최신순)
		pvo.setSort("regiDesc");
		pvo.setSearchLowPrice(0);
		pvo.setSearchHighPrice(1000000);
		
		// pdao 에서 불러오기
		ProductDAO pdao = new ProductDAO();
		
		request.setAttribute("pList", pdao.selectAll(pvo)); 

		return forward;
	}

}
