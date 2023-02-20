package model.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;

public class ProductDAO {
	Connection conn;
	PreparedStatement pstmt;

// 1.19 최신화
	final String SELECTALL_PRODUCT = "SELECT * FROM PRODUCT ORDER BY P_NO ASC"; // 상품 전체보기
	final String SELECTALL_PRODUCT_ASC = "SELECT P_NO, P_NM, CATEGORY, P_DETAIL, P_IMG_URL, P_IMG_URL2, P_AMT, DC_PERCENT, "
			+ "PRICE*((100-PRODUCT.DC_PERCENT)/100) "
			+ "AS PRICE FROM PRODUCT WHERE PRICE BETWEEN ? AND ? ORDER BY PRICE ASC"; // 상품
	// 전체
	// 가격낮은순
	final String SELECTALL_PRODUCT_DESC = "SELECT P_NO, P_NM, CATEGORY, P_DETAIL, P_IMG_URL, P_IMG_URL2, P_AMT, DC_PERCENT, "
			+ "PRICE*((100-PRODUCT.DC_PERCENT)/100) AS PRICE FROM PRODUCT WHERE PRICE BETWEEN ? AND ? ORDER BY PRICE DESC"; // 상품
	// 전체
	// 가격높은순
	final String SELECTALL_PNAME = "SELECT * FROM PRODUCT WHERE P_NM LIKE '%'||?||'%'"; // 상품 이름 검색
	final String SELECTONE_PRODUCT = "SELECT * FROM PRODUCT WHERE P_NO=?"; // 상품 상세 검색
	final String UPDATE_AMT = "UPDATE PRODUCT SET P_AMT = P_AMT - ? WHERE P_NO = ?";

	final String SELECTALL_CATEGORY_SELLDESC = "SELECT PRODUCT.P_NO, CATEGORY, P_NM, PRICE, P_IMG_URL, DC_PERCENT, P_AMT, "
			+ " P_DETAIL, P_IMG_URL2, SUM(OD_CNT) FROM ORDER_DETAIL INNER JOIN PRODUCT ON ORDER_DETAIL.P_NO = PRODUCT.P_NO AND CATEGORY= ?"
			+ " WHERE PRODUCT.PRICE  BETWEEN ? AND ? GROUP BY PRODUCT.P_NO, CATEGORY, P_NM, PRICE, P_IMG_URL, "
			+ " DC_PERCENT, P_AMT, P_DETAIL, P_IMG_URL2 ORDER BY SUM(OD_CNT) DESC"; // 상품 카테고리별 인기순

	final String SELECTALL_CATEGORY_PRICEASC = "SELECT P_NO ,P_NM, CATEGORY, P_DETAIL, P_IMG_URL, P_IMG_URL2, "
			+ " P_AMT,DC_PERCENT, PRICE*((100-PRODUCT.DC_PERCENT)/100) AS PRICE FROM PRODUCT WHERE CATEGORY= ? AND PRICE BETWEEN ? AND ? ORDER BY PRICE ASC"; // 상품
	// 가격순

	final String SELECTALL_CATEGORY_PRICEDESC = "SELECT P_NO, P_NM, CATEGORY, P_DETAIL, P_IMG_URL, P_IMG_URL2, P_AMT, DC_PERCENT,"
			+ " PRICE*((100-PRODUCT.DC_PERCENT)/100) AS PRICE FROM PRODUCT "
			+ " WHERE CATEGORY= ? AND PRICE BETWEEN ? AND ? ORDER BY PRICE DESC"; // 상품 카테고리별 높은 가격순

	final String SELECTALL_CATEGORY_REGIDESC = "SELECT * FROM PRODUCT WHERE CATEGORY= ? AND PRICE BETWEEN ? AND ? ORDER BY P_NO DESC"; // 상품
	// 카테고리별
	// 최신순

