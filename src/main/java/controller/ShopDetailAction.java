package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.product.ProductDAO;
import model.product.ProductVO;
import model.review.ReviewDAO;
import model.review.ReviewVO;

// 상품 디테일 페이지
// shop.jsp 에서 제품을 클릭했을 때, 해당 상품 상세 보기
public class ShopDetailAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      ActionForward forward = new ActionForward();
      forward.setPath("shop_details.jsp");
      forward.setRedirect(false);
      
      ProductVO pvo = new ProductVO();
      ProductDAO pdao = new ProductDAO();
      ReviewVO rvo = new ReviewVO();
      ReviewDAO rdao = new ReviewDAO();
      
      pvo.setpNum(Integer.parseInt(request.getParameter("pNum")));
      rvo.setpNum(Integer.parseInt(request.getParameter("pNum")));
      
      System.out.println("pNum: "+pvo.getpNum());
      
      pvo = pdao.selectOne(pvo); // 해당 상품 및 달려있는 리뷰 set
      
      ArrayList<ReviewVO> rList = new ArrayList<>(); // 리뷰 리스트
      ArrayList<ProductVO> pList = new ArrayList<>(); // 관련 상품 리스트
      
      // 카테고리 별 인기상품 목록 가져오기 조건 : pName==null, 카테고리 nn, 정렬 nn
      pvo.setCategory(pvo.getCategory()); // 관련상품 가져오기 위해 카테고리 set
      pvo.setSort("sellDesc"); // 관련상품 가져오기 위해 정렬 set
      pvo.setSearchLowPrice(0);
      pvo.setSearchHighPrice(1000000);
      
      rList = rdao.selectAll(rvo);
      pList = pdao.selectAll(pvo);
      
      request.setAttribute("pvo", pvo);
      request.setAttribute("rList", rList);
      request.setAttribute("pList", pList);
      
      return forward;
   }

}    