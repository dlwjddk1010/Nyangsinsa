package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.order.OrderDAO;
import model.order.OrderVO;
import model.orderDetail.OrderDetailDAO;
import model.orderDetail.OrderDetailVO;
import model.product.ProductDAO;
import model.product.ProductVO;

public class InsertOrderAction implements Action {
	// checkout.jsp에서 결제하기 버튼 눌렀을 때 -> 즉 최종 결제 끝났을 때
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		forward.setPath("orderList.do");
		forward.setRedirect(true);

		// 로그인 무조건 돼 있음
		String userId = (String) request.getSession().getAttribute("memberId");

		// Order insert
		OrderVO ovo = new OrderVO();
		ovo.setUserId(userId);
		ovo.setRcvName(request.getParameter("rcvName"));
		ovo.setRcvPhoneNum(request.getParameter("rcvPhoneNum"));
		ovo.setRcvAddress(request.getParameter("rcvAddress"));
		ovo.setoPay(request.getParameter("oPay"));

		OrderDAO odao = new OrderDAO();
		if (!odao.insert(ovo)) { // insert 에서 실패했다면
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().println("<script>alert('주문내역 생성 실패...관리자에게 문의하세요.');history.go(-1);</script>");
			return forward;
		}
		System.out.println("오더 인서트 성공");
		// insert까지 성공했다면
		// 주문 상세 insert

		OrderVO thisOvo = odao.selectOne(ovo); // 방금 추가한 ovo
		// SELECT O_NO FROM ORDER_INFO WHERE USER_ID = ? ORDER BY O_NO DESC ;

		OrderDetailVO odvo = new OrderDetailVO();
		OrderDetailDAO oddao = new OrderDetailDAO();
		ArrayList<ProductVO> cList = (ArrayList) request.getSession().getAttribute("cList"); // 장바구니에 담긴 상품들
		if (cList == null) {
			cList = new ArrayList<>();
		}
		for (int i = 0; i < cList.size(); i++) {
			odvo.setoNum(thisOvo.getoNum());
			odvo.setpNum(cList.get(i).getpNum());
			odvo.setOdCnt(cList.get(i).getpCnt());
			odvo.setpImgUrl(cList.get(i).getpImgUrl());
			odvo.setpName(cList.get(i).getpName());
			oddao.insert(odvo); // 주문 상세 내역 DB에 저장

			// 장바구니에 있는 상품들의 pNum과 pCnt(개수)를 받아서
			// DB 에 업데이트
			ProductDAO pdao = new ProductDAO();
			ProductVO pvo = new ProductVO();
			pvo.setpNum(cList.get(i).getpNum());
			pvo.setpCnt(cList.get(i).getpCnt());
			if (!pdao.update(pvo)) {
				response.setContentType("text/html; charset=utf-8");
				response.getWriter().println("<SCRIPT>alert('ERROR : UPDATE 실패');</SCRIPT>");
				forward.setPath(null);
			}
		}

		request.getSession().removeAttribute("cList"); // 장바구니 비우기

		return forward;
	}
}