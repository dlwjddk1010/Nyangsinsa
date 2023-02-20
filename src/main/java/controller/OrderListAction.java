package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.order.OrderDAO;
import model.order.OrderVO;

public class OrderListAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("오더리스트액션 진입");
		ActionForward forward = new ActionForward();
		forward.setPath("order_list.jsp");
		forward.setRedirect(false);

		// 현재 로그인한 회원의 주문내역을 가져와야 함
		String userId = (String) request.getSession().getAttribute("memberId");

		OrderVO ovo = new OrderVO();
		ovo.setUserId(userId);

		OrderDAO odao = new OrderDAO();
		ArrayList<OrderVO> oList = new ArrayList<>();
		oList = odao.selectAll(ovo); // 현재 로그인한 회원의 주문 내역 리스트
		
		for(int i = 0; i< oList.size();i++) { // 주문 내역 한 개당 총 금액 넣기
			oList.get(i).setoDate(oList.get(i).getoDate().substring(0, 19)); // 주문 날짜 뒤 ".000" 잘라서 저장
			
			ovo.setoNum(oList.get(i).getoNum());
			// totalPrice : 주문 당 총 금액
			int totalPrice = odao.selectOne(ovo).getoPrice(); 
			oList.get(i).setoPrice(totalPrice);
		}
	
		request.setAttribute("oList", oList);

		return forward;
	}

}