	final String SELECTALL_NEW = "SELECT * FROM PRODUCT WHERE PRICE BETWEEN ? AND ? ORDER BY P_NO DESC"; // 신상품 검색
	final String SELECTALL_DC = "SELECT * FROM PRODUCT WHERE DC_PERCENT>0"; // 할인 상품 검색
	final String SELECTALL_POPULAR = "SELECT PRODUCT.P_NO, P_NM, PRICE, P_IMG_URL, CATEGORY, SUM(OD_CNT), DC_PERCENT, P_AMT, P_DETAIL, "
			+ " P_IMG_URL2 FROM PRODUCT INNER JOIN ORDER_DETAIL ON ORDER_DETAIL.P_NO = PRODUCT.P_NO WHERE PRODUCT.PRICE BETWEEN ? AND ? "
			+ " GROUP BY PRODUCT.P_NO, P_NM, PRICE, P_IMG_URL, CATEGORY, DC_PERCENT, P_AMT, P_DETAIL, P_IMG_URL2 ORDER BY SUM(OD_CNT) DESC";

	// 인기 상품 검색

	final String INSERT_PRODUCT = "INSERT INTO PRODUCT VALUES(product_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, 0)";
	// 상품추가
	final String DELETE_PRODUCT = "DELETE FROM PRODUCT WHERE P_NO=?";
	// 상품 삭제
	final String UPDATE_PRODUCT = "UPDATE PRODUCT SET P_NM=?, CATEGORY=?, PRICE=?, P_AMT=?, P_DETAIL=?, P_IMG_URL=?, P_IMG_URL2=?"
			+ ", DC_PERCENT=? WHERE P_NO=?";
	// 상품정보변경

	// 인자만 가지고서 구분하기 어려운 경우
	// 1) 어떤 action인지 구분하기 위한 vo에 컬럼을추가하는 방식
	// 2) DAO의 메서드를 추가하는 방식

	public ArrayList<ProductVO> selectAll(ProductVO pvo) { // 상품 전체보기
		ArrayList<ProductVO> datas = new ArrayList<ProductVO>();
		int lowPrice = 0;
		int highPrice = 10000000;

		if (pvo != null) {
			lowPrice = pvo.getSearchLowPrice();
			highPrice = pvo.getSearchHighPrice();
		}

		conn = JDBCUtil.connect();
		try {
			if (pvo == null) {
				pstmt = conn.prepareStatement(SELECTALL_PRODUCT);
			} else if (pvo.getpSearchContent() != null) { // 상품 이름 검색
				pstmt = conn.prepareStatement(SELECTALL_PNAME);
				pstmt.setString(1, pvo.getpSearchContent());
			} else if (pvo.getCategory().equals("all")) { // 카테고리 검색
				if (pvo.getSort().equals("sellDesc")) {
					pstmt = conn.prepareStatement(SELECTALL_POPULAR); // 전체 인기상품
					pstmt.setInt(1, lowPrice);
					pstmt.setInt(2, highPrice);
				} else if (pvo.getSort().equals("priceAsc")) {
					pstmt = conn.prepareStatement(SELECTALL_PRODUCT_ASC); // 전체 가격 낮은순
					pstmt.setInt(1, lowPrice);
					pstmt.setInt(2, highPrice);
				} else if (pvo.getSort().equals("priceDesc")) {
					pstmt = conn.prepareStatement(SELECTALL_PRODUCT_DESC); // 전체 가격 높은순
					pstmt.setInt(1, lowPrice);
					pstmt.setInt(2, highPrice);
				} else if (pvo.getSort().equals("regiDesc")) {
					pstmt = conn.prepareStatement(SELECTALL_NEW); // 전체 신상품
					pstmt.setInt(1, lowPrice);
					pstmt.setInt(2, highPrice);
				}
			} else if (pvo.getCategory() != null) {
				if (pvo.getSort().equals("sellDesc")) {
					pstmt = conn.prepareStatement(SELECTALL_CATEGORY_SELLDESC); // 카테고리별 인기상품
					pstmt.setString(1, pvo.getCategory());
					pstmt.setInt(2, lowPrice);
					pstmt.setInt(3, highPrice);
				} else if (pvo.getSort().equals("priceAsc")) {
					pstmt = conn.prepareStatement(SELECTALL_CATEGORY_PRICEASC); // 카테고리별 가격 낮은순
					pstmt.setString(1, pvo.getCategory());
					pstmt.setInt(2, lowPrice);
					pstmt.setInt(3, highPrice);
				} else if (pvo.getSort().equals("priceDesc")) {
					pstmt = conn.prepareStatement(SELECTALL_CATEGORY_PRICEDESC); // 카테고리별 가격 높은순
					pstmt.setString(1, pvo.getCategory());
					pstmt.setInt(2, lowPrice);
					pstmt.setInt(3, highPrice);
				} else if (pvo.getSort().equals("regiDesc")) {
					pstmt = conn.prepareStatement(SELECTALL_CATEGORY_REGIDESC); // 카테고리별 신상품
					pstmt.setString(1, pvo.getCategory());
					pstmt.setInt(2, lowPrice);
					pstmt.setInt(3, highPrice);
				}
			}
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO product = new ProductVO();
				product.setpNum(rs.getInt("P_NO"));
				product.setpName(rs.getString("P_NM"));
				product.setCategory(rs.getString("CATEGORY"));
				product.setPrice(rs.getInt("PRICE"));
				product.setpAmt(rs.getInt("P_AMT"));
				product.setpDetail(rs.getString("P_DETAIL"));
				product.setpImgUrl(rs.getString("P_IMG_URL"));
				product.setpImgUrl2(rs.getString("P_IMG_URL2"));
				product.setpDcPercent(rs.getInt("DC_PERCENT"));
				product.setDc_price((int) (product.getPrice() * ((100 - product.getpDcPercent()) / 100.0)));
				datas.add(product);
//            if (product.getDc_price() >= lowPrice && product.getDc_price() <= highPrice) {
//               // dc_price가 lowPrice(최저가) 이상 highPrice(최고가) 이하 일때만 리스트에 추가하여 반환함
//               datas.add(product);
//            }

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(conn, pstmt);
		}
		return datas;
	}

