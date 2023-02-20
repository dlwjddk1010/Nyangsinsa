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

import model.product.ProductVO;

// 장바구니 수량 수정 비동기 처리
@WebServlet("/updateCart")
public class UpdateCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateCartController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");

		System.out.println("  로그 : UpdateCartCtrl 호출됨");
		int pNum = Integer.parseInt(request.getParameter("pNum"));
		String action = request.getParameter("action");

		ArrayList<ProductVO> cList = (ArrayList) request.getSession().getAttribute("cList"); // 기존 장바구니
		
		if(cList == null) {
			cList = new ArrayList<>();
		}
		
		for (int i = 0; i < cList.size(); i++) {
			if (cList.get(i).getpNum() == pNum) {
				if (action.equals("+")) { // plus 하는 경우
					cList.get(i).setpCnt(cList.get(i).getpCnt() + 1);
				} else if (action.equals("-")) { // minus 하는 경우
					if (cList.get(i).getpCnt() > 1) {
						cList.get(i).setpCnt(cList.get(i).getpCnt() - 1);
					}
				}
				break;
			}
		}

		// 수정된 장바구니 목록들을 세션에도 저장
		request.getSession().setAttribute("cList", cList); 

		// 1. JSON배열 만들어서 2. PVO->JSON 세팅하고 3.JSON배열에 JSON객체 담기
		JSONArray datas = new JSONArray();
		for (int i = 0; i < cList.size(); i++) {
			JSONObject data = new JSONObject(); // 배열 내에 들어갈 json
			data.put("pNum", cList.get(i).getpNum());
			data.put("pName", cList.get(i).getpName());
			data.put("category", cList.get(i).getCategory());
			data.put("price", cList.get(i).getPrice());
			data.put("pAmt", cList.get(i).getpAmt());
			data.put("pDetail", cList.get(i).getpDetail());
			data.put("pImgUrl", cList.get(i).getpImgUrl());
			data.put("pImgUrl2", cList.get(i).getpImgUrl2());
			data.put("pDcPercent", cList.get(i).getpDcPercent());
			data.put("dc_price", cList.get(i).getDc_price());
			data.put("pCnt", cList.get(i).getpCnt());
			datas.add(data);
		}
		// Gson: 구글에서 JSON 파일 생성을 위해 만든 클래스
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

		// JSON배열을 String 형식으로 변환
		String resList = gson.toJson(datas);
		response.getWriter().println(resList); // request로 보낼 수가 없음: 새로운 요청을 보내는 것이 아니기 때문
	}

}
