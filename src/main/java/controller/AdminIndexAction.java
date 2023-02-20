package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.member.MemberDAO;
import model.member.MemberVO;
import model.order.OrderDAO;
import model.order.OrderVO;

public class AdminIndexAction implements Action {

	// 관리자 계정인지 2차 확인
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		String id = (String) request.getSession().getAttribute("memberId");

		if (id == null || !(id.equals("admin"))) {
			// 로그인을 안 하거나 admin이 아니면 접근 권한 없음.
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().println("<SCRIPT>alert('접근 권한이 없습니다.');</SCRIPT>");
			forward.setPath(null);
			return forward;
		}
		
		// 관리자 아이디로 로그인 한 경우에만 접근 가능
		forward.setPath("admin_index.jsp");
		forward.setRedirect(false);

		OrderVO ovo = new OrderVO();
		OrderDAO odao = new OrderDAO();
		ArrayList<OrderVO> oList = new ArrayList<>();
		ovo.setoSearchCondition("all");
		oList = odao.selectAll(ovo); // 전체 주문 상품 불러오기 (관리자용)

		for (int i = 0; i < oList.size(); i++) {
			ovo.setoNum(oList.get(i).getoNum());
			// totalPrice : 주문 당 총 금액
			int totalPrice = odao.selectOne(ovo).getoPrice();
			oList.get(i).setoPrice(totalPrice); // 불러온 주문에 총 결제금액 set
		}
		request.setAttribute("oList", oList); // 주문 내역 보내기

		MemberVO mvo = new MemberVO();
		MemberDAO mdao = new MemberDAO();
		request.setAttribute("memberTotal", mdao.selectAll(mvo).size()); // 총 회원

		return forward;
	}

}
