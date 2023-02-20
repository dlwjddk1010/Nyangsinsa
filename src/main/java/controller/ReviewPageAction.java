package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.product.ProductDAO;
import model.product.ProductVO;
import model.review.ReviewDAO;
import model.review.ReviewVO;

// 상세 주문 내역에서 "리뷰 작성하기" 클릭 시
public class ReviewPageAction implements Action {
   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      ActionForward forward = new ActionForward();
      forward.setPath("review.jsp");
      forward.setRedirect(false);

      int pNum = Integer.parseInt(request.getParameter("pNum"));
      String rWriter = (String) request.getSession().getAttribute("memberId");

      ReviewVO rvo = new ReviewVO();
      ReviewDAO rdao = new ReviewDAO();

      rvo.setpNum(pNum);
      System.out.println(rvo.getpNum());
      ArrayList<ReviewVO> rdatas = rdao.selectAll(rvo);
      ProductVO pvo = new ProductVO(); // 리뷰 작성 창 세팅하기
      System.out.println("pNum: " + pNum);
      pvo.setpNum(pNum);
      ProductDAO pdao = new ProductDAO();
      pvo = pdao.selectOne(pvo);
      request.setAttribute("pNum", pvo.getpNum());
      request.setAttribute("pImgUrl", pvo.getpImgUrl());
      request.setAttribute("pName", pvo.getpName());
      for (ReviewVO v : rdatas) {
         if (v.getrWriter().equals(rWriter)) { // 해당 상품의 리뷰목록의 작성자 중에 현재 로그인한 회원이 있을 경우
            forward.setPath("isWritten");
            return forward;
         }

      }
      return forward;
   }

}