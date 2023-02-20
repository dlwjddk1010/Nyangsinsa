package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;

	final String INSERT = "INSERT INTO MEMBER VALUES (?, ?, ?, ?, ?, ?, ?)";
	final String DELETE = "DELETE FROM MEMBER WHERE USER_ID = ?";
	final String SELECTONE = "SELECT * FROM MEMBER WHERE USER_ID = ? AND USER_PW = ?";
	final String SELECTONE_ID = "SELECT USER_ID FROM MEMBER WHERE USER_ID = ? ";
	final String SELECTONE_PHONE = "SELECT PHONE_NO FROM MEMBER WHERE PHONE_NO = ?";
	final String SELECTONE_MYPAGE = "SELECT * FROM MEMBER WHERE USER_ID = ? ";
	final String SELECTALL = "SELECT * FROM MEMBER";
	final String SELECTALL_ID = "SELECT * FROM MEMBER WHERE USER_ID LIKE '%'||?||'%'";
	final String UPDATE = "UPDATE MEMBER SET CAT_NM = ?, PHONE_NO = ? , ADDRESS = ? WHERE USER_ID = ?";
	final String UPDATE_PW = "UPDATE MEMBER SET USER_PW = ? WHERE USER_ID=?";
	final String SELECTONE_FINDID = "SELECT * FROM MEMBER WHERE PHONE_NO= ?";
	final String SELECTONE_FINDPW = "SELECT * FROM MEMBER WHERE USER_ID = ? AND USER_NM = ? AND PHONE_NO= ? ";

	public boolean insert(MemberVO mvo) { // 회원가입
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, mvo.getUserId());
			pstmt.setString(2, mvo.getUserPw());
			pstmt.setString(3, mvo.getUserName());
			pstmt.setString(4, mvo.getCatName());
			pstmt.setString(5, mvo.getEmail());
			pstmt.setString(6, mvo.getPhoneNum());
			pstmt.setString(7, mvo.getAddress());
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

	public boolean delete(MemberVO mvo) { // 회원탈퇴, 회원 삭제
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(DELETE);
			pstmt.setString(1, mvo.getUserId());
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

	public boolean duplicationCheck(MemberVO mvo) { // 중복된 아이디가 있으면 true / 없으면 false
		conn = JDBCUtil.connect();
		try {
			if (mvo.getUserId() != null) {
				pstmt = conn.prepareStatement(SELECTONE_ID);
				pstmt.setString(1, mvo.getUserId());
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					return true;
				} else {
					return false;
				}
			} else {
				pstmt = conn.prepareStatement(SELECTONE_PHONE);
				pstmt.setString(1, mvo.getPhoneNum());
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					return true;
				} else {
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		} finally {
			JDBCUtil.disconnect(conn, pstmt);
		}
	}

	public MemberVO selectOne(MemberVO mvo) { // 로그인
		conn = JDBCUtil.connect();
		MemberVO data = null;
		try {
			if (mvo.getUserId() != null && mvo.getUserName() != null && mvo.getPhoneNum() != null) { // pw찾기
				pstmt = conn.prepareStatement(SELECTONE_FINDPW);
				pstmt.setString(1, mvo.getUserId());
				pstmt.setString(2, mvo.getUserName());
				pstmt.setString(3, mvo.getPhoneNum());
			} else if (mvo.getPhoneNum() != null) { // id 찾기
				pstmt = conn.prepareStatement(SELECTONE_FINDID);
				pstmt.setString(1, mvo.getPhoneNum());
			} else if (mvo.getUserId() != null && mvo.getUserPw() == null) { // 마이페이지
				pstmt = conn.prepareStatement(SELECTONE_MYPAGE);
				pstmt.setString(1, mvo.getUserId());
			} else {
				pstmt = conn.prepareStatement(SELECTONE); // 로그인
				pstmt.setString(1, mvo.getUserId());
				pstmt.setString(2, mvo.getUserPw());
			}
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				data = new MemberVO();
				data.setUserId(rs.getString("USER_ID"));
				data.setUserPw(rs.getString("USER_PW"));
				data.setUserName(rs.getString("USER_NM"));
				data.setCatName(rs.getString("CAT_NM"));
				data.setEmail(rs.getString("EMAIL"));
				data.setPhoneNum(rs.getString("PHONE_NO"));
				data.setAddress(rs.getString("ADDRESS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(conn, pstmt);
		}
		System.out.println(data);
		return data;
	}

	public ArrayList<MemberVO> selectAll(MemberVO mvo) {
		ArrayList<MemberVO> datas = new ArrayList<MemberVO>();
		conn = JDBCUtil.connect();
		try {
			if (mvo.getUserId() == null) { // 회원 전체 목록
				pstmt = conn.prepareStatement(SELECTALL);
			} else if (mvo.getUserId() != null) { // 아이디 검색
				pstmt = conn.prepareStatement(SELECTALL_ID);
				pstmt.setString(1, mvo.getUserId());
			}
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberVO data = new MemberVO();
				data.setUserId(rs.getString("USER_ID"));
				data.setUserPw(rs.getString("USER_PW"));
				data.setUserName(rs.getString("USER_NM"));
				data.setCatName(rs.getString("CAT_NM"));
				data.setEmail(rs.getString("EMAIL"));
				data.setPhoneNum(rs.getString("PHONE_NO"));
				data.setAddress(rs.getString("ADDRESS"));
				datas.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(conn, pstmt);
		}
		return datas;
	}

	public boolean update(MemberVO mvo) { // 회원 정보 변경
		conn = JDBCUtil.connect();
		try {
			if (mvo.getCatName() == null) { // 비밀번호 찾기로 인한 변경
				pstmt = conn.prepareStatement(UPDATE_PW);
				pstmt.setString(1, mvo.getUserPw());
				pstmt.setString(2, mvo.getUserId());
			} else { // 회원정보 수정
				pstmt = conn.prepareStatement(UPDATE);
				pstmt.setString(1, mvo.getCatName());
				pstmt.setString(2, mvo.getPhoneNum());
				pstmt.setString(3, mvo.getAddress());
				pstmt.setString(4, mvo.getUserId());
			}
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

}