package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.member.MemberDAO;
import model.member.MemberVO;
import model.orderDetail.OrderDetailDAO;
import model.orderDetail.OrderDetailVO;
import model.product.ProductDAO;
import model.product.ProductVO;
import model.review.ReviewDAO;
import model.review.ReviewVO;

// 관리자 ajax()로 다루기
@WebServlet("/getAdminList")
public class AdminListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminListController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// part = member, product, order, review 중 1
		String part = request.getParameter("part");

		// 파트 별로 JSONArray를 String으로 바꿔서 전달
		String resList = ""; // 전달할 결과 String

		// 1. selectAll 해서 알맞는 ArrayList에 저장
		// 2. JSON 배열 -> VO 를 JSON에 세팅
		// 3. JSONArray 에 JSON 객체 추가

		if (part.equals("member")) {
			resList = getMembersJsonString();
		} else if (part.equals("product")) {
			resList = getProductJsonString();
		} else if (part.equals("order")) {
			resList = getODJsonString();
		} else if (part.equals("review")) {
			resList = getReviewJsonString();
		}
		// System.out.println("resList: " + resList);
		response.setCharacterEncoding("UTF-8"); // 인코딩
		response.getWriter().println(resList);
	}

	private String getMembersJsonString() {
		MemberDAO mdao = new MemberDAO();
		ArrayList<MemberVO> list = mdao.selectAll(new MemberVO());

		JSONArray datas = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject data = new JSONObject();
			data.put("userId", list.get(i).getUserId());
			data.put("userPw", list.get(i).getUserPw());
			data.put("userName", list.get(i).getUserName());
			data.put("catName", list.get(i).getCatName());
			data.put("email", list.get(i).getEmail());
			data.put("phoneNum", list.get(i).getPhoneNum());
			data.put("address", list.get(i).getAddress());
			datas.add(data);
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

		return gson.toJson(datas);
	}

	private String getProductJsonString() {
		ProductDAO pdao = new ProductDAO();
		ProductVO pvo = new ProductVO();
		pvo.setCategory("all");
		pvo.setSort("regiDesc");
		pvo.setSearchLowPrice(0);
		pvo.setSearchHighPrice(10000000);
		ArrayList<ProductVO> list = pdao.selectAll(pvo);

		JSONArray datas = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject data = new JSONObject();
			data.put("pNum", list.get(i).getpNum());
			data.put("pName", list.get(i).getpName());
			data.put("category", list.get(i).getCategory());
			data.put("price", list.get(i).getPrice());
			data.put("pAmt", list.get(i).getpAmt());
			data.put("pDetail", list.get(i).getpDetail());
			data.put("pImgUrl", list.get(i).getpImgUrl());
			data.put("pImgUrl2", list.get(i).getpImgUrl2());
			data.put("pDcPercent", list.get(i).getpDcPercent());
			data.put("dc_price", list.get(i).getDc_price());
			datas.add(data);
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

		return gson.toJson(datas);
	}

	private String getODJsonString() {
		OrderDetailDAO oddao = new OrderDetailDAO();
		OrderDetailVO odvo = new OrderDetailVO();
		odvo.setoNum(0);
		ArrayList<OrderDetailVO> list = oddao.selectAll(odvo);

		JSONArray datas = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject data = new JSONObject();
			data.put("oNum", list.get(i).getoNum());
			data.put("pName", list.get(i).getpName());
			data.put("odCnt", list.get(i).getOdCnt());
			data.put("odPrice", list.get(i).getOdPrice());
			datas.add(data);
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

		return gson.toJson(datas);
	}

	private String getReviewJsonString() {
		ReviewDAO rdao = new ReviewDAO();
		ArrayList<ReviewVO> list = rdao.selectAll(null);

		JSONArray datas = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject data = new JSONObject();

			data.put("pNum", list.get(i).getpNum());
			data.put("rNum", list.get(i).getrNum());
			data.put("rWriter", list.get(i).getrWriter());
			data.put("rRate", list.get(i).getrRate());
			data.put("rDate", list.get(i).getrDate());
			data.put("rContent", list.get(i).getrContent());
			datas.add(data);
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

		return gson.toJson(datas);
	}
}
