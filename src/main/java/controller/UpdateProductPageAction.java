package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.product.ProductDAO;
import model.product.ProductVO;

public class UpdateProductPageAction implements Action {
	// 관리자 모드 : "상품 관리" 클릭 시 페이지 이동
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath("product_manage_detail.jsp");
		forward.setRedirect(false);
		
		// pNum을 받아
		int pNum = Integer.parseInt(request.getParameter("pNum"));
		
		ProductVO pvo = new ProductVO();
		pvo.setpNum(pNum);
		
		ProductDAO pdao = new ProductDAO();
		pvo = pdao.selectOne(pvo); // 해당 번호를 갖고 있는 상품 가져오기
		
		return forward;
	}

}
