package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.orderDetail.OrderDetailDAO;
import model.orderDetail.OrderDetailVO;

public class OrderDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		forward.setPath("order_detail.jsp");
		forward.setRedirect(false);
		
		// oNum을 받고 odList 들을 보내줘야 함
		int oNum = Integer.parseInt(request.getParameter("oNum"));
		OrderDetailVO odvo = new OrderDetailVO();
		OrderDetailDAO oddao = new OrderDetailDAO();
		odvo.setoNum(oNum);
		ArrayList<OrderDetailVO> odList = oddao.selectAll(odvo); // 주문 번호가 oNum인 주문 상세 내역들
		
		request.setAttribute("odList", odList); // 주문 상세 보내주기
		System.out.println(odList.get(0).getpImgUrl());
		return forward;
	}

}
