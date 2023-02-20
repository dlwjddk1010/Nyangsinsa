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

import model.review.ReviewDAO;
import model.review.ReviewVO;

@WebServlet("/getReviewList")
public class ReviewListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReviewListController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ajax가 보낸 category, sort
		String category = request.getParameter("category");
		String sort = request.getParameter("sort");
		int pNum = Integer.parseInt(request.getParameter("pNum"));

		// response로 보낼 값 (JSON배열을 String 형식으로 변환)
		String resList = "";

		ReviewVO rvo = new ReviewVO();
		// rvo

		ArrayList<ReviewVO> list = new ArrayList<>();
		// list
		rvo.setpNum(pNum);
		ReviewDAO rdao = new ReviewDAO();
		list = rdao.selectAll(rvo); // 결과

		System.out.println("list: " + list);

		// 1. JSON배열 만들어서 2. PVO->JSON 세팅하고 3.JSON배열에 JSON객체 담기
		JSONArray datas = new JSONArray();
		for (int i = 0; i < list.size(); i++) // 배열
		{
			JSONObject data = new JSONObject(); // 배열 내에 들어갈 json
			data.put("rNum", list.get(i).getrNum());
			data.put("pNum", list.get(i).getpNum());
			data.put("rRate", list.get(i).getrRate());
			data.put("rWriter", list.get(i).getrWriter());
			data.put("rContent", list.get(i).getrContent());
			data.put("rDate", list.get(i).getrDate());
			data.put("rSearchCondition", list.get(i).getrSearchCondition());
			datas.add(data);
		}
		// Gson: 구글에서 JSON 파일 생성을 위해 만든 클래스
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

		// JSON배열을 String 형식으로 변환한다.
		resList = gson.toJson(datas);

		System.out.println("resList: " + resList);

		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(resList); // request로 보낼 수가 없음: 새로운 요청을 보내는 것이 아니기 때문

	}

}
