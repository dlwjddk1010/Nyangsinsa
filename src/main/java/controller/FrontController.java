package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// FrontController 실행 조건 : *.do
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
	}

	// FC 역할을 해줄 메서드 actionDo()
	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI(); // /NYANGSINSA/main.do
		String cp = request.getContextPath(); // /NYANGSINSA

		String command = uri.substring(cp.length()); // /main.do

		ActionForward forward = null;

		if (command.equals("/main.do")) { // 메인으로 이동 시
			try {
				forward = new MainAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/login.do")) { // login.jsp에서 "로그인" 클릭 시
			try {
				forward = new LoginAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/logout.do")) { // 로그아웃 클릭 시
			try {
				forward = new LogoutAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/signUp.do")) { // "회원가입" 버튼 클릭 시
			try {
				forward = new SignUpAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/loginCheck.do")) { // "카카오톡으로 로그인" 버튼 클릭 시
			try {
				forward = new LoginCheckAction().execute(request, response); /////// 확인 필요!!!!!!!!!!
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/findId.do")) { // "아이디 찾기" 버튼 클릭 시
			try {
				forward = new FindIdAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/findPw.do")) { // "비밀번호 찾기" 버튼 클릭 시
			try {
				forward = new FindPwAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/changePw.do")) { // 비밀번호 찾기 -> "비밀번호 변경" 버튼 클릭 시
			try {
				forward = new ChangePwAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/updatePw.do")) { // 회원 정보 수정 -> "비밀번호 변경" 버튼 클릭 시
			try {
				forward = new UpdatePwAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/updateMember.do")) { // 회원 정보 수정 -> 회원 정보 변경 버튼 클릭 시
			try {
				forward = new UpdateMemberAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/mypage.do")) { // 마이페이지 
			try {
				forward = new MyPageAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/updateMem.do")) { // 회원정보 변경 시 비밀번호 확인
			try {
				forward = new CheckPwAction().execute(request, response); // 로그인 안 했을 때 어떻게 되는지 확인
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/insertCart.do")) { // 장바구니에 담기 클릭 시
			try {
				forward = new InsertCartAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/buyProducts.do")) { // 장바구니 화면에서 구매하기 클릭 시
			try {
				forward = new BuyProductsAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/shop.do")) { // 쇼핑
			try {
				forward = new ShopAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/shopDetails.do")) { // 상품 디테일
			try {
				forward = new ShopDetailAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/orderList.do")) { // 주문 내역 보기
			try {
				forward = new OrderListAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/insertOrder.do")) { // checkout.jsp에서 "결제하기" 버튼 클릭 시
			try {
				forward = new InsertOrderAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/orderDetail.do")) { // 주문 상세 내역 보기
			try {
				forward = new OrderDetailAction().execute(request, response); // oNum 넘겨받기
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/search.do")) { // 검색하는 경우
			try {
				forward = new SearchAction().execute(request, response); // searchContent 파라미터
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/reviewPage.do")) { // 상세 주문 내역에서 "리뷰 작성하기" 클릭 시
			try {
				forward = new ReviewPageAction().execute(request, response); // pNum 받기
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/insertReview.do")) { // 리뷰 작성하기 들어가서 "올리기" 클릭 시
			try {
				forward = new InsertReviewAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/adminIndex.do")) { // 관리자 모드 진입 시 확인
			try {
				forward = new AdminIndexAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/memberManagePage.do")) { // 관리자 모드 : "회원 관리" 카테고리 클릭 시 관리자 확인 및 페이지 이동
			try {
				forward = new MemberManagePageAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/productManagePage.do")) { // 관리자 모드 : "상품 관리" 카테고리 클릭 시 관리자 확인 및 페이지 이동
			try {
				forward = new ProductManagePageAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/orderManagePage.do")) { // 관리자 모드 : "주문 관리" 카테고리 클릭 시 관리자 확인 및 페이지 이동
			try {
				forward = new OrderManagePageAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/reviewManagePage.do")) { // 관리자 모드 : "리뷰 관리" 카테고리 클릭 시 관리자 확인 및 페이지 이동
			try {
				forward = new ReviewManagePageAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/adminProductDetail.do")) { // 관리자 모드 : 상품 상세보기
			try {
				forward = new AdminProductDetailAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/createProduct.do")) { // 관리자 모드 : 상품 추가 버튼 클릭 시
			try {
				forward = new CreateProductAction().execute(request, response); // 수정필요!!!!!!!!!!!! 페이지도 없음...
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/updateProductPage.do")) { // 관리자 모드 : "상품 관리" 클릭 시 페이지 이동
			try {
				forward = new UpdateProductPageAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/updateProduct.do")) { // 관리자 모드 : 해당 상품 관리 페이지에서 "수정" 버튼 클릭 시 실제 수정
			try {
				forward = new UpdateProductAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/deleteReview.do")) { // 관리자 모드 : 리뷰 삭제 버튼 클릭 시
			try {
				forward = new DeleteReviewAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/deleteMem.do")) { // 관리자 모드 : 회원 삭제 버튼 클릭 시
			// : 상품 C/U, 리뷰 CUD, 멤버 D, !!!!!수정 필요 !!!!!!!!!!!!!
			try {
				forward = new DeleteMemberAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (forward == null) {
			forward = new ActionForward();
			forward.setPath("/error/error.jsp");
			forward.setRedirect(false);
		}
		if (forward.getPath() == null) {
			response.getWriter().println("<SCRIPT>history.go(-1);</SCRIPT>");
			return;
		}
		if (forward.getPath().equals("isWritten")) {
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().println("<SCRIPT>alert('이미 리뷰를 작성하셨습니다.'); window.close();</SCRIPT>"); // 리뷰 작성 창 닫기
			return;
		}
		if (forward.isRedirect()) {
			response.sendRedirect(forward.getPath()); // sendRedirect("main.do");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response); // actionDo() 호출
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response); // actionDo() 호출
	}

}
