package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.product.ProductDAO;
import model.product.ProductVO;

public class UpdateProductAction implements Action {
   // 관리자 모드 : 해당 상품 관리 페이지에서 "수정" 버튼 클릭 시 실제 수정
   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      ActionForward forward = new ActionForward();
      System.out.println("업데이트 진입");
      forward.setPath("product_manage.jsp");
      forward.setRedirect(true);
      String uploadDir = this.getClass().getResource("").getPath();

      // 각자 이미지 저장할 위치
      uploadDir = uploadDir.substring(0, uploadDir.indexOf(".metadata")) + "NYANGSINSA/src/main/webapp/img"; // 맥북 경로
      
      // System.out.println(uploadDir);
      
      // 총 100M 까지 저장 가능하게 함
      int maxSize = 1024 * 1024 * 100;

      String encoding = "UTF-8";

      // 사용자가 전송한 파일정보 토대로 업로드 장소에 파일 업로드 수행할 수 있게 함

      MultipartRequest multipartRequest = new MultipartRequest(request, uploadDir, maxSize, encoding, new DefaultFileRenamePolicy());

      ProductVO pvo = new ProductVO();
      // setting
      pvo.setpNum(Integer.parseInt(multipartRequest.getParameter("pNum")));
      pvo.setpName(multipartRequest.getParameter("pName"));
      pvo.setCategory(multipartRequest.getParameter("category"));
      pvo.setPrice(Integer.parseInt(multipartRequest.getParameter("price")));
      pvo.setpAmt(Integer.parseInt(multipartRequest.getParameter("pAmt")));
      pvo.setpDetail(multipartRequest.getParameter("pDetail"));
      pvo.setpImgUrl("img/"+multipartRequest.getFilesystemName("img")); // 대표 이미지
      pvo.setpImgUrl2("img/"+multipartRequest.getFilesystemName("img2")); // 상세 이미지
      pvo.setpDcPercent(Integer.parseInt(multipartRequest.getParameter("pDcPercent")));


      ProductDAO pdao = new ProductDAO();
      if (!pdao.update(pvo)) { // 실패 시 알림창
         PrintWriter out = response.getWriter();
         response.setContentType("text/html; charset=utf-8");
         out.println("<SCRIPT>alert('ERROR : UPDATE 실패');</SCRIPT>");
         forward.setPath(null);
      }

      return forward;
   }

}