	public ProductVO selectOne(ProductVO pvo) { // 상품 상세보기

		conn = JDBCUtil.connect();
		ProductVO pdata = new ProductVO();
		try {
			pstmt = conn.prepareStatement(SELECTONE_PRODUCT);
			pstmt.setInt(1, pvo.getpNum());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				pdata = new ProductVO();
				pdata.setpNum(rs.getInt("P_NO"));
				pdata.setpName(rs.getString("P_NM"));
				pdata.setCategory(rs.getString("CATEGORY"));
				pdata.setPrice(rs.getInt("PRICE"));
				pdata.setpAmt(rs.getInt("P_AMT"));
				pdata.setpDetail(rs.getString("P_DETAIL"));
				pdata.setpImgUrl(rs.getString("P_IMG_URL"));
				pdata.setpImgUrl2(rs.getString("P_IMG_URL2"));
				pdata.setpDcPercent(rs.getInt("DC_PERCENT"));
				pdata.setDc_price((int) (pdata.getPrice() * ((100 - pdata.getpDcPercent()) / 100.0)));
				System.out.println("dc_price: " + pdata.getDc_price());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.disconnect(conn, pstmt);
		}
		return pdata;
	}

	public boolean insert(ProductVO pvo) { // 상품 추가
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(INSERT_PRODUCT);
			pstmt.setString(1, pvo.getpName());
			pstmt.setString(2, pvo.getCategory());
			pstmt.setInt(3, pvo.getPrice());
			pstmt.setInt(4, pvo.getpAmt());
			pstmt.setString(5, pvo.getpDetail());
			pstmt.setString(6, pvo.getpImgUrl());
			pstmt.setString(7, pvo.getpImgUrl2());
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

	public boolean update(ProductVO pvo) { // 상품 정보 변경
		conn = JDBCUtil.connect();
		try {
			if (pvo.getpImgUrl() == null) {
				pstmt = conn.prepareStatement(UPDATE_AMT);
				pstmt.setInt(1, pvo.getpCnt());
				pstmt.setInt(2, pvo.getpNum());
			} else {
				pstmt = conn.prepareStatement(UPDATE_PRODUCT);
				pstmt.setString(1, pvo.getpName());
				pstmt.setString(2, pvo.getCategory());
				pstmt.setInt(3, pvo.getPrice());
				pstmt.setInt(4, pvo.getpAmt());
				pstmt.setString(5, pvo.getpDetail());
				pstmt.setString(6, pvo.getpImgUrl());
				pstmt.setString(7, pvo.getpImgUrl2());
				pstmt.setInt(8, pvo.getpDcPercent());
				pstmt.setInt(9, pvo.getpNum());
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

	public boolean delete(ProductVO pvo) { // 상품 삭제
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(DELETE_PRODUCT);
			pstmt.setInt(1, pvo.getpNum());
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