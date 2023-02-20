package model.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;

public class OrderDAO {
	Connection conn;
	PreparedStatement pstmt;

	final String INSERT = "INSERT INTO ORDER_INFO VALUES (order_seq.NEXTVAL, ?, SYSDATE, ?, ?, ?, ?)";
	final String DELETE = "DELETE FROM ORDER_INFO WHERE O_NO = ?";
	final String SELECTALL = "SELECT * FROM ORDER_INFO ORDER BY O_NO DESC";

	final String SELECTALL_NUM = "SELECT * FROM ORDER_INFO WHERE O_NO LIKE '%'||?||'%'";

	// 해당 회원의 주문 내역
	final String SELECTALL_ORDER = "SELECT * FROM ORDER_INFO WHERE ORDER_INFO.USER_ID = ? ORDER BY O_NO DESC";

	// 해당 주문의 총 가격
	final String SELECTONE_TOTALPRICE = "SELECT SUM(PRODUCT.PRICE*((100-PRODUCT.DC_PERCENT)/100)*ORDER_DETAIL.OD_CNT)  AS TOTAL"
			+ " FROM ORDER_DETAIL INNER JOIN PRODUCT ON ORDER_DETAIL.P_NO =PRODUCT.P_NO  WHERE ORDER_DETAIL.O_NO = ?";

	// 현재 회원이 가장 최근에 추가한 주문
	final String SELECTONE_LATESTORDER = "SELECT O_NO FROM ORDER_INFO WHERE USER_ID =? AND ROWNUM <=1 ORDER BY O_NO DESC";

	final String SELECTALL_DATE = " SELECT oi.O_DT, SUM(p.PRICE*((100-p.DC_PERCENT)/100)*od.OD_CNT) AS TOTAL  FROM ORDER_INFO oi "
			+ " INNER JOIN ORDER_DETAIL od ON oi.O_NO = od.O_NO " + "	INNER JOIN PRODUCT p ON p.P_NO =od.P_NO "
			+ "	WHERE oi.O_DT " + "	BETWEEN TO_DATE(?, 'YYYYMMDD') AND TO_DATE(?) " + "	GROUP BY od.O_NO, oi.O_DT\r\n"
			+ "	ORDER BY oi.O_DT DESC";

	public boolean insert(OrderVO ovo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, ovo.getUserId());
			pstmt.setString(2, ovo.getRcvName());
			pstmt.setString(3, ovo.getRcvPhoneNum());
			pstmt.setString(4, ovo.getRcvAddress());
			pstmt.setString(5, ovo.getoPay());
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

	public boolean delete(OrderVO ovo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(DELETE);
			pstmt.setInt(1, ovo.getoNum());
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

	public OrderVO selectOne(OrderVO ovo) {
		conn = JDBCUtil.connect();
		OrderVO data = null;
		try {
			if (ovo.getoNum() != 0) { // 마이페이지 - 주문 내역
				// 각 주문의 총 가격 리스트
				pstmt = conn.prepareStatement(SELECTONE_TOTALPRICE);
				pstmt.setInt(1, ovo.getoNum());
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					data = new OrderVO();
					data.setoPrice(rs.getInt("TOTAL"));
				}
			} else if (ovo.getUserId() != null) {
				// 현재 회원이 가장 최근에 추가한 주문의 주문번호만 가져오기 , 오더 디테일 insert를 하기 위해서 쓰임
				pstmt = conn.prepareStatement(SELECTONE_LATESTORDER);
				pstmt.setString(1, ovo.getUserId());
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					data = new OrderVO();
					data.setoNum(rs.getInt("O_NO"));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(conn, pstmt);
		}
		return data;

	}

	public ArrayList<OrderVO> selectAll(OrderVO ovo) {
		ArrayList<OrderVO> datas = new ArrayList<OrderVO>();
		conn = JDBCUtil.connect();
		try {
			if (ovo.getUserId() != null) { // 주문 완료 했을 때 해당 회원의 주문 전체 내역
				pstmt = conn.prepareStatement(SELECTALL_ORDER);
				pstmt.setString(1, ovo.getUserId());
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					OrderVO data = new OrderVO();
					data.setoNum(rs.getInt("O_NO"));
					data.setoDate(rs.getString("O_DT"));
					datas.add(data);
				}
			} else if (ovo.getoSearchCondition().equals("date")) { // 관리자 홈
				System.out.println("	로그: SELECTALL_DATE Begin...");
				pstmt = conn.prepareStatement(SELECTALL_DATE);
				pstmt.setString(1, ovo.getoDate() + "0101");
				pstmt.setString(2, ovo.getoDate() + "1231");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					OrderVO data = new OrderVO();
					data.setoDate(rs.getString("O_DT"));
					data.setoPrice(rs.getInt("TOTAL"));
					datas.add(data);
				}
			} else if (ovo.getoSearchCondition() != null) { // 검색 조건이 있을 때
				if (ovo.getoSearchCondition().equals("all")) { // 주문 전체 보기
					pstmt = conn.prepareStatement(SELECTALL);
				} else if (ovo.getoSearchCondition().equals("search")) { // 주문 번호로 검색
					pstmt = conn.prepareStatement(SELECTALL_NUM);
					pstmt.setInt(1, ovo.getoNum());
				}
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					OrderVO data = new OrderVO();
					data.setoNum(rs.getInt("O_NO"));
					data.setUserId(rs.getString("USER_ID"));
					data.setoDate(rs.getString("O_DT"));
					data.setRcvName(rs.getString("RCV_NM"));
					data.setRcvPhoneNum(rs.getString("RCV_PHONE_NO"));
					data.setRcvAddress(rs.getString("RCV_ADDRESS"));
					data.setoPay(rs.getString("O_PAY"));
					datas.add(data);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(conn, pstmt);
		}
		System.out.println("오더 DAO DATAS 로그 :" + datas);
		return datas;
	}
}