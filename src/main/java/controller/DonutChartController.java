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

import model.order.OrderDAO;
import model.order.OrderVO;
import model.orderDetail.OrderDetailDAO;
import model.orderDetail.OrderDetailVO;

/**
 * Servlet implementation class DonutChartController
 */
@WebServlet("/donutChart")
public class DonutChartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DonutChartController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("도넛컨트롤러시작");
		ArrayList<OrderDetailVO> list = new ArrayList<>(); // 카테고리별 cnt / sum 넣을 list
		OrderDetailDAO oddao = new OrderDetailDAO();
		OrderDetailVO odvo = new OrderDetailVO();
		
		ArrayList<OrderVO> list2022 = new ArrayList<>(); // 연도별 수익 넣을 list
		ArrayList<OrderVO> list2023 = new ArrayList<>(); // 연도별 수익 넣을 list
		OrderDAO odao = new OrderDAO();
		OrderVO ovo = new OrderVO();

		odvo.setCategory("food"); // 카테고리 지정해주고
		odvo = oddao.selectOne(odvo); // cnt / sum 받아옴
		list.add(odvo); // 리스트에 추가
		odvo.setCategory("treat");
		odvo = oddao.selectOne(odvo);
		list.add(odvo);
		odvo.setCategory("sand");
		odvo = oddao.selectOne(odvo);
		list.add(odvo);

		JSONArray datas = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject data = new JSONObject();
			data.put("cnt", list.get(i).getCnt());
			System.out.println(list.get(i).getCnt());
			data.put("sum", list.get(i).getSum());
			System.out.println(list.get(i).getSum());
			datas.add(data);
		}
		
		// 연도별 수익 데이터 저장 부분 Begin
		// 연도별 수익 저장할 변수
		int sum2022=0;
		int sum2023=0;
		
		// 2022년 수익 
		ovo.setoDate("2022");
		ovo.setoSearchCondition("date");
		list2022 = odao.selectAll(ovo);
		
		
		System.out.println("list2022: "+list2022);
		
		for(OrderVO v : list2022) {
			sum2022 += v.getoPrice();
		}
		
		// data 리스트에 넣기
		System.out.println("sum2022: "+sum2022);
		JSONObject data2022 = new JSONObject();
		data2022.put("year", sum2022);
		datas.add(data2022);
		
		// 2023년 수익
		ovo.setoDate("2023");
		ovo.setoSearchCondition("date");
		list2023 = odao.selectAll(ovo);
		
		System.out.println("list2023: "+list2023);
		
		for(OrderVO v : list2023) {
			sum2023 += v.getoPrice();
		}
		
		// data 리스트에 넣기
		System.out.println("sum2023: "+sum2023);
		JSONObject data2023 = new JSONObject();
		data2023.put("year", sum2023);
		datas.add(data2023);
		// 연도별 수익 데이터 저장 부분 End

		
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		response.getWriter().println(datas);
	}

}
