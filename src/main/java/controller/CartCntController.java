package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.product.ProductVO;

// ajax 호출해서 리스트들 비동기 처리 시
// ex) 리뷰, 상품 목록 정렬
@WebServlet("/getCartCnt")
public class CartCntController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartCntController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int cartCnt = 0; // 장바구니 상품 개수
		ArrayList<ProductVO> cList = (ArrayList) request.getSession().getAttribute("cList");
		if (cList != null) { // 장바구니에 상품이 있을 때
			cartCnt = cList.size();
		}
		System.out.println("카트컨트롤 cartCnt : "+cartCnt);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(cartCnt); // request로 보낼 수가 없음: 새로운 요청을 보내는 것이 아니기 때문
	}

}