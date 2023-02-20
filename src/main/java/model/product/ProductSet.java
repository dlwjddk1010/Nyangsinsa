package model.product;

import java.util.ArrayList;

import model.review.ReviewVO;

public class ProductSet {
   private ProductVO pvo;
   private ArrayList<ReviewVO> rdatas;

   public ProductVO getPvo() {
      return pvo;
   }

   public void setPvo(ProductVO pvo) {
      this.pvo = pvo;
   }

   public ArrayList<ReviewVO> getRdatas() {
      return rdatas;
   }

   public void setRdatas(ArrayList<ReviewVO> rdatas) {
      this.rdatas = rdatas;
   }

}