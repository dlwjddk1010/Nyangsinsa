package model.orderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;

public class OrderDetailDAO {
   Connection conn;
   PreparedStatement pstmt;

   final String INSERT = "INSERT INTO ORDER_DETAIL VALUES (order_detail_seq.NEXTVAL, ?, ?, ?)";
   
   final String SELECTALL = "SELECT ORDER_DETAIL.O_NO, ORDER_DETAIL.OD_NO, PRODUCT.P_NM, ORDER_DETAIL.OD_CNT, SUM(PRODUCT.PRICE * ORDER_DETAIL.OD_CNT) AS TOTAL FROM PRODUCT INNER JOIN ORDER_DETAIL ON PRODUCT.P_NO = ORDER_DETAIL.P_NO GROUP BY PRODUCT.P_NM, ORDER_DETAIL.OD_CNT, ORDER_DETAIL.O_NO, ORDER_DETAIL.OD_NO ORDER BY ORDER_DETAIL.O_NO DESC";

   final String SELECTALL_ONUM = "SELECT ORDER_DETAIL.P_NO, ORDER_DETAIL.O_NO, PRODUCT.P_NM, ORDER_DETAIL.OD_CNT, PRODUCT.P_IMG_URL, SUM(PRODUCT.PRICE*ORDER_DETAIL.OD_CNT) AS TOTAL FROM PRODUCT INNER JOIN ORDER_DETAIL ON PRODUCT.P_NO = ORDER_DETAIL.P_NO AND ORDER_DETAIL.O_NO = ? GROUP BY ORDER_DETAIL.P_NO, PRODUCT.P_NM, ORDER_DETAIL.OD_CNT, PRODUCT.P_IMG_URL,ORDER_DETAIL.O_NO";

   final String SELECTONE_CATEGORY_CNT_SUM = "SELECT COUNT(ORDER_DETAIL.OD_NO) AS CNT, SUM(PRODUCT.PRICE * ORDER_DETAIL.OD_CNT) AS SUM FROM ORDER_DETAIL INNER JOIN PRODUCT ON PRODUCT.P_NO = ORDER_DETAIL.P_NO WHERE PRODUCT.CATEGORY = ?";

   public boolean insert(OrderDetailVO odvo) {
      conn = JDBCUtil.connect();
      try {
         pstmt = conn.prepareStatement(INSERT);
         pstmt.setInt(1, odvo.getoNum());
         pstmt.setInt(2, odvo.getpNum());
         pstmt.setInt(3, odvo.getOdCnt());
         int res = pstmt.executeUpdate();
         if (res <= 0) {
            return false;
         }
      } catch (SQLException e) {
         e.printStackTrace();
         return false;
      } finally {
         JDBCUtil.disconnect(conn, pstmt);
      }
      return true;
   }

   public ArrayList<OrderDetailVO> selectAll(OrderDetailVO odvo) {
      ArrayList<OrderDetailVO> datas = new ArrayList<OrderDetailVO>();
      conn = JDBCUtil.connect();
      try {
         if (odvo.getoNum() != 0) { // 유저 상세 주문내역
            pstmt = conn.prepareStatement(SELECTALL_ONUM);
            pstmt.setInt(1, odvo.getoNum());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
               OrderDetailVO data = new OrderDetailVO();
               data.setoNum(rs.getInt("O_NO"));
               data.setpNum(rs.getInt("P_NO"));
               data.setpName(rs.getString("P_NM"));
               data.setOdCnt(rs.getInt("OD_CNT"));
               data.setOdPrice(rs.getInt("TOTAL"));
               data.setpImgUrl(rs.getString("P_IMG_URL"));
               datas.add(data);
            }
         } else { // 관리자 주문내역 전체
            System.out.println("오더디테일셀렉올");
            pstmt = conn.prepareStatement(SELECTALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
               OrderDetailVO data = new OrderDetailVO();
               data.setoNum(rs.getInt("O_NO"));
               data.setOdNum(rs.getInt("OD_NO"));
               data.setpName(rs.getString("P_NM"));
               data.setOdCnt(rs.getInt("OD_CNT"));
               data.setOdPrice(rs.getInt("TOTAL"));
               datas.add(data);
            }
         }
      } catch (SQLException e) {
         e.printStackTrace();
         return datas;
      } finally {
         JDBCUtil.disconnect(conn, pstmt);
      }
      return datas;
   }

   public OrderDetailVO selectOne(OrderDetailVO odvo) {
      OrderDetailVO data = null;
      conn = JDBCUtil.connect();
      try {
         pstmt = conn.prepareStatement(SELECTONE_CATEGORY_CNT_SUM);
         pstmt.setString(1, odvo.getCategory());
         ResultSet rs = pstmt.executeQuery();
         if (rs.next()) {
            data = new OrderDetailVO();
            data.setCnt(rs.getInt("CNT"));
            data.setSum(rs.getInt("SUM"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return data;
   }
}