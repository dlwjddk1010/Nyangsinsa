package model.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;

public class ReviewDAO {
	Connection conn;
	PreparedStatement pstmt;

	final String SELECTALL_REVIEW = "SELECT * FROM REVIEW ORDER BY R_NO DESC";
	final String SELECTALL_REVIEW_PRODUCT = "SELECT * FROM REVIEW WHERE P_NO=? ORDER BY R_NO DESC";
	final String DELETE_REVIEW = "DELETE FROM REVIEW WHERE R_NO=?";
	final String INSERT_REVIEW = "INSERT INTO REVIEW VALUES(review_seq.NEXTVAL,?,?,?,SYSDATE,?)";
	final String SELECTALL_SEARCH = "SELECT * FROM REVIEW WHERE R_WRITER LIKE %'||?||'%'";

	public ArrayList<ReviewVO> selectAll(ReviewVO rvo) {
		conn = JDBCUtil.connect();
		ArrayList<ReviewVO> datas = new ArrayList<ReviewVO>();
		try {
			if (rvo == null) {
				pstmt = conn.prepareStatement(SELECTALL_REVIEW);
			} else if (rvo.getpNum() != 0) {
				pstmt = conn.prepareStatement(SELECTALL_REVIEW_PRODUCT);
				pstmt.setInt(1, rvo.getpNum());
			} else if (rvo.getrSearchCondition().equals("SEARCHREVIEW")) {
				pstmt = conn.prepareStatement(SELECTALL_SEARCH);
			}
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ReviewVO data = new ReviewVO();
				data.setpNum(rs.getInt("P_NO"));
				data.setrNum(rs.getInt("R_NO"));
				data.setrWriter(rs.getString("R_WRITER"));
				data.setrRate(rs.getInt("R_RATE"));
				data.setrDate(rs.getString("R_DT"));
				data.setrContent(rs.getString("R_CONTENT"));
				datas.add(data);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		JDBCUtil.disconnect(conn, pstmt);
		return datas;
	}

	public boolean insert(ReviewVO rvo) { // 리뷰 추가
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(INSERT_REVIEW);
			pstmt.setInt(1, rvo.getpNum());
			pstmt.setString(2, rvo.getrWriter());
			pstmt.setString(3, rvo.getrContent());
			pstmt.setInt(4, rvo.getrRate());
			int res = pstmt.executeUpdate();
			if (res <= 0) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		JDBCUtil.disconnect(conn, pstmt);
		return true;
	}

	public boolean delete(ReviewVO rvo) { // 리뷰 삭제
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(DELETE_REVIEW);
			pstmt.setInt(1, rvo.getrNum());
			int res = pstmt.executeUpdate();
			if (res <= 0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		JDBCUtil.disconnect(conn, pstmt);
		return true;
	}

}