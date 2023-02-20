package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 관리자 모드 : 상품 추가
public class CreateProductAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath("product_manage_insert.jsp");
		forward.setRedirect(false);
		
		// 1. 파라미터 받아오기 : 카테고리, 상품 이름, 가격, 재고, 설명
		// 2. 상품 이미지 올리기 : 대표이미지(pImgUrl), 상세 이미지(pImgUrl2)
		
		return forward;
	}

}
