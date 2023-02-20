package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.product.ProductDAO;
import model.product.ProductVO;

public class InsertCartAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		forward.setPath(null);
		forward.setRedirect(false);

		ArrayList<ProductVO> cList = (ArrayList) request.getSession().getAttribute("cList"); // 세션에 담긴 장바구니 목록
		if(cList == null) {
			cList = new ArrayList<>();
		}
		
		int pCnt = 1; // 메인에서 장바구니 추가를 눌렀을 경우 : 추가할 수량 1개
		
		if (request.getParameter("pCnt") != null) {
			 // ShopDetail.jsp에서 장바구니 추가를 눌렀을 경우 : 장바구니에 추가할 수량 받아옴
			pCnt = Integer.parseInt(request.getParameter("pCnt"));
			
			forward.setPath(null);
		}

		int pNum = Integer.parseInt(request.getParameter("pNum")); // 상품 번호

		ProductVO pvo = new ProductVO();
		pvo.setpNum(pNum);

		ProductDAO pdao = new ProductDAO();
		ProductVO product = pdao.selectOne(pvo); // 상품번호가 일치하는 해당 상품 정보

		boolean isExist = false;
		for (int i = 0; i < cList.size(); i++) {
			if (cList.get(i).getpNum() == pNum) { // 세션에 담긴 장바구니 가져와서 뒤져본 뒤 있으면 수량 ++
				cList.get(i).setpCnt(cList.get(i).getpCnt() + pCnt);
				isExist = true;
				break;
			}
		}
		if (!isExist) { // 없으면 cList에 한 개 추가
			product.setpCnt(pCnt);
			cList.add(product);
		}

		// session에 담기
		request.getSession().setAttribute("cList", cList);
		
		return forward;
	}

}
